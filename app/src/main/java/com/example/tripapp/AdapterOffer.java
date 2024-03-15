package com.example.tripapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterOffer extends RecyclerView.Adapter<AdapterOffer.MyViewHolerOffer> {
    Context context;
    ArrayList<ModelOffer> list;

    public AdapterOffer(Context context, ArrayList<ModelOffer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterOffer.MyViewHolerOffer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_list_view, parent, false);
        return new AdapterOffer.MyViewHolerOffer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOffer.MyViewHolerOffer holder, int position) {
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolerOffer extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolerOffer(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
