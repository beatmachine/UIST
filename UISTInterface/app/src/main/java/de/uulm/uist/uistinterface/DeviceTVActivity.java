package de.uulm.uist.uistinterface;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class DeviceTVActivity extends Activity {

    Switch switchOnOff;

    ImageButton programPlus, programMinus;
    ImageButton volumePlus, volumeMinus, volumeOff;

    Button program1, program2, program3, program4, program5;

    SearchView searchView;

    TextView currentProgram, programLabel, currentVolume, volumeLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_tv);

        Intent intent = getIntent();
        String room = intent.getStringExtra("room");

        if (room.equals("Wohnzimmer")){
            this.setTitle("Wohnzimmer / TV");
        } else {
            this.setTitle("Büro / TV");
        }

        switchOnOff = (Switch) findViewById(R.id.switchOnOff);

        programLabel = (TextView) findViewById(R.id.program_label);
        programPlus = (ImageButton) findViewById(R.id.program_plus);
        currentProgram = (TextView) findViewById(R.id.program);
        programMinus = (ImageButton) findViewById(R.id.program_minus);

        searchView = (SearchView) findViewById(R.id.program_searchbar);

        program1 = (Button) findViewById(R.id.button_program1);
        program2 = (Button) findViewById(R.id.button_program2);
        program3 = (Button) findViewById(R.id.button_program3);
        program4 = (Button) findViewById(R.id.button_program4);
        program5 = (Button) findViewById(R.id.button_program5);

        volumeLabel = (TextView) findViewById(R.id.volume_label);
        volumeMinus = (ImageButton) findViewById(R.id.volume_minus);
        currentVolume = (TextView) findViewById(R.id.volume);
        volumePlus = (ImageButton) findViewById(R.id.volume_plus);
        volumeOff = (ImageButton) findViewById(R.id.volume_off);

        //-------------------

        switchOnOff.setChecked(false);
        switchOnOff.setTextOn("I");
        switchOnOff.setTextOff("0");
        switchOnOff.setShowText(true);

        programLabel.setVisibility(View.INVISIBLE);
        programPlus.setVisibility(View.INVISIBLE);
        currentProgram.setVisibility(View.INVISIBLE);
        programMinus.setVisibility(View.INVISIBLE);
        searchView.setVisibility(View.INVISIBLE);
        program1.setVisibility(View.INVISIBLE);
        program2.setVisibility(View.INVISIBLE);
        program3.setVisibility(View.INVISIBLE);
        program4.setVisibility(View.INVISIBLE);
        program5.setVisibility(View.INVISIBLE);
        volumeLabel.setVisibility(View.INVISIBLE);
        volumePlus.setVisibility(View.INVISIBLE);
        currentVolume.setVisibility(View.INVISIBLE);
        volumeMinus.setVisibility(View.INVISIBLE);
        volumeOff.setVisibility(View.INVISIBLE);


        program1.setBackgroundColor(Color.WHITE);
        program1.setTextSize(20);
        program2.setBackgroundColor(Color.WHITE);
        program2.setTextSize(20);
        program3.setBackgroundColor(Color.WHITE);
        program3.setTextSize(20);
        program4.setBackgroundColor(Color.WHITE);
        program4.setTextSize(20);
        program5.setBackgroundColor(Color.WHITE);
        program5.setTextSize(20);


        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    programLabel.setVisibility(View.VISIBLE);
                    programPlus.setVisibility(View.VISIBLE);
                    currentProgram.setVisibility(View.VISIBLE);
                    programMinus.setVisibility(View.VISIBLE);
                    searchView.setVisibility(View.VISIBLE);
                    program1.setVisibility(View.VISIBLE);
                    program2.setVisibility(View.VISIBLE);
                    program3.setVisibility(View.VISIBLE);
                    program4.setVisibility(View.VISIBLE);
                    program5.setVisibility(View.VISIBLE);
                    volumeLabel.setVisibility(View.VISIBLE);
                    volumePlus.setVisibility(View.VISIBLE);
                    currentVolume.setVisibility(View.VISIBLE);
                    volumeMinus.setVisibility(View.VISIBLE);
                    volumeOff.setVisibility(View.VISIBLE);
                } else {
                    programLabel.setVisibility(View.INVISIBLE);
                    programPlus.setVisibility(View.INVISIBLE);
                    currentProgram.setVisibility(View.INVISIBLE);
                    programMinus.setVisibility(View.INVISIBLE);
                    searchView.setVisibility(View.INVISIBLE);
                    program1.setVisibility(View.INVISIBLE);
                    program2.setVisibility(View.INVISIBLE);
                    program3.setVisibility(View.INVISIBLE);
                    program4.setVisibility(View.INVISIBLE);
                    program5.setVisibility(View.INVISIBLE);
                    volumeLabel.setVisibility(View.INVISIBLE);
                    volumePlus.setVisibility(View.INVISIBLE);
                    currentVolume.setVisibility(View.INVISIBLE);
                    volumeMinus.setVisibility(View.INVISIBLE);
                    volumeOff.setVisibility(View.INVISIBLE);
                }

            }
        });

        programPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(currentProgram.getText().toString());
                if (currentValue == 5){
                    currentProgram.setText("" + 1);
                } else {
                    currentProgram.setText("" + (currentValue+1));
                }
            }
        });

        programMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(currentProgram.getText().toString());
                if (currentValue == 1){
                    currentProgram.setText("" + 5);
                } else {
                    currentProgram.setText("" + (currentValue-1));
                }
            }
        });

        program1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgram.setText("" + 1);
            }
        });

        program2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgram.setText("" + 2);
            }
        });

        program3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgram.setText("" + 3);
            }
        });

        program4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgram.setText("" + 4);
            }
        });

        program5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgram.setText("" + 5);
            }
        });

        volumeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(currentVolume.getText().toString());
                if (currentValue == 0){
                    currentVolume.setText("" + 0);
                } else {
                    currentVolume.setText("" + (currentValue-1));
                }
            }
        });

        volumePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(currentVolume.getText().toString());
                if (currentValue == 5){
                    currentVolume.setText("" + 5);
                } else {
                    currentVolume.setText("" + (currentValue+1));
                }
            }
        });

        volumeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentVolume.setText("" + 0);
            }
        });





    }
}
