module eus.ehu.sprint1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires javafx.web;

    exports eus.ehu.sprint1;
    opens eus.ehu.sprint1.Domain to com.google.gson;
    opens eus.ehu.sprint1 to com.google.gson, javafx.fxml;
}