package eus.ehu.sprint1.domain;


import social.bigbone.MastodonClient;
import social.bigbone.api.entity.Account;
import social.bigbone.api.entity.Status;
import social.bigbone.api.entity.MediaAttachment;
import social.bigbone.api.entity.Status.Visibility;
import social.bigbone.api.exception.BigBoneRequestException;



import java.io.File;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class BigBone {

    private static BigBone instance;
    private String instanceName;
    private MastodonClient client;
    private String accountID;
    private String TOKEN="0";


    private BigBone() {
        instanceName = "mastodon.social";
        client = new MastodonClient.Builder(instanceName).accessToken(this.TOKEN).build();
        try {
            accountID = client.accounts().verifyCredentials().execute().getId();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
    }

    private BigBone(String token) {
        instanceName = "mastodon.social";
        client = new MastodonClient.Builder(instanceName).accessToken(token).build();
        setTOKEN(token);
        try {
            accountID = client.accounts().verifyCredentials().execute().getId();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigBone getInstance() {
        return instance;
    }
    public static BigBone getInstanceFirst(String token) {
        if (instance == null) {
            instance = new BigBone(token);
        }
        ;
        return instance;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
        client = new MastodonClient.Builder(instanceName).accessToken(TOKEN).build();
        try {
            accountID = client.accounts().verifyCredentials().execute().getId();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        };
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
    public void postTootWithMedia(String toot) throws BigBoneRequestException {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final File uploadFile = new File(classLoader.getResource("tree-736885_1280.jpg").getFile());
       
// Upload image to Mastodon
        final MediaAttachment uploadedFile = client.media().uploadMedia(uploadFile, "image/jpg").execute();
        final String mediaId = uploadedFile.getId();

// Post status with media attached
        final String inReplyToId = null;
        final List<String> mediaIds = Collections.singletonList(mediaId);
        final boolean sensitive = false;
        final String spoilerText = "Image spoiler text";
        final Visibility visibility = Visibility.Public;
        final String language = "en";
        client.statuses().postStatus(toot, visibility, inReplyToId, mediaIds, sensitive, spoilerText, language).execute();
    }

    public void postToot(String toot) throws BigBoneRequestException {
        client.statuses().postStatus(toot).execute();
    }

    //gettoken
    public String getTOKEN() {
        return TOKEN;
    }

}