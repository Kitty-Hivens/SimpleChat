package messanger.app.simplechat;


public class Message {
    private String message;
    private User user;
    private String time;

    public Message(String message, User user,String time){
        this.message = message;
        this.user = user;
        this.time = time;
    }
}
