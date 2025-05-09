package messanger.app.simplechat;


public class Message {
    private String message;
    private User user;
    private final String time;

    public Message(String message, User user, String time) {
        this.message = message;
        this.user = user;
        this.time = time;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "[" + time + "] " + user.getUserName() + ": " + message;
    }

}
