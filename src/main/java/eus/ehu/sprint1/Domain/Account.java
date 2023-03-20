package eus.ehu.sprint1.Domain;

public class Account {
    String id;
    String username;
    String acct;
    String display_name;
    boolean locked;
    boolean bot;
    boolean discoverable;
    @Override
    public String toString() {
        return "Account{" + "id=" + id + '\''
                + ", username='" + username + '\''
                +", acct='" + acct + '\'' +
                ", display_name='" + display_name  +
                ", locked=" + locked + '}';
    }

    public String getUsername() {
        return username;
    }

}
