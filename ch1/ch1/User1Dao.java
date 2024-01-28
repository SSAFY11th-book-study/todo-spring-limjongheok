package ch1;

import java.sql.*;

public class User1Dao {

    // create user
    public void add(User1 user1) throws  ClassNotFoundException , SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook","root","pdw06135@");

        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user1.getId());
        ps.setString(2,user1.getName());
        ps.setString(3,user1.getPassWord());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    // read user
    public User1 get(String id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook","root","pdw06135@");

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User1 user = new User1();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassWord(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();
        return user;
    }



}
