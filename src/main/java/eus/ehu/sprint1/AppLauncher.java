package eus.ehu.sprint1;


import eus.ehu.sprint1.businessLogic.BlFacadeImplementation;
import eus.ehu.sprint1.businessLogic.BlFacade;
import eus.ehu.sprint1.controllers.LoginController;
import eus.ehu.sprint1.domain.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.stage.Stage;



public class AppLauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BlFacade bl = BlFacadeImplementation.getInstance();


        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("login.fxml"), ResourceBundle.getBundle("strings", Locale.getDefault()));
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
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mastodon Client");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}