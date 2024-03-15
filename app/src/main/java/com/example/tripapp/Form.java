package com.example.tripapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner; CardView BTN_CON;
    EditText selectedDateTV, selectedDateTV2;
    EditText member, name, mobile, money, email, amobile;
    DatabaseReference ROOT; FirebaseAuth AUTH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        AUTH = FirebaseAuth.getInstance();
        BTN_CON = findViewById(R.id.BTN_CON);
        spinner = findViewById(R.id.spinner);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        selectedDateTV2 = findViewById(R.id.selectedDateTV2);

        member = findViewById(R.id.member);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        amobile = findViewById(R.id.amobile);
        money = findViewById(R.id.money);


         ROOT = FirebaseDatabase.getInstance("https://tripapp-3adda-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        selectedDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCalender(selectedDateTV);
            }
        });

        selectedDateTV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCalender(selectedDateTV2);
            }
        });

        BTN_CON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BOOKING();
            }
        });
    }

    private void getCalender(EditText TV) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(Form.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        TV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void BOOKING(){
        HashMap<Object, Object> MAP = new HashMap<>();
        String spin = spinner.getSelectedItem().toString();
        MAP.put("COMING_DATE",selectedDateTV.getText().toString());
        MAP.put("LIVING_DATE",selectedDateTV2.getText().toString());
        MAP.put("MEMBER",member.getText().toString());
        MAP.put("NAME",name.getText().toString());
        MAP.put("MOBILE",mobile.getText().toString());
        MAP.put("MONEY",money.getText().toString());
        MAP.put("EMAIL",email.getText().toString());
        MAP.put("AMOBILE",amobile.getText().toString());
        MAP.put("SPINNER",spin);

        ROOT.child("BOOKING").child(AUTH.getCurrentUser().getUid()).push().setValue(MAP).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Form.this, "Booking Successfully", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}