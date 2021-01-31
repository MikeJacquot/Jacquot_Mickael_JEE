package com.humanbooster.Jacquot_Mickael_JEE.servlet.admin;


import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.UUID;


public class EditUserServlet extends HttpServlet {
    UserService cs = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idUser = Integer.parseInt(request.getParameter("id"));
        try {
            User chosenOne = cs.getById(idUser);
            request.setAttribute("chosenOne", chosenOne);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService cs = new UserService();
        int id = Integer.parseInt(request.getParameter("id"));
        String image = request.getParameter("image");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Date date = Date.valueOf(request.getParameter("date"));
        String tel = request.getParameter("tel");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


        User userToUpdate = new User(id, image, nom, prenom, date, tel, role, login, password);
        try {
            cs.update(userToUpdate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + "uploads";


        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String uniqueID = UUID.randomUUID().toString();
        String filePath = uploadFilePath + File.separator + uniqueID +".jpg";


        // write all files in upload folder
        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {


                part.write(filePath);
            }
        }

        response.sendRedirect("/admin/adminwelcome");

    }
}