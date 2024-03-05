package com.example.toby_spring_ch5.toby_spring_ch6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatement implements StatementStrategy{
    User user;

    public AddStatement(User user){
        this.user  = user;
    }
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(1,user.getName());
        ps.setString(1,user.getPassWord());
        return ps;
    }


}
