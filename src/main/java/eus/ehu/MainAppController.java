package eus.ehu;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.controllers.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.net.MalformedURLException;


public class MainAppController {

    private Window followingWin, tootsWin, followersWin, postTootWin, profileWin;



    private BlFacade bl;


    @FXML
    private ToggleButton theme;

    public MainAppController(BlFacade bl) {
        this.bl = bl;
    }

    public class Window {
        private FxController controller;
        private Parent ui;
    }

    private Window load(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml), ResourceBundle.getBundle("strings", new Locale("eus", "ES")));
            Parent ui = loader.load();

            Window window = new Window();
            window.ui = ui;
            return window;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void actionMyToots(ActionEvent event) {
        tootsWin = load("showtoot.fxml");
        showScene("Toot");
    }

    @FXML
    void actionFollowers(ActionEvent event) {
        followersWin = load("followers.fxml");
        showScene("Followers");
    }
    @FXML
    void actionPostToot(ActionEvent event) {
        postTootWin = load("postmytoot.fxml");
        showScene("PostToot");}
    @FXML
    void actionFollowing(ActionEvent event) {
        followingWin = load("following.fxml");
        showScene("Following");
    }

    @FXML
    void actionProfile(ActionEvent event) {
        showScene("Profile");
    }

    @FXML
    private BorderPane mainWrapper;

    @FXML
    void initialize() {

        followingWin = load("following.fxml");
        followersWin = load("followers.fxml");
        tootsWin = load("showtoot.fxml");
        postTootWin = load("postmytoot.fxml");
        profileWin = load("profile.fxml");

        showScene("Toot");

        if (!bl.getTheme()){
            theme.setSelected(true);
            theme.setText("Light Mode");
        }

    }

    private void showScene(String scene) {
        switch (scene) {
            case "Following" -> mainWrapper.setCenter(followingWin.ui);
            case "Followers" -> mainWrapper.setCenter(followersWin.ui);
            case "Toot" -> mainWrapper.setCenter(tootsWin.ui);
            case "PostToot" -> mainWrapper.setCenter(postTootWin.ui);
            case "Profile" -> mainWrapper.setCenter(profileWin.ui);
        }
    }



    @FXML
    void actionLogout(ActionEvent event) throws IOException {

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("login.fxml"),  ResourceBundle.getBundle("strings", Locale.getDefault()));
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
        if(!bl.getTheme()){
            scene.getStylesheets().add(bl.getDarkStyle().toURI().toURL().toExternalForm());
        }
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.show();

        currentStage.close();
    }

    @FXML
    void themeChng(ActionEvent event) throws MalformedURLException {
        if (theme.isSelected()){
            theme.setText("Light Theme");
            bl.setTheme(false);
            mainWrapper.getStylesheets().add(bl.getDarkStyle().toURI().toURL().toExternalForm());
            mainWrapper.getScene().getStylesheets().add(bl.getDarkStyle().toURL().toExternalForm());
        } else {
            theme.setText("Dark Theme");
            bl.setTheme(true);
            mainWrapper.getStylesheets().clear();
            mainWrapper.getScene().getStylesheets().clear();
        }
    }
}
