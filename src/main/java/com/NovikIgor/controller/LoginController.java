package com.NovikIgor.controller;

import com.NovikIgor.dao.mock.Roles;
import com.NovikIgor.dao.mock.UserMock;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * This is controllerServlet class for MVC model of InternetBanking.
 * <p>
 * Created by nolik on 15.09.16.
 */


public class LoginController extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loc", Locale.getDefault());

        /**
         * This is testing Moc for Login Form -> check index.jsp
         */
        UserMock userMock = new UserMock("nolik", "123");

        String login = String.valueOf(req.getParameter("login"));
        String password = String.valueOf(req.getParameter("password"));
        logger.info("authorisation information from Attribute login=%s Attribute password=%S"+login+password);


        if ( login.equals(userMock.getLogin())
                && password.equals(userMock.getPassword()) ){
            req.setAttribute("role", Roles.AuthorisedUser);
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
            logger.info("authorisation of user %s from index.jsp"+ userMock.getLogin());
        }
        else {
            req.getRequestDispatcher("/loginError.jsp").forward(req,resp);
            logger.info("go to loginError.jsp from authorisation mechanism");
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        logger.info("doGet to index.jsp");
    }
}
