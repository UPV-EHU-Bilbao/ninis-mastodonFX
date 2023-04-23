package eus.ehu.sprint1.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import eus.ehu.sprint1.domain.BigBone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import social.bigbone.api.entity.Account;

import social.bigbone.api.exception.BigBoneRequestException;

public class FollowersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> followersList;

    @FXML
    void initialize() throws BigBoneRequestException {

        showList();
    }
    public void showList() throws  BigBoneRequestException {
        List<String> itemList = getfollowers();

        ObservableList<String> items = FXCollections.observableList(itemList);

        if (followersList != null) {
            followersList.setItems(items);

        }

    }
    private  List<String> getfollowers() throws BigBoneRequestException {
        BigBone bigBone = BigBone.getInstance();
        List<Account> followers = bigBone.getFollowers();
        List<String> followersList = new java.util.ArrayList<>();
        followers.forEach(follower -> followersList.add(follower.getUsername() + "\r\n"));
        return followersList;
    }

}