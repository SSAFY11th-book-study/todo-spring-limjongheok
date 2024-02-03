package ch2.factory;

import java.sql.SQLException;

public class UserDaoTest {
    public static  void main(String[] args) throws  ClassNotFoundException, SQLException{
        UserDao dao = new DaoFactory().userDao();
        UserDao dao2 = new DaoFactory().userDao();

        System.out.println(dao);
        System.out.println(dao2);
//        User user = new User();
//        user.setName("임종혁");
//        user.setId("1234");
//        user.setPassWord("1234");
//
//        dao.add(user);
    }
}
