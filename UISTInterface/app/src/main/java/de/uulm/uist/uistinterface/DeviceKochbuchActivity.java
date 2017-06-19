package de.uulm.uist.uistinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Activity for the Kochbuch of the App
 */
public class DeviceKochbuchActivity extends AppCompatActivity {
    //region Constants
    private final String de_uulm_uist_uistinterface_KOCHREZEPTWASSER = "Ein Glass Wasser\n" +
            "Für ein Glass Wasser benötigt man einen Wasserhahn sowie ein Glas. Nun öffnete man" +
            "Wasserhahn und schenkt sich ein leckeres Glas Wasser ein" +
            "\n" +
            "Zubereitungszeit: 45 min" +
            "\n" +
            "Schwierigkeit: Einfach";
    private final String getDe_uulm_uist_uistinterface_KOCHREZEPTPUDDING ="Ein Pudding\n"+
            "Für einen Pudding benötigst du eine Packung Puddingpulver und ein Glas Wasser" +
            "zum aufkochen. Dies dauert etwas eine halbe Stunde danach kannst du ihn in den " +
            "Kühlschrank stellen damit er abkühlt." +
            "\n" +
            "Zubereitungszeit: 30 min" +
            "\n" +
            "Schwierigkeit: Veteran";
    //endregion

    //region Declaration
    ImageButton kochbuch_links, kochbuch_rechts;

    TextView kochbuch_rezepte;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_kochbuch);

        //region Initialization
        kochbuch_links = (ImageButton) findViewById(R.id.kochbuch_device_imagebutton_links);
        kochbuch_rechts= (ImageButton) findViewById(R.id.kochbuch_device_imagebutton_rechts);

        kochbuch_rezepte = (TextView) findViewById(R.id.kochbuch_device_textview_rezepte);

        kochbuch_rezepte.setText(de_uulm_uist_uistinterface_KOCHREZEPTWASSER);
        //endregion

        //region Listener
        /**
         * Set a Listener for the left Button
         */
        kochbuch_links.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                if(!kochbuch_rezepte.getText().equals(de_uulm_uist_uistinterface_KOCHREZEPTWASSER))
                kochbuch_rezepte.setText(de_uulm_uist_uistinterface_KOCHREZEPTWASSER);

                else{
                    kochbuch_rezepte.setText(getDe_uulm_uist_uistinterface_KOCHREZEPTPUDDING);
                }
                }


        });

        /**
         * Set a Listener for the play Button
         */
        kochbuch_rechts.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {

                if(!kochbuch_rezepte.getText().equals(de_uulm_uist_uistinterface_KOCHREZEPTWASSER)){
                    kochbuch_rezepte.setText(de_uulm_uist_uistinterface_KOCHREZEPTWASSER);
                 }
                 else
                {
                    kochbuch_rezepte.setText(getDe_uulm_uist_uistinterface_KOCHREZEPTPUDDING);
                }

            }
        });
        //endregion
    }
}
