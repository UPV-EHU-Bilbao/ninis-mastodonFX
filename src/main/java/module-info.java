module eus.ehu.Spring1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires javafx.web;

    opens eus.ehu.spring1 to javafx.fxml;
    exports eus.ehu.spring1;
    opens eus.ehu.spring1.Domain to com.google.gson;
}