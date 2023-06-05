package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

public class PromotionWriteRequest2 {

    @SerializedName("pwnumber")
    private String number;

    @SerializedName("pwtarget")
    private String target;

    @SerializedName("pwintroduce")
    private String introduce;

    public PromotionWriteRequest2(String number, String target, String introduce) {
        this.number = number;
        this.target = target;
        this.introduce = introduce;
    }

    // Getters and Setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}