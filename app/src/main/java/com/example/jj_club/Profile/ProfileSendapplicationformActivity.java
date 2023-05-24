package com.example.jj_club.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;

public class ProfileSendapplicationformActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromSendapplicationformActivity;

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

    }
}