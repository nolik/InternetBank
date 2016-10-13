package com.NovikIgor.dao.DAOException;

/**
 * Created by Novik Igor on 06.10.2016.
 */
public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 5940190815656240023L;

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
