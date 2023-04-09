package com.trodev.trodev.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trodev.trodev.models.ApplicationData;
import com.trodev.trodev.R;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.StudentViewAdapter> {

    // eikhnae amra list declear korbo kon seikhaner list er Data ta check korte hobe
    private List<ApplicationData> list;
    private Context context;
    private String category;


    // ApplicationData eikhane dekhte hobe change ache kina eikhane na thakle change kore nite hobe
    public ApplicationAdapter(List<ApplicationData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public StudentViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.application_item_layout, parent, false);

        return new StudentViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewAdapter holder, int position) {

        // eikhane amra teacher er ja ja database theke nibo eikhane sob dekhaite hobe amader.

        ApplicationData item = list.get(position);

        holder.name.setText(item.getName());
        holder.development.setText(item.getDevelopment());
        holder.types.setText(item.getType());
        holder.description.setText(item.getDescription());
        holder.url.setText(item.getUrl());


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

    public class StudentViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, development, types, description, url;
        private ImageView image;
        private Button update;


        public StudentViewAdapter(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTv);
            development = itemView.findViewById(R.id.developmentTv);
            types = itemView.findViewById(R.id.typesTv);
            description = itemView.findViewById(R.id.descriptionTv);
            url = itemView.findViewById(R.id.urlTv);

            // apps image
            image = itemView.findViewById(R.id.studentImage);
        }
    }
}
