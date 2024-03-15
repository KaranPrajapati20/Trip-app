package com.example.tripapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<Model> arrayList;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_list_view, parent, false);
        return new Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.COMING_DATE.setText(arrayList.get(position).getCOMING_DATE());
        holder.MEMBER.setText(arrayList.get(position).getMEMBER());
        holder.NAME.setText(arrayList.get(position).getNAME());
        holder.MOBILE.setText(arrayList.get(position).getMOBILE());
        holder.SPINNER.setText(arrayList.get(position).getSPINNER());
        holder.LIVING_DATE.setText(arrayList.get(position).getLIVING_DATE());
        holder.EMAIL.setText(arrayList.get(position).getEMAIL());
        holder.AMOBILE.setText(arrayList.get(position).getAMOBILE());
        holder.MONEY.setText(arrayList.get(position).getMONEY());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView COMING_DATE;
        TextView MEMBER;
        TextView NAME;
        TextView MOBILE;
        TextView SPINNER;
        TextView LIVING_DATE;
        TextView MONEY;
        TextView EMAIL;
        TextView AMOBILE;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            COMING_DATE = itemView.findViewById(R.id.COMING_DATE);
            MEMBER = itemView.findViewById(R.id.MEMBER);
            NAME = itemView.findViewById(R.id.NAME);
            MOBILE = itemView.findViewById(R.id.MOBILE);
            SPINNER = itemView.findViewById(R.id.SPINNER);
            LIVING_DATE = itemView.findViewById(R.id.LIVING_DATE);
            MONEY = itemView.findViewById(R.id.MONEY);
            EMAIL = itemView.findViewById(R.id.EMAIL);
            AMOBILE = itemView.findViewById(R.id.AMOBILE);
        }
    }
}
