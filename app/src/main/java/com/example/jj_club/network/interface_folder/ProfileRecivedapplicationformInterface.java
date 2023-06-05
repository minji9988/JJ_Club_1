package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileRecivedapplicationformRequest;
import com.example.jj_club.models.response.ProfileRecivedapplicationformResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileRecivedapplicationformInterface {
    @GET("recivedForm")
    Call<ProfileRecivedapplicationformResponse> PROFILE_RECIVEDAPPLICATIONFORM_RESPONSE_CALL(@Body ProfileRecivedapplicationformRequest request);
}
