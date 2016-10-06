package com.NovikIgor.dao.pool;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that provide pool of connection to DB.
 * Don't forget realize exactly concurrent connection pool!!!
 * <p>
 * Created by Novik Igor on 06.10.2016.
 */
public class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc/internetBanking";
    private static DataSource dataSource;
    private static final Logger logger = Logger.getLogger(ConnectionPool.class);

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
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

