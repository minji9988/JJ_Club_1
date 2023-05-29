package com.example.jj_club.network;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;

public class PopularPostViewHolder extends RecyclerView.ViewHolder {

    ImageView postImage;
    TextView postTitle, postContents, postDay, postLoveCount;

    public PopularPostViewHolder(View itemView) {
        super(itemView);
        // view components
        postImage = itemView.findViewById(R.id.item_popular_post_img);
        postTitle = itemView.findViewById(R.id.item_popular_post_title);
        postContents = itemView.findViewById(R.id.item_popular_post_contents);
        postDay = itemView.findViewById(R.id.item_popular_post_d_day);
        postLoveCount = itemView.findViewById(R.id.item_popular_post_love_count);
    }
}

