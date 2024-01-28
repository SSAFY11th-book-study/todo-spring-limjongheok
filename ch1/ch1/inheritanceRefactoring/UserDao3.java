package ch1.inheritanceRefactoring;

import ch1.User1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao3 {
    public void add(User1 user1) throws  ClassNotFoundException, SQLException{
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user1.getId());
        ps.setString(2,user1.getName());
        ps.setString(1,user1.getPassWord());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 get(String id) throws ClassNotFoundException, SQLException{
        Connection c = getConnection();

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
    public  abstract  Connection getConnection() throws SQLException;

}
