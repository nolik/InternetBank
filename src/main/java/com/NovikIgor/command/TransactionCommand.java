package com.NovikIgor.command;

import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dto.Card;
import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 31.10.16.
 */
public class TransactionCommand implements ActionCommand {
    private static final String PARAM_CART_ID = "operatingCartID";
    private static final String OPERATING_CART = "operatingCart";
    private CardManagmentDAOimpl cardManager = new CardManagmentDAOimpl();
    Card operatingCard = null;

    public String execute(HttpServletRequest request) {
        String page = null;


        int cartID = Integer.valueOf(request.getParameter(PARAM_CART_ID));
        operatingCard = cardManager.getCardByCardID(cartID);
        request.setAttribute(OPERATING_CART, operatingCard);
        page = ConfigurationManager.getProperty("path.page.transactionPage");

        return page;
    }
}
