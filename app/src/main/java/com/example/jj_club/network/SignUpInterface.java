// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의



package com.example.jj_club.network;

import com.example.jj_club.models.request.SignUpRequest;
import com.example.jj_club.models.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpInterface {
    @POST("/api/v1/auth/signup")
    Call<SignUpResponse> signUp( @Body SignUpRequest signUpRequest);
}
