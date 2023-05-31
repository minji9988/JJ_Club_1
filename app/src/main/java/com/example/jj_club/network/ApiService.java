package com.example.jj_club.network;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("send_date") // Replace with your server's API endpoint for sending the date
    Call<Void> sendDate(@Query("date") String date);
}
