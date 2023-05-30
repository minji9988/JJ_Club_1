package com.example.jj_club.models.response;


/**
 * 좋아요 상태 변경 응답을 위한 클래스입니다.
 */
public class LikeStatusResponse {
    private String postId;  // 게시글 ID
    private int likeCount;  // 변경된 좋아요 수

    // 게시글 ID를 반환하는 메소드
    public String getPostId() {
        return postId;
    }

    // 변경된 좋아요 수를 반환하는 메소드
    public int getLikeCount() {
        return likeCount;
    }
}
