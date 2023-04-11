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
import com.trodev.trodev.models.SoftwareData;
import com.trodev.trodev.adapters.SoftwareAdapter;

import java.util.ArrayList;
import java.util.List;

public class SoftwareListActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView software;
    private List<SoftwareData> list1;
    private SoftwareAdapter adapter;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_list);

        // action bar title
        getSupportActionBar().setTitle("All Software");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // progress Dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait for sometimes.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);


        // Recycler view  init
        software = findViewById(R.id.software);
        reference = FirebaseDatabase.getInstance().getReference().child("Trodev"); // databse ta check korte hobe always
        SoftwareDepartment();

    }

    // ############################################################################################
    // ############################### Software Department #########################################
    // ############################################################################################
    private void SoftwareDepartment() {

        progressDialog.setMessage("Data Fetching");
        progressDialog.show();

        dbRef = reference.child("Software");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    progressDialog.show();
                    software.setVisibility(View.GONE); // change
                } else {

                    progressDialog.hide();
                    software.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        SoftwareData data = snapshot.getValue(SoftwareData.class); // eikhane sob student hobe teacher thakle
                        list1.add(data);

                        Toast.makeText(SoftwareListActivity.this, "All Software's are here...!", Toast.LENGTH_SHORT).show();
                    }
                    progressDialog.hide();
                    software.setHasFixedSize(true);
                    software.setLayoutManager(new LinearLayoutManager(SoftwareListActivity.this));
                    adapter = new SoftwareAdapter(list1, SoftwareListActivity.this, "Software");
                    software.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SoftwareListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}