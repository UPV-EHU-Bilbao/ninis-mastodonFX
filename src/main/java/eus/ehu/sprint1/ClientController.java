package eus.ehu.sprint1;

import java.net.URL;
import java.util.*;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.WeakListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import static eus.ehu.sprint1.Utils.mapByValue;

public class ClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox tootsView;

    @FXML
    void initialize() throws BigBoneRequestException {
        showList();
    }

    public void showList() throws BigBoneRequestException {
        BigBone bigBone = new BigBone();
        List<Status> tootList = bigBone.getToots();

        ObservableList<Status> items = FXCollections.observableArrayList(tootList);

        if (tootsView != null) {
            mapByValue(items, tootsView.getChildren(), toot -> new TootItemCell(toot).getAnchorPane());
        }
    }





}
