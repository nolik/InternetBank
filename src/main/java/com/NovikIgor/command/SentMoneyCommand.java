package com.NovikIgor.command;

import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dto.Card;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 31.10.16.
 */
public class SentMoneyCommand implements ActionCommand {
    private static final String PARAM_OPERATING_CART_ID = "operatingCartID";
    private static final String PARAM_RECIPIENT_CART = "recipientCart";
    private static final String PARAM_OPERATION_SUM = "sumOfOperation";

    private CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
    String page = ConfigurationManager.getProperty("path.page.operationPage");
    Card operatingCard;

    public String execute(HttpServletRequest request) {


        int recipientCartID = Integer.valueOf(request.getParameter(PARAM_RECIPIENT_CART));
        int operationCartID = Integer.valueOf(request.getParameter(PARAM_OPERATING_CART_ID));
        int operationSum = Integer.valueOf(request.getParameter(PARAM_OPERATION_SUM));


        //checking does we have the curd with number from form in DB>?
        if (!cardManager.checkCartID(recipientCartID)) {
            request.setAttribute("cartNotFoundMessage", MessageManager.getProperty("message.cartNotFound"));
            return page;
        }

        operatingCard = cardManager.getCardByCardID(operationCartID);

        //here will be checked operation sum (if available money not enough money.
        if (operationSum > operatingCard.getSum()) {
            request.setAttribute("notEnoughMoney", MessageManager.getProperty(MessageManager.getProperty("message.notEnoughMoney")));
            return page;
        }

        return page;
    }
}
