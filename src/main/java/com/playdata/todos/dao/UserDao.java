package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.playdata.todos.servlet.UserServlet.users;
import static java.time.chrono.JapaneseEra.values;

public class UserDao {

    //data access object
    public void insert(User user) {
        Connection conn =new JdbcConnection().getJdbc();
        String sql = "insert into users(username,password,name)"+
                "values(?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getName());
            pst.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException();

        }

    }
    public boolean login2(String id, String password)
    {
        Connection conn =new JdbcConnection().getJdbc();
        String sql = "select id, password from users where username = ? and password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,password);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next())
            {
                return true;
            }
        }
        catch (SQLException e){
            throw new RuntimeException();

        }
        return false;


    }
    public boolean login(String id, String password)
    {
        Connection conn =new JdbcConnection().getJdbc();
        String sql = "select id, username,name,password,create_at"+
                "from users" +
                "where username = ? and password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,password);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next())
            {
                users.add(makeUser(resultSet));
                return true;
            }

        }
        catch (SQLException e){
            throw new RuntimeException();

        }
        return users.size()!=0;
    }
    private User makeUser(ResultSet resultSet){
        Integer id;
        String password, username, name, createAt;
        try {
            id = resultSet.getInt("id");
        }catch (SQLException e) {
            id = null;
        }
        try {
            password = resultSet.getString("password");
        }catch (SQLException e) {
            password = null;
        }
        try {
            username = resultSet.getString("username");
        }catch (SQLException e) {
            username = null;
        }
        try {
            name = resultSet.getString("name");
        }catch (SQLException e) {
            name = null;
        }
        try {
            createAt = resultSet.getString("createAt");
        }catch (SQLException e) {
            createAt = null;
        }
        return new User(id,username,password,name,createAt);
    }
}
