package eus.ehu.sprint1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "USERLIST")
public class User {

    @Id
    private String username;
    private String TOKEN;

    public User(String username,String TOKEN) {
        this.username = username;
        this.TOKEN = TOKEN;

    }
    public User() {
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
