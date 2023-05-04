package eus.ehu.sprint1;

import eus.ehu.sprint1.domain.Follows;
import eus.ehu.sprint1.domain.Toot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import social.bigbone.api.exception.BigBoneRequestException;

import java.net.URL;
import java.util.ResourceBundle;

public class FollowerItemCell {

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


    public FollowerItemCell(Follows follow) {
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
