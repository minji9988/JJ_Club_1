package com.example.jj_club.models;

/**
 * 인기 게시글의 정보를 저장하는 클래스입니다.
 */
public class PopularPostsData {
    private String postId;  // 게시글 아이디
    private String title;
    private String contents;
    private String date;
    private int likeCount; // 게시글 좋아요 수
    private String postImage;

    private boolean isLikedByUser; // 사용자가 게시글에 좋아요를 눌렀는지 여부

    // 게시글 아이디를 반환하는 메소드
    public String getPostId() {
        return postId;
    }

    // 게시글 아이디를 설정하는 메소드
    public void setPostId(String postId) {
        this.postId = postId;
    }

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
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    // 게시글 좋아요 수를 반환하는 메소드
    public int getLikeCount() {
        return likeCount;
    }

    // 게시글 이미지 URL을 설정하는 메소드
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    // 게시글 이미지 URL을 반환하는 메소드
    public String getPostImage() {
        return postImage;
    }

    // 사용자가 게시글에 좋아요를 눌렀는지 여부를 설정하는 메소드
    public void setLikedByUser(boolean likedByUser) {
        this.isLikedByUser = likedByUser;
    }

    // 사용자가 게시글에 좋아요를 눌렀는지 여부를 반환하는 메소드
    public boolean isLikedByUser() {
        return isLikedByUser;
    }
}
