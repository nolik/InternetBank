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
    private static final String URL = "jdbc:mysql://localhost:3306/InternetBanking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "novik03";

    private static final Logger logger = Logger.getLogger(ConnectionPool.class);

    protected ConnectionPool() {
    }

    //TODO: realize here connection pool! with TRANSACTION.
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
      /*  Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;*/
        //realise Tomcat Connection Pool:
        //https://tomcat.apache.org/tomcat-9.0-doc/jndi-datasource-examples-howto.html
        Connection connection = null;

        try {
        Context initialContext = new InitialContext();
        Context envContext  = (Context)initialContext.lookup("java:/comp/env");

            DataSource ds =  (DataSource)envContext.lookup("jdbc/InternetBanking");
            connection = ds.getConnection();
        } catch (NamingException e) {
           logger.error("Error during getConnection with Name", e);
            e.printStackTrace();
        }

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

