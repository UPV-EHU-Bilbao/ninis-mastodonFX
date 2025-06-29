package eus.ehu;

import eus.ehu.domain.Users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserItemCell {

    Users users;

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


    public UserItemCell(Users users) {
        if (loader == null) {
            loader = new FXMLLoader(getClass().getResource("follows.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.users = users;
        username.setText(users.getUsername());
        Image img = new Image(users.getAvatar());
        image.setImage(img);


    }

    public AnchorPane getAnchorPane() {
        if (listItem == null)
        {
            throw new NullPointerException("listItem returned null");
        }

        return listItem;
    }

}
