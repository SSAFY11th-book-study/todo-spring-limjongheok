package ch1.extractDuplicateMethods;

import ch1.User1;

import java.sql.*;

public class User2Dao {
    public void add(User1 user1) throws  ClassNotFoundException , SQLException {

    Connection c = getConnection();

    PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
    ps.setString(1,user1.getId());
    ps.setString(2,user1.getName());
    ps.setString(1,user1.getPassWord());

    ps.executeUpdate();
    ps.close();
    c.close();
}

    // read user
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

    // 추출
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook","root","root");
        return c;
    }
}
