package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TopUpActivity extends AppCompatActivity {
    private Button topUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        topUp = findViewById(R.id.write_tag);
        topUp.setOnClickListener(v -> {

                EditText amount = findViewById(R.id.note);
                String msg = amount.getText().toString();

                if (!msg.isEmpty()) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("MESSAGE", msg);
                    startActivity(intent);
                    amount.setText("");
                } else {
                    Toast.makeText(this, " ENTER ANY AMOUNT ",
                            Toast.LENGTH_SHORT).show();
                    amount.requestFocus();
                }
        });
    }
}