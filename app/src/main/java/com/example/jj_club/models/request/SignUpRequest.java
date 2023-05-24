package com.example.jj_club.models.request;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("nickName")
    private String nickName;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    public SignUpRequest(String email, String password, String nickName, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
//    Getter 메서드는 각 필드의 값을 반환하고, Setter 메서드는 각 필드에 값을 설정합니다.
//
//    Getter 메서드는 필드 값을 반환하기 위해 사용됩니다.
//    Setter 메서드는 외부에서 필드 값을 설정하기 위해 사용됩니다.
//    이러한 Getter와 Setter 메서드를 정의함으로써 SignUpRequest 클래스의 인스턴스에서 필드 값을 읽고 설정할 수 있습니다.

