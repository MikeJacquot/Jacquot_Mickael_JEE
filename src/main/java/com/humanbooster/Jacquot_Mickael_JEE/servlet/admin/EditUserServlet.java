package com.humanbooster.Jacquot_Mickael_JEE.servlet.admin;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.Integer.parseInt;


public class EditUserServlet extends HttpServlet {
    private UserService userservice;


    public EditUserServlet() {
        this.userservice = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = parseInt(request.getParameter("id"));
        User chosenOne = null;
        try {
            chosenOne = userservice.getById(idUser);
            request.setAttribute("chosenOne", chosenOne);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("edit_user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id =Integer.parseInt(request.getParameter("id"));
        String imgLink = request.getParameter("image_link");
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        Date date = Date.valueOf(request.getParameter("date_entree"));
        String tel = request.getParameter("numero_tel");
        String role = request.getParameter("role");
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        User userToUpdate = new User(id,imgLink,lastName,firstName,date,tel,role,login,password);
        try {
            userservice.updatev2(userToUpdate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/adminwelcome");

    }
}
