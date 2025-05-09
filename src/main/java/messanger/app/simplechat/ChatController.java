package messanger.app.simplechat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ChatController {
    private final ObservableList<Message> messageList = FXCollections.observableArrayList();
    private User currentUser = new User("TEST", "pass", "email@example.com");

    @FXML
    public ListView<Message> messageListView;
    public TextArea messageField;
    public Button sendButton;
    public Button logoutButton;

    @FXML
    public void sendMessage() {
        String text = messageField.getText().trim();
        if (!text.isEmpty()) {

            String time = java.time.LocalTime.now().withNano(0).toString();

            Message message = new Message(text, currentUser, time);
            messageList.add(message);

            messageField.clear();
        }

        messageField.textProperty().addListener((obs, oldText, newText) -> {
            int lines = newText.split("\n", -1).length;

            int maxRows = 5;
            int rowCount = Math.min(lines, maxRows);

            messageField.setPrefRowCount(rowCount);
        });
    }


    @FXML
    public void initialize() {
        messageListView.setItems(messageList);

        messageField.setOnKeyPressed(event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.ENTER && !event.isShiftDown()) {
                sendMessage(); // отправка при нажатии Enter без Shift
                event.consume(); // предотвращаем добавление новой строки
            } else if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
                messageField.appendText("\n"); // вставка новой строки при Shift+Enter
            }
        });
    }



    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
