package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.ProfileAlarmRequest;
import com.example.jj_club.models.response.ProfileAlarmResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileAlarmInterface {
    @GET("")
    Call<ProfileAlarmResponse> PROFILE_ALARM_RESPONSE_CALL(@Body ProfileAlarmRequest requset);
}
