package com.example.jj_club.models.request;

public class HomeRequest {
    private String userId;  // 사용자 아이디
    private String userMbti; // 사용자 MBTI

    public HomeRequest(String userId, String userMbti) {
        this.userId = userId;
        this.userMbti = userMbti;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMbti() {
        return userMbti;
    }

    public void setUserMbti(String userMbti) {
        this.userMbti = userMbti;
    }
}
