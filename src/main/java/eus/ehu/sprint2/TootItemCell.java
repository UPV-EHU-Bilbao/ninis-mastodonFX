package eus.ehu.sprint2;

import java.net.URL;
import java.util.ResourceBundle;

import eus.ehu.sprint2.Domain.Toot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class TootItemCell {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private FXMLLoader loader;

    @FXML
    private AnchorPane listItem;

    @FXML
    private RadioButton boost = new RadioButton();

    @FXML
    private ImageView image;

    @FXML
    private Label date = new Label();

    @FXML
    private WebView tootText = new WebView();

    @FXML
    private Label username = new Label();

    //create inizialize method
    @FXML
    void initialize() {
        assert boost != null : "fx:id=\"boost\" was not injected: check your FXML file 'toot.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'toot.fxml'.";
        assert listItem != null : "fx:id=\"listItem\" was not injected: check your FXML file 'toot.fxml'.";
        assert tootText != null : "fx:id=\"tootText\" was not injected: check your FXML file 'toot.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'toot.fxml'.";
    }


    public TootItemCell(Toot toot) {
        if (loader == null) {
            loader = new FXMLLoader(getClass().getResource("toot.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        date.setText(toot.getDate());
        username.setText(toot.getUsername());
        tootText.getEngine().loadContent(toot.getTootText());
        tootText.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(tootText));
        boost.setSelected(toot.isBoost());
        image.setImage(new Image(toot.getAvatar()));
        System.out.println(toot.getAvatar());
        boost.setDisable(true);

    }

    public AnchorPane getAnchorPane() {
        if (listItem == null)
        {
            throw new NullPointerException("listItem returned null");
        }

        return listItem;
    }

}