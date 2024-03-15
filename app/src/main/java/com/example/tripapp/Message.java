package com.example.tripapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Message extends Fragment {

    RecyclerView recyclerViewOffer;
    ImageView imageView;
    ArrayList<ModelOffer> list1 = new ArrayList<>();
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imageView);
        recyclerViewOffer = view.findViewById(R.id.RecycleViewOffer);
        databaseReference = FirebaseDatabase.getInstance("https://tripapp-3adda-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        databaseReference.child("offer").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for(DataSnapshot snap : snapshot.getChildren()) {
                        list1.add(new ModelOffer(snap.getValue().toString()));
                    }

                    AdapterOffer adapter = new AdapterOffer(getActivity(), list1);
                    recyclerViewOffer.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerViewOffer.setAdapter(adapter);
                }else{
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}