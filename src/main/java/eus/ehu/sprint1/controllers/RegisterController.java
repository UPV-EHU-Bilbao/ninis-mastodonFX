package eus.ehu.sprint1.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import eus.ehu.sprint1.AppLauncher;
import eus.ehu.sprint1.FxController;
import eus.ehu.sprint1.businessLogic.BlFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController implements FxController {


   private BlFacade bl;

    public RegisterController(BlFacade bl) {
       this.bl = bl;
   }
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button returnlogin;
    @FXML
    private URL location;

    @FXML
    private PasswordField token;

    @FXML
    private TextField usernameField;

    @FXML
    private Label warning;

    @FXML
    private AnchorPane window;

    @FXML
    private Label wrong;

    @FXML
    void register(ActionEvent event) throws IOException {
         String user = bl.getusername(usernameField.getText());
         if (usernameField.getText() == user) {
            warning.setText("Username already exists");
         } else {
            bl.register(usernameField.getText(), token.getText());
            window.getScene().getWindow().hide();
            //show main.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("login.fxml"));
            fxmlLoader.setControllerFactory(c -> {
                if (c == LoginController.class) {
                    return new LoginController(bl);
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
  //  }
    }
    @FXML
    void returntologin(ActionEvent event)throws IOException  {
        window.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("login.fxml"));
        fxmlLoader.setControllerFactory(c -> {
            if (c == LoginController.class) {
                return new LoginController(bl);
            } else {
                try {
                    return c.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        if (!bl.getTheme()){
            scene.getStylesheets().add(bl.getStyle().toURI().toURL().toExternalForm());
        }
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();

    }


    @FXML
    void initialize() {
        assert token != null : "fx:id=\"token\" was not injected: check your FXML file 'register.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'register.fxml'.";
        assert warning != null : "fx:id=\"warning\" was not injected: check your FXML file 'register.fxml'.";
        assert window != null : "fx:id=\"window\" was not injected: check your FXML file 'register.fxml'.";
        assert wrong != null : "fx:id=\"wrong\" was not injected: check your FXML file 'register.fxml'.";

    }

}
