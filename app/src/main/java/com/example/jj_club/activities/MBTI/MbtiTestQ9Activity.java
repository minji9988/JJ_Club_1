package com.example.jj_club.activities.MBTI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.R;

public class MbtiTestQ9Activity extends AppCompatActivity {

    private Button btnLogin1;
    private Button btnLogin2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_test_q9);

        btnLogin1 = findViewById(R.id.button_login);
        btnLogin2 = findViewById(R.id.button);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼1이 클릭되었을 때 mbti_test_q2.xml 페이지로 이동
                Intent intent = new Intent(MbtiTestQ9Activity.this, MbtiTestQ10Activity.class);
                startActivity(intent);
            }
        });

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼2가 클릭되었을 때 mbti_test_q2.xml 페이지로 이동
                Intent intent = new Intent(MbtiTestQ9Activity.this, MbtiTestQ10Activity.class);
                startActivity(intent);
            }
        });
    }
}