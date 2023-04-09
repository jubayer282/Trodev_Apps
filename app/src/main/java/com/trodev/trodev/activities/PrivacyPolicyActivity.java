package com.trodev.trodev.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.trodev.R;

public class PrivacyPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        // action bar title
        getSupportActionBar().setTitle("Privacy Policy");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}