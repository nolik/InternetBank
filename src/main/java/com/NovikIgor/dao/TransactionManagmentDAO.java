package com.NovikIgor.dao;

import com.NovikIgor.dto.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nolik on 03.11.16.
 */
public interface TransactionManagmentDAO {
    public boolean createTransaction(Transaction transaction, Connection connection) throws SQLException;

    public List<Transaction> getTransactionsByCardID (int cartID);
}
