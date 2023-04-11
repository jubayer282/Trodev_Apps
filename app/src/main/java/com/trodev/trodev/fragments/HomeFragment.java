package com.trodev.trodev.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.trodev.trodev.activities.GraphicsDesignActivity;
import com.trodev.trodev.activities.SoftwareListActivity;
import com.trodev.trodev.activities.UiDesignActivity;
import com.trodev.trodev.activities.ApplicationListActivity;
import com.trodev.trodev.R;

public class HomeFragment extends Fragment {

    private MaterialCardView appsBtn, softwareBtn, graphicsBtn, uiBtn;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        appsBtn = view.findViewById(R.id.appsBtn);
        softwareBtn = view.findViewById(R.id.softwareBtn);
        graphicsBtn = view.findViewById(R.id.graphicsBtn);
        uiBtn = view.findViewById(R.id.uiBtn);

        appsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ApplicationListActivity.class));
            }
        });

        softwareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SoftwareListActivity.class));
            }
        });

        graphicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GraphicsDesignActivity.class));
            }
        });

        uiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UiDesignActivity.class));
            }
        });

        return view;
    }
}