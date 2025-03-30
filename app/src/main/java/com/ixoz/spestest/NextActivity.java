package com.ixoz.spestest;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Get device name and update UI
        String device = getIntent().getStringExtra("device");
        ((TextView) findViewById(R.id.deviceTextView)).setText("Selected Device: " + device);

        // Show NFC checkbox only for SPESN
        findViewById(R.id.nfcCheckBox).setVisibility("SPESN".equals(device) ? CheckBox.VISIBLE : CheckBox.GONE);
    }
}
