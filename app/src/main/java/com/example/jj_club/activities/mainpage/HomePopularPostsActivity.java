package com.example.jj_club.activities.mainpage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jj_club.R;
import com.example.jj_club.models.PopularPostsData;
import com.example.jj_club.models.request.PopularPostsRequest;
import com.example.jj_club.models.response.PopularPostsResponse;
import com.example.jj_club.network.LikeAdapter;
import com.example.jj_club.network.PopularPostsAdapter;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.HomePopularPostsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePopularPostsActivity extends AppCompatActivity {
    private static final String TAG = "HomePopularPostsActivity"; // 로그 메세지용 태그
    private RecyclerView recyclerView;
    private PopularPostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_popular_posts);

        recyclerView = findViewById(R.id.recyclerView_popular_posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 인기 게시글 가져오기
        fetchPopularPosts();
    }

    /**
     * 인기 게시글을 서버에서 가져와서 화면에 표시하는 메소드입니다.
     */
    private void fetchPopularPosts() {
        // API 요청에 필요한 PopularPostsRequest 인스턴스 생성
        PopularPostsRequest request = new PopularPostsRequest();

        // Retrofit을 사용하여 HTTP 통신을 위한 HomePopularPostsInterface 인스턴스 생성
        HomePopularPostsInterface apiInterface = RetrofitClient.getClient().create(HomePopularPostsInterface.class);

        // 좋아요 기능을 위한 LikeAdapter 인스턴스 생성
        LikeAdapter likeAdapter = new LikeAdapter();

        // 서버에 인기 게시글 요청을 보내고 응답을 처리하는 비동기 방식으로 처리
        Call<PopularPostsResponse> call = apiInterface.getPopularPosts();
        call.enqueue(new Callback<PopularPostsResponse>() {
            @Override
            public void onResponse(Call<PopularPostsResponse> call, Response<PopularPostsResponse> response) {
                if (response.isSuccessful()) {
                    // 서버 응답이 성공한 경우, 인기 게시글 데이터를 가져옴
                    List<PopularPostsData> posts = response.body().getPosts();

                    // 인기 게시글 어댑터 생성 및 설정
                    adapter = new PopularPostsAdapter(HomePopularPostsActivity.this, posts, likeAdapter);
                    recyclerView.setAdapter(adapter);


                } else {
                    // 서버 응답이 실패한 경우
                    Toast.makeText(HomePopularPostsActivity.this, "인기 게시글을 가져올 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PopularPostsResponse> call, Throwable t) {
                // 서버 통신 실패 시
                Toast.makeText(HomePopularPostsActivity.this, "인기 게시글을 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Error fetching popular posts", t);
            }
        });
    }
}
