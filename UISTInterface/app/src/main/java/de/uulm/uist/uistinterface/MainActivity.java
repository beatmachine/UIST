package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button wohnzimmer, kueche, bad, buero;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (LinearLayout) findViewById(R.id.main_layout);
        l.setBackgroundColor(Color.BLACK);

        wohnzimmer = (Button) findViewById(R.id.button_main_wohnzimmer);
        kueche = (Button) findViewById(R.id.button_main_kueche);
        bad = (Button) findViewById(R.id.button_main_bad);
        buero = (Button) findViewById(R.id.button_main_buero);

        wohnzimmer.setBackgroundColor(Color.WHITE);
        wohnzimmer.setTextSize(35);
        kueche.setBackgroundColor(Color.WHITE);
        kueche.setTextSize(35);
        bad.setBackgroundColor(Color.WHITE);
        bad.setTextSize(35);
        buero.setBackgroundColor(Color.WHITE);
        buero.setTextSize(35);



        wohnzimmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                intent.putExtra("room", "Wohnzimmer");
                startActivity(intent);
            }
        });

        kueche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                intent.putExtra("room", "Kueche");
                startActivity(intent);
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                intent.putExtra("room", "Bad");
                startActivity(intent);
            }
        });

        buero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                intent.putExtra("room", "Buero");
                startActivity(intent);
            }
        });




    }
}
