package com.example.jj_club.network;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.jj_club.R;

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
        // 레이아웃 인플레이션을 통해 아이템 뷰 생성
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home, parent, false);
        // ViewHolder 객체 생성 후 반환
        return new HomeViewHolder(itemView);
    }

    // onBindViewHolder 메서드 오버라이드
    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        // 데이터 리스트에서 해당 position의 아이템 가져오기
        HomePostItem postItem = postItemList.get(position);
        // 이미지 로딩은 Picasso나 Glide와 같은 라이브러리를 사용하면 편리합니다.
        // 이미지 라이브러리를 사용하지 않는다면 직접 이미지를 로드하여 설정해주어야 합니다.
        // Picasso.get().load(postItem.getImageUrl()).into(holder.imageView);
        holder.title.setText(postItem.getTitle()); // 아이템의 제목 설정
        holder.date.setText(postItem.getDate()); // 아이템의 날짜 설정
    }

    // getItemCount 메서드 오버라이드
    @Override
    public int getItemCount() {
        // 아이템 리스트의 크기 반환
        return postItemList.size();
    }
}
