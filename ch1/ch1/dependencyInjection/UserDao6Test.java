package ch1.dependencyInjection;


import org.junit.Test;

public class UserDao6Test {
    @Test
    public void UserDao6DTest(){
        ConnectionMaker2 connectionMaker2 = new DConnectionMaker2();
        UserDao6 userDao6 = new UserDao6(connectionMaker2);
    }

    @Test
    public void UserDao6NTest(){
        ConnectionMaker2 connectionMaker2 = new NConnectionMaker2();
        UserDao6 userDao6 = new UserDao6(connectionMaker2);
    }
}
