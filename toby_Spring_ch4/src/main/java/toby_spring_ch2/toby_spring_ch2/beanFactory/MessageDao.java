package toby_spring_ch2.toby_spring_ch2.beanFactory;

public class MessageDao {
    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
}
