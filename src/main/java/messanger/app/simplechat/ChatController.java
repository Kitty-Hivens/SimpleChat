package messanger.app.simplechat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ChatController {
    private final ObservableList<Message> messageList = FXCollections.observableArrayList();
    private User currentUser;

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

        // ENTER / SHIFT+ENTER
        messageField.setOnKeyPressed(event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.ENTER && !event.isShiftDown()) {
                sendMessage();
                event.consume();
            } else if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
                messageField.appendText("\n");
            }
        });

        // Контекстное меню для поля ввода
        // Context menu for input field
        ContextMenu fieldMenu = new ContextMenu();
        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(e -> messageField.paste());
        MenuItem clearItem = new MenuItem("Clear");
        clearItem.setOnAction(e -> messageField.clear());
        fieldMenu.getItems().addAll(pasteItem, clearItem);
        fieldMenu.setOnShowing(e -> clearItem.setDisable(messageField.getText().isEmpty()));
        messageField.setContextMenu(fieldMenu);

        // Контекстное меню для сообщений
        // Context menu for messages
        messageListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Message item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setContextMenu(null);
                } else {
                    setText("[" + item.getTime() + "] " + item.getUser().getUserName() + ": " + item.getMessage());


                    ContextMenu msgMenu = new ContextMenu();

                    MenuItem copyItem = new MenuItem("Copy");
                    copyItem.setOnAction(e -> {
                        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
                        content.putString(item.getMessage());
                        javafx.scene.input.Clipboard.getSystemClipboard().setContent(content);
                    });

                    MenuItem deleteItem = new MenuItem("Delete");
                    deleteItem.setOnAction(e -> messageList.remove(item));

                    msgMenu.getItems().addAll(copyItem, deleteItem);
                    setContextMenu(msgMenu);
                }
            }
        });
    }




    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
