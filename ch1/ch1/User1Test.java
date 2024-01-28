package ch1;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class User1Test {
    @Test
    public void user1Test() throws SQLException, ClassNotFoundException {
        User1Dao user1Dao = new User1Dao();

        User1 user1 = new User1();
       // user1.setId("witeship");
        //user1.setName("백기선");
        //user1.setPassWord("married");

        //user1Dao.add(user1);

        User1 findUser = user1Dao.get("witeship");
        Assert.assertEquals("witeship",findUser.getId());
    }

}
