package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.TransactionManagmentDAO;
import com.NovikIgor.dto.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nolik on 04.11.16.
 */
public class TransactionManagmentDAOimpl implements TransactionManagmentDAO {
    private static final String SQL_CREATE_TRANSACTION ="INSERT INTO `InternetBanking`.`Transactions` (`transactionID`, `operation`, `summOfOperation`, `Cards_cardNumber`, `Cards_Users_login`, `transactionTime`) VALUES (?, ?, ?, ?, ?, ?)";


    public boolean createTransaction(Transaction transaction, Connection connection) throws SQLException {

        PreparedStatement state = null;

        state = connection.prepareStatement(SQL_CREATE_TRANSACTION);
        state.setInt(1,transaction.getTransactionID());
        state.setString(2, transaction.getOperation());
        state.setInt(3,transaction.getSumOfOperation());
        state.setInt(4,transaction.getCardNumber());
        state.setString(5,transaction.getUsersLogin());
        state.setTimestamp(6,transaction.getTransactionTime());

       return   state.execute();

    }
}
