package eus.ehu.sprint1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FollowersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea followersArea;

    @FXML
    void initialize() {
        assert followersArea != null : "fx:id=\"followersArea\" was not injected: check your FXML file 'followers.fxml'.";

    }

}