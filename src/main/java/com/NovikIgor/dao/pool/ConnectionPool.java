package com.NovikIgor.dao.pool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that provide pool of connection to DB.
 * Don't forget realize exactly concurrent connection pool!!!
 * <p>
 * Created by Novik Igor on 06.10.2016.
 */
public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/InternetBanking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "novik03";

    private static final Logger logger = Logger.getLogger(ConnectionPool.class);

    protected ConnectionPool() {
    }

    //TODO: realize here connection pool! with TRANSACTION.
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            logger.error("ERROR: cannot close statement " + e);
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null && connection.getAutoCommit()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("ERROR: cannot close connection " + e);
        }
    }
}

