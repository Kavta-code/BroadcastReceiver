package com.example.broadcastreceive_batteryindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int level =intent.getIntExtra("level",0);
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(level);
            TextView textView = findViewById(R.id.textView);
            textView.setText("Batterylevel"+Integer.toString(level)+"%");

        }
    };
}
