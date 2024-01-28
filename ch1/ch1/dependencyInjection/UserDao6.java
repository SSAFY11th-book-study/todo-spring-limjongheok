package ch1.dependencyInjection;

import ch1.User1;
import ch1.interfaceRefactoring.ConnectionMaker;
import ch1.interfaceRefactoring.DConnectionMaker;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao6 {
    private ConnectionMaker2 connectionMaker;

    public UserDao6(ConnectionMaker2 connectionMaker){
        connectionMaker = connectionMaker;
    }

    public void add(User1 user1) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        // 기존 코드와 동일
    }

    public User1 get(User1 user1) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();
        // 기존 코드와 동일
        return  user1;

    }

}
