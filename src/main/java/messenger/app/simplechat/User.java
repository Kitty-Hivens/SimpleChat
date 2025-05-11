package messenger.app.simplechat;

public class User {
    private String userName;
    private String password;
    private final String Email;

    public User(String userName, String password, String Email) {
        this.userName = userName;
        this.password = password;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void switchPassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password))
            this.password = newPassword;
        else
            System.out.println("Incorrect password");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
