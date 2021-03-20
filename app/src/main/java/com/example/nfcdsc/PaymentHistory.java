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

    TextView account_balance_txt;

    //Global Variables to store the data from the MainActivity and the top up activity.
    String account_balance;
    double current_amount = 60000d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        Intent intent = getIntent();
        //Account balance from the TopUp Activity
        account_balance = intent.getStringExtra("MESSAGE");

        // Amount from the transaction.
        //current_amount = Integer.parseInt(intent.getStringExtra("AMOUNT CHARGED"));

        account_balance_txt = findViewById(R.id.acc_balance);

        double current_balance = Double.parseDouble(account_balance);

        double updated_balance = current_balance-current_amount;

        account_balance = String.valueOf(updated_balance);

        // Formatting the account balance for the view
        //String my_acc_balance = String.format("%,d", account_balance);

        account_balance_txt.setText(account_balance);
        //messageView.setText((int) current_amount);

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