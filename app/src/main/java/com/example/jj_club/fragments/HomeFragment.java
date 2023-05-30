package com.example.jj_club.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;
import com.example.jj_club.activities.mainpage.FilterActivity;
import com.example.jj_club.activities.mainpage.HomeCompatibleMbtiPostsActivity;
import com.example.jj_club.activities.mainpage.HomeLatestPostsActivity;
import com.example.jj_club.activities.mainpage.HomePopularPostsActivity;
import com.example.jj_club.activities.mainpage.HomeSameMbtiPostsActivity;
import com.example.jj_club.activities.mainpage.SearchActivity;
import com.example.jj_club.activities.promotion.PromotionWrite1;
import com.example.jj_club.network.HomeAdapter;
import com.example.jj_club.network.HomePostItem;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.HomeInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    // 리사이클러뷰 인스턴스 선언
    private RecyclerView popularPostsRecyclerView, latestPostsRecyclerView, sameMbtiPostsRecyclerView, compatibleMbtiPostsRecyclerView;

    // 포스트 아이템 리스트 선언
    private List<HomePostItem> popularPostItemList, latestPostItemList, sameMbtiPostItemList, compatibleMbtiPostItemList;

    // Retrofit 서비스 인스턴스 선언
    private HomeInterface homeInterface;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 리사이클러뷰 인스턴스 초기화
        popularPostsRecyclerView = view.findViewById(R.id.recycler_view_main_page_popular);
        latestPostsRecyclerView = view.findViewById(R.id.recycler_view_main_page_latest);
        sameMbtiPostsRecyclerView = view.findViewById(R.id.recycler_view_main_page_same_mbti);
        compatibleMbtiPostsRecyclerView = view.findViewById(R.id.recycler_view_main_page_compatible_mbti);

        // 리사이클러뷰에 LinearLayoutManager 설정
        popularPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        latestPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        sameMbtiPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        compatibleMbtiPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        // HomePostItem 인스턴스 생성
        popularPostItemList = new ArrayList<>();
        latestPostItemList = new ArrayList<>();
        sameMbtiPostItemList = new ArrayList<>();
        compatibleMbtiPostItemList = new ArrayList<>();

        // Retrofit 서비스 초기화
        homeInterface = RetrofitClient.getClient().create(HomeInterface.class);

        // 서버에서 인기글 데이터 가져오기
        fetchPosts(homeInterface.getPopularPosts(), popularPostItemList, popularPostsRecyclerView);

        // 서버에서 최신글 데이터 가져오기
        fetchPosts(homeInterface.getLatestPosts(), latestPostItemList, latestPostsRecyclerView);

        // 서버에서 같은 MBTI 글 데이터 가져오기
        fetchPosts(homeInterface.getSameMbtiPosts(), sameMbtiPostItemList, sameMbtiPostsRecyclerView);

        // 서버에서 궁합이 맞는 MBTI 글 데이터 가져오기
        fetchPosts(homeInterface.getCompatibleMbtiPosts(), compatibleMbtiPostItemList, compatibleMbtiPostsRecyclerView);

        // 인기글 더보기 버튼 클릭 시
        TextView morePopularPostsTextView = view.findViewById(R.id.btn_more_popular_posts);
        morePopularPostsTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomePopularPostsActivity.class);
                startActivity(intent);
            }
        });

        // 최신글 더보기 버튼 클릭 시
        TextView moreLatestPostsTextView = view.findViewById(R.id.btn_more_latest_posts);
        moreLatestPostsTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeLatestPostsActivity.class);
                startActivity(intent);
            }
        });

        // 같은 MBTI 글 더보기 버튼 클릭 시
        TextView moreSameMbtiPostsTextView = view.findViewById(R.id.btn_more_same_mbti_posts);
        moreSameMbtiPostsTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeSameMbtiPostsActivity.class);
                startActivity(intent);
            }
        });

        // 궁합이 맞는 MBTI 글 더보기 버튼 클릭 시
        TextView moreCompatibleMbtiPostsTextView = view.findViewById(R.id.btn_more_compatible_mbti_posts);
        moreCompatibleMbtiPostsTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeCompatibleMbtiPostsActivity.class);
                startActivity(intent);
            }
        });

        // 필터 아이콘 클릭 시
        ImageButton filterButton = view.findViewById(R.id.btn_filter_main_page);
        filterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });

        // 돋보기 아이콘 클릭 시
        ImageButton searchButton = view.findViewById(R.id.btn_magnifying_glass_main_page);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        // 글쓰기 아이콘 클릭 시
        ImageButton writePostButton = view.findViewById(R.id.btn_write_post);
        writePostButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PromotionWrite1.class);
                startActivity(intent);
            }
        });


        return view;
    }

    private void fetchPosts(Call<List<HomePostItem>> call, List<HomePostItem> postItemList, RecyclerView recyclerView) {
        call.enqueue(new Callback<List<HomePostItem>>() {
            @Override
            public void onResponse(Call<List<HomePostItem>> call, Response<List<HomePostItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // 데이터 리스트에 서버에서 받아온 데이터 추가
                    postItemList.addAll(response.body());

                    // 리사이클러뷰에 HomeAdapter 설정
                    HomeAdapter homeAdapter = new HomeAdapter(postItemList);
                    recyclerView.setAdapter(homeAdapter);

                    // 데이터를 성공적으로 받아온 것을 Toast 메시지로 알림
                    if (getActivity() != null) {
                        Toast.makeText(getActivity(), "데이터를 성공적으로 받아왔습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<HomePostItem>> call, Throwable t) {
                // 에러 처리
                t.printStackTrace();

                // 데이터 받아오기에 실패한 것을 Toast 메시지로 알림
                if (getActivity() != null) {
                    Toast.makeText(getActivity(), "데이터를 받아오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}