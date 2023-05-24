package com.example.jj_club.models.response;

// 이메일 인증 코드 받았는데 오류뜰 때

import com.google.gson.annotations.SerializedName;

public class EmailVerificationErrorResponse {
    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("code")
    private String code;

    @SerializedName("error")
    private String error;

    @SerializedName("message")
    private String message;

    // Getter and Setter methods
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

