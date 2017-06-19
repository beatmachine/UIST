package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Tim Mend on 18.06.2017
 * Activity for the Hifi
 */
public class DeviceHifiActivity extends AppCompatActivity {
    //region Declaration
    String room;
    /**
     * Switch for turning the Hifi on
     */
    Switch onoff;
    /**
     * Image buttons for regulating the loudness of the sound
     */
    ImageButton louder, leiser;

    /**
     * Image Buttons for setting the next or the previous song;
     */
    ImageButton nexttrack, previoustrack;

    /**
     * TextView for displaying loudness of the hifi and the played track;
     */
    TextView loudness, track, lautstärke, song;

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_hifi);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        this.setTitle(room + " / HiFi");


        //region FindComponents

        /**
         * This code will initialize all Components
         */
        onoff = (Switch) findViewById(R.id.switchHifi);
        louder = (ImageButton) findViewById(R.id.hifi_louder);
        leiser = (ImageButton) findViewById(R.id.hifi_quieter);
        nexttrack = (ImageButton) findViewById(R.id.hifi_nexttrack);
        previoustrack = (ImageButton) findViewById(R.id.hifi_previoustrack);
        loudness = (TextView) findViewById(R.id.loudness);
        track = (TextView) findViewById(R.id.track);
        song = (TextView) findViewById(R.id.hifi_song);
        lautstärke = (TextView) findViewById(R.id.hifi_lautstärke);
        //endregion

        //region Visibility
        /**
         * Set onoff as false when activity is created, also set text of button
         */
        onoff.setChecked(false);
        onoff.setTextOn("I");
        onoff.setTextOff("O");
        onoff.setShowText(true);

        louder.setVisibility(View.INVISIBLE);
        leiser.setVisibility(View.INVISIBLE);
        nexttrack.setVisibility(View.INVISIBLE);
        previoustrack.setVisibility(View.INVISIBLE);
        loudness.setVisibility(View.INVISIBLE);
        track.setVisibility(View.INVISIBLE);
        lautstärke.setVisibility(View.INVISIBLE);
        song.setVisibility(View.INVISIBLE);
        //endregion

        /**
         * Set a Listener for the onoff Switch Component
         */
        onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            /**
             * This will be called if the Switch button status changed
             * @param buttonView ???
             * @param isChecked boolean if button is checked or not
             */
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                //region checkedCondition
                if(isChecked){
                    louder.setVisibility(View.VISIBLE);
                    leiser.setVisibility(View.VISIBLE);
                    nexttrack.setVisibility(View.VISIBLE);
                    previoustrack.setVisibility(View.VISIBLE);
                    loudness.setVisibility(View.VISIBLE);
                    track.setVisibility(View.VISIBLE);
                    lautstärke.setVisibility(View.VISIBLE);
                    song.setVisibility(View.VISIBLE);
                }
                else
                {
                    louder.setVisibility(View.INVISIBLE);
                    leiser.setVisibility(View.INVISIBLE);
                    nexttrack.setVisibility(View.INVISIBLE);
                    previoustrack.setVisibility(View.INVISIBLE);
                    loudness.setVisibility(View.INVISIBLE);
                    track.setVisibility(View.INVISIBLE);
                    lautstärke.setVisibility(View.INVISIBLE);
                    song.setVisibility(View.INVISIBLE);
                }
                //endregion
            }

        });

        /**
         * Set a Listener for the louder Button
         */
        louder.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region louderCondition
                int currentValue = Integer.parseInt(loudness.getText().toString());
                if (currentValue == 25){
                    loudness.setText("" + 25);
                } else {
                    loudness.setText("" + (currentValue+1));
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the leiser Button
         */
        leiser.setOnClickListener(new View.OnClickListener() {
            /**
             * This Method will be called when the leiser Button is clicked.
             * @param v The View where the click ccmes from
             */
            @Override
            public void onClick(View v) {
                //region leiserCondition
                int currentValue = Integer.parseInt(loudness.getText().toString());
                if (currentValue == 0){
                    loudness.setText("" + 0);
                } else {
                    loudness.setText("" + (currentValue-1));
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the nexttrack Button
         */
        nexttrack.setOnClickListener(new View.OnClickListener() {
            /**
             * This Method will be called when the nexttracak Button is clicked
             * @param v The View where the Click comes from
             */
            @Override
            public void onClick(View v) {
                //region nexttrackCondition
                int currentValue = Integer.parseInt(track.getText().toString());
                if (currentValue == 12){
                    track.setText("" + 1);
                } else {
                    track.setText("" + (currentValue+1));
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the previoustrack Button
         */
        previoustrack.setOnClickListener(new View.OnClickListener() {
            /**
             * This Method will be called if the previousTrack Button is clicked
             * @param v the View where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region previousTrackCondition
                int currentValue = Integer.parseInt(track.getText().toString());
                if (currentValue == 1){
                    track.setText("" + 12);
                } else {
                    track.setText("" + (currentValue-1));
                }
                //endregion
            }
        });
    }


}