package com.example.jj_club.network;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;

public class PopularPostViewHolder extends RecyclerView.ViewHolder {

    ImageView postImage;
    TextView postTitle, postContents, postDay, postLoveCount;
    ImageButton likeButton;  // '좋아요' 버튼을 위한 참조 추가

    public PopularPostViewHolder(View itemView) {
        super(itemView);
        // 뷰 컴포넌트들
        postImage = itemView.findViewById(R.id.item_popular_post_img);
        postTitle = itemView.findViewById(R.id.item_popular_post_title);
        postContents = itemView.findViewById(R.id.item_popular_post_contents);
        postDay = itemView.findViewById(R.id.item_popular_post_d_day);
        postLoveCount = itemView.findViewById(R.id.item_popular_post_love_count);
        likeButton = itemView.findViewById(R.id.item_popular_white_love);  // '좋아요' 버튼 찾기
    }
}
