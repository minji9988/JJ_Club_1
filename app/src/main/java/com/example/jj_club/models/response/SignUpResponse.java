package com.example.jj_club.models.response;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {
    @SerializedName("result")
    private String result;

    @SerializedName("data")
    private UserData data;

    public String getResult() {
        return result;
    }

    public UserData getData() {
        return data;
    }

    public static class UserData {
        @SerializedName("email")
        private String email;

        @SerializedName("userName")
        private String userName;

        @SerializedName("nickName")
        private String nickName;

        @SerializedName("phoneNumber")
        private String phoneNumber;

        @SerializedName("mbti")
        private String mbti;

        public String getEmail() {
            return email;
        }

        public String getUserName() {
            return userName;
        }

        public String getNickName() {
            return nickName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getMbti() {
            return mbti;
        }
    }
}
