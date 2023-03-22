package eus.ehu.sprint1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import social.bigbone.MastodonClient;
import social.bigbone.api.exception.BigBoneRequestException;

import static social.bigbone.api.method.TimelineMethods.StatusOrigin.LOCAL_AND_REMOTE;

public class FollowersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea followersArea;

    @FXML
    void initialize() throws BigBoneRequestException {
        final String instance = "@alaitz19@mastodon.social";

        // Instantiate client
        final MastodonClient client = new MastodonClient.Builder(instance).accessToken(accessToken).build();

        // Print timeline statuses
        client.timelines().getPublicTimeline(LOCAL_AND_REMOTE).doOnJson(
                json -> {
                    followersArea.setText(json.toString());
                }
        ).execute();
    }

}