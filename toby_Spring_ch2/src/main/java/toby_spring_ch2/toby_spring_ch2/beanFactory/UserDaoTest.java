package toby_spring_ch2.toby_spring_ch2.beanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static  void main(String[] args) throws  ClassNotFoundException, SQLException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        UserDao userDao2 = context.getBean("userDao", UserDao.class);

        System.out.println(userDao);
        System.out.println(userDao2);
//        User user = new User();
//
//        user.setName("스프링 빈 이용");
//        user.setId("222");
//        user.setPassWord("222");
//        userDao.add(user);
    }
}
