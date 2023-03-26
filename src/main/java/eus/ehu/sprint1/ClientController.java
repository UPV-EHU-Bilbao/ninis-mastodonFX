package eus.ehu.sprint1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.control.CheckBox;


import java.util.List;


import social.bigbone.api.entity.Status;

import social.bigbone.api.exception.BigBoneRequestException;

public class ClientController implements FxController {
    private List<Status> list;

    @FXML
    private WebView content;

    @FXML
    private TextField date;

    @FXML
    private TextField user;
    @FXML
    private CheckBox boost;

    private int index;


    @FXML
    void nextoot(ActionEvent event) {
        if (index < list.size() - 1) {
            index++;
            update(index);
        }
    }

    @FXML
    void previoustoot(ActionEvent event) {
        if (index > 0) {
            index--;
            update(index);
        }
    }

    @FXML
    void initialize() throws BigBoneRequestException {
        /*

        String id = "109897213456794839";
        String body = Utilities.request("accounts/" + id + "/statuses");
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(body, JsonArray.class);

        Type statusList = new TypeToken<ArrayList<Status>>() {
        }.getType();
        list = gson.fromJson(jsonArray.getAsJsonArray(), statusList);

        MastodonClient client = new MastodonClient.Builder().accessToken("TOKEN").build();
        Pageable<Status> timeline = client.timelines().getHomeTimeline(new Range(null, null, 5)).execute();

        timeline.getPart().forEach(status -> {
            System.out.println(status.getContent());
        });

         */

        BigBone bigBone = new BigBone();
        list = bigBone.getToots();


        index = 0;
        date.setText(list.get(index).getCreatedAt());
        update(0);
        boost.setDisable(true);


    }


    public void update(int index) {
        date.setText(list.get(index).getCreatedAt());
        if (list.get(index).getReblog() == null) {
            user.setText(list.get(index).getAccount().getUsername());
            boost.setSelected(false);
            content.getEngine().loadContent(list.get(index).getContent());
            content.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(content));
        } else {
            user.setText(list.get(index).getReblog().getAccount().getUsername());
            content.getEngine().loadContent(list.get(index).getReblog().getContent());
            boost.setSelected(true);
            content.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(content));

        }

    }

}

