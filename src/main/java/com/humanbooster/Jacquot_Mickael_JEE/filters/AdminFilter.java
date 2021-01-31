package com.humanbooster.Jacquot_Mickael_JEE.filters;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();


        if ( session.getAttribute("admin") == null ) {

            response.sendRedirect( request.getContextPath() + "/login" );
        } else {

            chain.doFilter( request, response );
        }
    }
}
