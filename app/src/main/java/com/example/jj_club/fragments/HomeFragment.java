package com.example.jj_club.fragments;
////////////////////메인(홈) 페이지///////////////////

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jj_club.activities.PopularPostsActivity;
import com.example.jj_club.R;

public
class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public
    HomeFragment () {
        // Required empty public constructor
    }


    public static
    HomeFragment newInstance ( String param1, String param2 ) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public
    View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 홈(메인) 페이지에 있는 인기글 옆 '더보기' 텍스트 클릭 시 '인기글' 페이지로 이동
        TextView more_popular_posts = view.findViewById(R.id.btn_more_popular_posts);
        more_popular_posts.setOnClickListener(new View.OnClickListener() {
            public
            void onClick ( View view ) {
                Intent intent = new Intent(view.getContext(), PopularPostsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
