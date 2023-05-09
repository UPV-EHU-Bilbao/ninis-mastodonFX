package eus.ehu.sprint1.controllers;

import eus.ehu.sprint1.domain.BigBone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private Label wordcounter;
    @FXML
    private ImageView image;

    @FXML
    private TextField imagepath;

    @FXML
    void initialize() throws BigBoneRequestException {

        postbutton.setOnAction(postbutton.getOnAction());
        content.textProperty().addListener((observable, oldValue, newValue) -> {
            String[] words = newValue.split("\\s+");
            int wordCount = words.length;
            wordcounter.setText("Nº of words: " + wordCount);
    });


    }

    public void postToot(ActionEvent actionEvent) throws BigBoneRequestException {
        int max = 11000;

        if (content.getText().length() > max) {
            warining.setText("The toot is too long!");
        } else {
            BigBone bigBone = BigBone.getInstance();
/*
           if (!imagepath.getText().isEmpty()){
               bigBone.PostStatusWithMediaAttached(content.getText(),bigBone.getTOKEN());
            }else {

                bigBone.postToot(content.getText());
            }

 */
            bigBone.postToot(content.getText());
            warining.setText("Toot posted!");
            warining.setFill(javafx.scene.paint.Color.GREEN);
        }

    }
    @FXML
    void showimage(ActionEvent event) {
        if(!imagepath.getText().isEmpty()){
            image.setImage(new javafx.scene.image.Image(imagepath.getText()));
        }else{
            warining.setText("You must enter a valid URL");
            warining.setFill(javafx.scene.paint.Color.RED);
        }
    }

}
