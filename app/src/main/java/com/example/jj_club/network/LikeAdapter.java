package com.example.jj_club.network;

import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jj_club.R;
import com.example.jj_club.models.PopularPostsData;
import com.example.jj_club.models.request.LikeStatusRequest;
import com.example.jj_club.models.response.LikeStatusResponse;
import com.example.jj_club.network.interface_folder.HomePopularPostsInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LikeAdapter {
    private HomePopularPostsInterface apiInterface;

    public LikeAdapter() {
        this.apiInterface = RetrofitClient.getClient().create(HomePopularPostsInterface.class);
    }

    public void toggleLikeStatus(PopularPostsData post, ImageButton likeButton, TextView likeCountView) {
        if (post.isLikedByUser()) {
            // 이미 좋아요 상태라면, 좋아요 취소
            post.setLikedByUser(false);
            post.setLikeCount(post.getLikeCount() - 1);
            likeButton.setImageResource(R.drawable.love_outline);
        } else {
            // 아직 좋아요 상태가 아니라면, 좋아요
            post.setLikedByUser(true);
            post.setLikeCount(post.getLikeCount() + 1);
            likeButton.setImageResource(R.drawable.icon_love_blue);
        }
        likeCountView.setText(String.valueOf(post.getLikeCount()));

        // 좋아요 상태를 서버로 보내는 메소드 호출
        sendLikeStatusToServer(post, likeButton, likeCountView);
    }


    private void sendLikeStatusToServer(PopularPostsData post, ImageButton likeButton, TextView postLoveCount) {
        // LikeStatusRequest 객체 생성
        LikeStatusRequest request = new LikeStatusRequest(post.getPostId(), post.isLikedByUser());

        // Retrofit을 사용하여 서버에 요청
        Call<LikeStatusResponse> call = apiInterface.sendLikeStatus(request);
        call.enqueue(new Callback<LikeStatusResponse>() {
            @Override
            public void onResponse(Call<LikeStatusResponse> call, Response<LikeStatusResponse> response) {
                if (response.isSuccessful()) {
                    LikeStatusResponse likeStatusResponse = response.body();

                    // 변경된 좋아요 수를 post 객체에 업데이트
                    post.setLikeCount(likeStatusResponse.getLikeCount());

                    // 좋아요 상태에 따라 하트 색상 변경
                    if (post.isLikedByUser()) {
                        likeButton.setImageResource(R.drawable.icon_love_blue);
                    } else {
                        likeButton.setImageResource(R.drawable.icon_love_outline);
                    }

                    // 변경된 좋아요 수를 표시
                    postLoveCount.setText(String.valueOf(post.getLikeCount()));
                } else {
                    Log.e("LikeAdapter", "Failed to send like status to server");
                }
            }

            @Override
            public void onFailure(Call<LikeStatusResponse> call, Throwable t) {
                Log.e("LikeAdapter", "Error sending like status to server", t);
            }
        });
    }
}

