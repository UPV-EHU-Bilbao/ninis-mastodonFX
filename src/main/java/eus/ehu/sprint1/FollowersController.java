package eus.ehu.sprint1;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import social.bigbone.MastodonClient;
import social.bigbone.MastodonRequest;
import social.bigbone.api.Pageable;
import social.bigbone.api.Scope;
import social.bigbone.api.entity.Account;
import social.bigbone.api.entity.Application;
import social.bigbone.api.entity.MastodonList;
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
        String instance = "mastodon.social";

        MastodonClient client = new MastodonClient.Builder(instance).accessToken(System.getenv("TOKEN")).build();

        String accountID = client.accounts().verifyCredentials().execute().getId();

        List<Account> followers = client.accounts().getFollowers(accountID).execute().getPart();

        followers.forEach(follower -> followersArea.appendText(follower.getUsername() + "\r\n"));

    }

}