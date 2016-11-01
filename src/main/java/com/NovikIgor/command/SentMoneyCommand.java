package com.NovikIgor.command;

import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dto.Card;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 31.10.16.
 */
public class SentMoneyCommand implements ActionCommand {
    private static final String OPERATING_CART = "operatingCart";
    private static final String PARAM_RECIPIENT_CART = "recipientCart";
    private static final String PARAM_OPERATION_SUM = "sumOfOperation";

    private static Logger logger = Logger.getLogger(SentMoneyCommand.class);

    private CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
    String page = ConfigurationManager.getProperty("path.page.operationPage");
    Card operatingCard;

    public String execute(HttpServletRequest request) {

        logger.info("start to execute method in sentMoney command");

        int recipientCartID = Integer.valueOf(request.getParameter(PARAM_RECIPIENT_CART));

        int operationSum = Integer.valueOf(request.getParameter(PARAM_OPERATION_SUM));
        logger.info("parcel all to execute method in sentMoney command");

        //checking does we have the curd with number from form in DB>?
        if (!cardManager.checkCartID(recipientCartID)) {
            request.setAttribute("cartNotFoundMessage", MessageManager.getProperty("message.cartNotFound"));
            return page;
        }

         operatingCard = (Card) request.getSession().getAttribute(OPERATING_CART);
        logger.info("load operatingCard from session"+operatingCard);

        //here will be checked operation sum (if available money not enough money.
        if (operationSum > operatingCard.getSum() ) {
            request.setAttribute("notEnoughMoney", MessageManager.getProperty(MessageManager.getProperty("message.notEnoughMoney")));
            return page;
        }

        if (operationSum <=0 ) {
            request.setAttribute("wrongSum", MessageManager.getProperty(MessageManager.getProperty("message.wrongSum")));
            return page;
        }
        return page;
    }
}
