package ch2.factory;

public class MessageDao {
    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
}
