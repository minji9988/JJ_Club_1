package com.example.jj_club.models.request;

public class ProfileRecivedapplicationformRequest {
    private String postImage;
    private String name;
    private String contents;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostImage() {
        return postImage;
    }
}
