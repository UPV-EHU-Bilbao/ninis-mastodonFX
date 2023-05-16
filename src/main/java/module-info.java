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
    requires org.jsoup;

    exports eus.ehu;

    opens eus.ehu to com.google.gson, javafx.fxml, org.hibernate.orm.core;
    exports eus.ehu.domain;
    opens eus.ehu.domain to com.google.gson, javafx.fxml, org.hibernate.orm.core;
    exports eus.ehu.controllers;
    opens eus.ehu.controllers to com.google.gson, javafx.fxml, org.hibernate.orm.core;

}