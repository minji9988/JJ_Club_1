package com.example.jj_club.network;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<HomePostItem> postItemList;

    // ViewHolder 클래스 정의
    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, date;

        // ViewHolder 생성자
        public HomeViewHolder(View view) {
            super(view);
            // 아이템의 뷰 요소들을 findViewById를 통해 참조
            imageView = view.findViewById(R.id.item_mainpage_button);
            title = view.findViewById(R.id.item_mainpage_title);
            date = view.findViewById(R.id.item_mainpage_d_day);
        }
    }

    // 생성자
    public HomeAdapter(List<HomePostItem> postItemList) {
        this.postItemList = postItemList;
    }

    // onCreateViewHolder 메서드 오버라이드
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 각 아이템에 대한 레이아웃 인플레이션
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item, parent, false);
        return new HomeViewHolder(itemView);
    }

    // onBindViewHolder 메서드 오버라이드
    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        // 데이터 리스트에서 해당 position의 아이템 가져오기
        HomePostItem postItem = postItemList.get(position);
        // Picasso를 사용해 이미지를 로드하고 imageView에 설정
        Picasso.get().load(postItem.getImageUrl()).placeholder(R.drawable.gray_rectangle).into(holder.imageView);
        holder.title.setText(postItem.getTitle()); // 아이템의 제목 설정
        holder.date.setText(postItem.getDate()); // 아이템의 날짜 설정
    }

    // getItemCount 메서드 오버라이드
    @Override
    public int getItemCount() {
        // 아이템 리스트의 크기 반환
        return postItemList.size();
    }

    // 새로운 데이터로 갱신하고 RecyclerView에 알리는 메서드
    public void updateData(List<HomePostItem> newPostItemList) {
        postItemList = newPostItemList;
        notifyDataSetChanged();
    }
}
