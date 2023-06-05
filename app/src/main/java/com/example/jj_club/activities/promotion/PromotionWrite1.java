package com.example.jj_club.activities.promotion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.R;

import java.util.Calendar;

public class PromotionWrite1 extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextName;
    private EditText editTextInterview;
    private EditText editTextFee;

    private int selectedYear;
    private int selectedMonth;
    private int selectedDayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_write1);

        Button btnNext = findViewById(R.id.button_next);
        Button btnCalendar = findViewById(R.id.button_calendar);

        editTextTitle = findViewById(R.id.pwtitle);
        editTextName = findViewById(R.id.pwname);
        editTextInterview = findViewById(R.id.pwinterview);
        editTextFee = findViewById(R.id.pwfee);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromotionWrite1.this, PromotionWrite2.class);
                intent.putExtra("title", editTextTitle.getText().toString());
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("interview", editTextInterview.getText().toString());
                intent.putExtra("fee", editTextFee.getText().toString());
                startActivity(intent);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                PromotionWrite1.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 선택된 날짜 처리
                        selectedYear = year;
                        selectedMonth = month;
                        selectedDayOfMonth = dayOfMonth;

                        // 선택된 날짜를 EditText에 설정
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        editTextTitle.setText(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );

        datePickerDialog.show();
    }
}
