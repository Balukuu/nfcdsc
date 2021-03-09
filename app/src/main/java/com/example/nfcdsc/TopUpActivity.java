package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopUpActivity extends AppCompatActivity {

    private Button topUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        topUp = findViewById(R.id.write_tag);
        topUp.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}