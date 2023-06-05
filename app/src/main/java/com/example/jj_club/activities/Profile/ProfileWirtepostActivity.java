package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;
import com.example.jj_club.models.request.ProfileWritepostRequest;
import com.example.jj_club.models.response.ProfileWritepostResponse;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.ProfileWritepostInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileWirtepostActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromWirtepostActivity;

    ProfileWritepostRequest request = new ProfileWritepostRequest();
    ProfileWritepostInterface writePost = RetrofitClient.getClient().create(ProfileWritepostInterface.class);
    Call<ProfileWritepostResponse> call = writePost.PROFILE_WRITEPOST_RESPONSE_CALL(request);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_wirtepost);

        btn_GoBackProfile_fromWirtepostActivity = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromWirtepostActivity);
        btn_GoBackProfile_fromWirtepostActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();

            }
        });



    }
}