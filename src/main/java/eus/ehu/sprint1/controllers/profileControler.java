package eus.ehu.sprint1.controllers;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import eus.ehu.sprint1.TootItemCell;
import eus.ehu.sprint1.UserItemCell;
import eus.ehu.sprint1.domain.BigBone;
import eus.ehu.sprint1.domain.Toot;
import eus.ehu.sprint1.domain.User;
import eus.ehu.sprint1.domain.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Account;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.sprint1.domain.Utils.mapByValue;

public class profileControler {

    BigBone bigBone = BigBone.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button followersButton;

    @FXML
    private Button followingButton;

    @FXML
    private ImageView profilePhoto;


    @FXML
    private AnchorPane showPane;

    @FXML
    private Button tootsButton;

    @FXML
    private Label username;

    @FXML
    private VBox view = new VBox();

    @FXML
    private ScrollPane scrollPane;



    @FXML
    void initialize() throws BigBoneRequestException {
        username.setText(bigBone.getUsername());
        profilePhoto.setImage(new Image(bigBone.getAvatar()));
        showToots();
    }

    @FXML
    void actionFollowers(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        showFollowers();
    }

    @FXML
    void actionFollowing(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        showFollowing();
    }

    @FXML
    void actionToots(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        showToots();
    }


    void showFollowers() throws BigBoneRequestException {
        List<Account> tootList = bigBone.getFollowers();
        List<Users> users = new ArrayList<>();
        for (Account t : tootList) {
            users.add(new Users(t));
        }

        ObservableList<Users> items = FXCollections.observableArrayList(users);

        if (view != null) {
            mapByValue(items, view.getChildren(), user -> new UserItemCell(user).getAnchorPane());
        }
    }


    void showFollowing() throws BigBoneRequestException {
        List<Account> tootList = bigBone.getFollowing();
        List<Users> users = new ArrayList<>();
        for (Account t : tootList) {
            users.add(new Users(t));
        }

        ObservableList<Users> items = FXCollections.observableArrayList(users);

        if (view != null) {
            mapByValue(items, view.getChildren(), user -> new UserItemCell(user).getAnchorPane());
        }
    }

    public void showToots() throws BigBoneRequestException {
        List<Status> tootList = bigBone.getToots();
        List<Toot> toots = new ArrayList<>();
        for (Status t : tootList) {
            toots.add(new Toot(t));
        }

        ObservableList<Toot> items = FXCollections.observableArrayList(toots);

        if (view != null) {
            mapByValue(items, view.getChildren(), toot -> new TootItemCell(toot).getAnchorPane());
        }
    }

}
