package com.trodev.trodev.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;
import com.trodev.trodev.models.ApplicationData;
import com.trodev.trodev.R;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewAdapter> {
    private List<ApplicationData> list;
    private Context context;
    private String category;

    public ApplicationAdapter(List<ApplicationData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public ApplicationViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.application_item_layout, parent, false);

        return new ApplicationViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewAdapter holder, int position) {

        ApplicationData item = list.get(position);

        holder.name.setText(item.getName());
        holder.development.setText(item.getDevelopment());
        holder.types.setText(item.getType());
        holder.description.setText(item.getDescription());
       // holder.url.setText(item.getUrl());

        holder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // button click and go to play store
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(item.getUrl())));
                context.startActivity(webIntent);
            }
        });


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

    public class ApplicationViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, development, types, description;
        private ImageView image;
        private MaterialCardView playBtn;


        public ApplicationViewAdapter(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTv);
            development = itemView.findViewById(R.id.developmentTv);
            types = itemView.findViewById(R.id.typesTv);
            description = itemView.findViewById(R.id.descriptionTv);

            // apps image
            image = itemView.findViewById(R.id.appsIv);

            //material card view init
            playBtn = itemView.findViewById(R.id.playBtn);
        }
    }
}
