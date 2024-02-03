package ch2.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassWord());

        ps.executeUpdate();
        ps.close();
        c.close();
        // 기존 코드와 동일
    }

    public User get(User user) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();
        // 기존 코드와 동일
        return  user;

    }
}
