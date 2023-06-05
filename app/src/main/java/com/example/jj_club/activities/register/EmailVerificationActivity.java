package com.example.jj_club.activities.register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.R;
import com.example.jj_club.models.request.EmailConfirmationRequest;
import com.example.jj_club.models.request.EmailVerificationRequest;
import com.example.jj_club.models.response.EmailConfirmationResponse;
import com.example.jj_club.models.response.EmailVerificationErrorResponse;
import com.example.jj_club.models.response.EmailVerificationResponse;
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.interface_folder.EmailVerificationInterface;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EmailVerificationActivity extends AppCompatActivity {

    // 마지막 요청 시간을 저장하는 변수
    private long lastRequestTime;

    // 10분을 밀리세컨드로 환산한 값
    private static final long TEN_MINUTES_IN_MILLIS = 600000;

    // 이메일 입력을 위한 EditText
    private EditText emailEditText;

    // 인증 메일 전송 버튼
    private Button sendVerificationButton;

    // 인증 코드 입력을 위한 EditText
    private EditText verificationCodeEditText;

    // 인증 버튼
    private Button verifyButton;

    // 이메일 인증 API interface
    private EmailVerificationInterface emailVerificationApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        // Retrofit 객체를 가져와서 EmailVerificationInterface 생성
        Retrofit retrofit = RetrofitClient.getClient();
        emailVerificationApi = retrofit.create(EmailVerificationInterface.class);

        // UI 컴포넌트 초기화
        emailEditText = findViewById(R.id.emailEditText);
        sendVerificationButton = findViewById(R.id.sendVerificationButton);
        verificationCodeEditText = findViewById(R.id.verificationCodeEditText);
        verifyButton = findViewById(R.id.verifyButton);

        // 인증 메일 전송 버튼의 클릭 리스너 설정
        sendVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();

                // 이메일이 비어있는지 확인
                if (TextUtils.isEmpty(email)) {
                    emailEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    emailEditText.setHintTextColor(Color.GRAY);
                    verificationCodeEditText.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.VISIBLE);

                    // 현재 시간을 밀리세컨드 단위로 얻음
                    long currentTime = System.currentTimeMillis();

                    // 마지막 요청 이후 10분이 지나지 않았으면 인증 메일을 재전송하고, 그렇지 않으면 새 인증 코드를 요청함
                    if (currentTime - lastRequestTime < TEN_MINUTES_IN_MILLIS) {
                        sendVerificationEmail(email);
                    } else {
                        refreshVerificationCode(email);
                    }

                    // 마지막 요청 시간을 현재 시간으로 업데이트
                    lastRequestTime = currentTime;
                }
            }
        });

        // 인증 버튼의 클릭 리스너 설정
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String verificationCode = verificationCodeEditText.getText().toString().trim();

                boolean isEmailEmpty = TextUtils.isEmpty(email);
                boolean isVerificationCodeEmpty = TextUtils.isEmpty(verificationCode);

                // 이메일과 인증 코드의 입력 상태를 검사하고, 둘 다 비어있지 않으면 이메일을 검증함
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

    // 이메일 인증 코드 발송 메서드
    private void sendVerificationEmail(String email) {
        // 이메일을 사용하여 인증 요청 객체 생성
        EmailVerificationRequest request = new EmailVerificationRequest(email);

        // API 요청 호출 및 응답 처리
        Call<EmailVerificationResponse> call = emailVerificationApi.sendVerificationEmail(request);
        call.enqueue(new Callback<EmailVerificationResponse>() {
            // 응답 성공시 처리
            @Override
            public void onResponse(Call<EmailVerificationResponse> call, Response<EmailVerificationResponse> response) {
                if (response.isSuccessful()) {
                    EmailVerificationResponse verificationResponse = response.body();
                    if (verificationResponse != null && "success".equals(verificationResponse.getResult())) {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호를 전송했습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호 전송에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 응답 실패시 에러 메시지 파싱
                    Gson gson = new Gson();
                    EmailVerificationErrorResponse errorResponse = null;
                    try {
                        errorResponse = gson.fromJson(response.errorBody().string(), EmailVerificationErrorResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (errorResponse != null) {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호 전송 실패: " + errorResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            // 응답 실패시 (네트워크 에러 등) 처리
            @Override
            public void onFailure(Call<EmailVerificationResponse> call, Throwable t) {
                String errorMessage = "네트워크 오류로 인증번호 전송에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Toast.makeText(EmailVerificationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 인증 코드 새로고침 메서드
    private void refreshVerificationCode(String email) {
        // 이메일을 사용하여 인증 코드 새로고침 요청 객체 생성
        EmailVerificationRequest request = new EmailVerificationRequest(email);

        // API 요청 호출 및 응답 처리
        Call<EmailVerificationResponse> call = emailVerificationApi.refreshVerificationCode(request);
        call.enqueue(new Callback<EmailVerificationResponse>() {
            // 응답 성공시 처리
            @Override
            public void onResponse(Call<EmailVerificationResponse> call, Response<EmailVerificationResponse> response) {
                if (response.isSuccessful()) {
                    EmailVerificationResponse verificationResponse = response.body();
                    if (verificationResponse != null && "success".equals(verificationResponse.getResult())) {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호를 새로 전송했습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호 새로 전송에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 응답 실패시 에러 메시지 파싱
                    Gson gson = new Gson();
                    EmailVerificationErrorResponse errorResponse = null;
                    try {
                        errorResponse = gson.fromJson(response.errorBody().string(), EmailVerificationErrorResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (errorResponse != null) {
                        Toast.makeText(EmailVerificationActivity.this, "인증번호 새로 전송 실패: " + errorResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            // 응답 실패시 (네트워크 에러 등) 처리
            @Override
            public void onFailure(Call<EmailVerificationResponse> call, Throwable t) {
                String errorMessage = "네트워크 오류로 인증번호 새로 전송에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Toast.makeText(EmailVerificationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 이메일 인증 메서드
    private void verifyEmail(String email, String code) {
        // 이메일 및 인증 코드를 사용하여 이메일 확인 요청 객체 생성
        EmailConfirmationRequest request = new EmailConfirmationRequest(email, code);

        // API 요청 호출 및 응답 처리
        Call<EmailConfirmationResponse> call = emailVerificationApi.verifyEmail(request);
        call.enqueue(new Callback<EmailConfirmationResponse>() {
            // 응답 성공시 처리
            @Override
            public void onResponse(Call<EmailConfirmationResponse> call, Response<EmailConfirmationResponse> response) {
                if (response.isSuccessful()) {
                    EmailConfirmationResponse confirmationResponse = response.body();
                    if (confirmationResponse != null && "success".equals(confirmationResponse.getResult())) {
                        Toast.makeText(EmailVerificationActivity.this, "이메일 인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        // 이메일 인증 성공 후, 회원가입 액티비티로 이동
                        Intent intent = new Intent(EmailVerificationActivity.this, SignUpActivity.class);
                        startActivity(intent);
                        finish(); // 현재 액티비티 종료
                    } else {
                        Toast.makeText(EmailVerificationActivity.this, "이메일 인증에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 응답 실패시 에러 메시지 파싱
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

            // 응답 실패시 (네트워크 에러 등) 처리
            @Override
            public void onFailure(Call<EmailConfirmationResponse> call, Throwable t) {
                String errorMessage = "네트워크 오류로 인증에 실패했습니다.";
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }
                Toast.makeText(EmailVerificationActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
