package toby_spring_ch2.toby_spring_ch2.beanFactory;

public class AccountDao {
    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
}
