package ch2.factory;

public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    public AccountDao accountDao(){
        return new AccountDao(connectionMaker()); // 중복 코드 분리
    }

    public MessageDao messageDao(){
        return new MessageDao(new DConnectionMaker()); // 중복 발생
    }

    //중복 코드 분리
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
