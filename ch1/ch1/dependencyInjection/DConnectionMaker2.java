package ch1.dependencyInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker2 implements ConnectionMaker2{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        // 독자적 방법으로 Connection 생성
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook","root","root");

        return c;
    }
}
