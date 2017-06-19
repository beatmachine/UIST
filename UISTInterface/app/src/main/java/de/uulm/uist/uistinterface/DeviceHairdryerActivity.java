package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Tim on 19.06.17.
 */

public class DeviceHairdryerActivity extends AppCompatActivity {

    String room;

    TextView tmpLabel, speedLabel;
    SeekBar tmpSeekbar, speedSeekbar;

    Switch switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_hairdryer);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        this.setTitle(room + " / Fön");


        switchOnOff = (Switch) findViewById(R.id.switchHairdryer);

        tmpLabel = (TextView) findViewById(R.id.hairdryer_tmp_label);
        speedLabel = (TextView) findViewById(R.id.hairdryer_speed_label);

        tmpSeekbar = (SeekBar) findViewById(R.id.hairdryer_tmp_seekbar);
        speedSeekbar = (SeekBar) findViewById(R.id.hairdryer_speed_seekbar);


        switchOnOff.setChecked(false);
        switchOnOff.setTextOn("I");
        switchOnOff.setTextOff("0");
        switchOnOff.setShowText(true);

        tmpLabel.setVisibility(View.INVISIBLE);
        speedLabel.setVisibility(View.INVISIBLE);
        tmpSeekbar.setVisibility(View.INVISIBLE);
        speedSeekbar.setVisibility(View.INVISIBLE);

        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tmpLabel.setVisibility(View.VISIBLE);
                    speedLabel.setVisibility(View.VISIBLE);
                    tmpSeekbar.setVisibility(View.VISIBLE);
                    speedSeekbar.setVisibility(View.VISIBLE);
                } else {
                    tmpLabel.setVisibility(View.INVISIBLE);
                    speedLabel.setVisibility(View.INVISIBLE);
                    tmpSeekbar.setVisibility(View.INVISIBLE);
                    speedSeekbar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}

