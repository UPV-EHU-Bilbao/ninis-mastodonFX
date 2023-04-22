package eus.ehu.sprint1.Domain;

import social.bigbone.MastodonClient;
import social.bigbone.api.entity.Account;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import java.util.List;

public class BigBone {

    public String instance;
    MastodonClient client;
    String accountID;

    String TOKEN;

    public BigBone() {
        instance = "mastodon.social";
        //client = new MastodonClient.Builder(instance).accessToken(TOKEN).build();
        client = new MastodonClient.Builder(instance).accessToken(System.getenv("TOKEN")).build();
        try {
            accountID = client.accounts().verifyCredentials().execute().getId();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Account> getFollowers() throws BigBoneRequestException {
        return client.accounts().getFollowers(accountID).execute().getPart();
    }

    public List<Account> getFollowing() throws BigBoneRequestException {
        return client.accounts().getFollowing(accountID).execute().getPart();
    }

    public List<Status> getToots() throws BigBoneRequestException {
        return  client.accounts().getStatuses(accountID).execute().getPart();
    }

    //get user avatar
    public String getAvatar() throws BigBoneRequestException {
        return client.accounts().getAccount(accountID).execute().getAvatar();
    }

    //create a request to like a toot
    public void likeToot(String tootID, boolean like) throws BigBoneRequestException {
        if (like)
            client.statuses().favouriteStatus(tootID).execute();
        else
            client.statuses().unfavouriteStatus(tootID).execute();

    }
    public void postToot(String toot) throws BigBoneRequestException {
        client.statuses().postStatus(toot).execute();
    }
  //settoken
    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }
    //gettoken
    public String getTOKEN() {
        return TOKEN;
    }

}
