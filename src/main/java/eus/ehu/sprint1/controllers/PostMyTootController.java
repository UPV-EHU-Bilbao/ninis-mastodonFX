package eus.ehu.sprint1.controllers;

import eus.ehu.sprint1.Domain.BigBone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import social.bigbone.api.exception.BigBoneRequestException;


import java.net.URL;
import java.util.ResourceBundle;

public class PostMyTootController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane listItem;

    @FXML
    private Button postbutton;

    @FXML
    private TextArea content;
    @FXML
    private Text warining;

    @FXML
    void initialize() throws BigBoneRequestException {

        postbutton.setOnAction(postbutton.getOnAction());
    }

    public void postToot(ActionEvent actionEvent) throws BigBoneRequestException {
        int max = 500;

        if (content.getText().length() > max) {
            warining.setText("The toot is too long!");
        } else {
            BigBone bigBone = new BigBone();
            bigBone.postToot(content.getText());
            warining.setText("Toot posted!");
            warining.setFill(javafx.scene.paint.Color.GREEN);
        }

    }
}
