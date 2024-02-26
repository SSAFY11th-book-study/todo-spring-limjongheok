package com.example.toby_spring_ch5.toby_spring_ch5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
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
            ps = c.prepareStatement("delete from users");
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
}
