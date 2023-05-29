package com.example.jj_club.models.response;

import com.example.jj_club.models.PopularPostsData;

import java.util.List;

public class PopularPostsResponse {
    private List<PopularPostsData> posts;

    public List<PopularPostsData> getPosts() {
        return posts;
    }
}