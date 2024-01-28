package ch1.dependencyInjection;

import java.sql.Connection;
import java.sql.SQLException;

public class NConnectionMaker2 implements ConnectionMaker2{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
