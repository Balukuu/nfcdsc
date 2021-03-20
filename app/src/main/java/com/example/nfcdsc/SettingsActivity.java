package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.nfcdsc.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    //UI Global variables
    private EditText names, acc_balance, phoneNo;
    //Global properties
    private String username, balance, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Binding the UI variables to their xml ids
        names = findViewById(R.id.names_field);
        acc_balance = findViewById(R.id.balance_field);
        phoneNo = findViewById(R.id.phone_field);

        Intent stringIntent = getIntent();

        username = stringIntent.getStringExtra("USERNAME");
        balance = stringIntent.getStringExtra("BALANCE");
        phone = stringIntent.getStringExtra("CONTACT");

        names.setText(username);
        acc_balance.setText(balance);
        phoneNo.setText(phone);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
        //function to terminate the activity
        finish();
    }
}