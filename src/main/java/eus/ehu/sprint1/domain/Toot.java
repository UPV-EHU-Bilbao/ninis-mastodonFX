package eus.ehu.sprint1.domain;

import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

public class Toot {

    private Status toot;
    private String tootID;
    private String username;
    private String date;
    private String tootText;
    private boolean boost;

    private boolean liked;

    private String avatar;

    public Toot(Status toot) {
        this.toot = toot;
        this.date = splitDate(toot.getCreatedAt());
        if (toot.getReblog() == null) {
            this.username =toot.getAccount().getUsername();
            this.tootID = toot.getId();
            this.boost = false;
            this.liked = toot.isFavourited();
            this.tootText = toot.getContent();
            this.avatar = toot.getAccount().getAvatar();
        } else {
            this.username = toot.getReblog().getAccount().getUsername();
            this.tootID = toot.getId();
            this.tootText = toot.getReblog().getContent();
            this.boost = true;
            this.liked = toot.getReblog().isFavourited();
            this.avatar = toot.getReblog().getAccount().getAvatar();
        }
    }

    public String splitDate(String date){
        String[] parts = date.split("T");

        return parts[0] + " " + parts[1].substring(0, 8);
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public String getTootText() {
        return tootText;
    }

    public boolean isBoost() {
        return boost;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean b) throws BigBoneRequestException {
        BigBone bigBone = BigBone.getInstance();;
        bigBone.likeToot(tootID, b);
    }
}
