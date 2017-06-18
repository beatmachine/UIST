package de.uulm.uist.uistinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeviceBlindActivity extends AppCompatActivity {

    String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_blind);

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

    }
}
