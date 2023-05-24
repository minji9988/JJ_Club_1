package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

// 이메일 인증 요청을 나타내는 클래스
public class EmailConfirmationRequest {

    @SerializedName("email")
    private String email;

    @SerializedName("code")
    private String code;

    public EmailConfirmationRequest(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }
}
