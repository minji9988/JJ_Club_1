package com.example.jj_club.activities.promotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jj_club.R;

public class PromotionWrite2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_write2);

        Button btn_next = findViewById(R.id.button_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionWrite2.this, PromotionWrite4.class);
                startActivity(intent);
            }
        });

    }
}