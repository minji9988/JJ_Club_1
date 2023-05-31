package com.example.jj_club.activities.promotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.R;
import com.example.jj_club.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PromotionWrite1 extends AppCompatActivity {

    private Button calendarButton;
    private ActivityResultLauncher<Intent> calendarLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_write1);

        Button btn_next = findViewById(R.id.button_next);
        calendarButton = findViewById(R.id.button_calendar);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionWrite1.this, PromotionWrite2.class);
                startActivity(intent);
            }
        });

        calendarLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Get the selected date from the calendar
                            Intent data = result.getData();
                            if (data != null) {
                                String selectedDate = data.getStringExtra("date");

                                // Send the selected date to the server using Retrofit
                                sendDateToServer(selectedDate);
                            }
                        }
                    }
                });
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //캘린더 열기 위한 인텐트
                Intent calendarIntent = new Intent(Intent.ACTION_VIEW);
                calendarIntent.setType("vnd.android.cursor.item/event");

                // 캘린더 열기 위해 액티비티 시작
                calendarLauncher.launch(calendarIntent);
            }
        });
    }

    private void sendDateToServer(String selectedDate) {
        // 레트로핏 인스턴스
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://Cap.jjclub.pe.kr:80/") // 서버 주소
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // API 서비스 인터페이스
        ApiService apiService = retrofit.create(ApiService.class);

        // 서버에 날짜 전송 요청
        Call<Void> call = apiService.sendDate(selectedDate);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Date sent successfully
                    // TODO: Handle the response from the server
                } else {
                    // Failed to send the date
                    // TODO: Handle the error response
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Failed to make the network request
                // TODO: Handle the network failure
            }
        });
    }
}
