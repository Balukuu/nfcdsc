package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TopUpActivity extends AppCompatActivity {
    private Button topUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        topUp = findViewById(R.id.write_tag);

        topUp.setOnClickListener(v -> {
            transferTopUpData();
        });

        //Function to handle the bottom nav bar actions
        handleBottomNavBarActions();
    }

    private void transferTopUpData(){
        EditText amount = findViewById(R.id.note);
        String msg = amount.getText().toString();

        if (!msg.isEmpty()) {
            Intent intent = new Intent(this, PaymentHistory.class);
            intent.putExtra("MESSAGE", msg);
            startActivity(intent);
            amount.setText("");
        } else {
            Toast.makeText(this, " ENTER ANY AMOUNT ",
                    Toast.LENGTH_SHORT).show();
            amount.requestFocus();
        }

    }

    // Function handling the bottom nav bar
    private void handleBottomNavBarActions(){

        //Handling the Bottom navigation view actions
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav_bar);

        // CHECKING THE CURRENT CLICKED BOTTOM NAV BAR MENU ITEM
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.tap2pay:
                    startActivity(new Intent(this, MainActivity.class));
                    break;
                case R.id.topup_activity:
                    startActivity(new Intent(this, TopUpActivity.class));
                    break;
                case R.id.payment_history_activity:
                    break;
                case R.id.profile:
                    startActivity(new Intent(this,SettingsActivity.class));
                    break;
            }
            return false;
        });
    }
}