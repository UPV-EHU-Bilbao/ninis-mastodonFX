package eus.ehu.sprint1.businessLogic;

import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;

public interface BlFacade {
    String getTOKEN(String username);
    void login(String username);
    void register(String username,String TOKEN);
    String getusername(String username);

    ArrayList<String> getAllUsernames();

    void setTheme(boolean theme);

    boolean getTheme();

    File getStyle();

}
