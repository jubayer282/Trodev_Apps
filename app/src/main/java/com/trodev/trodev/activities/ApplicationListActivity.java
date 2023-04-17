package com.trodev.trodev.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.trodev.R;
import com.trodev.trodev.adapters.ApplicationAdapter;
import com.trodev.trodev.models.ApplicationData;

import java.util.ArrayList;
import java.util.List;

public class ApplicationListActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private RecyclerView applicationRv;
    private List<ApplicationData> list1;
    private ApplicationAdapter adapter;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);

        // action bar title
        getSupportActionBar().setTitle("All Application");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait for sometimes.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        // Recycler view finding
        applicationRv = findViewById(R.id.applicationRv);

        reference = FirebaseDatabase.getInstance().getReference().child("Trodev");

        Application();
    }

    // ############################################################################################
    // ############################### Application Department ######################################
    // ############################################################################################
    private void Application() {

        progressDialog.setMessage("Data Fetching");
        progressDialog.show();

        dbRef = reference.child("Application");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    progressDialog.show();
                    applicationRv.setVisibility(View.GONE); // change
                } else {
                    progressDialog.hide();
                    applicationRv.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        ApplicationData data = snapshot.getValue(ApplicationData.class);
                        list1.add(data);

                        Toast.makeText(ApplicationListActivity.this, "All Applications are here...!", Toast.LENGTH_SHORT).show();
                    }

                    progressDialog.hide();
                    applicationRv.setHasFixedSize(true);
                    applicationRv.setLayoutManager(new LinearLayoutManager(ApplicationListActivity.this));
                    adapter = new ApplicationAdapter(list1, ApplicationListActivity.this, "Application");
                    applicationRv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ApplicationListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}