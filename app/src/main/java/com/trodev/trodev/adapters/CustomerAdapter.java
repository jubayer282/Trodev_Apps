package com.trodev.trodev.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trodev.trodev.models.CustomerData;
import com.trodev.trodev.R;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewAdapter> {

    private List<CustomerData> list;
    private Context context;
    private String category;

    public CustomerAdapter(List<CustomerData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public CustomerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // init layout with adapter
        View view = LayoutInflater.from(context).inflate(R.layout.review_item_layout, parent, false);
        return new CustomerViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewAdapter holder, int position) {

        // link adapter on model dataset
        CustomerData item = list.get(position);

        holder.name.setText("'' "+item.getName()+" ''");
        holder.description.setText("'' "+item.getComments()+" ''");

        try {
            Picasso.get().load(item.getImage()).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomerViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, description;
        private ImageView image;


        public CustomerViewAdapter(@NonNull View itemView) {
            super(itemView);
            // textview init
            name = itemView.findViewById(R.id.customerName);
            description = itemView.findViewById(R.id.customerReview);
            // apps image
            image = itemView.findViewById(R.id.studentImage);

        }
    }
}
