package com.example.jj_club.network;

public class HomePostItem {
    private String imageUrl;
    private String title;
    private String date;

    // 생성자
    public HomePostItem(String imageUrl, String title, String date) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.date = date;
    }

    // Getters
    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
