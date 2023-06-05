package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;
import com.example.jj_club.models.request.ProfileSendapplicationformRequest;
import com.example.jj_club.models.response.ProfileSendapplicationformResponse;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.ProfileSendapplicationformInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileSendapplicationformActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromSendapplicationformActivity;

    ProfileSendapplicationformRequest request = new ProfileSendapplicationformRequest();
    ProfileSendapplicationformInterface Sendform = RetrofitClient.getClient().create(ProfileSendapplicationformInterface.class);
    Call<ProfileSendapplicationformResponse> call = Sendform.PROFILE_RECIVEDAPPLICATIONFORM_RESPONSE_CALL(request);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_sendapplicationform);

        btn_GoBackProfile_fromSendapplicationformActivity = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromSendapplicationformActivity);
        btn_GoBackProfile_fromSendapplicationformActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        call.enqueue(new Callback<ProfileSendapplicationformResponse>() {
            @Override
            public void onResponse(Call<ProfileSendapplicationformResponse> call, Response<ProfileSendapplicationformResponse> response) {
                if (response.isSuccessful()) {
                    // Profile update successful
                    ProfileSendapplicationformResponse updateResponse = response.body();
                    // Handle the response as needed


                } else {
                    Toast.makeText(ProfileSendapplicationformActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileSendapplicationformResponse> call, Throwable t) {
                // Profile update request failed
                // Handle the failure case
            }
        });
    }
}