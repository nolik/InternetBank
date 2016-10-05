package com.NovikIgor.dao;

import com.NovikIgor.dao.DAOException.UserNotFoundException;
import com.NovikIgor.dto.User;

import java.util.List;

/**
 * DAO  interface for work with Users fro DB.
 *
 * Created by Novik Igor on 05.10.2016.
 */
public interface UserManagementDAO {
    public List<User> getAllUsers() throws UserNotFoundException;

    public User getUsersByElement(String element, String elementValue) throws UserNotFoundException;

}
