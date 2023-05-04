package eus.ehu.sprint1.domain;

import social.bigbone.api.entity.Account;

public class Follows {

    private Account account;
    private String username;
    private String ID;
    private String avatar;

    public Follows(Account account) {
        this.username = account.getUsername();
        this.ID = account.getId();
        this.avatar = account.getAvatar();
    }

    public String getUsername() {
        return username;
    }

    public String getID() {
        return ID;
    }

    public String getAvatar() {
        return avatar;
    }

}
