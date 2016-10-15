package com.NovikIgor.dao.DAOException;

/**
 * Created by Novik Igor on 05.10.2016.
 */
public class UserNotFoundException extends Exception{
    private static final long serialVersionUID = 5940190815656240023L;

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
