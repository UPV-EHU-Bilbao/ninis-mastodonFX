package eus.ehu.sprint1.businessLogic;

import eus.ehu.sprint1.DataAccess.DbAccessManager;
import eus.ehu.sprint1.Domain.User;
import eus.ehu.sprint1.configuration.Config;

public class BLFacadeImplementation implements BlFacade {

DbAccessManager dbAccessManager = DbAccessManager.getInstance();

Config config = Config.getInstance();

private User currentuser;

private String TOKEN;




    public void BlFacadeImplementation() {

        System.out.println("Creating BlFacadeImplementation instance");


    }

    @Override
    public String getID(String username, String password) {

            dbAccessManager.open();

            TOKEN = dbAccessManager.getTOKEN(username);

            dbAccessManager.close();

        return username;
    }
    public void login(String username)  {

        dbAccessManager.open();
        this.currentuser = dbAccessManager.login(username);
        dbAccessManager.close();

    }
}

