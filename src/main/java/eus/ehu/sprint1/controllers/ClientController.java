package eus.ehu.sprint1.controllers;

import java.net.URL;
import java.util.*;

import eus.ehu.sprint1.Domain.BigBone;
import eus.ehu.sprint1.Domain.Toot;
import eus.ehu.sprint1.TootItemCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.sprint1.Domain.Utils.mapByValue;

public class ClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox tootsView = new VBox();

    @FXML
    void initialize() throws BigBoneRequestException {
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

        if (tootsView != null) {
            mapByValue(items, tootsView.getChildren(), toot -> new TootItemCell(toot).getAnchorPane());
        }
    }





}
