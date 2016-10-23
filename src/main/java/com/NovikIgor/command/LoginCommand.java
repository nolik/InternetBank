package com.NovikIgor.command;


import com.NovikIgor.dao.entity.ClientType;
import com.NovikIgor.dao.impl.UserManagmentDAOimpl;
import com.NovikIgor.dto.User;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Command class responsible for Login from login page.
 * <p>LoginCommand command implementation of Command patter.</p>
 */
public class LoginCommand implements ActionCommand {
    private static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    private UserManagmentDAOimpl userManager;
    User user = null;

    private static Logger logger = Logger.getLogger(ActionCommand.class);

    public String execute(HttpServletRequest req) {
        userManager = new UserManagmentDAOimpl();
        String page = null;

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);


        logger.info("authorisation information from Attribute login=" + login
                + " \n Attribute password=" + password);

        logger.info("initialise session in during login command implementation. next step - check login with DB");
        //check for registration user if it's not unique print cause on the web page
        boolean haveLogin = userManager.checkLogin(login);

        if (!haveLogin) {
            req.setAttribute("loginNotFoundMessage", MessageManager.getProperty("message.loginNotFound"));
            page = ConfigurationManager.getProperty("path.page.loginError");
            return page;
        }

        //for avoid exception we connect to DB and get user after check login
        // in previous if() block;
        user = userManager.getUsersByLogin(login);

        if (checkingLogin(login, password, user)) {
            req.getSession().setAttribute("login", login);
            String role = user.getRole();
            //check Administrator role and if administrator redirect it to admin page
            if (role.equals(ClientType.ADMIN)) {
                req.getSession().setAttribute("role", ClientType.ADMIN);
                return ConfigurationManager.getProperty("path.page.admin");
            }

            //for all others
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("firstName", user.getFirstName());
            req.getSession().setAttribute("lastName", user.getLastName());
            page = ConfigurationManager.getProperty("path.page.main");

        } else {
            req.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.loginError");
        }


        return page;
    }

    /**
     * Validate the password from login page with password in DB.
     * <p> TODO: In future planing use MD5 hashing. </p>
     *
     * @param login    login from request from login page.
     * @param password password from login form from login page.
     * @return true - if password valid.
     */

    private boolean checkingLogin(String login, String password, User user) {


        logger.info("User by login returned form DAO");
        if (password.equals(user.getPassword())) return true;
        else return false;
    }
}
