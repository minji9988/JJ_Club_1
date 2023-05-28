package com.example.jj_club.network;


// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의

import com.example.jj_club.models.request.LoginRequest;
import com.example.jj_club.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LoginInterface {
    @POST("/api/v1/auth/login") // 로그인 API의 엔드포인트 경로
    Call<LoginResponse> login ( @Body LoginRequest loginRequest);
}

