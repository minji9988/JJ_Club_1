package com.example.jj_club.models.response;
//프로필 편집 응답
public class ProfileEditResponse {
    private String result;
    private ProfileData data;
    private String timestamp;
    private String code;
    private String error;
    private String message;

    public String getResult() {
        return result;
    }

    public ProfileData getData() {
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

    public class ProfileData {
        private String email;
        private String userName;
        private String nickName;
        private String phoneNumber;
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