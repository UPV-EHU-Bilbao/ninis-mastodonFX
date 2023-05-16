package eus.ehu.domain;

import social.bigbone.api.entity.Account;

import java.util.AbstractCollection;

public class Users {
    private String username;
    private String avatar;

    public Users(Account account) {
        this.username = account.getUsername();
        this.avatar = account.getAvatar();
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }
}
