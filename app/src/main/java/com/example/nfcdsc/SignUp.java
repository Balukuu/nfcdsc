package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    //Global variables for UI components
    private Button signup;
    private EditText fname, lname, phoneNo;

    //Global variables
    private String firstname, lastname, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Binding the xml to java
        signup = findViewById(R.id.sign_up_btn);
        fname = findViewById(R.id.first_name);
        lname = findViewById(R.id.second_name);
        phoneNo = findViewById(R.id.phone_number);

        signup.setOnClickListener(v -> {

            firstname = fname.getText().toString();
            lastname = lname.getText().toString();
            phone = phoneNo.getText().toString();

            if (!firstname.isEmpty() && !lastname.isEmpty() && !phone.isEmpty()) {
                Intent intent = new Intent(this, SettingsActivity.class);
                intent.putExtra("USERNAME", firstname);
                intent.putExtra("BALANCE", lastname);
                intent.putExtra("CONTACT", phone);
                startActivity(intent);
            } else {
                Toast.makeText(this, " ENTER YOUR DETAILS ",
                        Toast.LENGTH_SHORT).show();
                fname.requestFocus();
            }
        });

    }
}