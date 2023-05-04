package eus.ehu.sprint1;

import eus.ehu.sprint1.domain.Follows;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FollowingItemCell {
    Follows follow;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private FXMLLoader loader;

    @FXML
    private AnchorPane listItem;

    @FXML
    private ImageView image;

    @FXML
    private Label username = new Label();


    //create inizialize method
    @FXML
    void initialize() {
    }


    public FollowingItemCell(Follows follow) {
        if (loader == null) {
            loader = new FXMLLoader(getClass().getResource("followers.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.follow = follow;
        username.setText(follow.getUsername());
        image.setImage(new Image(follow.getAvatar()));

    }

    public AnchorPane getAnchorPane() {
        if (listItem == null)
        {
            throw new NullPointerException("listItem returned null");
        }

        return listItem;
    }
}
