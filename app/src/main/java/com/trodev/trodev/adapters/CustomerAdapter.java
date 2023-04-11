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

    // eikhnae amra list declear korbo kon seikhaner list er Data ta check korte hobe
    private List<CustomerData> list;
    private Context context;
    private String category;


    // StudentData eikhane dekhte hobe change ache kina eikhane na thakle change kore nite hobe
    public CustomerAdapter(List<CustomerData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public CustomerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.review_item_layout, parent, false);

        return new CustomerViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewAdapter holder, int position) {

        // eikhane amra teacher er ja ja database theke nibo eikhane sob dekhaite hobe amader.
        CustomerData item = list.get(position);

        holder.name.setText("'' "+item.getName()+" ''");
        holder.description.setText("'' "+item.getComments()+" ''");

        try {
            Picasso.get().load(item.getImage()).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }

/*        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateStudentActivity.class);
                intent.putExtra("name",item.getName());
                intent.putExtra("roll",item.getRoll());
                intent.putExtra("result",item.getResult());
                intent.putExtra("image",item.getImage());
                intent.putExtra("key",item.getKey());
                intent.putExtra("category",category);

                context.startActivity(intent);
            }
        });*/
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

            name = itemView.findViewById(R.id.customerName);

            description = itemView.findViewById(R.id.customerReview);

            // apps image
            image = itemView.findViewById(R.id.studentImage);

        }
    }
}
