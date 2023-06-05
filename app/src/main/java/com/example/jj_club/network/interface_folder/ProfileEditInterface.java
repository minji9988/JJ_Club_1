package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileEditRequest;
import com.example.jj_club.models.response.ProfileEditResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.Call;
import retrofit2.http.PUT;

public interface ProfileEditInterface {
    @PUT("/api/v1/auth/user/update")
    Call<ProfileEditResponse> editProfile(@Body ProfileEditRequest request);
}

/*
public interface ProfileEditInterface {
    @GET("/api/v1/profile")
    Call<ProfileEditResponse> editFrofile(@Body ProfileEditRequest request);
}
*/