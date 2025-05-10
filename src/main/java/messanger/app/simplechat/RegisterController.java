package messanger.app.simplechat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

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

        boolean success = registerUser(username, password);

        if (success) {
            statusLabel.setText("Registration successful!");

            // Создаём пользователя
            // Create user
            User user = new User(username, password, "email@placeholder.com");
            clearFields();

            // Переход в чат
            // Move to chat
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
                Parent root = loader.load();

                ChatController chatController = loader.getController();
                chatController.setCurrentUser(user);

                Stage stage = (Stage) registerButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                // JMetro css
                JMetro jMetro = new JMetro(Style.LIGHT);
                jMetro.setScene(scene);
                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            statusLabel.setText("Registration failed.");
        }
    }


    // Dummy method for now – you can connect it to a database later
    // Лог регистрации корректного пользователя
    private boolean registerUser(String username, String password) {
        System.out.println("Registered user: " + username + " with password: " + password);
        return true;
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }
}
