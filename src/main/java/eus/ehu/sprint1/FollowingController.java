package eus.ehu.sprint1;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


import social.bigbone.api.entity.Account;

import social.bigbone.api.exception.BigBoneRequestException;

public class FollowingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea followingArea;

    @FXML
    void initialize() throws BigBoneRequestException {
        BigBone bigBone = new BigBone();
        List<Account> following = bigBone.getFollowing();
        following.forEach(followings -> followingArea.appendText(followings.getUsername() + "\r\n"));
    }

}