package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

public class WithdrawalRequest {
    @SerializedName("userId")
    private String userId;

    public WithdrawalRequest(String userId) {
        this.userId = userId;
    }
}