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
import com.example.jj_club.network.PopularPostsAdapter;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.HomePopularPostsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePopularPostsActivity extends AppCompatActivity {
    private static final String TAG = "HomePopularPostsActivity"; // For log messages
    private RecyclerView recyclerView;
    private PopularPostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_popular_posts);

        recyclerView = findViewById(R.id.recyclerView_popular_posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchPopularPosts();
    }
    private void fetchPopularPosts() {
        PopularPostsRequest request = new PopularPostsRequest();

        // Create HomePopularPostsInterface instance
        HomePopularPostsInterface apiInterface = RetrofitClient.getClient().create(HomePopularPostsInterface.class);

        // Make the HTTP request
        Call<PopularPostsResponse> call = apiInterface.getPopularPosts(request);

        call.enqueue(new Callback<PopularPostsResponse>() {
            @Override
            public void onResponse(Call<PopularPostsResponse> call, Response<PopularPostsResponse> response) {
                if (response.isSuccessful()) {
                    List<PopularPostsData> posts = response.body().getPosts();

                    adapter = new PopularPostsAdapter(HomePopularPostsActivity.this, posts);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(HomePopularPostsActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PopularPostsResponse> call, Throwable t) {
                Toast.makeText(HomePopularPostsActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Error fetching popular posts", t);
            }
        });
    }
}
