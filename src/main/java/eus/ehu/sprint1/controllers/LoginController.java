package eus.ehu.sprint1.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import eus.ehu.sprint1.AppLauncher;
import eus.ehu.sprint1.MainAppController;
import eus.ehu.sprint1.domain.BigBone;
import eus.ehu.sprint1.businessLogic.BlFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {


    private BlFacade bl;

     public LoginController(BlFacade bl) {
        this.bl = bl;
      }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane window;


    @FXML
    private TextField usernameField;

    @FXML
    private Label wrong;

    @FXML
    void login(ActionEvent event) throws IOException {
        if (bl.getTOKEN(usernameField.getText()) == null) {
            wrong.setText("Username does not exist");
        } else{
            BigBone bigbone = BigBone.getInstanceFirst(bl.getTOKEN(usernameField.getText()));
            bigbone.setTOKEN(bl.getTOKEN(usernameField.getText()));
        window.getScene().getWindow().hide();
        ///show main.fxml

        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("main.fxml"));
            fxmlLoader.setControllerFactory(c -> {
                if (c == MainAppController.class) {
                    return new MainAppController(bl);
                } else {
                    try {
                        return c.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        Parent root = fxmlLoader.load();

        // Crear una nueva escena con la vista y establecerla en la ventana actual
        Scene scene = new Scene(root);
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();
    }

}

    @FXML
    void initialize() {
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'login.fxml'.";
        assert wrong != null : "fx:id=\"wrong\" was not injected: check your FXML file 'login.fxml'.";

    }
    @FXML
    void goreg(ActionEvent event) throws IOException {

        window.getScene().getWindow().hide();
        //show main.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("register.fxml"));
        fxmlLoader.setControllerFactory(c -> {
            if (c == RegisterController.class) {
                return new RegisterController(bl);
            } else {
                try {
                    return c.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Parent root = fxmlLoader.load();
        // Crear una nueva escena con la vista y establecerla en la ventana actual
        Scene scene = new Scene(root);
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();
    }






}
