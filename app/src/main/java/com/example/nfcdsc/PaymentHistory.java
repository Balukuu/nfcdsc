package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nfcdsc.adapters.RecyclerViewAdapter;

public class PaymentHistory extends AppCompatActivity {

    String account_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        Intent intent = getIntent();
        account_balance = intent.getStringExtra("MESSAGE");
        TextView messageView = findViewById(R.id.acc_balance);

        messageView.setText(account_balance);

        populateRecyclerView();

    }

    // METHOD/FUNCTION TO POPULATE THE PAYMENT HISTORY RECYCLER VIEW LIST
    private void populateRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.payment_history_list);

        Intent stringIntent = getIntent();

        String data = stringIntent.getStringExtra("AMOUNT CHARGED");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void viewSettings(View view){
        startActivity(new Intent(this, SettingsActivity.class));
    }
}