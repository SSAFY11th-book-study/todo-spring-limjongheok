package com.example.toby_spring_ch5.toby_spring_ch6;

public class UserDaoDeleteAll extends  UserDao{


    public UserDaoDeleteAll(ConnectionMaker connectionMaker) {
        super(connectionMaker);
    }

    // 탬플릿 메소드 패턴
//    @Override
//    protected PreparedStatement makeStatement(Connection c) throws SQLException {
//        PreparedStatement ps;
//        ps = c.prepareStatement("delete from users");
//        return ps;
//    }
}
