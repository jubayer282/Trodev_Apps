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
import com.trodev.trodev.adapters.GraphicsAdapter;
import com.trodev.trodev.models.GraphicsData;

import java.util.ArrayList;
import java.util.List;

public class GraphicsDesignActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private RecyclerView graphics;
    private List<GraphicsData> list1;
    private GraphicsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_design);


        // action bar title
        getSupportActionBar().setTitle("Graphics Design");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // progress Dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait for sometimes.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        // Recycler view  init
        graphics = findViewById(R.id.graphics);
        reference = FirebaseDatabase.getInstance().getReference().child("Trodev"); // databse ta check korte hobe always
        SoftwareDepartment();

    }

    // ############################################################################################
    // ############################### Graphics Department #########################################
    // ############################################################################################
    private void SoftwareDepartment() {

        progressDialog.setMessage("Data Fetching");
        progressDialog.show();

        dbRef = reference.child("Graphics Design");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {

                    progressDialog.show();
                    graphics.setVisibility(View.GONE); // change
                } else {
                    progressDialog.hide();
                    graphics.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        GraphicsData data = snapshot.getValue(GraphicsData.class); // eikhane sob student hobe teacher thakle
                        list1.add(data);
                        Toast.makeText(GraphicsDesignActivity.this, "All Graphics Design's are here...!", Toast.LENGTH_SHORT).show();
                    }
                    graphics.setHasFixedSize(true);
                    graphics.setLayoutManager(new LinearLayoutManager(GraphicsDesignActivity.this));
                    adapter = new GraphicsAdapter(list1, GraphicsDesignActivity.this, "Graphics Design");
                    graphics.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GraphicsDesignActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}