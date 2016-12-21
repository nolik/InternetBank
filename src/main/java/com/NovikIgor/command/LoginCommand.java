package com.NovikIgor.command;


import com.NovikIgor.dao.entity.ClientType;
import com.NovikIgor.dao.impl.CardManagmentDAOimpl;
import com.NovikIgor.dao.impl.UserManagmentDAOimpl;
import com.NovikIgor.dto.Card;
import com.NovikIgor.dto.User;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.NovikIgor.recourceManagment.ProjectConstants.ATTR_USER_CARDS;
import static com.NovikIgor.recourceManagment.ProjectConstants.LOGIN;
import static com.NovikIgor.recourceManagment.ProjectConstants.PASSWORD;

/**
 * Command class responsible for Login from login page.
 * <p>LoginCommand command implementation of Command patter.</p>
 */
public class LoginCommand implements ActionCommand {

    private UserManagmentDAOimpl userManager;
    private CardManagmentDAOimpl cardManager;
    User user = null;
    List<Card> userCards = null;

    private static Logger logger = Logger.getLogger(LoginCommand.class);

    public String execute(HttpServletRequest req) {
        String page = null;
        HttpSession session = req.getSession();
        userManager = new UserManagmentDAOimpl();
        cardManager = new CardManagmentDAOimpl();

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
        //take all user cards from DB
        userCards = cardManager.getCardsByLogin(login);


        if (checkingLogin(login, password, user)) {
            session.setAttribute("login", login);
            String role = user.getRole();
            //check Administrator role and if administrator redirect it to admin page
            if (role.equals(ClientType.ADMIN)) {
                session.setAttribute("role", ClientType.ADMIN);
                return ConfigurationManager.getProperty("path.page.admin");
            }

            //for all others (Typically must be USER)
            session.setAttribute("role", role);
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());

            //* TODO: next step realize this in attributes. DO it multithreaded stable!!!


            session.setAttribute(ATTR_USER_CARDS, userCards);

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
     * <p> Based on MD5 hashing. </p>
     *
     * @param login    login from request from login page.
     * @param password password from login form from login page.
     * @return true - if password valid.
     */

    private boolean checkingLogin(String login, String password, User user) {

        byte b[] = new byte[0];
        String mD5passwordSumm = "";
        try {
            b = java.security.MessageDigest.getInstance("MD5").digest((login + ":" + password).getBytes());
            java.math.BigInteger bi = new java.math.BigInteger(1, b);
            mD5passwordSumm = bi.toString(16);
            while (mD5passwordSumm.length() < 32)
                mD5passwordSumm = "0" + mD5passwordSumm;

            logger.info("User by login returned form DAO");
            if (mD5passwordSumm.equals(user.getPassword())) return true;
            else return false;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
