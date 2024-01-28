package ch1.extractClass;

import ch1.User1;
import ch1.User1Dao;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class User4Test {

    @Test
    public void user4Test() throws SQLException, ClassNotFoundException {
        UserDao4 userDao4 = new UserDao4();
        User1 findUser = userDao4.get("witeship");
        Assert.assertEquals("witeship",findUser.getId());
    }
}
