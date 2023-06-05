package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

//프로필 편집 요청

public class ProfileEditRequest {
    @SerializedName("nickName")
    private String nickname;

    @SerializedName("password")
    private String password;

    @SerializedName("mbti")
    private String mbti;

    public ProfileEditRequest(String nickname, String password, String mbti) {
        this.nickname = nickname;
        this.password = password;
        this.mbti = mbti;
    }
}

/*전에 작성했던거
public class ProfileEditRequest {

    @SerializedName("nickName")
    private String nickName;
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @SerializedName("MBTI")
    private String MBTI;
    public String MBTI() {
        return MBTI;
    }
    public void MBTI(String nickName) {
        this.MBTI = MBTI;
    }

    @SerializedName("password")
    private String password;
    public String password() {
        return password;
    }
    public void password(String password) {
        this.password = password;
    }

}
 */

