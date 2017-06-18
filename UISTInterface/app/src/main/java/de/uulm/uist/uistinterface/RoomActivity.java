package de.uulm.uist.uistinterface;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    Button eins, zwei, drei, vier, fuenf, sechs;
    LinearLayout l;

    List<String> wohnzimmerGeraete = new ArrayList<>();
    List<String> kuechenGeraete = new ArrayList<>();
    List<String> badGeraete = new ArrayList<>();
    List<String> bueroGeraete = new ArrayList<>();

    String room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

        this.setTitle(room);

        l = (LinearLayout) findViewById(R.id.room_layout);
        l.setBackgroundColor(Color.BLACK);


        wohnzimmerGeraete.add("TV");
        wohnzimmerGeraete.add("HiFi");
        wohnzimmerGeraete.add("BluRay-Player");
        wohnzimmerGeraete.add("Licht");
        wohnzimmerGeraete.add("Klimaanlage");
        wohnzimmerGeraete.add("Rollladen");

        kuechenGeraete.add("Kühlschrank");
        kuechenGeraete.add("Herd");
        kuechenGeraete.add("Kochbuch");
        kuechenGeraete.add("Licht");
        kuechenGeraete.add("Klimaanlage");
        kuechenGeraete.add("Rollladen");

        badGeraete.add("Dusche");
        badGeraete.add("Whirlpool");
        badGeraete.add("Fön");
        badGeraete.add("Licht");
        badGeraete.add("Klimaanlage");
        badGeraete.add("Rollladen");

        bueroGeraete.add("Telefon");
        bueroGeraete.add("Notizblock");
        bueroGeraete.add("TV");
        bueroGeraete.add("Licht");
        bueroGeraete.add("Klimaanlage");
        bueroGeraete.add("Rollladen");


        eins = (Button) findViewById(R.id.button_room_device1);
        zwei = (Button) findViewById(R.id.button_room_device2);
        drei = (Button) findViewById(R.id.button_room_device3);
        vier = (Button) findViewById(R.id.button_room_device4);
        fuenf = (Button) findViewById(R.id.button_room_device5);
        sechs = (Button) findViewById(R.id.button_room_device6);

        eins.setBackgroundColor(Color.WHITE);
        eins.setTextSize(35);
        zwei.setBackgroundColor(Color.WHITE);
        zwei.setTextSize(35);
        drei.setBackgroundColor(Color.WHITE);
        drei.setTextSize(35);
        vier.setBackgroundColor(Color.WHITE);
        vier.setTextSize(35);
        fuenf.setBackgroundColor(Color.WHITE);
        fuenf.setTextSize(35);
        sechs.setBackgroundColor(Color.WHITE);
        sechs.setTextSize(35);

        eins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (room.equals("Wohnzimmer")){
                    Intent intent = new Intent(RoomActivity.this, DeviceTVActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
                else if (room.equals("Kueche")){
                    Intent intent = new Intent(RoomActivity.this, DeviceFridgeActivity.class);
                    startActivity(intent);
                }
                else if (room.equals("Buero")){
                    Intent intent = new Intent(RoomActivity.this, DeviceShowerActivity.class);
                    startActivity(intent);
                }
                else if (room.equals("Bad")){
                    Intent intent = new Intent(RoomActivity.this, DeviceTelephoneActivity.class);
                    startActivity(intent);
                }
            }
        });

        zwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (room.equals("Wohnzimmer")){
                    Intent intent = new Intent(RoomActivity.this, DeviceHifiActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
                /*
                else if (room.equals("Kueche")){
                    Intent intent = new Intent(RoomActivity.this, DeviceFridgeActivity.class);
                    startActivity(intent);
                }
                else if (room.equals("Buero")){
                    Intent intent = new Intent(RoomActivity.this, DeviceShowerActivity.class);
                    startActivity(intent);
                }
                else if (room.equals("Bad")){
                    Intent intent = new Intent(RoomActivity.this, DeviceTelephoneActivity.class);
                    startActivity(intent);
                }
                */
            }
        });




        vier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, DeviceLightActivity.class);
                intent.putExtra("room", room);
                startActivity(intent);
            }
        });

        fuenf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, DeviceACActivity.class);
                intent.putExtra("room", room);
                startActivity(intent);
            }
        });

        sechs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, DeviceBlindActivity.class);
                intent.putExtra("room", room);
                startActivity(intent);
            }
        });


        switch (room){
            case "Wohnzimmer":
                eins.setText(wohnzimmerGeraete.get(0));
                zwei.setText(wohnzimmerGeraete.get(1));
                drei.setText(wohnzimmerGeraete.get(2));
                vier.setText(wohnzimmerGeraete.get(3));
                fuenf.setText(wohnzimmerGeraete.get(4));
                sechs.setText(wohnzimmerGeraete.get(5));
                break;

            case "Kueche":
                eins.setText(kuechenGeraete.get(0));
                zwei.setText(kuechenGeraete.get(1));
                drei.setText(kuechenGeraete.get(2));
                vier.setText(kuechenGeraete.get(3));
                fuenf.setText(kuechenGeraete.get(4));
                sechs.setText(kuechenGeraete.get(5));
                break;

            case "Buero":
                eins.setText(bueroGeraete.get(0));
                zwei.setText(bueroGeraete.get(1));
                drei.setText(bueroGeraete.get(2));
                vier.setText(bueroGeraete.get(3));
                fuenf.setText(bueroGeraete.get(4));
                sechs.setText(bueroGeraete.get(5));
                break;

            case "Bad":
                eins.setText(badGeraete.get(0));
                zwei.setText(badGeraete.get(1));
                drei.setText(badGeraete.get(2));
                vier.setText(badGeraete.get(3));
                fuenf.setText(badGeraete.get(4));
                sechs.setText(badGeraete.get(5));
                break;
        }





    }
}
