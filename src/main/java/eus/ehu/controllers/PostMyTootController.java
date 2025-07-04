package eus.ehu.controllers;

import eus.ehu.domain.BigBone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import social.bigbone.api.exception.BigBoneRequestException;


import java.io.*;
import java.net.URISyntaxException;
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
    private Button file;
    @FXML
    private ImageView image;
    private  File files;
    @FXML
    private Button sensebuton;
    @FXML
    private TextField spoilertext;

    @FXML
    void initialize() throws BigBoneRequestException {

        postbutton.setOnAction(postbutton.getOnAction());
        content.textProperty().addListener((observable, oldValue, newValue) -> {
            String[] words = newValue.split("\\s+");
            int wordCount = words.length;
            wordcounter.setText("Nº of words: " + wordCount);

    });


    }

    public void postToot(ActionEvent actionEvent) throws BigBoneRequestException, IOException, URISyntaxException {
        int max = 11000;

        if (content.getText().length() > max) {
            warining.setText("The toot is too long!");
        } else {
            BigBone bigBone = BigBone.getInstance();


           if (image.getImage()!=null){

               if (spoilertext.getText()!=null){
                   bigBone.PostStatusWithMediaAttached(content.getText(), bigBone.getTOKEN(), files, spoilertext.getText());
               }
                else {
                     bigBone.PostStatusWithMediaAttached(content.getText(), bigBone.getTOKEN(), files, "");
                }
            }else {

               bigBone.postToot(content.getText());

            }
           }

            warining.setText("Toot posted!");
            warining.setFill(Color.GREEN);
        }


    @FXML
    void openfiles(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        Stage stage = (Stage) image.getScene().getWindow();
        files = fileChooser.showOpenDialog(stage);


        image.setImage(new Image(files.toURI().toString()));


    }
    @FXML
    void sensitive(ActionEvent event) {
        if (sensebuton.isPressed()) {
            spoilertext.setVisible(false);
        } else {
            spoilertext.setVisible(true );
        }

    }

    public void changeSize(){
        postbutton.setPrefHeight(53);
    }



}
