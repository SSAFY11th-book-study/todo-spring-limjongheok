package toby_spring_ch2.toby_spring_ch2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import toby_spring_ch2.toby_spring_ch2.beanFactory.DaoFactory;
import toby_spring_ch2.toby_spring_ch2.beanFactory.User;
import toby_spring_ch2.toby_spring_ch2.beanFactory.UserDao;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class JUnitUseDaoTest {

    private UserDao userDao;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = context.getBean("userDao", UserDao.class);
         user1 = new User("1","1","1");
         user2 = new User("2","2","2");
         user3 = new User("3","3","3");
    }
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {


        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);


        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);
        User userGet1= userDao.get(user1.getId());
        User userGet2= userDao.get(user2.getId());

        assertThat(userGet1.getName()). isEqualTo(user1.getName());
        assertThat(userGet1.getPassWord()).isEqualTo(user1.getPassWord());

        assertThat(userGet2.getName()).isEqualTo(user2.getName());
        assertThat(userGet2.getPassWord()).isEqualTo(user2.getPassWord());

    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {



        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);
        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }

    @Test
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();
        Assertions.assertThrows(EmptyResultDataAccessException.class,() -> userDao.get("fail"));
        userDao.get("unkonwn_id");

    }
}
