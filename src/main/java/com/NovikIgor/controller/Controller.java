package com.NovikIgor.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * This is controllerServlet class for MVC model of InternetBanking.
 * <p>
 * Created by nolik on 15.09.16.
 */
public class Controller extends HttpServlet {
    private static Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loc", Locale.getDefault());
        req.getSession().setAttribute("calend", Calendar.getInstance());
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
        logger.info("doPost from index.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        logger.info("doGet to index.jsp");
    }
}
