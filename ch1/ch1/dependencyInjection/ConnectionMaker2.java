package ch1.dependencyInjection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker2 {
    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
