package com.example.jj_club.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.jj_club.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyClubFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_club);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);

        // 초기 화면으로 "내모임" 프래그먼트를 표시
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyClubFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.vector_home:
                            // "홈" 선택 시 처리할 내용
                            selectedFragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, selectedFragment)
                                    .commit();
                            break;

                        case R.id.vector_myClub:
                            // "내모임" 선택 시 처리할 내용
                            selectedFragment = new Fragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, selectedFragment)
                                    .commit();
                            break;

                        case R.id.vector_profile:
                            // "프로필" 선택 시 처리할 내용
                            selectedFragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, selectedFragment)
                                    .commit();
                            break;
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                        return true;
                    }

                    return false;
                }
            };
}