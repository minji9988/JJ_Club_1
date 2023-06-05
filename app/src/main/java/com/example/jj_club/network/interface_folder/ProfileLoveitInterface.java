package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileLoveitRequest;
import com.example.jj_club.models.response.ProfileLoveitResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileLoveitInterface {
    @GET("Loveit")
    Call<ProfileLoveitResponse> PROFILE_LOVEIT_RESPONSE_CALL(@Body ProfileLoveitRequest requset);

}
