package eus.ehu.sprint1.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
    private ToggleButton theme;

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
        if (!bl.getTheme()){
            scene.getStylesheets().add(bl.getStyle().toURI().toURL().toExternalForm());
        }
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();
        }
    }

    @FXML
    void themeChng(ActionEvent event) throws MalformedURLException {
        if (theme.isSelected()){
            theme.setText("Light Theme");
            bl.setTheme(false);
            window.getStylesheets().add(bl.getStyle().toURI().toURL().toExternalForm());
        } else {
            theme.setText("Dark Theme");
            bl.setTheme(true);
            window.getStylesheets().clear();
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
        if (!bl.getTheme()){
            theme.setSelected(true);
            theme.setText("Light Theme");
        }
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
        if (!bl.getTheme()){
            scene.getStylesheets().add(bl.getStyle().toURI().toURL().toExternalForm());
        }
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();
    }

}
