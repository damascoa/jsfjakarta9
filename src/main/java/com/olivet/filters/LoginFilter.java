package com.olivet.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLOutput;

public class LoginFilter implements Filter {


    @Inject
    SessionApplication application;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("INI");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("DO FILTER ");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String sessionId = req.getSession().getId();
        System.out.println("SESSION ID "+sessionId);



        if (req.getSession().getAttribute("loggedUser") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() );
        }
    }

    @Override
    public void destroy() {
        System.out.println("DESTROy");
        Filter.super.destroy();
    }
}
