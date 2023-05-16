package eus.ehu.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import eus.ehu.domain.BigBone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import social.bigbone.api.entity.Account;

import social.bigbone.api.exception.BigBoneRequestException;

public class FollowingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> followingList;

    @FXML
    void initialize() throws BigBoneRequestException {

        showList();
    }
    public void showList() throws  BigBoneRequestException {
        List<String> itemList = getfollowing();

        ObservableList<String> items = FXCollections.observableList(itemList);

        if (followingList != null) {
            followingList.setItems(items);
        }

    }
    private  List<String> getfollowing() throws BigBoneRequestException {
        BigBone bigBone = BigBone.getInstance();
        List<Account> following = bigBone.getFollowing();
        List<String> followingList = new java.util.ArrayList<>();
        following.forEach(follower -> followingList.add(follower.getUsername() + "\r\n"));

        return followingList;
    }
}