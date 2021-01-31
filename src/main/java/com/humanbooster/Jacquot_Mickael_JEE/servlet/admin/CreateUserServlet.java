package com.humanbooster.Jacquot_Mickael_JEE.servlet.admin;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;


import java.io.File;
import java.io.IOException;

import java.sql.SQLException;


import java.util.Date;
import java.util.UUID;


public class CreateUserServlet extends HttpServlet {

    private UserService userService;

    public CreateUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/create_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Date date = java.sql.Date.valueOf(request.getParameter("date"));
        String tel = request.getParameter("tel");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");



        String applicationPath = request.getServletContext().getRealPath("");

        String uploadFilePath = applicationPath + File.separator + "uploads";


        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String uniqueID = UUID.randomUUID().toString();
        String filePath = uploadFilePath + uniqueID +".jpg";
        String image = uniqueID + ".jpg";


        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {


                part.write(filePath);
            }
        }
        try {
            User newUser = new User(image, nom, prenom, date, tel, role, login, password);
            int id = userService.create(newUser);
            newUser.setId(id);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/admin/adminwelcome");

        }

    }

