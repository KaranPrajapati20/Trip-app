package com.example.tripapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signUp extends AppCompatActivity {
    TextView changelogin, changeforgotnext;
    ConstraintLayout PROGRESS;

    private EditText msigupemail, msignuppassword, mfullname;
    private ConstraintLayout msignup;
    private FirebaseAuth firebaseAuth;

    DatabaseReference ROOT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        firebaseAuth = FirebaseAuth.getInstance();
        changelogin = findViewById(R.id.changelogin);
        msigupemail = findViewById(R.id.signupemail);
        mfullname = findViewById(R.id.fullname);
        msignuppassword = findViewById(R.id.signuppassword);
        msignup = findViewById(R.id.signup);
        PROGRESS = findViewById(R.id.PROGRESS);

        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        ROOT = FirebaseDatabase.getInstance("https://tripapp-3adda-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        changelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  mail = msigupemail.getText().toString().trim();
                String  password = msignuppassword.getText().toString().trim();
                String name = mfullname.getText().toString().trim();

                if(mail.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() < 7){
                    Toast.makeText(getApplicationContext(), "Password should greater than 7 digits", Toast.LENGTH_SHORT).show();
                }
                else{
                    PROGRESS.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            task.addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.e("MOHSINALI", e.toString());
                                }
                            });

                            if(task.isSuccessful()){
                                HashMap<Object, Object> MAP = new HashMap<>();
                                MAP.put("EMAIL", mail);
                                MAP.put("PASSWORD", password);
                                MAP.put("NAME", name);
                                MAP.put("UID", firebaseAuth.getCurrentUser().getUid());

                                ROOT.child("USERS").child(firebaseAuth.getCurrentUser().getUid()).setValue(MAP).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getApplicationContext(), "Register successfull", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        finish();
                                    }
                                });
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Failed to register", Toast.LENGTH_SHORT).show();
                                PROGRESS.setVisibility(View.GONE);
                                finish();
                            }
                        }
                    });
                }
            }
        });

    }

    /*private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(Signup.this, "Verification Email is Send, and login again", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(), NoteActivity.class));
                }
            });
        }
        else{
            Toast.makeText(this, "Failed to send Verification", Toast.LENGTH_SHORT).show();
        }
    }*/
}