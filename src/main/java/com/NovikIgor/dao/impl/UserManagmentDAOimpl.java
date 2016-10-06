package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.DAOException.UserNotFoundException;
import com.NovikIgor.dao.UserManagementDAO;
import com.NovikIgor.dto.User;

import java.util.List;

/**
 * Created by Novik Igor on 06.10.2016.
 */
public class UserManagmentDAOimpl implements UserManagementDAO {
    public List<User> getAllUsers() throws UserNotFoundException {
        return null;
    }

    public User getUsersByElement(String element, String elementValue) throws UserNotFoundException {
        return null;
    }
}
