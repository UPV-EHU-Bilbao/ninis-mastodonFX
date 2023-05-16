package eus.ehu.businessLogic;

import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

public interface BlFacade {
    String getTOKEN(String username);
    void login(String username);
    void register(String username,String TOKEN);
    String getusername(String username);

    ArrayList<String> getAllUsernames();

    void setTheme(boolean theme);

    boolean getTheme();

    File getDarkStyle();

    File getLightStyle();

}
