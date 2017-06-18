package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class DeviceLightActivity extends AppCompatActivity {

    Switch switchLight;

    TextView labelIntensity;

    SeekBar seekBar;


    String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_light);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        if (room.equals("Wohnzimmer")){
            this.setTitle(room + " / Licht");
        } else if (room.equals("Kueche")){
            this.setTitle(room + " / Licht");
        } else if (room.equals("Buero")){
            this.setTitle(room + " / Licht");
        } else if (room.equals("Bad")){
            this.setTitle(room + " / Licht");
        }

        switchLight = (Switch) findViewById(R.id.switchLight);
        labelIntensity = (TextView) findViewById(R.id.light_intensity_label);
        seekBar = (SeekBar) findViewById(R.id.light_seekbar);

        switchLight.setChecked(false);
        switchLight.setTextOn("I");
        switchLight.setTextOff("0");
        switchLight.setShowText(true);

        labelIntensity.setVisibility(View.INVISIBLE);
        seekBar.setVisibility(View.INVISIBLE);

        switchLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    labelIntensity.setVisibility(View.VISIBLE);
                    seekBar.setVisibility(View.VISIBLE);
                } else {
                    labelIntensity.setVisibility(View.INVISIBLE);
                    seekBar.setVisibility(View.INVISIBLE);
                }
            }
        });



    }
}
