package com.NovikIgor.controller;

import com.NovikIgor.command.ActionCommand;
import com.NovikIgor.command.ActionFactory;
import com.NovikIgor.dao.entity.ClientType;
import com.NovikIgor.recourceManagment.ConfigurationManager;
import com.NovikIgor.recourceManagment.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

import static com.NovikIgor.recourceManagment.ProjectConstants.PARAM_COMMAND;

/**
 * This is controllerServlet class for MVC model of InternetBanking.
 * <p>
 * Created by nolik on 15.09.16.
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = -4051736549894026861L;

    private static Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loc", Locale.getDefault());
        logger.info("Request came to the doPost methode and go to the processRequest");
        String com = req.getParameter(PARAM_COMMAND);
        logger.info("command in request="+com);
        processRequest(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
     //   req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        resp.sendRedirect(ConfigurationManager.getProperty("path.page.index"));
        logger.info("doGet to index.jsp");
    }

    /**
     * This method it's point of entry for servlet in  Command Factory pattern
     * for implementation of different commands realization through one servlet.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(3000);
        if (session.isNew()) {
            session.setAttribute("role", ClientType.GUEST);
        }
        // definition of the command, which came from a JSP
        ActionFactory client = new ActionFactory();

        logger.info("After Creation ActionFactory, try to recognize the command");

        ActionCommand command = client.defineCommand(request);

        logger.info("After recogniz the command start to implement commnad - "
                + command.toString() +
                ", use the methode execute of this command");
        /*
         * Call to implement execute () method and passing parameters
		 * Class-specific command handler
		 *  */
        page = command.execute(request);

        logger.info("methode execute implemented and return page="+page);

        if (page != null) {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(page);
            // Call the page response to the request
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }


}
