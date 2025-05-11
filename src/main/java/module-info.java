module messenger.app.simplechat {
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jfxtras.styles.jmetro;
    requires com.google.gson;

    opens messenger.app.simplechat to javafx.fxml;
    exports messenger.app.simplechat;
}