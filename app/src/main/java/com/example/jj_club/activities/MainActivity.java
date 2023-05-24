package com.example.jj_club.activities;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.jj_club.network.RetrofitClient;
import com.example.jj_club.network.LoginInterface;
import com.example.jj_club.models.request.LoginRequest;
import com.example.jj_club.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private LoginInterface loginInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.editText_email_login);
        passwordEditText = findViewById(R.id.editText_password);
        loginButton = findViewById(R.id.button_login);

        loginInterface = RetrofitClient.getClient().create(LoginInterface.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    emailEditText.setHintTextColor(Color.RED);
                    passwordEditText.setHintTextColor(Color.RED);
                    Toast.makeText(MainActivity.this, "이메일과 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    emailEditText.setHintTextColor(Color.RED);
                    Toast.makeText(MainActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    passwordEditText.setHintTextColor(Color.RED);
                    Toast.makeText(MainActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                LoginRequest loginRequest = new LoginRequest(email, password);
                Call<LoginResponse> call = loginInterface.login(loginRequest);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            if (loginResponse != null && loginResponse.getResult().equals("success")) {
                                Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "이메일 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 응답 오류", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "로그인 요청 실패: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        TextView txtRegister = findViewById(R.id.registerTextButton);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EmailVerificationActivity.class);
                startActivity(intent);
            }
        });
    }
}

/* 코드 설명 (읽을 필요 X)
Call<LoginResponse> call = loginInterface.login(email, password);:

loginInterface를 사용하여 서버로 로그인 요청을 전송합니다.
email과 password는 사용자가 입력한 값입니다.


======================================================


public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) { ... }:

서버로부터의 응답이 성공적으로 도착했을 때 호출되는 메서드입니다.
response.isSuccessful()은 서버 응답이 성공 상태 코드인지 확인합니다.
LoginResponse loginResponse = response.body();:

서버로부터 받은 응답 데이터를 LoginResponse 객체로 변환합니다.
response.body()는 서버 응답의 본문을 가져옵니다.

=========================================


call.enqueue(new Callback<LoginResponse>() { ... })는
서버에 비동기 요청을 보내고, 서버의 응답을 처리하는 콜백을 등록하는 역할을 합니다

비동기 요청(Asynchronous request)은 요청과 응답 처리가 동시에 이루어지는 것이 아니라, 요청을 보낸 후 응답을 기다리지 않고 다음 작업을 진행하는 방식을 말합니다. 비동기 요청은 보통 네트워크 요청과 같이 시간이 오래 걸리는 작업을 처리할 때 사용됩니다.

call.enqueue(new Callback<LoginResponse>() { ... })는 비동기 요청을 보내기 위한 메서드입니다. 이 메서드는 Retrofit에서 제공하는 기능으로, 서버에 HTTP 요청을 전송하고 응답을 비동기적으로 받아오기 위해 사용됩니다.

콜백(Callback)은 비동기 작업이 완료되었을 때 호출되는 메서드입니다. 위의 코드에서 new Callback<LoginResponse>() { ... }는 익명 클래스를 생성하여 Callback 인터페이스를 구현한 것입니다. 이 익명 클래스 내부에서는 onResponse와 onFailure라는 콜백 메서드를 오버라이드하고 있습니다.

onResponse: 서버의 응답이 성공적으로 도착했을 때 호출되는 메서드입니다. 이 메서드에서는 서버 응답을 처리하고 원하는 로직을 수행할 수 있습니다.
onFailure: 서버와의 통신이 실패했을 때 호출되는 메서드입니다. 이 메서드에서는 실패에 대한 처리를 수행할 수 있습니다.
따라서 call.enqueue(new Callback<LoginResponse>() { ... })는 비동기 요청을 보내고, 서버의 응답이 도착하면 등록된 콜백 메서드인 onResponse 또는 onFailure를 호출하여 응답 처리를 수행합니다.




call.enqueue(new Callback<LoginResponse>() { ... }:

비동기적으로 로그인 요청을 실행하고 응답을 처리하기 위해 enqueue 메서드를 호출합니다.
Callback<LoginResponse>는 로그인 요청에 대한 비동기적인 응답을 처리하기 위한 콜백 객체를 생성합니다.

==================================

익명클래스란?

여기서 "익명 클래스"는 new Callback<LoginResponse>() { ... } 부분을 의미합니다.
해당 코드는 Callback<LoginResponse> 인터페이스를 구현하는 익명 클래스를 생성하고 있습니다.

익명 클래스는 이름이 없는 클래스로서, 클래스를 정의하면서 동시에 객체를 생성하는 방식입니다.
익명 클래스는 일회성으로 사용되는 간단한 구현을 위해 주로 활용됩니다.

위의 코드에서는 Callback<LoginResponse> 인터페이스를 구현하기 위해 익명 클래스를 사용하고 있습니다.
익명 클래스 내부에서는 onResponse()와 onFailure() 메서드를 오버라이드하여 콜백 메서드를 구현하고 있습니다. 이를 통해 비동기 요청의 응답을 처리하고, 로그인 성공 또는 실패에 따라 적절한 동작을 수행할 수 있습니다.

익명 클래스는 해당 코드 블록에서만 사용되며 재사용되지 않습니다.
주로 한 곳에서만 필요한 간단한 구현을 위해 사용되며, 클래스를 별도로 정의하지 않고도 인터페이스를 구현할 수 있도록 도와줍니다.


*/



