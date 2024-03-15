package com.example.tripapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profil extends AppCompatActivity {

    TextView TXT_USERNAME, TXT_LOGOUT;
    DatabaseReference ROOT; FirebaseAuth AUTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        AUTH = FirebaseAuth.getInstance();
        TXT_LOGOUT = findViewById(R.id.TXT_LOGOUT);
        TXT_USERNAME = findViewById(R.id.TXT_USERNAME);
        ROOT = FirebaseDatabase.getInstance("https://tripapp-3adda-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        ROOT.child("USERS").child(AUTH.getCurrentUser().getUid()).child("NAME").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TXT_USERNAME.setText(snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profil.this, "Unknown Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });

        TXT_LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AUTH.signOut();
                startActivity(new Intent(getApplicationContext(), signUp.class));
            }
        });
    }
}