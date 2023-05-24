package com.example.jj_club.models.response;

import com.example.jj_club.models.response.EmailVerificationErrorResponse;
import com.google.gson.annotations.SerializedName;

// 이메일 인증번호 발송 시 서버에서 보내는 응답을 나타내는 클래스
public class EmailVerificationResponse {

    @SerializedName("result")
    private String result;

    @SerializedName("data")
    private String data;

    @SerializedName("errorResponse")
    private EmailVerificationErrorResponse errorResponse;

    // Getter and Setter methods
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EmailVerificationErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(EmailVerificationErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
