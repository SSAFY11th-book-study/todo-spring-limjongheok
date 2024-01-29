package ch1.inheritanceRefactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao3{
    @Override
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
