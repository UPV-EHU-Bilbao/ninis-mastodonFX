package eus.ehu.sprint1.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import eus.ehu.sprint1.FollowerItemCell;
import eus.ehu.sprint1.FollowingItemCell;
import eus.ehu.sprint1.TootItemCell;
import eus.ehu.sprint1.domain.BigBone;
import eus.ehu.sprint1.domain.Follows;
import eus.ehu.sprint1.domain.Toot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Account;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.sprint1.domain.Utils.mapByValue;

public class ProfileController {

    BigBone bigBone = BigBone.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane childAnchor;

    @FXML
    private Button followers;

    @FXML
    private Button following;

    @FXML
    private ImageView fotoPerfil;

    @FXML
    private Button myToots;

    @FXML
    private Label username;

    @FXML
    private VBox view;




    @FXML
    void initialize() throws BigBoneRequestException {
        username.setText(bigBone.getName());
        fotoPerfil.setImage(new Image(bigBone.getAvatar()));
        tootShowList();
    }

    @FXML
    void actionToots(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        tootShowList();
    }

    @FXML
    void actionFollowers(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        followingShowList();
    }

    @FXML
    void actionFollowing(ActionEvent event) throws BigBoneRequestException {
        view.getChildren().clear();
        followerShowList();
    }

    public void tootShowList() throws BigBoneRequestException {
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

    public void followingShowList() throws BigBoneRequestException {
        List<Account> tootList = bigBone.getFollowing();
        List<Follows> follows = new ArrayList<>();
        for (Account t : tootList) {
            follows.add(new Follows(t));
        }

        ObservableList<Follows> items = FXCollections.observableArrayList(follows);

        if (view != null) {
            mapByValue(items, view.getChildren(), follow -> new FollowingItemCell(follow).getAnchorPane());
        }
    }
    public void followerShowList() throws BigBoneRequestException {
        List<Account> tootList = bigBone.getFollowers();
        List<Follows> follows = new ArrayList<>();
        for (Account t : tootList) {
            follows.add(new Follows(t));
        }

        ObservableList<Follows> items = FXCollections.observableArrayList(follows);

        if (view != null) {
            mapByValue(items, view.getChildren(), follow -> new FollowerItemCell(follow).getAnchorPane());
        }
    }
}
