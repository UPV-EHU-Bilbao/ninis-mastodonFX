package eus.ehu.sprint1.domain;

public class User {

    private String username;

    private String TOKEN;

    public User(String username,String TOKEN) {
        this.username = username;
        this.TOKEN = TOKEN;

    }

    //getters


    public String getUsername() {
        return username;
    }

    //gettoken
    public String getTOKEN() {
        return TOKEN;
    }
}
