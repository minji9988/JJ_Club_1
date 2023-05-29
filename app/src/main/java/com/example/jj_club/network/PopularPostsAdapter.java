package com.example.jj_club.network;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;
import com.example.jj_club.models.PopularPostsData;

import java.util.List;

public class PopularPostsAdapter extends RecyclerView.Adapter<PopularPostViewHolder> {
    private Context context;
    private List<PopularPostsData> posts;

    public PopularPostsAdapter(Context context, List<PopularPostsData> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PopularPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_home_posts_item, parent, false);
        return new PopularPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopularPostViewHolder holder, int position) {
        // Get the current post
        PopularPostsData post = posts.get(position);
        // Bind the data to the ViewHolder
        holder.postTitle.setText(post.getTitle());
        holder.postContents.setText(post.getContents());
        holder.postDay.setText(post.getDate());
        holder.postLoveCount.setText(post.getLoveCount());
        // TODO: Load image into postImage
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
