package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;

public class ProfileWirtepostActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromWirtepostActivity;

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