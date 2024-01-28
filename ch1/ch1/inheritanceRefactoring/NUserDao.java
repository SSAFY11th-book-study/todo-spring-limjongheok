package ch1.inheritanceRefactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends  UserDao3{
    @Override
    public Connection getConnection() throws SQLException {
        // n사 mysql
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook","root","root");
        return c;
    }
}
