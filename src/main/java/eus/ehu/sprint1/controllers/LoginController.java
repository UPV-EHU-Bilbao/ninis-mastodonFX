package eus.ehu.sprint1.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
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
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> usernameCB;

    @FXML
    private Label wrong;

    @FXML
    void login(ActionEvent event) throws IOException {
        if (bl.getTOKEN(usernameCB.getValue()) == null) {
            wrong.setText("Username does not exist");
        } else{
            BigBone bigbone = BigBone.getInstanceFirst(bl.getTOKEN(usernameCB.getValue()));
            bigbone.setTOKEN(bl.getTOKEN(usernameCB.getValue()));
        window.getScene().getWindow().hide();
        ///show main.fxml

        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("main.fxml"), ResourceBundle.getBundle("strings", new Locale("eus", "ES")));
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

    public void setUsernameCB() {
        for (String username : bl.getAllUsernames()) {
            usernameCB.getItems().add(username);
        }
        usernameCB.getSelectionModel().selectFirst();
    }

    @FXML
    void initialize() {
        assert wrong != null : "fx:id=\"wrong\" was not injected: check your FXML file 'login.fxml'.";
        setUsernameCB();


    }


    @FXML
    void goreg(ActionEvent event) throws IOException {

        window.getScene().getWindow().hide();
        //show main.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("register.fxml"), ResourceBundle.getBundle("strings", new Locale("eus", "ES")));
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
