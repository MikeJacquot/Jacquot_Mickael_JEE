package com.humanbooster.Jacquot_Mickael_JEE.servlet.admin;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


public class DeleteUserServlet extends HttpServlet {
    private UserService userService;

    public DeleteUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCandidat = Integer.parseInt(request.getParameter("id"));
        try {
            User chosenOne = userService.getById(idCandidat);
            userService.delete(chosenOne);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/adminwelcome");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
