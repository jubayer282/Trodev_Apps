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
import com.trodev.trodev.R;
import com.trodev.trodev.models.SoftwareData;

import java.util.List;

public class SoftwareAdapter extends RecyclerView.Adapter<SoftwareAdapter.SoftwareViewAdapter> {
    private List<SoftwareData> list;
    private Context context;
    private String category;

    public SoftwareAdapter(List<SoftwareData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public SoftwareViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //init layout to show data
        View view = LayoutInflater.from(context).inflate(R.layout.software_item_layout, parent, false);
        //return views
        return new SoftwareViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoftwareViewAdapter holder, int position) {
        // set software data into holder position
        SoftwareData item = list.get(position);

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

    public class SoftwareViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, development, types, description, url;
        private ImageView image;
        private Button update;


        public SoftwareViewAdapter(@NonNull View itemView) {
            super(itemView);
            //init all software xml layout views
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
