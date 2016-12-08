package com.NovikIgor.command;

import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dto.Card;
import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

import static com.NovikIgor.recourceManagment.ProjectConstants.OPERATING_CART;
import static com.NovikIgor.recourceManagment.ProjectConstants.PARAM_CART_ID;

/**
 * This command responsible for the forwarding to operating page. Now this page using
 * only for SentMoneyCommand, in the future number of command can be increased (add additional form for
 * selecting the command, and depending of this for parameters => create responsible operating.jsp.
 * Created by nolik on 31.10.16.
 */
public class OperationCommandForSendingMoney implements ActionCommand {

    private CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
    Card operatingCard = null;
    String operationPage = null;

    public String execute(HttpServletRequest request) {
        int cartID = Integer.valueOf(request.getParameter(PARAM_CART_ID));

        operationPage = ConfigurationManager.getProperty("path.page.operationPage");
        operatingCard = cardManager.getCardByCardID(cartID);

        request.getSession().setAttribute(OPERATING_CART, operatingCard);

        return operationPage;
    }
}
