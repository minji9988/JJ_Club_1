package com.example.jj_club.activities.Profile;
import com.example.jj_club.fragments.ProfileFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.jj_club.R;

public class ProfileAlarmActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromProfileAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_alarm);

        btn_GoBackProfile_fromProfileAlarm = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromProfileAlarm);
        btn_GoBackProfile_fromProfileAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });



    }
}