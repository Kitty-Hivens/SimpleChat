module messanger.app.simplechat {
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jfxtras.styles.jmetro;

    opens messanger.app.simplechat to javafx.fxml;
    exports messanger.app.simplechat;
}