package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.TransactionManagmentDAO;
import com.NovikIgor.dto.Transaction;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nolik on 04.11.16.
 */
public class TransactionManagmentDAOimpl implements TransactionManagmentDAO {
    private static final String SQL_CREATE_TRANSACTION ="INSERT INTO `InternetBanking`.`Transactions` (`operation`, `summOfOperation`, `Cards_cardNumber`, `Cards_Users_login`) VALUES (?, ?, ?, ?)";

    private static Logger logger = Logger.getLogger(TransactionManagmentDAOimpl.class);

    public boolean createTransaction(Transaction transaction, Connection connection) throws SQLException {

        logger.info("start to create transactinon" + transaction +" connection" + connection);

        PreparedStatement state = connection.prepareStatement(SQL_CREATE_TRANSACTION);
       // state.setInt(1,transaction.getTransactionID());
        state.setString(1, transaction.getOperation());
        state.setInt(2,transaction.getSumOfOperation());
        state.setInt(3,transaction.getCardNumber());
        state.setString(4,transaction.getUsersLogin());

        // Transaction time must be fulfil by database
      //  state.setTimestamp(6,transaction.getTransactionTime());

       return   state.execute();

    }
}
