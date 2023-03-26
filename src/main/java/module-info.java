module eus.ehu.sprint1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires javafx.web;
    requires bigbone;
    requires jdk.xml.dom;
    requires java.datatransfer;
    requires java.desktop;


    exports eus.ehu.sprint1;

    opens eus.ehu.sprint1 to com.google.gson, javafx.fxml;
}