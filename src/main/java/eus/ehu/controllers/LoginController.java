package eus.ehu.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.AppLauncher;
import eus.ehu.MainAppController;
import eus.ehu.domain.BigBone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private ComboBox<String> comboidiom;

    private String Language;

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
        setLanguage();

        ///show main.fxml

        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("main.fxml"), ResourceBundle.getBundle("strings", Locale.getDefault()));
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
            scene.getStylesheets().add(bl.getDarkStyle().toURI().toURL().toExternalForm());
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
            window.getStylesheets().clear();
            window.getStylesheets().add(bl.getDarkStyle().toURI().toURL().toExternalForm());
        } else {
            theme.setText("Dark Theme");

            bl.setTheme(true);
            window.getStylesheets().clear();
            window.getStylesheets().add(bl.getLightStyle().toURI().toURL().toExternalForm());
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
        String[] idiomas = {"eus", "es", "en"};


        comboidiom.getItems().addAll(idiomas);
        setLanguage();




    }

    public void setLanguage() {
        if (comboidiom.getValue() == "eus") {
            Locale.setDefault(new Locale("eus", "ES"));
        }else if (comboidiom.getValue() == "es") {
            Locale.setDefault(new Locale("es", "ES"));
        }else if (comboidiom.getValue() == "en") {
            Locale.setDefault(new Locale("en", "EN"));
        }
    }

    @FXML
    void goreg(ActionEvent event) throws IOException {
        setLanguage();
        window.getScene().getWindow().hide();
        //show main.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("register.fxml"),ResourceBundle.getBundle("strings", Locale.getDefault()));
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
            scene.getStylesheets().add(bl.getDarkStyle().toURI().toURL().toExternalForm());
        }
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();
    }

}
