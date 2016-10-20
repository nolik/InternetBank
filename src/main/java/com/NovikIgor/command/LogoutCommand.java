package com.NovikIgor.command;

import com.NovikIgor.recourceManagment.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class that implement Logout logic in command pattern.
 * Responsible for close session and redirect user to login page.
 *
 * Created by Novik Igor on 20.10.2016.
 */
public class LogoutCommand implements ActionCommand{
    private static Logger logger = Logger.getLogger(LogoutCommand.class);


    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        request.getSession().invalidate();
        return page;
    }
}


