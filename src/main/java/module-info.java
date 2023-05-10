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
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires javafx.swing;

    exports eus.ehu.sprint1;

    opens eus.ehu.sprint1 to com.google.gson, javafx.fxml, org.hibernate.orm.core;
    exports eus.ehu.sprint1.domain;
    opens eus.ehu.sprint1.domain to com.google.gson, javafx.fxml, org.hibernate.orm.core;
    exports eus.ehu.sprint1.controllers;
    opens eus.ehu.sprint1.controllers to com.google.gson, javafx.fxml, org.hibernate.orm.core;

}