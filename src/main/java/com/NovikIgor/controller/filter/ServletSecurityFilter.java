package com.NovikIgor.controller.filter;

import com.NovikIgor.dao.mock.ClientType;

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

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        ClientType clientType = (ClientType) session.getAttribute("role");

        if (clientType == null) {
            session.setAttribute("role", ClientType.GUEST);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        filterChain.doFilter(req, resp);
    }

    public void destroy() {

    }
}