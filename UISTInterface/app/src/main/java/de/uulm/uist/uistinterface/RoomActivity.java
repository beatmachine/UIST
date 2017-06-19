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
    //region Constants
    private static final String de_uulm_uist_uistinterface_WOHNZIMMER = "Wohnzimmer";
    private static final String de_uulm_uist_uistinterface_KUECHE = "Kueche";
    private static final String de_uulm_uist_uistinterface_BUERO = "Buero";
    private static final String de_uulm_uist_uistinterface_BAD = "Bad";
    //endregion

    //region Declaration
    Button eins, zwei, drei, vier, fuenf, sechs;
    LinearLayout l;

    List<String> wohnzimmerGeraete = new ArrayList<>();
    List<String> kuechenGeraete = new ArrayList<>();
    List<String> badGeraete = new ArrayList<>();
    List<String> bueroGeraete = new ArrayList<>();

    String room;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent intent = getIntent();
        room = intent.getStringExtra("room");

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

        //region OnClickListener
        eins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)){
                    Intent intent = new Intent(RoomActivity.this, DeviceTVActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
                else if (room.equals(de_uulm_uist_uistinterface_KUECHE)){
                    Intent intent = new Intent(RoomActivity.this, DeviceFridgeActivity.class);
                    startActivity(intent);
                }
                else if (room.equals(de_uulm_uist_uistinterface_BAD)){
                    Intent intent = new Intent(RoomActivity.this, DeviceShowerActivity.class);
                    startActivity(intent);
                }
                else if (room.equals(de_uulm_uist_uistinterface_BUERO)){
                    Intent intent = new Intent(RoomActivity.this, DeviceTelephoneActivity.class);
                    startActivity(intent);
                }
            }
        });

        /**
         * Set an OnclickListener for the Second Button which will send the Activity to the
         * right Activity
         */
        zwei.setOnClickListener(new View.OnClickListener() {
            /**
             * This Method will send the User to the DeviceHifiActivity after Clicking on Hifi
             * @param v The View where the Click comes from
             */
            @Override
            public void onClick(View v) {
                if(room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)) {
                    Intent intent = new Intent(RoomActivity.this, DeviceHifiActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
            }
        });

        /**
         * Set an OnClickListener for the third Button which will send the Activity to the right
         * Activity
         */
        drei.setOnClickListener(new View.OnClickListener() {
            /**
             * This Method will send the User to the DeviceHifiActivity after Clicking on Hifi
             * @param v The View where the Click comes from
             */
            @Override
            public void onClick(View v) {
                if(room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)) {
                    Intent intent = new Intent(RoomActivity.this, DeviceBlurayPlayerActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
            }
        });


        vier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)) {
                    Intent intent = new Intent(RoomActivity.this, DeviceLightActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
            }
        });

        fuenf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)) {
                    Intent intent = new Intent(RoomActivity.this, DeviceACActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
            }
        });

        sechs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(room.equals(de_uulm_uist_uistinterface_WOHNZIMMER)) {
                    Intent intent = new Intent(RoomActivity.this, DeviceBlindActivity.class);
                    intent.putExtra("room", room);
                    startActivity(intent);
                }
            }
        });
        //endregion

        //region NameSwitch
        switch (room){
            case "Wohnzimmer": this.setTitle("Wohnzimmer");
                eins.setText(wohnzimmerGeraete.get(0));
                zwei.setText(wohnzimmerGeraete.get(1));
                drei.setText(wohnzimmerGeraete.get(2));
                vier.setText(wohnzimmerGeraete.get(3));
                fuenf.setText(wohnzimmerGeraete.get(4));
                sechs.setText(wohnzimmerGeraete.get(5));
                break;

            case "Kueche": this.setTitle("Küche");
                eins.setText(kuechenGeraete.get(0));
                zwei.setText(kuechenGeraete.get(1));
                drei.setText(kuechenGeraete.get(2));
                vier.setText(kuechenGeraete.get(3));
                fuenf.setText(kuechenGeraete.get(4));
                sechs.setText(kuechenGeraete.get(5));
                break;

            case "Buero": this.setTitle("Büro");
                eins.setText(bueroGeraete.get(0));
                zwei.setText(bueroGeraete.get(1));
                drei.setText(bueroGeraete.get(2));
                vier.setText(bueroGeraete.get(3));
                fuenf.setText(bueroGeraete.get(4));
                sechs.setText(bueroGeraete.get(5));
                break;

            case "Bad": this.setTitle("Bad");
                eins.setText(badGeraete.get(0));
                zwei.setText(badGeraete.get(1));
                drei.setText(badGeraete.get(2));
                vier.setText(badGeraete.get(3));
                fuenf.setText(badGeraete.get(4));
                sechs.setText(badGeraete.get(5));
                break;
        }
//endregion




    }
}
