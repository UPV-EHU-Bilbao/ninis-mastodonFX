package eus.ehu.sprint1.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import eus.ehu.sprint1.TootItemCell;
import eus.ehu.sprint1.domain.BigBone;
import eus.ehu.sprint1.domain.Toot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.sprint1.domain.Utils.mapByValue;

public class ProfileController {

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
    void initialize() {

    }

    @FXML
    void actionToots(ActionEvent event) throws BigBoneRequestException {
        showList();
    }

    public void showList() throws BigBoneRequestException {
        BigBone bigBone = BigBone.getInstance();
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
}
