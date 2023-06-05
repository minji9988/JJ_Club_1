package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileLoveitRequest;
import com.example.jj_club.models.request.ProfileWritepostRequest;
import com.example.jj_club.models.response.ProfileLoveitResponse;
import com.example.jj_club.models.response.ProfileWritepostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileWritepostInterface {
    @GET("writePost")
    Call<ProfileWritepostResponse> PROFILE_WRITEPOST_RESPONSE_CALL(@Body ProfileWritepostRequest request);
}
