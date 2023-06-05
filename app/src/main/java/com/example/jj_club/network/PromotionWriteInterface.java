package com.example.jj_club.network;

import com.example.jj_club.models.request.PromotionWriteRequest;
import com.example.jj_club.models.request.PromotionWriteRequest2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PromotionWriteInterface {
    @POST("send_date") // Replace with your server's API endpoint for sending the date
    Call<Void> sendDate(@Query("date") String date);

    @POST("api/promotion/write")
    Call<Void> sendPromotionWriteData(@Body PromotionWriteRequest pwData);

    @POST("api/promotion/write")
    Call<Void> sendPromotionWriteData(@Body PromotionWriteRequest2 pwData);
}
