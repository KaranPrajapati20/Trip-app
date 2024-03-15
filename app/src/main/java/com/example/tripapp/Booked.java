package com.example.tripapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Booked extends Fragment {

    ArrayList<Model> list = new ArrayList<>();
    RecyclerView recyclerView;
    DatabaseReference ROOT;
    FirebaseAuth auth; ImageView IMG_EMPTY;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booked, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();
        recyclerView = view.findViewById(R.id.RecycleView);
        IMG_EMPTY = view.findViewById(R.id.IMG_EMPTY);
        IMG_EMPTY.setVisibility(View.GONE);

        ROOT = FirebaseDatabase.getInstance("https://tripapp-3adda-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        ROOT.child("BOOKING").child(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    for(DataSnapshot snap : snapshot.getChildren()) {
                        Model model =snap.getValue(Model.class);
                        list.add(new Model(model.getCOMING_DATE(), model.getMEMBER(), model.getNAME(), model.getMOBILE(), model.getSPINNER(), model.getLIVING_DATE(), model.getMONEY(), model.getEMAIL(), model.getAMOBILE()));
                    }
                    Adapter adapter = new Adapter(getActivity(), list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setAdapter(adapter);

                }
                if(list.size() == 0){
                    IMG_EMPTY.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}