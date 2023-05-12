package eus.ehu.sprint1.businessLogic;

import eus.ehu.sprint1.dataAccess.DbAccessManager;
import eus.ehu.sprint1.domain.User;
import eus.ehu.sprint1.configuration.Config;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class BlFacadeImplementation implements BlFacade {

DbAccessManager dbAccessManager;

Config config = Config.getInstance();

private User currentuser;

private String TOKEN;


private static BlFacadeImplementation bl = new BlFacadeImplementation();

public static BlFacadeImplementation getInstance() {
    return bl;
}
private boolean theme = true; //TRUE = LIGHT, FALSE = DARK

File darkStyle = new File("src\\main\\resources\\eus\\ehu\\sprint1\\style.css");
File lightStyle = new File("src\\main\\resources\\eus\\ehu\\sprint1\\lightstyle.css");
    public void BlFacadeImplementation() {


    private BlFacadeImplementation() {
        System.out.println("Creating BlFacadeImplementation instance");
        boolean initialize = config.getDataBaseOpenMode().equals("initialize");
        dbAccessManager = new DbAccessManager();
        if (initialize)
            dbAccessManager.initializeDB();
        dbAccessManager.close();
    }

    @Override
    public String getTOKEN(String username) {

            dbAccessManager.open();

            TOKEN = dbAccessManager.getTOKEN(username);
            dbAccessManager.close();

        return TOKEN;
    }
    public void login(String username)  {

        dbAccessManager.open();
        this.currentuser = dbAccessManager.login(username);
        dbAccessManager.close();


    }
    public void register(String username,String TOKEN) {

        dbAccessManager.open();
        User user= new User(username,TOKEN);
        dbAccessManager.storeUser(user);
        dbAccessManager.close();

    }

    @Override
    public String getusername(String username) {
        dbAccessManager.open();
        String name= dbAccessManager.getUserString(username);
        dbAccessManager.close();
        return name;
    }

    @Override
    public ArrayList<String> getAllUsernames() {
        dbAccessManager.open();
        ArrayList<String> usernames= dbAccessManager.getAllUsernames();
        dbAccessManager.close();
        return usernames;
    }

    public void setTheme(boolean theme){
        this.theme = theme;
    }

    public boolean getTheme(){
        return this.theme;
    }

    public File getDarkStyle() {
        return darkStyle;
    }

    public File getLightStyle() {
        return lightStyle;
    }
}

