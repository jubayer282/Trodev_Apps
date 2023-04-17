package com.trodev.trodev.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.trodev.trodev.adapters.CustomerAdapter;
import com.trodev.trodev.models.CustomerData;

import java.util.ArrayList;
import java.util.List;

public class CustomerReviewActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private RecyclerView customerRv;
    private List<CustomerData> list1;
    private CustomerAdapter adapter;
    private DatabaseReference reference, dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_review);

        // action bar title
        getSupportActionBar().setTitle("Client's");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait for sometimes.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        // Recycler view finding
        customerRv = findViewById(R.id.customerRv);
        reference = FirebaseDatabase.getInstance().getReference().child("Review"); // database check always
        customerReview();
    }
    // ############################################################################################
    // ############################### Review Department #########################################
    // ############################################################################################
    private void customerReview() {

        progressDialog.setMessage("Data Fetching");
        progressDialog.show();

        dbRef = reference.child("Customer Review");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    progressDialog.show();
                    customerRv.setVisibility(View.GONE); // change
                }
                else
                {
                    progressDialog.hide();
                    customerRv.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CustomerData data = snapshot.getValue(CustomerData.class); // eikhane sob student hobe teacher thakle
                        list1.add(data);
                    }
                    customerRv.setHasFixedSize(true);
                    customerRv.setLayoutManager(new LinearLayoutManager(CustomerReviewActivity.this));
                    adapter = new CustomerAdapter(list1,CustomerReviewActivity.this,"Customer Review");
                    customerRv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.hide();
                Toast.makeText(CustomerReviewActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}