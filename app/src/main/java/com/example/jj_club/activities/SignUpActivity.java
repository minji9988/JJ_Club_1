package com.example.jj_club.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.R;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.SignUpInterface;
import com.example.jj_club.models.request.SignUpRequest;
import com.example.jj_club.models.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private Button signUpButton;

    private SignUpInterface signUpApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Retrofit 인스턴스 가져오기
        Retrofit retrofit = RetrofitClient.getClient();

        // API 인스턴스 생성
        signUpApi = retrofit.create(SignUpInterface.class);

        emailEditText = findViewById(R.id.emailEditText);
        nameEditText = findViewById(R.id.nameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String nickName = nameEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();

                boolean hasError = false;

                if (nickName.isEmpty()) { // 닉네임을 입력하지 않았을 때
                    nameEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (phoneNumber.isEmpty()) {
                    phoneNumberEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (password.isEmpty()) {
                    passwordEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (email.isEmpty()) {
                    emailEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (hasError) {
                    // 입력되지 않은 항목이 있을 경우 Toast 메시지 표시
                    Toast.makeText(SignUpActivity.this, "입력을 해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                signUp(email, nickName, phoneNumber, password);
            }
        });
    }


    private void signUp(String email, String nickName, String phoneNumber, String password) { // 회원가입 정보를 서버로 전송하고, 서버의 응답에 따라 적절한 Toast 메시지를 표시
        SignUpRequest signUpRequest = new SignUpRequest(email, password, nickName, phoneNumber);

        Call<SignUpResponse> call = signUpApi.signUp(signUpRequest);
        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.isSuccessful()) {
                    // 회원가입 성공 시 Toast 메시지 표시 및 MainActivity로 이동
                    Toast.makeText(SignUpActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                } else {
                    // 회원가입 실패 시 Toast 메시지 표시
                    Toast.makeText(SignUpActivity.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                // 네트워크 오류 시 Toast 메시지 표시
                Toast.makeText(SignUpActivity.this, "네트워크 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
