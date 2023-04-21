package eus.ehu.sprint1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class MainAppController {

    private Window followingWin, tootsWin, followersWin;

    public class Window {
        private FxController controller;
        private Parent ui;
    }

    private Window load(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent ui = loader.load();
            //FxController controller = loader.getController();

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
    private BorderPane mainWrapper;

    @FXML
    void initialize() {
        followingWin = load("following.fxml");
        followersWin = load("followers.fxml");
        tootsWin = load("showtoot.fxml");

        showScene("Toot");
    }

    private void showScene(String scene) {
        switch (scene) {
            case "Following" -> mainWrapper.setCenter(followingWin.ui);
            case "Followers" -> mainWrapper.setCenter(followersWin.ui);
            case "Toot" -> mainWrapper.setCenter(tootsWin.ui);
        }
    }

    @FXML
    void actionFollowing(ActionEvent event) {
        showScene("Following");
    }
}
