package com.example.jj_club.network;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;
import com.example.jj_club.models.PopularPostsData;

import java.util.List;

public class PopularPostsAdapter extends RecyclerView.Adapter<PopularPostsAdapter.PopularPostViewHolder> {
    private Context context;
    private List<PopularPostsData> posts;
    private LikeAdapter likeAdapter;

    public PopularPostsAdapter(Context context, List<PopularPostsData> posts, LikeAdapter likeAdapter) {
        this.context = context;
        this.posts = posts;
        this.likeAdapter = likeAdapter;
    }
    @Override
    public PopularPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 새로운 뷰 생성
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_home_posts_item, parent, false);
        return new PopularPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopularPostViewHolder holder, int position) {
        // 현재 게시글 가져오기
        PopularPostsData post = posts.get(position);
        // ViewHolder에 데이터 바인딩
        holder.postTitle.setText(post.getTitle());
        holder.postContents.setText(post.getContents());
        holder.postDay.setText(post.getDate());
        holder.postLoveCount.setText(String.valueOf(post.getLikeCount()));
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeAdapter.toggleLikeStatus(post, holder.likeButton, holder.postLoveCount);
            }
        });
        // TODO: 이미지 로딩 필요
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PopularPostViewHolder extends RecyclerView.ViewHolder {
        ImageButton likeButton;
        TextView postTitle, postContents, postDay, postLoveCount;

        public PopularPostViewHolder(View itemView) {
            super(itemView);
            // 뷰 컴포넌트들
            likeButton = itemView.findViewById(R.id.item_popular_white_love);
            postTitle = itemView.findViewById(R.id.item_popular_post_title);
            postContents = itemView.findViewById(R.id.item_popular_post_contents);
            postDay = itemView.findViewById(R.id.item_popular_post_d_day);
            postLoveCount = itemView.findViewById(R.id.item_popular_post_love_count);
        }
    }
}
