package com.ixoz.spestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if device is already saved
        SharedPreferences prefs = getSharedPreferences("DevicePref", MODE_PRIVATE);
        String device = prefs.getString("selected_device", null);
        if (device != null) { // If already set, go to NextActivity
            startActivity(new Intent(this, NextActivity.class).putExtra("device", device));
            finish();
            return;
        }

        // Set UI only if needed
        setContentView(R.layout.activity_main);

        // Setup Spinner
        Spinner deviceSpinner = findViewById(R.id.deviceSpinner);
        deviceSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"SPES", "SPESN"}));

        // Save choice & move to NextActivity
        findViewById(R.id.btnNext).setOnClickListener(v -> {
            String selectedDevice = deviceSpinner.getSelectedItem().toString();
            prefs.edit().putString("selected_device", selectedDevice).apply();
            startActivity(new Intent(this, NextActivity.class).putExtra("device", selectedDevice));
            finish();
        });
    }
}
