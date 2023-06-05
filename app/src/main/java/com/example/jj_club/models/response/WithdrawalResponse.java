package com.example.jj_club.models.response;

public class WithdrawalResponse {
    private String result;
    private Object data;
    private String timestamp;
    private String code;
    private String error;
    private String message;

    public String getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }

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