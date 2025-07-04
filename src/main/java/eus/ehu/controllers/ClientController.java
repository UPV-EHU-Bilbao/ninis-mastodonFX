package eus.ehu.controllers;

import java.net.URL;
import java.util.*;

import eus.ehu.TootItemCell;
import eus.ehu.domain.BigBone;
import eus.ehu.domain.Toot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.domain.Utils.mapByValue;

public class ClientController {

    BigBone bigBone = BigBone.getInstance();

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

        //List<Status> tootList = bigBone.getToots();
        List<Status> timelineList = bigBone.getTimeline();
        List<Toot> toots = new ArrayList<>();
        /*for (Status t : tootList) {
            toots.add(new Toot(t));
        }*/
        for (Status t : timelineList) {
            toots.add(new Toot(t));
        }

        // sort by date
        Collections.sort(toots, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        ObservableList<Toot> items = FXCollections.observableArrayList(toots);

        if (tootsView != null) {
            mapByValue(items, tootsView.getChildren(), toot -> new TootItemCell(toot).getAnchorPane());
        }
    }





}
