package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.DAOException.DatabaseException;
import com.NovikIgor.dao.UserManagementDAO;
import com.NovikIgor.dao.pool.ConnectionPool;
import com.NovikIgor.dto.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Novik Igor on 06.10.2016.
 */
public class UserManagmentDAOimpl implements UserManagementDAO {

    private static final String SQL_CHECK_LOGIN_IN_DB = "SELECT * FROM InternetBanking.Users WHERE login=?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM InternetBanking.Users";
    private static final String SQL_SELECT_ALL_USERS_BY_LOGIN = "SELECT * FROM InternetBanking.Users WHERE login=?";
    //private static final String SQL_SELECT_USER_AND_CARD_AND_CURRENCY_OF_CARD_BY_LOGIN="SELECT * FROM InternetBanking.Users INNER JOIN InternetBanking.Cards INNER JOIN InternetBanking.Currencies ON Users.login=Cards.Users_login AND Currencies.idCurrency=Cards.Currencies_idCurrency WHERE Users.login=?";

    private static final Logger logger = Logger.getLogger(UserManagmentDAOimpl.class);


    public List<User> getAllUsers() {
        Connection conn = null;
        PreparedStatement state = null;
        LinkedList<User> allUsers = new LinkedList<User>();
        try {
            conn = ConnectionPool.getConnection();
            state = conn.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setLogin(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setRole(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                allUsers.add(user);
            }
            return allUsers;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException(e);
        } finally {

            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }
    }


    public User getUsersByLogin(String login) {
        Connection conn = null;
        PreparedStatement state = null;
        User user = null;

        try {
            logger.info("Here will be get connection!");
            conn = ConnectionPool.getConnection();
            logger.info("Connection recieved!");

            state = conn.prepareStatement(SQL_SELECT_ALL_USERS_BY_LOGIN);
            state.setString(1, login);


            logger.info(state.toString());
            logger.info("try to execute SQLQuery");
            //   ResultSet rs =  statement.executeQuery("SELECT * FROM InternetBanking.Users WHERE login='nolik'");
            ResultSet rs = state.executeQuery();
            logger.info("successful");

            while (rs.next()) {
                user = new User();
                user.setLogin(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setRole(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                logger.info("find a user" + user.toString());
                return user;
            }

            logger.info("in UserManagmentDAOimpl all ok, if don't start rs.getString()");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException(e);
        } finally {
            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }
        return user;
    }

    /**
     * Check login from form on login.jsp with information from DB
     *
     * @param login
     * @return true - if login present in DB
     */
    public boolean checkLogin(String login) {
        Connection conn = null;
        PreparedStatement state = null;
        boolean haveLogin = false;

        try {
            conn = ConnectionPool.getConnection();
            state = conn.prepareStatement(SQL_CHECK_LOGIN_IN_DB, Statement.RETURN_GENERATED_KEYS);
            state.setString(1, login);
            ResultSet rs = state.executeQuery();
            haveLogin = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQLExp where checkCartID", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }

        return haveLogin;
    }


}
