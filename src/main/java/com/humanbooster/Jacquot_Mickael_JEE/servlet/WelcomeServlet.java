package com.humanbooster.Jacquot_Mickael_JEE.servlet;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WelcomeServlet extends HttpServlet {
    private UserService userservice;

    public WelcomeServlet() {
        this.userservice =new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users =new ArrayList<User>();
        if(request.getSession().getAttribute("username") != null){

        try {
            users = userservice.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("welcome.jsp").forward(request,response);}
        else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
