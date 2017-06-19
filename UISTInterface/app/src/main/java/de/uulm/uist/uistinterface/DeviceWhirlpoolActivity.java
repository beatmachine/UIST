package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class DeviceWhirlpoolActivity extends AppCompatActivity {

    String room;

    TextView tmpLabel, waterLabel;
    SeekBar tmpSeekbar, waterSeekbar;

    Switch bubblebath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_whirlpool);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        this.setTitle(room + " / Whirlpool");

        tmpLabel = (TextView) findViewById(R.id.whirlpool_tmp_label);
        waterLabel = (TextView) findViewById(R.id.whirlpool_water_label);

        tmpSeekbar = (SeekBar) findViewById(R.id.whirlpool_tmp_seekbar);
        waterSeekbar = (SeekBar) findViewById(R.id.whirlpool_water_seekbar);

        bubblebath = (Switch) findViewById(R.id.switchBubblebath);

        bubblebath.setChecked(false);
        bubblebath.setTextOn("I");
        bubblebath.setTextOff("0");
        bubblebath.setShowText(true);

    }
}
