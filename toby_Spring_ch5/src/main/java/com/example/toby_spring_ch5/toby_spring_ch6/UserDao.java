package com.example.toby_spring_ch5.toby_spring_ch6;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public  class UserDao {
    private  ConnectionMaker connectionMaker;


    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassWord());

        ps.executeUpdate();
        ps.close();
        c.close();
        // 기존 코드와 동일
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();

        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassWord(rs.getString("password"));
        }
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassWord(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();
        if(user == null) throw new SQLException();
        return user;

    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = connectionMaker.makeConnection();
            StatementStrategy statementStrategy = new DeleteAllStatement();
            ps = statementStrategy.makePreparedStatement(c);
            ps.executeUpdate();
        }catch (SQLException e){
            throw e;
        }finally {
            if(ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c!=null){
                try {
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }

    public void deleteAll2() throws SQLException, ClassNotFoundException {

        StatementStrategy statementStrategy = new DeleteAllStatement();

        try( Connection c = connectionMaker.makeConnection();
            PreparedStatement ps = statementStrategy.makePreparedStatement(c);
        ) {
            ps.executeUpdate();
        }
        catch (SQLException e){
            throw e;
        }
    }

    // protected PreparedStatement makeStatement(Connection c) throws SQLException;

    public int getCount() throws SQLException,ClassNotFoundException{

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("delete from users");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            throw e;
        }finally {
            if(rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){

                }
            }
            if(ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c!=null){
                try {
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new AddStatement(user);
        jdbcContextWithStatementStrategy(statementStrategy);
    }

    public void deleteUser() throws SQLException, ClassNotFoundException{
        StatementStrategy statementStrategy = new DeleteAllStatement();
        jdbcContextWithStatementStrategy(statementStrategy);
    }
    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException,ClassNotFoundException{
        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = connectionMaker.makeConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){

                }
            }
            if(c!=null){
                try {
                    c.close();
                }catch (SQLException e){

                }
            }
        }
    }

    public void add2(final User user) throws SQLException, ClassNotFoundException {
        class AddStatement implements StatementStrategy{

            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
                ps.setString(1,user.getId());
                ps.setString(1,user.getName());
                ps.setString(1,user.getPassWord());
                return ps;
            }
        }
        StatementStrategy st = new AddStatement();
        jdbcContextWithStatementStrategy(st);
    }

    // 익명클래스 사용
    public void add3(final User user) throws SQLException, ClassNotFoundException {
      StatementStrategy st = new StatementStrategy(){

            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
                ps.setString(1,user.getId());
                ps.setString(1,user.getName());
                ps.setString(1,user.getPassWord());
                return ps;
            }
        };
      jdbcContextWithStatementStrategy(st);
    }

    public void add4(final User user) throws SQLException, ClassNotFoundException {
        jdbcContextWithStatementStrategy(new StatementStrategy(){

            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
                ps.setString(1,user.getId());
                ps.setString(1,user.getName());
                ps.setString(1,user.getPassWord());
                return ps;
            }
        });
    }

    // 3-5장
    private JdbcContext jdbcContext;
    private DataSource dataSource;
    public  void setJdbcContext(DataSource dataSource){
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);

        this.dataSource = dataSource;
    }
    public void add5(final User user) throws  SQLException{
        // jdbcConext 의존을 받고

        // 콜백 StatementStrategy 생성
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy(){

            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
                ps.setString(1,user.getId());
                ps.setString(1,user.getName());
                ps.setString(1,user.getPassWord());
                return ps;
            }
        });
    }

    public void deleteAll3() throws Exception {
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return c.prepareStatement("delete from user");
            }
        });
    }


    public void deleteAll4() throws SQLException, ClassNotFoundException {
        executeSql("delete from users");
    }
    private void executeSql(final String query ) throws SQLException, ClassNotFoundException{
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return c.prepareStatement(query);
            }
        });
    }

    public void deleteAll6() throws  SQLException,ClassNotFoundException{
        this.jdbcContext.equals("delete from users");
    }




}
