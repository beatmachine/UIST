package de.uulm.uist.uistinterface;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Tim Mend on 19.06.2017
 * This Activity is for the BluRay Player Device
 */
public class DeviceBlurayPlayerActivity extends AppCompatActivity {
    //region Declaration
    //Image Button for starting and stopping a Movie of the Bluray Player
    ImageButton play, stop;
    //Switch for turning on and off the BluRay Player
    Switch blurayonoff;
    //TextViews for showing values in the Activity
    TextView dvdName, dvdnamevalue;

    Boolean isrunning;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_bluray_player);

        //region Initialization
        play = (ImageButton) findViewById(R.id.bluray_player_play);
        stop = (ImageButton) findViewById(R.id.bluray_player_stop);

        blurayonoff = (Switch) findViewById(R.id.bluray_player_switch);

        dvdName = (TextView) findViewById(R.id.bluray_player_textView_DVDNAME);
        dvdnamevalue = (TextView) findViewById(R.id.bluray_player_textView_KRABAT);

        isrunning = false;
        //endregion

        //region Visibility
        blurayonoff.setChecked(false);
        blurayonoff.setTextOn("I");
        blurayonoff.setTextOff("O");
        blurayonoff.setShowText(true);
        play.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
        dvdName.setVisibility(View.INVISIBLE);
        dvdnamevalue.setVisibility(View.INVISIBLE);
        //endregion

        /**
         * Set a Listener for the blurayonoff Switch Component
         */
        blurayonoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            /**
             * This will be called if the Switch button status changed
             * @param buttonView ???
             * @param isChecked boolean if button is checked or not
             */
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                //region checkedCondition
                if(isChecked){
                    play.setVisibility(View.VISIBLE);
                    //stop.setVisibility(View.VISIBLE);
                    dvdName.setVisibility(View.VISIBLE);
                    dvdnamevalue.setVisibility(View.VISIBLE);
                    }
                else
                {
                    play.setVisibility(View.INVISIBLE);
                    stop.setVisibility(View.INVISIBLE);
                    dvdName.setVisibility(View.INVISIBLE);
                    dvdnamevalue.setVisibility(View.INVISIBLE);
                    }
                //endregion
            }

        });


        /**
         * Set a Listener for the play Button
         */
        play.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region louderCondition
                if(!isrunning){
                    play.setVisibility(View.INVISIBLE);
                    stop.setVisibility(View.VISIBLE);
                    isrunning = true;
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the stop Button
         */
        stop.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region louderCondition
                if(isrunning){
                    stop.setVisibility(View.INVISIBLE);
                    play.setVisibility(View.VISIBLE);
                    isrunning = false;
                }
                //endregion
            }
        });

    }
}
