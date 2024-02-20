package toby_spring_ch2.toby_spring_ch2.beanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static  void main(String[] args) throws  ClassNotFoundException, SQLException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("1");
        user.setName("홍길동");
        user.setPassWord("1234");

        userDao.add(user);


        User user2 = userDao.get("1");

        if(!user.getName().equals(user2.getName())){
            System.out.println("테스트 실패  (name)");
        }else if(!user.getPassWord().equals(user2.getPassWord())){
            System.out.println("테스트 실패(password)");
        }else{
            System.out.println("조회 테스트 성공");
        }
    }
}
