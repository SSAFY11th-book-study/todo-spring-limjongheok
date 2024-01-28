package ch1.extractDuplicateMethods;


import ch1.User1;
import ch1.User1Dao;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class User2DaoTest {

    @Test
    public void user2Test() throws SQLException, ClassNotFoundException {
        User2Dao user2Dao = new User2Dao();
        User1 findUser = user2Dao.get("witeship");
        Assert.assertEquals("witeship",findUser.getId());
    }
}
