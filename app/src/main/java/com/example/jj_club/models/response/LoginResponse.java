package com.example.jj_club.models.response;

// 서버로부터 받은 데이터를 정의해 준다.


public class LoginResponse {
    private String result;
    private Data data;

    public String getResult() {
        return result;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        private String grantType;
        private String accessToken;
        private String refreshToken;
        private long accessTokenExpiresIn;

        public String getGrantType() {
            return grantType;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public long getAccessTokenExpiresIn() {
            return accessTokenExpiresIn;
        }
    }
}


//
//public class LoginResponse {
//    @SerializedName("success")
//    private boolean success;
//
//    public boolean isSuccess() {
//        return success;
//    }
//}
