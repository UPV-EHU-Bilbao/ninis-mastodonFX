package eus.ehu.sprint1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import social.bigbone.api.entity.Status;

public class TootItemCell {

    private FXMLLoader loader;

    @FXML
    private AnchorPane listItem;

    @FXML
    private RadioButton boost = new RadioButton();

    @FXML
    private Label date = new Label();

    @FXML
    private WebView tootText = new WebView();

    @FXML
    private Label username = new Label();

    public TootItemCell(Status toot) {
        if (loader == null) {
            loader = new FXMLLoader(getClass().getResource("toot.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        date.setText(toot.getCreatedAt());
        if (toot.getReblog() == null) {
            username.setText(toot.getAccount().getUsername());
            boost.setSelected(false);
            tootText.getEngine().loadContent(toot.getContent());
            tootText.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(tootText));
        } else {
            username.setText(toot.getReblog().getAccount().getUsername());
            tootText.getEngine().loadContent(toot.getReblog().getContent());
            boost.setSelected(true);
            tootText.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(tootText));
        }
        boost.setDisable(true);
    }

    public AnchorPane getAnchorPane() {
        return listItem;
    }

}