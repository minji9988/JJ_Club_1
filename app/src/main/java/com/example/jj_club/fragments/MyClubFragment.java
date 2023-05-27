package com.example.jj_club.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.jj_club.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyClubFragment extends Fragment {

    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public
                boolean onNavigationItemSelected ( @NonNull MenuItem item ) {
                    Fragment selectedFragment = null;

                    int itemId = item.getItemId();
                    if (itemId == R.id.vector_home) {
                        selectedFragment = new HomeFragment();
                    } else if (itemId == R.id.vector_myClub) {
                        selectedFragment = new MyClubFragment();
                    } else if (itemId == R.id.vector_profile) {
                        selectedFragment = new ProfileFragment();
                    }

                    if (selectedFragment != null) {
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.replace(R.id.fragment_container, selectedFragment);
                        fragmentTransaction.commit();
                        return true;
                    }

                    return false;
                }
            };
}