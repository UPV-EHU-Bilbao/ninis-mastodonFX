package eus.ehu.sprint1;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import eus.ehu.sprint1.Domain.BigBone;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


import social.bigbone.api.entity.Account;

import social.bigbone.api.exception.BigBoneRequestException;

public class FollowersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea followersArea;

    @FXML
    void initialize() throws BigBoneRequestException {
        BigBone bigBone = new BigBone();
        List<Account> followers = bigBone.getFollowers();
        followers.forEach(follower -> followersArea.appendText(follower.getUsername() + "\r\n"));
    }

}