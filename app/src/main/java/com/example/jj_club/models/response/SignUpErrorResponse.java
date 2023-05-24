package com.example.jj_club.models.response;

import com.google.gson.annotations.SerializedName;

public class SignUpErrorResponse {
    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("code")
    private String code;

    @SerializedName("error")
    private String error;

    @SerializedName("message")
    private String message;

    public String getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
