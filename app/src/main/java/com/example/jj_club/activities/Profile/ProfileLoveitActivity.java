package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;
import com.example.jj_club.models.request.ProfileLoveitRequest;
import com.example.jj_club.models.request.ProfileLoveitRequest;
import com.example.jj_club.models.response.ProfileLoveitResponse;
import com.example.jj_club.models.response.ProfileLoveitResponse;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.ProfileLoveitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileLoveitActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromLoveIt;

    ProfileLoveitRequest request = new ProfileLoveitRequest();
    ProfileLoveitInterface loveIt = RetrofitClient.getClient().create(ProfileLoveitInterface.class);
    Call<ProfileLoveitResponse> call = loveIt.PROFILE_LOVEIT_RESPONSE_CALL(request);
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_loveit);

        btn_GoBackProfile_fromLoveIt = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromLoveIt);
        btn_GoBackProfile_fromLoveIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                /*Intent intent = new Intent(ProfileLoveitActivity.this, ProfileFragment.class);
                startActivity(intent);
                */
            }
        });

        call.enqueue(new Callback<ProfileLoveitResponse>() {
            @Override
            public void onResponse(Call<ProfileLoveitResponse> call, Response<ProfileLoveitResponse> response) {
                if (response.isSuccessful()) {
                    // Profile update successful
                    ProfileLoveitResponse updateResponse = response.body();
                    // Handle the response as needed


                } else {
                    Toast.makeText(ProfileLoveitActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileLoveitResponse> call, Throwable t) {
                // Profile update request failed
                // Handle the failure case
            }
        });


    }
}