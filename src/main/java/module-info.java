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
    requires java.sql;

    exports eus.ehu.sprint2;

    opens eus.ehu.sprint2 to com.google.gson, javafx.fxml;
    exports eus.ehu.sprint2.Domain;
    opens eus.ehu.sprint2.Domain to com.google.gson, javafx.fxml;
    exports eus.ehu.sprint2.controllers;
    opens eus.ehu.sprint2.controllers to com.google.gson, javafx.fxml;

}