package toby_spring_ch2.toby_spring_ch2.beanFactory;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;



public class JUnitUseDaoTest {

    private UserDao userDao;

    private User user1;
    private User user2;
    private User user3;

    @Before
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
        Assert.assertThat(userDao.getCount(),is(0));


        userDao.add(user1);
        userDao.add(user2);
        Assert.assertThat(userDao.getCount(),is(2));
        User userGet1= userDao.get(user1.getId());
        User userGet2= userDao.get(user2.getId());

        Assert.assertThat(userGet1.getName(), is(user1.getName()));
        Assert.assertThat(userGet1.getPassWord(),  is(user1.getPassWord()));

        Assert.assertThat(userGet2.getName(), is(user2.getName()));
        Assert.assertThat(userGet2.getPassWord(),  is(user2.getPassWord()));

    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {



        userDao.deleteAll();
        Assert.assertThat(userDao.getCount(),is(0));
        userDao.add(user1);
        Assert.assertThat(userDao.getCount(),is(1));

        userDao.add(user2);
        Assert.assertThat(userDao.getCount(),is(2));

        userDao.add(user3);
        Assert.assertThat(userDao.getCount(),is(3));
    }

    @Test(expected = SQLException.class)

    public void getUserFailure() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();
        Assert.assertThat(userDao.getCount(),is(0));

        userDao.get("unkonwn_id");

    }
}
