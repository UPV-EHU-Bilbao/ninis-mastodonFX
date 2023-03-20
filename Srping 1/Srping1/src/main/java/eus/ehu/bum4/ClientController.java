package eus.ehu.bum4;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import eus.ehu.bum4.Domain.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.control.CheckBox;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

   @FXML
    private WebView content;

    @FXML
    private TextField date;

    @FXML
    private TextField user;
    @FXML
    private CheckBox boost;

    private int index;


    String id = "109897213456794839";
 String body = Utilities.request("accounts/"+id+"/statuses");
 Gson gson = new Gson();
 JsonArray jsonArray = gson.fromJson(body, JsonArray.class);

 Type statusList = new TypeToken<ArrayList<Status>>(){}.getType();
 List<Status> list = gson.fromJson(jsonArray.getAsJsonArray(), statusList);




    @FXML
    void nextoot(ActionEvent event) {
     if (index < list.size()-1) {
                update(index+1);

         index++;
     }
    }

    @FXML
    void previoustoot(ActionEvent event) {
      if (index > 0) {
                update(index-1);
            index--;
      }

    }

    @FXML
    void initialize() {
         index = 0 ;
     date.setText(list.get(index).getCreated_at());
     update(0);
        boost.setDisable(true);


     }


    public void update(int index) {
        date.setText(list.get(index).getCreated_at());
        if (list.get(index).getReblog() == null) {
            user.setText(list.get(index).getAccount().getUsername());
            boost.setSelected(false);
            content.getEngine().loadContent(list.get(index).getContent());

        } else {
            user.setText(list.get(index).getReblog().getAccount().getUsername());
            content.getEngine().loadContent(list.get(index).getReblog().getContent());
            boost.setSelected(true);


        }

    }

}

