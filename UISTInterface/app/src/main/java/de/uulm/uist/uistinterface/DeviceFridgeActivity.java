package de.uulm.uist.uistinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Activity for the Fridge
 *
 */
public class DeviceFridgeActivity extends AppCompatActivity {
    //region Constants
    private final int de_uulm_uist_uistinterface_MAXTEMP = 10;
    private final int de_uulm_uist_uistinterface_MINTEMP = -5;

    //endregion

    //region Declaration
    ImageButton left,right;

    TextView temperatur;



    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_fridge);

        //region Initialization
        left = (ImageButton) findViewById(R.id.fridge_imagebutton_left);
        right = (ImageButton) findViewById(R.id.fridge_imagebutton_right);

        temperatur = (TextView) findViewById(R.id.fridge_textview_temp);

        //endregion

        //region Listener
        /**
         * Set a Listener for the left ImageButton
         */
        left.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region louderCondition
                int tmp = Integer.parseInt(temperatur.getText().toString());
                if(tmp != de_uulm_uist_uistinterface_MINTEMP){
                    temperatur.setText(String.valueOf(tmp-1));
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the right ImagewButton
         */
        right.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region louderCondition
                int tmp = Integer.parseInt(temperatur.getText().toString());
                if(tmp != de_uulm_uist_uistinterface_MAXTEMP){
                    temperatur.setText(String.valueOf(tmp+1));
                }
                //endregion
            }
        });
        //endregion



    }
}
