package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

// 이메일 인증번호 발송 요청을 나타내는 클래스
public class EmailVerificationRequest {

    @SerializedName("email")
    private String email;

    public EmailVerificationRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
