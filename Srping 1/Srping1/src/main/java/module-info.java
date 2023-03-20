module eus.ehu.bum4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires javafx.web;

    opens eus.ehu.bum4 to javafx.fxml;
    exports eus.ehu.bum4;
    opens eus.ehu.bum4.Domain to com.google.gson;
}