package com.example.jj_club.network.interface_folder;

import com.example.jj_club.models.request.LikeStatusRequest;
import com.example.jj_club.models.response.LikeStatusResponse;
import com.example.jj_club.models.response.PopularPostsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 인기 게시글을 가져오는 API와 좋아요 상태를 변경하는 API와 통신하기 위한 인터페이스입니다.
 */
// HomePopularPostsInterface.java
public interface HomePopularPostsInterface {
    @GET("popular_posts")
    Call<PopularPostsResponse> getPopularPosts();

    @POST("change_like_status")
    Call<LikeStatusResponse> sendLikeStatus(@Body LikeStatusRequest request);
}
