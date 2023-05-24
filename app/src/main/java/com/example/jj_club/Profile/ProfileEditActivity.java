package com.example.jj_club.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.provider.MediaStore;

import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;


public class ProfileEditActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromProfileEdit;
    private ImageButton btn_profileImage;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap)data.getParcelableExtra("data");
                    btn_profileImage.setImageBitmap(bitmap);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        btn_profileImage = (ImageButton) findViewById(R.id.btn_profileImage);
        btn_GoBackProfile_fromProfileEdit = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromProfileEdit);

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 1);

        btn_GoBackProfile_fromProfileEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        btn_profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });


    }
}