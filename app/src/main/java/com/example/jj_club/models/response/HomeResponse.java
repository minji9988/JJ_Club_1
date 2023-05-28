package com.example.jj_club.models.response;

import com.example.jj_club.network.HomePostItem;

import java.util.List;

public class HomeResponse {
    private List<HomePostItem> popularPosts;        // 인기 게시글
    private List<HomePostItem> latestPosts;         // 최신 게시글
    private List<HomePostItem> sameMbtiPosts;       // 사용자 MBTI와 같은 게시글
    private List<HomePostItem> compatibleMbtiPosts; // 사용자 MBTI와 궁합이 맞는 게시글

    // Default constructor
    public HomeResponse() {}

    // Constructor with all parameters
    public HomeResponse(List<HomePostItem> popularPosts, List<HomePostItem> latestPosts, List<HomePostItem> sameMbtiPosts, List<HomePostItem> compatibleMbtiPosts) {
        this.popularPosts = popularPosts;
        this.latestPosts = latestPosts;
        this.sameMbtiPosts = sameMbtiPosts;
        this.compatibleMbtiPosts = compatibleMbtiPosts;
    }

    // Getter and Setter methods
    public List<HomePostItem> getPopularPosts() {
        return popularPosts;
    }

    public void setPopularPosts(List<HomePostItem> popularPosts) {
        this.popularPosts = popularPosts;
    }

    public List<HomePostItem> getLatestPosts() {
        return latestPosts;
    }

    public void setLatestPosts(List<HomePostItem> latestPosts) {
        this.latestPosts = latestPosts;
    }

    public List<HomePostItem> getSameMbtiPosts() {
        return sameMbtiPosts;
    }

    public void setSameMbtiPosts(List<HomePostItem> sameMbtiPosts) {
        this.sameMbtiPosts = sameMbtiPosts;
    }

    public List<HomePostItem> getCompatibleMbtiPosts() {
        return compatibleMbtiPosts;
    }

    public void setCompatibleMbtiPosts(List<HomePostItem> compatibleMbtiPosts) {
        this.compatibleMbtiPosts = compatibleMbtiPosts;
    }
}
