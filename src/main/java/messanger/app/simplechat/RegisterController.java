package messanger.app.simplechat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        // Simulate successful registration
        boolean success = registerUser(username, password);

        if (success) {
            statusLabel.setText("Registration successful!");
            clearFields();
        } else {
            statusLabel.setText("Registration failed.");
        }
    }

    // Dummy method for now – you can connect it to a database later
    private boolean registerUser(String username, String password) {
        System.out.println("Registered user: " + username + " with password: " + password);
        return true;
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }
}
