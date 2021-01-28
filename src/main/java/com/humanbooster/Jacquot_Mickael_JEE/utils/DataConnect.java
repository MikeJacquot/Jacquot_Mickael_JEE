package com.humanbooster.Jacquot_Mickael_JEE.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    public static Connection getConnexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/base_exam_jee_mj?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }


}
