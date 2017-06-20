package de.uulm.uist.uistinterface;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DeviceTelephoneActivity extends AppCompatActivity {

    TextView numbers;

    boolean isGreen;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9 , bClear;
    ImageButton bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_telephone);

        this.setTitle("Buero / Telefon");

        numbers = (TextView) findViewById(R.id.tele_numberview);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);

        bCall = (ImageButton) findViewById(R.id.buttonCall);
        bClear = (Button) findViewById(R.id.buttonClear);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = numbers.getText().toString();
                numbers.setText(a + "9");
            }
        });

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.setText("");
            }
        });

        bCall.setBackgroundColor(Color.GREEN);
        isGreen = true;

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGreen == true){
                    bCall.setBackgroundColor(Color.RED);
                    isGreen = false;
                } else {
                    bCall.setBackgroundColor(Color.GREEN);
                    isGreen = true;
                }
            }
        });


    }
}
