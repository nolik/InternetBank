package com.NovikIgor.command;

import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dao.impl.TransactionManagmentDAOimpl;
import com.NovikIgor.dao.pool.TransactionConnectionWrapper;
import com.NovikIgor.dto.Card;
import com.NovikIgor.dto.Transaction;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;
import org.apache.log4j.Logger;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.NovikIgor.recourceManagment.ProjectConstants.*;

/**
 * Created by nolik on 31.10.16.
 */
public class SentMoneyCommand implements ActionCommand {


    private static Logger logger = Logger.getLogger(SentMoneyCommand.class);

    private CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
    private TransactionManagmentDAOimpl transactionManager = new TransactionManagmentDAOimpl();

    private String page = ConfigurationManager.getProperty("path.page.operationPage");

    private Card operatingCard;
    private Card recipientCart;

    public String execute(HttpServletRequest request) {

        logger.info("start to execute method in sentMoney command");

        int recipientCartID = Integer.valueOf(request.getParameter(PARAM_RECIPIENT_CART));

        BigDecimal operationSum = BigDecimal.valueOf(Long.parseLong(request.getParameter(PARAM_OPERATION_SUM)));
        logger.info("parcel all to execute method in sentMoney command");

        //checking does we have the curd with number from form in DB>?
        if (!cardManager.checkCartID(recipientCartID)) {
            logger.info("don't find the recipient cart");
            request.setAttribute("cartNotFoundMessage", MessageManager.getProperty("message.cartNotFound"));
            return page;
        }

        operatingCard = (Card) request.getSession().getAttribute(ATR_OPERATING_CART);
        recipientCart = cardManager.getCardByCardID(recipientCartID);

        logger.info("load operatingCard from session" + operatingCard);

        //here will be checked operation sum (if available money not enough money.
        if (operationSum.compareTo(operatingCard.getSum()) == 1) {
            logger.info("not enough money on the card, operation sum=" + operationSum + " sum on the card=" + operatingCard.getSum());
            //TODO:bugFix with java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key Not enough Money on the bill.
            //  request.setAttribute("notEnoughMoney", MessageManager.getProperty(MessageManager.getProperty("message.notEnoughMoney")));
            request.setAttribute("notEnoughMoney", "not enough money on the bill.");
            return page;
        }

        if (operationSum.compareTo(new BigDecimal(0)) == 0) {
            logger.info("operation sum=" + operationSum);
            //TODO:bugFix with java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle,
            // request.setAttribute("wrongSum", MessageManager.getProperty(MessageManager.getProperty("message.wrongSum")));
            request.setAttribute("wrongSum", "you write wrong sum, please try once again.");
            return page;
        }

        logger.info("before transaction");
        //Transaction of sending sum from operating cart to rhe recipient cart
        // better do separately method
        //TODO: realise here logic of Transaction with sending money!
        if (doTransaction(operationSum)) {
            page = ConfigurationManager.getProperty("path.page.successful");

            //below we overwrite the cardLit (because some money will be transfer)
            HttpSession session = request.getSession();
            CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
            List<Card> userCards = cardManager.getCardsByLogin(String.valueOf(session.getAttribute(ATTR_LOGIN)));
            session.setAttribute(ATTR_USER_CARDS, userCards);
        }

        return page;
    }


    private boolean doTransaction(BigDecimal operationSum) {
        TransactionConnectionWrapper transConWrapper = new TransactionConnectionWrapper();
        String operationCartCurrency = operatingCard.getCurrency();
        String recipientCartCurrency = recipientCart.getCurrency();
        BigDecimal recipientMoneySum;


        try {
            logger.info("Start ot implement command with sent sum");
            transConWrapper.init();
            Connection connectionFromWrapper = transConWrapper.getConnectionWrapper();
            transConWrapper.begin();

            operatingCard.setSum(operatingCard.getSum().subtract(operationSum));

            //Compare currencies of operation cards. In case of different currencies - make currency exchange.
            if (!operationCartCurrency.equals(recipientCartCurrency)) {
                MonetaryAmount operationMoney = Money.of(operationSum, operationCartCurrency);
                CurrencyConversion currencyConversion = MonetaryConversions.getConversion(recipientCartCurrency, "ECB");
                MonetaryAmount recipientMoney = operationMoney.with(currencyConversion);

                recipientMoneySum = recipientMoney.getNumber().numberValue(BigDecimal.class);

            } else recipientMoneySum = operationSum;

            recipientCart.setSum(recipientCart.getSum().add(recipientMoneySum));

            Transaction transaction = new Transaction();

            transaction.setCardNumber(operatingCard.getCardNumber());
            transaction.setOperation("sent money");
            transaction.setSumOfOperation(operationSum);
            transaction.setUsersLogin(operatingCard.getUser());

            logger.info("before create transaction " + transaction);
            transactionManager.createTransaction(transaction, connectionFromWrapper);
            cardManager.editCartSum(operatingCard, connectionFromWrapper);
            cardManager.editCartSum(recipientCart, connectionFromWrapper);

            transConWrapper.commit();
            logger.info("Sent Money operation finished successful");

        } catch (SQLException e) {
            try {
                transConWrapper.rollback();
                logger.error("catch Database exception in main sent command operation", e);
                return false;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                transConWrapper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
