package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.TransactionManagmentDAO;
import com.NovikIgor.dao.pool.ConnectionPool;
import com.NovikIgor.dto.Transaction;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nolik on 04.11.16.
 */
public class TransactionManagmentDAOimpl implements TransactionManagmentDAO {
    private static final String SQL_CREATE_TRANSACTION = "INSERT INTO `InternetBanking`.`Transactions` (`operation`, `summOfOperation`, `Cards_cardNumber`, `Cards_Users_login`) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_TRANSACTIONS_BY_CART_ID = "SELECT * FROM `InternetBanking`.`Transactions` WHERE Transactions.Cards_cardNumber = ?";

    private static Logger logger = Logger.getLogger(TransactionManagmentDAOimpl.class);

    public boolean createTransaction(Transaction transaction, Connection connection) throws SQLException {

        logger.info("start to create transactinon" + transaction + " connection" + connection);

        PreparedStatement state = connection.prepareStatement(SQL_CREATE_TRANSACTION);
        // state.setInt(1,transaction.getTransactionID());
        state.setString(1, transaction.getOperation());
        state.setInt(2, transaction.getSumOfOperation());
        state.setInt(3, transaction.getCardNumber());
        state.setString(4, transaction.getUsersLogin());

        // Transaction time must be fulfil by database
        //  state.setTimestamp(6,transaction.getTransactionTime());

        return state.execute();

    }

    public List<Transaction> getTransactionsByCardID(int cartID) {
        List<Transaction> transactionList = new LinkedList<Transaction>();
        Connection connection = null;
        PreparedStatement statement = null;

        logger.info("start to getTransaction by CardID");

        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_TRANSACTIONS_BY_CART_ID);
            statement.setInt(1, cartID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(resultSet.getInt(1));
                transaction.setOperation(resultSet.getString(2));
                transaction.setSumOfOperation(resultSet.getInt(3));
                transaction.setCardNumber(resultSet.getInt(4));
                transaction.setUsersLogin(resultSet.getString(5));
                transaction.setTransactionTime(resultSet.getTimestamp(6));

                transactionList.add(transaction);
            }
        } catch (Exception e) {
            logger.error("Error during selection of transaction from DB",e);
            e.printStackTrace();
        }
        finally {
            ConnectionPool.close(statement);
            ConnectionPool.close(connection);
        }

        return transactionList;
    }
}
