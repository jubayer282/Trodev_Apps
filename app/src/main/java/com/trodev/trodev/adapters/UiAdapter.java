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
import com.trodev.trodev.models.GraphicsData;
import com.trodev.trodev.models.UiData;

import java.util.List;

public class UiAdapter extends RecyclerView.Adapter<UiAdapter.UiViewAdapter> {
    private List<UiData> list;
    private Context context;
    private String category;

    public UiAdapter(List<UiData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public UiViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //init layout to show data
        View view = LayoutInflater.from(context).inflate(R.layout.ui_item_layout, parent, false);
        //return views
        return new UiViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UiViewAdapter holder, int position) {
        // set software data into holder position
        UiData item = list.get(position);

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

    public class UiViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, development, types, description, url;
        private ImageView image;
        private Button update;

        public UiViewAdapter(@NonNull View itemView) {
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
