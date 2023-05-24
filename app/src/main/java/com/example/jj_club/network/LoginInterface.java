package com.example.jj_club.network;


// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의

//////////////Login 수정하고, //////////////////////////
// //모든 Acitivty에 주석 추가해서 다시 붙이고
// 지혁이 거 부터 pull request 날리고
// 그다음 명준이 거

import com.example.jj_club.models.request.LoginRequest;
import com.example.jj_club.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LoginInterface {
    @POST("/api/v1/auth/login") // 로그인 API의 엔드포인트 경로
    Call<LoginResponse> login ( @Body LoginRequest loginRequest);
}


//public interface LoginInterface {
//
//    @FormUrlEncoded
//    @POST("/api/v1/auth/login") // 로그인:  API 엔드포인트가 들어가는 자리다.
//    Call<LoginResponse> login(
//            @Field("email") String email,
//            @Field("password") String password
//    );
//}
