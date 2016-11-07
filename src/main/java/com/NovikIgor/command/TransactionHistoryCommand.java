package com.NovikIgor.command;

import com.NovikIgor.dao.TransactionManagmentDAO;
import com.NovikIgor.dao.impl.TransactionManagmentDAOimpl;
import com.NovikIgor.dto.Transaction;
import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Novik Igor on 07.11.2016.
 */
public class TransactionHistoryCommand implements ActionCommand {
    private static final String OPERATING_CART_ID = "operatingCartID";
    private static final String ATR_TRANSACTION_LIST="transactionList";
    private int operatingCartID;
    private String page;
    private List<Transaction> transactionList = null;

    public String execute(HttpServletRequest request) {
        TransactionManagmentDAO transactionManagmentDAO = new TransactionManagmentDAOimpl();
        operatingCartID = Integer.valueOf(request.getParameter(OPERATING_CART_ID));
        transactionList = transactionManagmentDAO.getTransactionsByCardID(operatingCartID);
        request.getSession().setAttribute(ATR_TRANSACTION_LIST,transactionList);

        page = ConfigurationManager.getProperty("path.page.transactionHistory");

        return page;
    }
}
