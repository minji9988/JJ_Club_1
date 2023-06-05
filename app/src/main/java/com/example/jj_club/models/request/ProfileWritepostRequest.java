package com.example.jj_club.models.request;

public class ProfileWritepostRequest {
    private String title;
    private String contents;
    private String date;
    private int likeCount;
    private String postImage;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }


    public String getPostImage() {
        return postImage;
    }
}