package com.example.toby_spring_ch5.toby_spring_ch6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

    PreparedStatement makePreparedStatement(Connection c) throws SQLException;

}
