package eus.ehu.spring1.Domain;

public class Status {
    String id;
    String uri;
    String in_reply_to_id;
    String in_reply_to_account_id;
    Status reblog;
    String content;
    String created_at;
    String edited_at;
    int reblogs_count;
    int replies_count;
    int favourites_count;
    boolean reblogged;
    boolean favourited;
    boolean muted;
    boolean sensitive;
    boolean bookmarked;
    String spoiler_text;
    String visibility;
    String language;
    Account account;

    @Override
    public String toString() {
        return "Status{" + "id=" + id + '\''
                + ", created_at='" + created_at + '\''
                +", content='" + content + '\'' +
                ", reblog='" + reblog  +
                ", account=" + account + '}';
    }

    public Status getReblog() {
        return reblog;
    }

    public Account getAccount() {
        return account;
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }
    public void geturi (String uri){
        this.uri = uri;
    }
    public String geturi (){
        return uri;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public boolean isMuted() {
        return muted;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public boolean isFavourited() {
        return favourited;
    }

    public boolean isReblogged() {
        return reblogged;
    }

    public int getReblogs_count() {
        return reblogs_count;
    }

    public String getUri() {
        return uri;
    }

    public int getReplies_count() {
        return replies_count;
    }

    public String getEdited_at() {
        return edited_at;
    }

    public String getId() {
        return id;
    }

    public String getIn_reply_to_account_id() {
        return in_reply_to_account_id;
    }

    public String getIn_reply_to_id() {
        return in_reply_to_id;

    }

    public String getLanguage() {
        return language;
    }

    public String getSpoiler_text() {
        return spoiler_text;
    }

    public String getVisibility() {
        return visibility;
    }
}
