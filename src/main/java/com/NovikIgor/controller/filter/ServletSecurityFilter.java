package com.NovikIgor.controller.filter;

import com.NovikIgor.dao.entity.ClientType;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This Fillter block access for unautorisedUsers to servlet.
 * <p>
 * Created by Novik Igor on 22.09.2016.
 */

public class ServletSecurityFilter implements Filter {
    private static Logger logger = Logger.getLogger(Filter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("REQUEST GO THROUGH ServletSecurityFilter");
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Object clientType =  session.getAttribute("role");

        if (clientType == null) {
            session.setAttribute("role", ClientType.GUEST);
            req.getServletContext().getRequestDispatcher("/inex.jsp").forward(req, resp);
            return;
        }
        filterChain.doFilter(req, resp);
    }

    public void destroy() {

    }
}
