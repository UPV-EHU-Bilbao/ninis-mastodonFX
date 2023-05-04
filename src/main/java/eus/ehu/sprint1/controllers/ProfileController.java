package eus.ehu.sprint1.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button followers;

    @FXML
    private Button following;

    @FXML
    private ImageView fotoPerfil;

    @FXML
    private Button myToots;

    @FXML
    private Label username;

    @FXML
    void initialize() {
        assert followers != null : "fx:id=\"followers\" was not injected: check your FXML file 'profile.fxml'.";
        assert following != null : "fx:id=\"following\" was not injected: check your FXML file 'profile.fxml'.";
        assert fotoPerfil != null : "fx:id=\"fotoPerfil\" was not injected: check your FXML file 'profile.fxml'.";
        assert myToots != null : "fx:id=\"myToots\" was not injected: check your FXML file 'profile.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'profile.fxml'.";

    }

}
