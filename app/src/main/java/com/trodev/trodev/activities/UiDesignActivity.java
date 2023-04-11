package com.trodev.trodev.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.trodev.R;
import com.trodev.trodev.adapters.UiAdapter;
import com.trodev.trodev.models.UiData;

import java.util.ArrayList;
import java.util.List;

public class UiDesignActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView uiDesign;
    private List<UiData> list1;
    private UiAdapter adapter;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_design);


        // action bar title
        getSupportActionBar().setTitle("User Interface Design");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait for sometimes.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        // Recycler view  init
        uiDesign = findViewById(R.id.uiDesign);
        reference = FirebaseDatabase.getInstance().getReference().child("Trodev"); // databse ta check korte hobe always
        SoftwareDepartment();

    }

    // ############################################################################################
    // ############################### Graphics Department #########################################
    // ############################################################################################
    private void SoftwareDepartment() {

        progressDialog.setMessage("Data Fetching");
        progressDialog.show();

        dbRef = reference.child("UI Design");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    progressDialog.show();
                    uiDesign.setVisibility(View.GONE); // change
                } else {

                   progressDialog.hide();
                    uiDesign.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        UiData data = snapshot.getValue(UiData.class); // eikhane sob student hobe teacher thakle
                        list1.add(data);
                        Toast.makeText(UiDesignActivity.this, "All User Interface Design are here...!", Toast.LENGTH_SHORT).show();
                    }

                    progressDialog.hide();
                    uiDesign.setHasFixedSize(true);
                    uiDesign.setLayoutManager(new LinearLayoutManager(UiDesignActivity.this));
                    adapter = new UiAdapter(list1, UiDesignActivity.this, "UI Design");
                    uiDesign.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.hide();
                Toast.makeText(UiDesignActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}