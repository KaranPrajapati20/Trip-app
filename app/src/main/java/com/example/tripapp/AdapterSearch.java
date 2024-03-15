package com.example.tripapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.MyViewHolderSearch> {

    Context context;
    ArrayList<ModelSearch> list;

    public AdapterSearch(Context context, ArrayList<ModelSearch> list) {
        this.context = context;
        this.list = list;
    }

    public void setFilterList(ArrayList<ModelSearch> filterList) {
        this.list = filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterSearch.MyViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_list_view, parent, false);
        return new AdapterSearch.MyViewHolderSearch(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearch.MyViewHolderSearch holder, int position) {
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
        holder.title.setText(list.get(position).getTitle());
        holder.subtitle.setText(list.get(position).getSutitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolderSearch extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView subtitle;
        public MyViewHolderSearch(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }
    }
}
