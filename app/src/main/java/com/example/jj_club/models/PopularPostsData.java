package com.example.jj_club.models;

// PopularPostData.java

/**
 * 인기 게시글의 정보를 저장하는 클래스입니다.
 */
public class PopularPostsData {
    private String title;
    private String contents;
    private String date;
    private String loveCount;
    private String postImage;

    // 게시글 제목을 설정하는 메소드
    public void setTitle(String title) {
        this.title = title;
    }

    // 게시글 제목을 반환하는 메소드
    public String getTitle() {
        return title;
    }

    // 게시글 내용을 설정하는 메소드
    public void setContents(String contents) {
        this.contents = contents;
    }

    // 게시글 내용을 반환하는 메소드
    public String getContents() {
        return contents;
    }

    // 게시글 날짜를 설정하는 메소드
    public void setDate(String date) {
        this.date = date;
    }

    // 게시글 날짜를 반환하는 메소드
    public String getDate() {
        return date;
    }

    // 게시글 좋아요 수를 설정하는 메소드
    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    // 게시글 좋아요 수를 반환하는 메소드
    public String getLoveCount() {
        return loveCount;
    }

    // 게시글 이미지 URL을 설정하는 메소드
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    // 게시글 이미지 URL을 반환하는 메소드
    public String getPostImage() {
        return postImage;
    }
}

