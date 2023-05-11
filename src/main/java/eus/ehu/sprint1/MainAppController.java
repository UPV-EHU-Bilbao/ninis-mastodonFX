package eus.ehu.sprint1;

import eus.ehu.sprint1.businessLogic.BlFacade;
import eus.ehu.sprint1.controllers.LoginController;
import eus.ehu.sprint1.controllers.PostMyTootController;
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
import java.net.MalformedURLException;


public class MainAppController {

    private Window followingWin, tootsWin, followersWin, postTootWin;

    private PostMyTootController postMyTootController;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent ui = loader.load();
            //LoginController controller = loader.getController();

            Window window = new Window();
            //window.controller = controller;
            window.ui = ui;
            return window;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void actionMyToots(ActionEvent event) {
        showScene("Toot");
    }

    @FXML
    void actionFollowers(ActionEvent event) {
        showScene("Followers");
    }
    @FXML
    void actionPostToot(ActionEvent event) {showScene("PostToot");}

    @FXML
    private BorderPane mainWrapper;

    @FXML
    void initialize() {
        followingWin = load("following.fxml");
        followersWin = load("followers.fxml");
        tootsWin = load("showtoot.fxml");
        postTootWin = load("postmytoot.fxml");

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
        }
    }

    @FXML
    void actionFollowing(ActionEvent event) {
        showScene("Following");
    }

    @FXML
    void actionLogout(ActionEvent event) throws IOException {

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

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
