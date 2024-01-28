package ch1.interfaceRefactoring;

import ch1.User1;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao5 {
    private ConnectionMaker connectionMaker;

    public UserDao5(){
        connectionMaker = new DConnectionMaker();
    }

    public void add(User1 user1) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();
        // 기존 코드와 동일
    }

    public User1 get(User1 user1) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();
        // 기존 코드와 동일
        return  user1;

    }

}
