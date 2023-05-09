package eus.ehu.sprint1.controllers;

import eus.ehu.sprint1.domain.BigBone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import social.bigbone.api.exception.BigBoneRequestException;


import java.io.File;
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
    void openfiles(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        Stage stage = (Stage) image.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                Image image = new Image(file.toURI().toString());


            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se pudo cargar la imagen");
                alert.setContentText("El archivo seleccionado no es una imagen válida.");
                alert.showAndWait();
            }
        }
    }



}
