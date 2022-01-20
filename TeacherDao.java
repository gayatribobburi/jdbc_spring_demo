package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dxc.model.Teacher;


public class TeacherDao {

    private static final String INSERT_ONE_Teacher;

    private static final String SELECT_ALL_Teacher;


    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final String URL;


    static {
        INSERT_ONE_TEACHER = "INSERT INTO Teacher (name, sub, id) VALUES (?, ?, ?)";
        SELECT_ALL_TEACHER = "SELECT * FROM teacher";

        USER_NAME = "root";
        PASSWORD = "password";

        // URL = "jdbc:mysql://server-name or server-ip-address:port/database-name";
        URL = "jdbc:mysql://localhost:3306/dxc";
    }

    public TeacherDao() {

    }

    public List<Teacher> findAll() throws SQLException{
        List<Teacher> teacher = null;
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_TEACHER);
        teacher = new ArrayList();
        while (rs.next()) {
            teacher.add(new teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        rs.close();
        statement.close();
        connection.close();
        return teacher;
    }

    public int save(Teacher teacher) throws SQLException {
        System.out.println("Saving teacher: " + teacher);

        // Load the JDBC Driver
        // Automatically done for version 8 and above
        // DriverManager.registerDriver(Driver.class);
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // Get a connection to the database
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_TEACHER);

        ps.setString(1, teacher.getName());
        ps.setString(2, teacher.getSub());
        ps.setString(3, teacher.getId());

        int rows = 0;
        rows = ps.executeUpdate();

        ps.close();
        connection.close();

        return rows;

    }

}