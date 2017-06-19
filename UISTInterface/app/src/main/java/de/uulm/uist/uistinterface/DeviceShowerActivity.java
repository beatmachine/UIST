package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class DeviceShowerActivity extends AppCompatActivity {

    String room;

    TextView tmpLabel, waterLabel;
    SeekBar tmpSeekbar, waterSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_shower);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        this.setTitle(room + " / Dusche");

        tmpLabel = (TextView) findViewById(R.id.hairdryer_tmp_label);
        waterLabel = (TextView) findViewById(R.id.hairdryer_speed_label);

        tmpSeekbar = (SeekBar) findViewById(R.id.hairdryer_tmp_seekbar);
        waterSeekbar = (SeekBar) findViewById(R.id.hairdryer_speed_seekbar);

    }
}
