package com.example.jj_club.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.jj_club.R;
import com.example.jj_club.databinding.ActivityMainPageBinding;
import com.example.jj_club.fragments.HomeFragment;
import com.example.jj_club.fragments.MyClubFragment;
import com.example.jj_club.fragments.ProfileFragment;

public class MainPageActivity extends AppCompatActivity {

    private ActivityMainPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.vector_home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.vector_myClub) {
                replaceFragment(new MyClubFragment());
            } else if (itemId == R.id.vector_profile) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
