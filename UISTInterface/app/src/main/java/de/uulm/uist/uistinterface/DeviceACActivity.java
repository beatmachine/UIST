package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class DeviceACActivity extends AppCompatActivity {

    String room;

    TextView tmpLabel, tmp, speedLabel, speed;
    ImageButton tmpMinus, tmpPlus, speedMinus, speedPlus;

    Switch switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_ac);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        if (room.equals("Wohnzimmer")){
            this.setTitle(room + " / Klimaanlage");
        } else if (room.equals("Kueche")){
            this.setTitle(room + " / Klimaanlage");
        } else if (room.equals("Buero")){
            this.setTitle(room + " / Klimaanlage");
        } else if (room.equals("Bad")){
            this.setTitle(room + " / Klimaanlage");
        }


        switchOnOff = (Switch) findViewById(R.id.switchAC);

        tmpLabel = (TextView) findViewById(R.id.ac_tmp_label);
        tmp = (TextView) findViewById(R.id.ac_tmp);
        speedLabel = (TextView) findViewById(R.id.ac_speed_label);
        speed = (TextView) findViewById(R.id.ac_speed);

        tmpMinus = (ImageButton) findViewById(R.id.ac_tmp_minus);
        tmpPlus = (ImageButton) findViewById(R.id.ac_tmp_plus);
        speedMinus = (ImageButton) findViewById(R.id.ac_speed_minus);
        speedPlus = (ImageButton) findViewById(R.id.ac_speed_plus);

        switchOnOff.setChecked(false);
        switchOnOff.setTextOn("I");
        switchOnOff.setTextOff("0");
        switchOnOff.setShowText(true);

        tmpLabel.setVisibility(View.INVISIBLE);
        tmp.setVisibility(View.INVISIBLE);
        tmpMinus.setVisibility(View.INVISIBLE);
        tmpPlus.setVisibility(View.INVISIBLE);
        speedLabel.setVisibility(View.INVISIBLE);
        speed.setVisibility(View.INVISIBLE);
        speedMinus.setVisibility(View.INVISIBLE);
        speedPlus.setVisibility(View.INVISIBLE);

        tmpMinus.setBackgroundColor(Color.BLUE);
        tmpPlus.setBackgroundColor(Color.RED);

        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tmpLabel.setVisibility(View.VISIBLE);
                    tmp.setVisibility(View.VISIBLE);
                    tmpMinus.setVisibility(View.VISIBLE);
                    tmpPlus.setVisibility(View.VISIBLE);
                    speedLabel.setVisibility(View.VISIBLE);
                    speed.setVisibility(View.VISIBLE);
                    speedMinus.setVisibility(View.VISIBLE);
                    speedPlus.setVisibility(View.VISIBLE);
                } else {
                    tmpLabel.setVisibility(View.INVISIBLE);
                    tmp.setVisibility(View.INVISIBLE);
                    tmpMinus.setVisibility(View.INVISIBLE);
                    tmpPlus.setVisibility(View.INVISIBLE);
                    speedLabel.setVisibility(View.INVISIBLE);
                    speed.setVisibility(View.INVISIBLE);
                    speedMinus.setVisibility(View.INVISIBLE);
                    speedPlus.setVisibility(View.INVISIBLE);
                }
            }
        });

        tmpPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(tmp.getText().toString());
                if (currentValue == 25){
                    tmp.setText("" + 25);
                } else {
                    tmp.setText("" + (currentValue+1));
                }
            }
        });

        tmpMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(tmp.getText().toString());
                if (currentValue == 16){
                    tmp.setText("" + 16);
                } else {
                    tmp.setText("" + (currentValue-1));
                }
            }
        });

        speedPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(speed.getText().toString());
                if (currentValue == 5){
                    speed.setText("" + 5);
                } else {
                    speed.setText("" + (currentValue+1));
                }
            }
        });

        speedMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(speed.getText().toString());
                if (currentValue == 0){
                    speed.setText("" + 0);
                } else {
                    speed.setText("" + (currentValue-1));
                }
            }
        });





    }
}
