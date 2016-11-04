package com.NovikIgor.dao.pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This temporary class-wrapper for realising Transactions with using multiple DAO.
 * TODO: rewrite it base on DAO Manager: http://tutorials.jenkov.com/java-persistence/dao-manager.html
 * This can be solved using Spring Framework!
 *
 * Created by nolik on 04.11.16.
 */
public class TransactionConnectionWrapper extends ConnectionPool{

    private Connection connection;

    public void init() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionPool.getConnection();
    }

    public void begin() throws SQLException {
        this.connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        this.connection.commit();
        this.connection.setAutoCommit(true);
    }

    public void rollback() throws SQLException {
        this.connection.rollback();
        this.connection.setAutoCommit(true);
    }


    public Connection  getConnectionWrapper() {
        return connection;
    }

}
