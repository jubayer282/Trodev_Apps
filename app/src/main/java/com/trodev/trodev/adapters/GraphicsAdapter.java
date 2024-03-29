package com.trodev.trodev.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;
import com.trodev.trodev.models.GraphicsData;
import com.trodev.trodev.R;

import java.util.List;

public class GraphicsAdapter extends RecyclerView.Adapter<GraphicsAdapter.GraphicsViewAdapter> {
    private List<GraphicsData> list;
    private Context context;
    private String category;

    public GraphicsAdapter(List<GraphicsData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public GraphicsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //init layout to show data
        View view = LayoutInflater.from(context).inflate(R.layout.graphics_item_layout, parent, false);
        //return views
        return new GraphicsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphicsViewAdapter holder, int position) {
        // set software data into holder position
        GraphicsData item = list.get(position);

        holder.name.setText(item.getName());
        holder.development.setText(item.getDevelopment());
        holder.types.setText(item.getType());
        holder.description.setText(item.getDescription());
    //    holder.url.setText(item.getUrl());


        holder.graphicsBtn.setOnClickListener(new View.OnClickListener() {
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

    public class GraphicsViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, development, types, description, url;
        private ImageView image;
        private MaterialCardView graphicsBtn;

        public GraphicsViewAdapter(@NonNull View itemView) {
            super(itemView);

            //init all software xml layout views
            name = itemView.findViewById(R.id.nameTv);
            development = itemView.findViewById(R.id.developmentTv);
            types = itemView.findViewById(R.id.typesTv);
            description = itemView.findViewById(R.id.descriptionTv);

            // apps image
            image = itemView.findViewById(R.id.studentImage);

            //init material card view
            graphicsBtn = itemView.findViewById(R.id.graphicsBtn);
        }
    }
}
