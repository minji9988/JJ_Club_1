package com.example.jj_club.models.response;

import com.google.gson.annotations.SerializedName;

// 이메일 인증 요청 응답을 나타내는 클래스
public class EmailConfirmationResponse {

    @SerializedName("result")
    private String result;

    @SerializedName("data")
    private boolean data;

    public String getResult() {
        return result;
    }

    public boolean getData() {
        return data;
    }
}
