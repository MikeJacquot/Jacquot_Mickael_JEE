package com.humanbooster.Jacquot_Mickael_JEE.servlet;

import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class LoginServlet extends HttpServlet {
    private boolean logged = false;
    private boolean admin = false;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        UserService us = new UserService();
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if(name.isEmpty()) {
            errors.add("Le nom d'utilisateur ne peut pas etre vide");

        }

        try {
            if (us.getByLogin(name) == null) {
                errors.add("utilisateur inconnu");
                request.setAttribute("errors",errors);
                this.doGet(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        if (password.isEmpty()) {
            errors.add("Saisissez votre mot de passe");

        }
        if (us.checkUser(name, password)) {
            request.getSession().setAttribute("username", name);
            this.logged = true;
            request.getSession().setAttribute("logged",this.logged);
            if(us.checkAdmin(name)){
                this.admin = true;
                request.getSession().setAttribute("admin",this.admin);
            response.sendRedirect(request.getContextPath()+"/adminwelcome");
            return;
            }else{
                this.admin = false;
                response.sendRedirect(request.getContextPath()+"/welcome");
                return;
            }

        }else{
            errors.add("mauvais mot de passe !");
        }



        request.setAttribute("errors",errors);
        this.doGet(request, response);
    }


}
