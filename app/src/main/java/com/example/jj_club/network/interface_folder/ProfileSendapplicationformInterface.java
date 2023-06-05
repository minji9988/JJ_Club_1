package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileRecivedapplicationformRequest;
import com.example.jj_club.models.request.ProfileSendapplicationformRequest;
import com.example.jj_club.models.response.ProfileRecivedapplicationformResponse;
import com.example.jj_club.models.response.ProfileSendapplicationformResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileSendapplicationformInterface {
    @GET("sendForm")
    Call<ProfileSendapplicationformResponse> PROFILE_RECIVEDAPPLICATIONFORM_RESPONSE_CALL(@Body ProfileSendapplicationformRequest request);
}

