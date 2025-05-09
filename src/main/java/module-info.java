module messanger.app.simplechat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens messanger.app.simplechat to javafx.fxml;
    exports messanger.app.simplechat;
}