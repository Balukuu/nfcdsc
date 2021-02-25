package com.example.nfcdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    NfcManager mNfcManager;
    NfcAdapter mAdapter;

    ImageView sign;
    TextView nfcDetectedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        sign = findViewById(R.id.sign);
        nfcDetectedMsg = findViewById(R.id.nfc_msg);

        mNfcManager = (NfcManager) getSystemService(NFC_SERVICE);
        mAdapter = mNfcManager.getDefaultAdapter();

        if (mAdapter!=null && mAdapter.isEnabled()){
            nfcDetectedMsg.setText("NFC IS ENABLED");
            sign.setImageResource(R.drawable.ic_baseline_check_box_24);
        } else {
            nfcDetectedMsg.setText("NFC IS DISABLED");
            sign.setImageResource(R.drawable.ic_baseline_cancel_presentation_24);
        }

    }

}