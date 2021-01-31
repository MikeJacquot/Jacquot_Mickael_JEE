package com.humanbooster.Jacquot_Mickael_JEE.servlet.admin;

import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;


import java.io.File;
import java.io.IOException;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        List<String> errors = new ArrayList<>();
        String nom = null;
        String prenom;
        String tel = null;
        String login = null;
        ;
        String password = null;
        Date date;
        String role = null;


        date = java.sql.Date.valueOf(request.getParameter("date"));

        nom = request.getParameter("nom");

        prenom = request.getParameter("prenom");

        tel = request.getParameter("tel");

        login = request.getParameter("login");

        password = request.getParameter("password");

        role = request.getParameter("role");

        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + "uploads";


        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String uniqueID = UUID.randomUUID().toString();
        String filePath = uploadFilePath + File.separator + uniqueID + ".jpg";
        String image = uniqueID + ".jpg";


        // write all files in upload folder
        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {


                part.write(filePath);
            }
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            this.doGet(request, response);
        } else {
            try {
                User newUser = new User(image, nom, prenom, date, tel, role, login, password);
                int id = userService.create(newUser);
                newUser.setId(id);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            response.sendRedirect(request.getContextPath() + "/admin/adminwelcome");

        }
    }

}




