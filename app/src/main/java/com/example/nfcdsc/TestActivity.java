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

    TextView nfcDetectedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        nfcDetectedMsg = findViewById(R.id.nfc_msg);

        mNfcManager = (NfcManager) getSystemService(NFC_SERVICE);
        mAdapter = mNfcManager.getDefaultAdapter();

        if (mAdapter!=null && mAdapter.isEnabled()){
            nfcDetectedMsg.setText("NFC IS ENABLED");
        } else {
            nfcDetectedMsg.setText("NFC IS DISABLED");
        }

    }

}