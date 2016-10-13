package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.DAOException.DatabaseException;
import com.NovikIgor.dao.UserManagementDAO;
import com.NovikIgor.dao.pool.ConnectionPool;
import com.NovikIgor.dto.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Novik Igor on 06.10.2016.
 */
public class UserManagmentDAOimpl implements UserManagementDAO {

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Users";
    private static final String SQL_SELECT_ALL_USERS_BY_ID = "SELECT * FROM Users WHERE login=?";

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
            state = conn.prepareStatement(SQL_SELECT_ALL_USERS_BY_ID);
            state.setString(1,login);
            logger.info(state.toString());
            ResultSet rs = state.executeQuery();
            logger.info("vipolneno");

            user = new User();
            user.setLogin(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setRole(rs.getString(3));
            user.setFirstName(rs.getString(4));
            user.setLastName(rs.getString(5));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException(e);
        } finally {

            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }
        return user;
    }
}
