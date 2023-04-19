package eus.ehu.sprint1.Domain;

import social.bigbone.api.entity.Status;

public class Toot {
    private String username;
    private String date;
    private String tootText;
    private boolean boost;

    public Toot(Status toot) {
        this.date = splitDate(toot.getCreatedAt());
        if (toot.getReblog() == null) {
            this.username =toot.getAccount().getUsername();
            this.boost = false;
            this.tootText = toot.getContent();
        } else {
            this.username = toot.getReblog().getAccount().getUsername();
            this.tootText = toot.getReblog().getContent();
            this.boost = true;
            //tootText.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(tootText));
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
}
