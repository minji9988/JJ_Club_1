package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.PUT;

public class ProfileAlarmRequest {
    @SerializedName("alarmRequest")
    private String alarmRequest;

    public ProfileAlarmRequest(String alarmRequest){
        this.alarmRequest = alarmRequest;
    }

}
