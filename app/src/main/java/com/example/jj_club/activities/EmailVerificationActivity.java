package com.example.jj_club.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.jj_club.R;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.EmailVerificationInterface;
import com.example.jj_club.models.request.EmailConfirmationRequest;
import com.example.jj_club.models.response.EmailConfirmationResponse;
import com.example.jj_club.models.response.EmailVerificationErrorResponse;
import com.example.jj_club.models.request.EmailVerificationRequest;
import com.example.jj_club.models.response.EmailVerificationResponse;
import com.google.gson.Gson;

import java.io.IOException;

public class EmailVerificationActivity extends AppCompatActivity {

    // 로그랑 토스트 같이 하도록 하고
    // retrofit 부분 정리해서 올리기
    // main page 제작 ///////////////////////////////////

    private long lastRequestTime;  // 추가
    private static final long TEN_MINUTES_IN_MILLIS = 600000;  // 10분을 밀리세컨드로 환산

    private EditText emailEditText;
    private Button sendVerificationButton;
    private EditText verificationCodeEditText;
    private Button verifyButton;

    private EmailVerificationInterface emailVerificationApi;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        Retrofit retrofit = RetrofitClient.getClient();
        emailVerificationApi = retrofit.create(EmailVerificationInterface.class);

        emailEditText = findViewById(R.id.emailEditText);
        sendVerificationButton = findViewById(R.id.sendVerificationButton);
        verificationCodeEditText = findViewById(R.id.verificationCodeEditText);
        verifyButton = findViewById(R.id.verifyButton);

        sendVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick ( View v ) {
                String email = emailEditText.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    emailEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    emailEditText.setHintTextColor(Color.GRAY);
                    verificationCodeEditText.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.VISIBLE);

                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastRequestTime < TEN_MINUTES_IN_MILLIS) {
                        // 10분이 안 지났으면 이메일 인증 코드를 재전송
                        sendVerificationEmail(email);
                    } else {
                        // 10분이 지났으면 인증 코드를 새로고침
                        refreshVerificationCode(email);  // 이 부분은 아래에 정의
                    }
                    lastRequestTime = currentTime;  // 마지막 요청 시간 갱신
                }
            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick ( View v ) {
                String email = emailEditText.getText().toString().trim();
                String verificationCode = verificationCodeEditText.getText().toString().trim();

                boolean isEmailEmpty = TextUtils.isEmpty(email);
                boolean isVerificationCodeEmpty = TextUtils.isEmpty(verificationCode);

                if (isEmailEmpty && isVerificationCodeEmpty) {
                    emailEditText.setHintTextColor(Color.RED);
                    verificationCodeEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일과 인증 코드를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (isEmailEmpty) {
                    emailEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (isVerificationCodeEmpty) {
                    verificationCodeEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "인증 번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    emailEditText.setHintTextColor(Color.GRAY);
                    verificationCodeEditText.setHintTextColor(Color.GRAY);
                    verifyEmail(email, verificationCode);
                }
            }
        });
    }

    private
    void sendVerificationEmail ( String email ) {
        EmailVerificationRequest request = new EmailVerificationRequest(email);

        Call<EmailVerificationResponse> call = emailVerificationApi.sendVerificationEmail(request);
        call.enqueue(new Callback<EmailVerificationResponse>() {
            @Override
            public
            void onResponse ( Call<EmailVerificationResponse> call, Response<EmailVerificationResponse> response ) {
                if (response.isSuccessful()) {
                    EmailVerificationResponse verificationResponse = response.body();
                    if (verificationResponse != null && "success".equals(verificationResponse.getResult())) {
                        Log.d("EmailVerification", "인증번호를 전송했습니다.");
                    } else {
                        Log.d("EmailVerification", "인증번호 전송에 실패했습니다.");
                    }
                } else {
                    Gson gson = new Gson();
                    EmailVerificationErrorResponse errorResponse = null;
                    try {
                        errorResponse = gson.fromJson(response.errorBody().string(), EmailVerificationErrorResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (errorResponse != null) {
                        Log.e("EmailVerification", "인증번호 전송 실패: " + errorResponse.getMessage());
                    }
                }
            }

            @Override
            public
            void onFailure ( Call<EmailVerificationResponse> call, Throwable t ) {
                String errorMessage = "네트워크 오류로 인증번호 전송에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Log.e("EmailVerification", errorMessage);
            }
        });
    }

    private void refreshVerificationCode(String email) {
        EmailVerificationRequest request = new EmailVerificationRequest(email);

        Call<EmailVerificationResponse> call = emailVerificationApi.refreshVerificationCode(request);
        call.enqueue(new Callback<EmailVerificationResponse>() {
            @Override
            public
            void onResponse ( Call<EmailVerificationResponse> call, Response<EmailVerificationResponse> response ) {
                if (response.isSuccessful()) {
                    EmailVerificationResponse verificationResponse = response.body();
                    if (verificationResponse != null && "success".equals(verificationResponse.getResult())) {
                        Log.d("EmailVerification", "인증번호를 새로 전송했습니다.");
                    } else {
                        Log.d("EmailVerification", "인증번호 새로 전송에 실패했습니다.");
                    }
                } else {
                    Gson gson = new Gson();
                    EmailVerificationErrorResponse errorResponse = null;
                    try {
                        errorResponse = gson.fromJson(response.errorBody().string(), EmailVerificationErrorResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (errorResponse != null) {
                        Log.e("EmailVerification", "인증번호 새로 전송 실패: " + errorResponse.getMessage());
                    }
                }
            }

            @Override
            public
            void onFailure ( Call<EmailVerificationResponse> call, Throwable t ) {
                String errorMessage = "네트워크 오류로 인증번호 새로 전송에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Log.e("EmailVerification", errorMessage);
            }
        });
    }

    private
    void verifyEmail ( String email, String code ) {
        EmailConfirmationRequest request = new EmailConfirmationRequest(email, code);

        Call<EmailConfirmationResponse> call = emailVerificationApi.verifyEmail(request);
        call.enqueue(new Callback<EmailConfirmationResponse>() {
            @Override
            public
            void onResponse ( Call<EmailConfirmationResponse> call, Response<EmailConfirmationResponse> response ) {
                if (response.isSuccessful()) {
                    EmailConfirmationResponse confirmationResponse = response.body();
                    if (confirmationResponse != null && "success".equals(confirmationResponse.getResult())) {
                        Toast.makeText(EmailVerificationActivity.this, "이메일 인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EmailVerificationActivity.this, SignUpActivity.class);
                        startActivity(intent);
                        finish(); // 현재 액티비티 종료
                    } else {
                        Toast.makeText(EmailVerificationActivity.this, "이메일 인증에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Gson gson = new Gson();
                    EmailVerificationErrorResponse errorResponse = null;
                    try {
                        errorResponse = gson.fromJson(response.errorBody().string(), EmailVerificationErrorResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (errorResponse != null) {
                        Toast.makeText(EmailVerificationActivity.this, errorResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public
            void onFailure ( Call<EmailConfirmationResponse> call, Throwable t ) {
                String errorMessage = "네트워크 오류로 이메일 인증에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Toast.makeText(EmailVerificationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
