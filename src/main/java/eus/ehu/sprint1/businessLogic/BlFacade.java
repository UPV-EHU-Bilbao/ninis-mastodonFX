package eus.ehu.sprint1.businessLogic;

import java.util.ArrayList;
import java.util.ResourceBundle;

public interface BlFacade {
    String getTOKEN(String username);
    void login(String username);
    void register(String username,String TOKEN);
    String getusername(String username);

    ArrayList<String> getAllUsernames();


}
