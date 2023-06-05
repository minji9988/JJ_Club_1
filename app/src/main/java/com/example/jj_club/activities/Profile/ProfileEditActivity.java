package com.example.jj_club.activities.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

import com.example.jj_club.activities.mainpage.HomePopularPostsActivity;
import com.example.jj_club.fragments.ProfileFragment;
import com.example.jj_club.R;
import com.example.jj_club.models.request.ProfileEditRequest;
import com.example.jj_club.models.response.ProfileEditResponse;
import com.example.jj_club.network.interface_folder.ProfileEditInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jj_club.R;
import com.example.jj_club.activities.mainpage.MainPageActivity;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.LoginInterface;
import com.example.jj_club.models.request.LoginRequest;
import com.example.jj_club.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ProfileEditActivity extends AppCompatActivity {

    private ImageButton btn_GoBackProfile_fromProfileEdit;
    private ImageButton btn_profileImage;
    private EditText btn_editTextNickname;
    private EditText btn_editTextMbti;
    private EditText btn_editTextPassword;
    private Button btn_save;
    private ProfileEditInterface profileEditInterface;
    private String accessToken;


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

        btn_editTextNickname = findViewById(R.id.btn_editTextNickname);
        btn_editTextMbti = findViewById(R.id.btn_editTextMbti);
        btn_editTextPassword = findViewById(R.id.btn_editTextPassword);
        btn_save = findViewById(R.id.btn_save);
        btn_profileImage = (ImageButton) findViewById(R.id.btn_profileImage);
        btn_GoBackProfile_fromProfileEdit = (ImageButton) findViewById(R.id.btn_GoBackProfile_fromProfileEdit);




        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 1);

        // Get accessToken from intent or shared preferenc
        accessToken = getIntent().getStringExtra("accessToken");

        // Create ProfileService instance
        //밑에 retrofit오류뜸
        // profileEditInterface = retrofit.create(profileEditInterface.class);
        profileEditInterface = RetrofitClient.getClient().create(profileEditInterface.getClass());
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = btn_editTextNickname.getText().toString();
                String mbti = btn_editTextMbti.getText().toString();
                String password = btn_editTextPassword.getText().toString();

                // Create ProfileUpdateRequest object with user input
                ProfileEditRequest request = new ProfileEditRequest(nickname, mbti, password);

                ProfileEditInterface editProfile = RetrofitClient.getClient().create(ProfileEditInterface.class);
                // Send profile update request to the server

                Call<ProfileEditResponse> call = editProfile.editProfile(request);
                //profileEditInterface = RetrofitClient.getClient().create(ProfileEditInterface.class);

                call.enqueue(new Callback<ProfileEditResponse>() {
                    @Override
                    public void onResponse(Call<ProfileEditResponse> call, Response<ProfileEditResponse> response) {
                        if (response.isSuccessful()) {
                            // Profile update successful
                            ProfileEditResponse updateResponse = response.body();
                            // Handle the response as needed


                        } else {
                            Toast.makeText(ProfileEditActivity.this, "Failed to fetch posts", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileEditResponse> call, Throwable t) {
                        // Profile update request failed
                        // Handle the failure case
                    }
                });
            }
        });

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