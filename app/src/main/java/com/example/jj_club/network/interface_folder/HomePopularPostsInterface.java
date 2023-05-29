package com.example.jj_club.network.interface_folder;

// HomePopularPostsInterface.java

import com.example.jj_club.models.request.PopularPostsRequest;
import com.example.jj_club.models.response.PopularPostsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * 인기 게시글을 가져오는 API와 통신하기 위한 인터페이스입니다.
 */
public interface HomePopularPostsInterface {
    @GET("popular_posts")
    Call<PopularPostsResponse> getPopularPosts( @Body PopularPostsRequest request);
}
