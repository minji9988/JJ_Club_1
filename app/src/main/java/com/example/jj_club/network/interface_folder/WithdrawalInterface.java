package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.WithdrawalRequest;
import com.example.jj_club.models.response.WithdrawalResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface WithdrawalInterface {
    @POST("/api/v1/auth/user/me2")
    Call<WithdrawalResponse> withdrawUser(@Header("Authorization") String accessToken, @Body WithdrawalRequest request);
}