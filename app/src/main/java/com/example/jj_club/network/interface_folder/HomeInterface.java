package com.example.jj_club.network.interface_folder;

import com.example.jj_club.network.HomePostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeInterface {
    @GET("popular")
    Call<List<HomePostItem>> getPopularPosts();

    @GET("latest")
    Call<List<HomePostItem>> getLatestPosts();

    @GET("sameMbti")
    Call<List<HomePostItem>> getSameMbtiPosts();

    @GET("compatibleMbti")
    Call<List<HomePostItem>> getCompatibleMbtiPosts();
}
