package com.example.jj_club.models.request;

/**
 * 좋아요 상태 변경 요청을 위한 클래스입니다.
 */
public class LikeStatusRequest {
    private String postId;  // 게시글 ID
    private boolean likeStatus;  // 좋아요 상태 (true: 좋아요, false: 좋아요 취소)

    public LikeStatusRequest(String postId, boolean likeStatus) {
        this.postId = postId;
        this.likeStatus = likeStatus;
    }

    // 게시글 ID를 반환하는 메소드
    public String getPostId() {
        return postId;
    }

    // 좋아요 상태를 반환하는 메소드
    public boolean isLikeStatus() {
        return likeStatus;
    }
}
