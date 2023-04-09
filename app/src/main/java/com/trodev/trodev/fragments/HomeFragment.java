package com.trodev.trodev.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.trodev.trodev.activities.ApplicationListActivity;
import com.trodev.trodev.R;

public class HomeFragment extends Fragment {

    private MaterialCardView appsBtn;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        appsBtn = view.findViewById(R.id.appsBtn);
        appsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ApplicationListActivity.class));
            }
        });

        return view;
    }
}