package com.example.jj_club.models.request;

public class PromotionWriteRequest {

    private String title;
    private String name;
    private String interview;
    private String fee;

    public PromotionWriteRequest(String title, String name, String interview, String fee) {
        this.title = title;
        this.name = name;
        this.interview = interview;
        this.fee = fee;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
