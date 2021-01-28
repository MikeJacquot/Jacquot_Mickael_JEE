package com.humanbooster.Jacquot_Mickael_JEE.filters;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;


        User session = (User) req.getSession().getAttribute("username");

        if(session != null){
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/");
        }

    }
}
