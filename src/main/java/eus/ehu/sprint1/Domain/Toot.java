package eus.ehu.sprint1.Domain;

import social.bigbone.api.entity.Status;

public class Toot {
    private String username;
    private String date;
    private String tootText;
    private boolean boost;

    public Toot(Status toot) {
        this.date = toot.getCreatedAt();
        if (toot.getReblog() == null) {
            this.username =toot.getAccount().getUsername();
            this.boost = false;
            this.tootText = tootText;toot.getContent();
        } else {
            this.username = toot.getReblog().getAccount().getUsername();
            this.tootText = toot.getReblog().getContent();
            this.boost = true;
            //tootText.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(tootText));
        }
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
}
