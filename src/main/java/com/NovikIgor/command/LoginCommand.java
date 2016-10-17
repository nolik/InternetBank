package com.NovikIgor.command;


import com.NovikIgor.dao.DAOException.UserNotFoundException;
import com.NovikIgor.dao.UserManagementDAO;
import com.NovikIgor.dao.entity.ClientType;
import com.NovikIgor.dao.impl.UserManagmentDAOimpl;
import com.NovikIgor.dto.User;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by nolik on 15.10.16.
 */
public class LoginCommand  implements ActionCommand{
    private static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    private UserManagementDAO userManager;

    private static Logger logger = Logger.getLogger(ActionCommand.class);

    public String execute(HttpServletRequest req) {
        userManager = new UserManagmentDAOimpl();
        String page;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = null;


        UserManagementDAO session = new UserManagmentDAOimpl();
        try {
            user = session.getUsersByLogin(login);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("User by login returned form DAO");

        logger.info("authorisation information from Attribute login=" + login + "Attribute password=%s" + password);
        HttpSession session1 = req.getSession();
        if(user != null && login.equals(user.getLogin()) && password.equals(user.getPassword())) {
            session1.setAttribute("role", ClientType.CLIENT);
         page = ConfigurationManager.getProperty("/main.jsp");
            logger.info("authorisation of user %s from index.jsp" + user.getLogin());
        } else {
            session1.setAttribute("role", ClientType.GUEST);
            page = ConfigurationManager.getProperty("/loginError.jsp");
            logger.info("go to loginError.jsp from authorisation mechanism");
        }


        return page;
    }
}
