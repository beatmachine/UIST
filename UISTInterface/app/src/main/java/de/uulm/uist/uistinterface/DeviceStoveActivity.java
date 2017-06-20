package de.uulm.uist.uistinterface;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DeviceStoveActivity extends AppCompatActivity {
    //region Constants
    private static final int de_uulm_uist_uisterface_MAXTEMPERATURE = 230;
    private static final int de_uulm_uist_uisterface_MINTEMPERATURE = 0;

    //endregion

    //region Declaration
    ImageButton platte1_left, platte1_right, platte2_left, platte2_right, platte3_left,
                platte3_right, platte4_right, platte4_left;

    EditText platte1_text, platte2_text, platte3_text, platte4_text;

    TextView platte1_bez, platte2_bez, platte3_bez, platte4_bez, temperatur, temp1, temp2, temp3,
            temp4;

    Switch stove_onoff;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_stove);
        //region Initialization
        stove_onoff = (Switch) findViewById(R.id.stove_switch_onoff);
        stove_onoff.setChecked(false);
        stove_onoff.setTextOn("I");
        stove_onoff.setTextOff("O");
        stove_onoff.setShowText(true);
        //ImageButtons
        platte1_left = (ImageButton) findViewById(R.id.stove_imagebutton_platte1);
        platte1_right = (ImageButton) findViewById(R.id.stove_imagebutton_platte1_2);
        platte2_left = (ImageButton) findViewById(R.id.stove_imagebutton_platte2);
        platte2_right = (ImageButton) findViewById(R.id.stove_imagebutton_platte2_2);
        platte3_left = (ImageButton) findViewById(R.id.stove_imagebutton_platte3);
        platte3_right = (ImageButton) findViewById(R.id.stove_imagebutton_platte3_2);
        platte4_left = (ImageButton) findViewById(R.id.stove_imagebutton_platte4);
        platte4_right = (ImageButton) findViewById(R.id.stove_imagebutton_platte4_2);

        //Editexts
        platte1_text = (EditText) findViewById(R.id.stove_edittext_platte1);
        platte1_text.setText(String.valueOf(0));
        platte2_text = (EditText) findViewById(R.id.stove_edittext_platte2);
        platte2_text.setText(String.valueOf(0));
        platte3_text = (EditText) findViewById(R.id.stove_edittext_platte3);
        platte3_text.setText(String.valueOf(0));
        platte4_text = (EditText) findViewById(R.id.stove_edittext_platte4);
        platte4_text.setText(String.valueOf(0));

        //TextViews
        platte1_bez = (TextView) findViewById(R.id.stove_textview_platte1);
        platte2_bez = (TextView) findViewById(R.id.stove_textview_platte2);
        platte3_bez = (TextView) findViewById(R.id.stove_textview_platte3);
        platte4_bez = (TextView) findViewById(R.id.stove_textview_platte4);
        temperatur = (TextView) findViewById(R.id.stove_textview_temperatur);
        temp1 = (TextView) findViewById(R.id.stove_textview_temp1);
        temp2 = (TextView) findViewById(R.id.stove_textview_temp2);
        temp3 = (TextView) findViewById(R.id.stove_textview_temp3);
        temp4 = (TextView) findViewById(R.id.stove_textview_temp4);

        //endregion

        //region Visibility

        //Visibility for ImageButtons
        platte1_left.setVisibility(View.INVISIBLE);
        platte1_right.setVisibility(View.INVISIBLE);
        platte2_left.setVisibility(View.INVISIBLE);
        platte2_right.setVisibility(View.INVISIBLE);
        platte3_left.setVisibility(View.INVISIBLE);
        platte3_right.setVisibility(View.INVISIBLE);
        platte4_left.setVisibility(View.INVISIBLE);
        platte4_right.setVisibility(View.INVISIBLE);
        //Visibility for EditText
        platte1_text.setVisibility(View.INVISIBLE);
        platte2_text.setVisibility(View.INVISIBLE);
        platte3_text.setVisibility(View.INVISIBLE);
        platte4_text.setVisibility(View.INVISIBLE);
        //Visibility for the TextViews
        platte1_bez.setVisibility(View.INVISIBLE);
        platte2_bez.setVisibility(View.INVISIBLE);
        platte3_bez.setVisibility(View.INVISIBLE);
        platte4_bez.setVisibility(View.INVISIBLE);
        temperatur.setVisibility(View.INVISIBLE);
        temp1.setVisibility(View.INVISIBLE);
        temp2.setVisibility(View.INVISIBLE);
        temp3.setVisibility(View.INVISIBLE);
        temp4.setVisibility(View.INVISIBLE);

        //endregion

        //region Listener


        /**
         * Set a Listener for the blurayonoff Switch Component
         */
        stove_onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            /**
             * This will be called if the Switch button status changed
             * @param buttonView ???
             * @param isChecked boolean if button is checked or not
             */
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                //region checkedCondition
                if(isChecked){
                    //Visibility for ImageButtons
                    platte1_left.setVisibility(View.VISIBLE);
                    platte1_right.setVisibility(View.VISIBLE);
                    platte2_left.setVisibility(View.VISIBLE);
                    platte2_right.setVisibility(View.VISIBLE);
                    platte3_left.setVisibility(View.VISIBLE);
                    platte3_right.setVisibility(View.VISIBLE);
                    platte4_left.setVisibility(View.VISIBLE);
                    platte4_right.setVisibility(View.VISIBLE);
                    //Visibility for EditText
                    platte1_text.setVisibility(View.VISIBLE);
                    platte2_text.setVisibility(View.VISIBLE);
                    platte3_text.setVisibility(View.VISIBLE);
                    platte4_text.setVisibility(View.VISIBLE);
                    //Visibility for the TextViews
                    platte1_bez.setVisibility(View.VISIBLE);
                    platte2_bez.setVisibility(View.VISIBLE);
                    platte3_bez.setVisibility(View.VISIBLE);
                    platte4_bez.setVisibility(View.VISIBLE);
                    temperatur.setVisibility(View.VISIBLE);
                    temp1.setVisibility(View.VISIBLE);
                    temp2.setVisibility(View.VISIBLE);
                    temp3.setVisibility(View.VISIBLE);
                    temp4.setVisibility(View.VISIBLE);
                }
                else
                {
                    //Visibility for ImageButtons
                    platte1_left.setVisibility(View.INVISIBLE);
                    platte1_right.setVisibility(View.INVISIBLE);
                    platte2_left.setVisibility(View.INVISIBLE);
                    platte2_right.setVisibility(View.INVISIBLE);
                    platte3_left.setVisibility(View.INVISIBLE);
                    platte3_right.setVisibility(View.INVISIBLE);
                    platte4_left.setVisibility(View.INVISIBLE);
                    platte4_right.setVisibility(View.INVISIBLE);
                    //Visibility for EditText
                    platte1_text.setVisibility(View.INVISIBLE);
                    platte2_text.setVisibility(View.INVISIBLE);
                    platte3_text.setVisibility(View.INVISIBLE);
                    platte4_text.setVisibility(View.INVISIBLE);
                    //Visibility for the TextViews
                    platte1_bez.setVisibility(View.INVISIBLE);
                    platte2_bez.setVisibility(View.INVISIBLE);
                    platte3_bez.setVisibility(View.INVISIBLE);
                    platte4_bez.setVisibility(View.INVISIBLE);
                    temperatur.setVisibility(View.INVISIBLE);
                    temp1.setVisibility(View.INVISIBLE);
                    temp2.setVisibility(View.INVISIBLE);
                    temp3.setVisibility(View.INVISIBLE);
                    temp4.setVisibility(View.INVISIBLE);
                }
                //endregion
            }

        });
        /**
         * This will set a Listener for the Platte 1 EditText
         */
        platte1_text.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //ToDo: the if shit isn´t working..=> DEAD CODE fix this maybe
                if(s.toString().trim().length()==0){return;}
                int tmp = checkIfNumber(platte1_text.getText().toString());

                if(tmp > de_uulm_uist_uisterface_MAXTEMPERATURE){
                    temp1.setText(String.valueOf(de_uulm_uist_uisterface_MAXTEMPERATURE));
                }
                if(tmp < de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp1.setText(String.valueOf(de_uulm_uist_uisterface_MINTEMPERATURE));
                }
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE && tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp1.setText(String.valueOf(tmp));
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        /**
         * This will set a Listener for the Platte 2 EditText
         */
        platte2_text.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //ToDo: the if shit isn´t working..=> DEAD CODE fix this maybe
                if(s.toString().trim().length()==0){return;}
                int tmp = checkIfNumber(platte2_text.getText().toString());
                if(tmp > de_uulm_uist_uisterface_MAXTEMPERATURE){
                    temp2.setText(String.valueOf(de_uulm_uist_uisterface_MAXTEMPERATURE));
                }
                if(tmp < de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp2.setText(String.valueOf(de_uulm_uist_uisterface_MINTEMPERATURE));
                }
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE && tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp2.setText(String.valueOf(tmp));
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        /**
         * This will set a Listener for the Platte 3 EditText
         */
        platte3_text.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //ToDo: the if shit isn´t working..=> DEAD CODE fix this maybe
                if(s.toString().trim().length()==0){return;}
                int tmp = checkIfNumber(platte3_text.getText().toString());

                if(tmp > de_uulm_uist_uisterface_MAXTEMPERATURE){
                    temp3.setText(String.valueOf(de_uulm_uist_uisterface_MAXTEMPERATURE));
                }
                if(tmp < de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp3.setText(String.valueOf(de_uulm_uist_uisterface_MINTEMPERATURE));
                }
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE && tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp3.setText(String.valueOf(tmp));
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        /**
         * This will set a Listener for the Platte 4 EditText
         */
        platte4_text.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //ToDo: the if shit isn´t working..=> DEAD CODE fix this maybe
                if(s.toString().trim().length()==0){return;}
                int tmp = checkIfNumber(platte4_text.getText().toString());
                if(tmp > de_uulm_uist_uisterface_MAXTEMPERATURE){
                    temp4.setText(String.valueOf(de_uulm_uist_uisterface_MAXTEMPERATURE));
                }
                if(tmp < de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp4.setText(String.valueOf(de_uulm_uist_uisterface_MINTEMPERATURE));
                }
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE && tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    temp4.setText(String.valueOf(tmp));
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        /**
         * Set a Listener for the platte1_left ImageButton
         */
        platte1_left.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte1_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    platte1_text.setText(String.valueOf(tmp-1));
                }
                //endregion
            }
        });
        /**
         * Set a Listener for the platte1_right ImageButton
         */
        platte1_right.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte1_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE){
                    platte1_text.setText(String.valueOf(tmp+1));
                }
               //endregion
            }
        });
        platte2_left.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte2_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    platte2_text.setText(String.valueOf(tmp-1));
                }
                //endregion
            }
        });

        platte2_right.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte2_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE){
                    platte2_text.setText(String.valueOf(tmp+1));
                }
                //endregion
            }
        });

        platte3_left.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte3_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    platte3_text.setText(String.valueOf(tmp-1));
                }
                //endregion
            }
        });

        platte3_right.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte3_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE){
                    platte3_text.setText(String.valueOf(tmp+1));
                }
                //endregion
            }
        });
        platte4_left.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte4_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MINTEMPERATURE){
                    platte4_text.setText(String.valueOf(tmp-1));
                }
                //endregion
            }
        });

        platte4_right.setOnClickListener(new View.OnClickListener() {

            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region TemperateCondition
                int tmp = Integer.parseInt(platte4_text.getText().toString());
                if(tmp != de_uulm_uist_uisterface_MAXTEMPERATURE){
                    platte4_text.setText(String.valueOf(tmp+1));
                }
                //endregion
            }
        });





        //endregion
    }

    /**
     * Method to check if a given String is a valid Parsable string for an Integer
     * @param s the String which should be parsable
     * @return will return 0 if it isn't parsable else it will return the Integer
     */
    public int checkIfNumber(String s){
        try {
            int tmp = Integer.parseInt(s);
                return tmp;

        }catch(NumberFormatException e){
            return 0;
        }

    }
}
