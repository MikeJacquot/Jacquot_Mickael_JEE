package com.humanbooster.Jacquot_Mickael_JEE.service;



import com.humanbooster.Jacquot_Mickael_JEE.model.User;
import com.humanbooster.Jacquot_Mickael_JEE.utils.DAO;
import com.humanbooster.Jacquot_Mickael_JEE.utils.DataConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements DAO<User, Integer> {

    private Connection connection;

    public UserService() {
        try {
            this.connection = DataConnect.getConnexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        String query = "SELECT * FROM users;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = prepareStatement.executeQuery();
        while(resultSet.next()){
            int idUser = resultSet.getInt("id");
            String imgLink = resultSet.getString("image_link");
            String lastName = resultSet.getString("lastname");
            String firstName = resultSet.getString("firstname");
            Date date = (resultSet.getDate("date_entree"));
            String tel = resultSet.getString("numero_tel");
            String role = resultSet.getString("role");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            User nextUser = new User(idUser,imgLink,lastName,firstName,date,tel,role,login,password);
            users.add(nextUser);
        }
        resultSet.close();
        prepareStatement.close();
        return users;
    }

    @Override
    public User getById(Integer id) throws SQLException {

        User user = null;

        String query = "SELECT * FROM users WHERE id = ? ;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        if(resultSet.next()) {
            Integer idUser = resultSet.getInt("id");
            String imgLink = resultSet.getString("image_link");
            String lastName = resultSet.getString("lastname");
            String firstName = resultSet.getString("firstname");
            Date date = resultSet.getDate("date_entree");
            String tel = resultSet.getString("numero_tel");
            String role = resultSet.getString("role");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");


            user = new User(idUser,imgLink,lastName,firstName,date,tel,role,login,password);
        }

        return user;
    }

    @Override
    public Integer create(User user) throws SQLException {
        String query = "INSERT INTO users(image_link, lastname, firstname, date_entree, numero_tel, role, login, password)" +
                "VALUES(?,?,?,?,?,?,?,?);";
        PreparedStatement prepst = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        prepst.setString(1, user.getImage_link());
        prepst.setString(2, user.getLastName());
        prepst.setString(3, user.getFirstName());
        prepst.setDate(4, new java.sql.Date(user.getDate_entree().getTime()));
        prepst.setString(5, user.getNumero_tel());
        prepst.setString(6, user.getRole());
        prepst.setString(7, user.getLogin());
        prepst.setString(8, user.getPassword());

        prepst.executeUpdate();
        ResultSet resultSet = prepst.getGeneratedKeys();

        Integer generatedId = null;

        if (resultSet.next()) {
            generatedId = resultSet.getInt(1);
            user.setId(generatedId);
            getAll().add(user);
        }
        return generatedId;
    }

    @Override
    public Integer update(User user) throws SQLException {
        String query = "UPDATE users "+
                "SET image_link = ?, lastname = ?,firstname = ?,date_entree = ?,numero_tel = ?, role = ?,login = ?,password = ?   where id = ?;";

        PreparedStatement prepst = this.connection.prepareStatement(query);
        prepst.setString(1, user.getImage_link());
        prepst.setString(2, user.getLastName());
        prepst.setString(3, user.getFirstName());
        prepst.setDate(4, new java.sql.Date(user.getDate_entree().getTime()));
        prepst.setString(5, user.getNumero_tel());
        prepst.setString(6, user.getRole());
        prepst.setString(7, user.getLogin());
        prepst.setString(8, user.getPassword());
        prepst.setInt(9,user.getId());


        Integer nbUpdated = prepst.executeUpdate();
        prepst.close();

        return nbUpdated;
    }

    @Override
    public void delete(User user) throws SQLException {
        String query = "DELETE from users where id = ?;";


        PreparedStatement prepst = this.connection.prepareStatement(query);
        prepst.setInt(1, user.getId());

        prepst.executeUpdate();

    }

    public User getByLogin(String login) throws SQLException {
        User targetUser = null;

        String query = "SELECT * FROM users WHERE login = ? ;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, login);

        ResultSet resultSet = prepareStatement.executeQuery();

        if(resultSet.next()) {
            Integer idUser = resultSet.getInt("id");
            String imgLink = resultSet.getString("image_link");
            String lastName = resultSet.getString("lastname");
            String firstName = resultSet.getString("firstname");
            Date date = resultSet.getDate("date_entree");
            String tel = resultSet.getString("numero_tel");
            String role = resultSet.getString("role");
            String name = resultSet.getString("login");
            String password = resultSet.getString("password");



            targetUser = new User(idUser,imgLink,lastName,firstName,date,tel,role,name,password);
        }

        return targetUser;


    }
    public boolean checkUser(String login,String password) {
        try {
            if(getByLogin(login).getPassword().equals(password)){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public java.util.Date convertSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }








}