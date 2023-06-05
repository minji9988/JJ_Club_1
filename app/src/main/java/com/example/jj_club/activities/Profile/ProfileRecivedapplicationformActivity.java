package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;
import com.example.jj_club.models.request.ProfileRecivedapplicationformRequest;
import com.example.jj_club.models.response.ProfileEditResponse;
import com.example.jj_club.models.response.ProfileRecivedapplicationformResponse;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.ProfileRecivedapplicationformInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRecivedapplicationformActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromRecivedapplicationformActivity;

    ProfileRecivedapplicationformRequest request = new ProfileRecivedapplicationformRequest();
    ProfileRecivedapplicationformInterface recivedform = RetrofitClient.getClient().create(ProfileRecivedapplicationformInterface.class);
    Call<ProfileRecivedapplicationformResponse> call = recivedform.PROFILE_RECIVEDAPPLICATIONFORM_RESPONSE_CALL(request);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_recivedapplicationform);

        btn_GoBackProfile_fromRecivedapplicationformActivity = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromRecivedapplicationformActivity);
        btn_GoBackProfile_fromRecivedapplicationformActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        call.enqueue(new Callback<ProfileRecivedapplicationformResponse>() {
            @Override
            public void onResponse(Call<ProfileRecivedapplicationformResponse> call, Response<ProfileRecivedapplicationformResponse> response) {
                if (response.isSuccessful()) {
                    // Profile update successful
                    ProfileRecivedapplicationformResponse updateResponse = response.body();
                    // Handle the response as needed


                } else {
                    Toast.makeText(ProfileRecivedapplicationformActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileRecivedapplicationformResponse> call, Throwable t) {
                // Profile update request failed
                // Handle the failure case
            }
        });

    }
}