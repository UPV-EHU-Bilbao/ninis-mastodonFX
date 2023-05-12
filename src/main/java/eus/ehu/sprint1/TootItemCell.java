package eus.ehu.sprint1;

import java.net.URL;
import java.util.ResourceBundle;

import eus.ehu.sprint1.domain.Toot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import social.bigbone.api.exception.BigBoneRequestException;
import org.jsoup.Jsoup;

public class TootItemCell {

    Toot toot;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private FXMLLoader loader;

    @FXML
    private AnchorPane listItem;

    @FXML
    private CheckBox boost;

    @FXML
    private CheckBox like;

    @FXML
    private ImageView image;

    @FXML
    private Label date = new Label();

    @FXML
    private TextFlow tootText = new TextFlow();

    @FXML
    private Label username = new Label();

    @FXML
    void likeAction(ActionEvent event) throws BigBoneRequestException {
        if (like.isSelected()) {
            toot.setLiked(true);
        } else {
            toot.setLiked(false);
        }
    }



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
        this.toot = toot;
        date.setText(toot.getDate());
        username.setText(toot.getUsername());
        tootText.getChildren().add(new javafx.scene.text.Text(Jsoup.parse(toot.getTootText()).text()));
        //add black borders to the tootText
        tootText.setStyle("-fx-border-color: black;");
        //add white background to the tootText
        tootText.setStyle("-fx-background-color: white;");
        boost.setSelected(toot.isBoost());
        like.setSelected(toot.isLiked());
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