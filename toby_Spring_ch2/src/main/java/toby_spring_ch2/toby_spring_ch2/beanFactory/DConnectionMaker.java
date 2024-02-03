package toby_spring_ch2.toby_spring_ch2.beanFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook","root","pdw06135@");

        return c;
    }
}
