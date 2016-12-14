package com.NovikIgor.command;

import com.NovikIgor.dao.TransactionManagmentDAO;
import com.NovikIgor.dao.impl.TransactionManagmentDAOimpl;
import com.NovikIgor.dto.Transaction;
import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.NovikIgor.recourceManagment.ProjectConstants.ATR_TRANSACTION_LIST;
import static com.NovikIgor.recourceManagment.ProjectConstants.PARAM_OPERATING_CART_ID;

/**
 * Command that realise command for view history of all transactions belong to this cart.
 * 
 * Created by Novik Igor on 07.11.2016.
 */
public class TransactionHistoryCommand implements ActionCommand {
      private int operatingCartID;
    private String page;
    private List<Transaction> transactionList = null;

    public String execute(HttpServletRequest request) {
        TransactionManagmentDAO transactionManagmentDAO = new TransactionManagmentDAOimpl();
        operatingCartID = Integer.valueOf(request.getParameter(PARAM_OPERATING_CART_ID));
        transactionList = transactionManagmentDAO.getTransactionsByCardID(operatingCartID);
        request.setAttribute(ATR_TRANSACTION_LIST,transactionList);
        request.setAttribute(PARAM_OPERATING_CART_ID,operatingCartID);

        page = ConfigurationManager.getProperty("path.page.transactionHistory");

        return page;
    }
}
