package com.example.nfcdsc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
//                Intent intent = new Intent(this, SettingsActivity.class);
//                intent.putExtra("USERNAME", firstname);
//                intent.putExtra("BALANCE", lastname);
//                intent.putExtra("CONTACT", phone);
                //startActivity(intent);
                //finish();
                customAlertDialog();
            } else {
                Toast.makeText(this, " ENTER YOUR DETAILS ",
                        Toast.LENGTH_SHORT).show();
                fname.requestFocus();
            }
        });
    }

    void customAlertDialog() {
        // get alert_dialog.xml view
        LayoutInflater li = LayoutInflater.from(getApplicationContext());
        View promptsView = li.inflate(R.layout.alert_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getApplicationContext());
        // set alert_dialog.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.verification_code);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, id) -> {
                    // get user input and set it to result
// edit text
                    Toast.makeText(getApplicationContext(), "Entered: "
                            +userInput.getText().toString(), Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

}