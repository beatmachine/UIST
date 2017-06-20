package de.uulm.uist.uistinterface;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Activity for the Notizblock logic
 * Created on 20.06.2017 by Tim Mend
 */
public class DeviceNotizblockActivity extends AppCompatActivity {

    //region Constants
    public static final String FILE_NAME = "de.uulm.uist.userinterface.CHAT_MESSAGES";
    //endregion

    //region Declaration
    Button speichern;

    EditText notiz;

    ImageButton left,right;

    int index = 0;

    ArrayList<String> notizen = new ArrayList<>();

    BufferedReader reader;

    FileOutputStream stream;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_notizblock);

        //region Initialization

        speichern = (Button) findViewById(R.id.notizblock_button_speichern);

        notiz = (EditText) findViewById(R.id.notizblock_plaintext_notizen);


        left = (ImageButton) findViewById(R.id.notizblock_imagebutton_left);
        right= (ImageButton) findViewById(R.id.notizblock_imagebutton_right);

        File file = new File(this.getFilesDir(), FILE_NAME);
        if(!file.exists()) {
            file = new File(this.getFilesDir(), FILE_NAME);
        }

        //Load all saved messages
        if(!file.isDirectory() && file.exists()){
            notizen = loadMessages(getApplicationContext());
        }

        if(notizen.size() != 0){
            notiz.setText(notizen.get(0));
        }
        //endregion





        //region Listener
        /**
         * Set a Listener for the Speichern Button
         */
        speichern.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region SpeichernCondition
                String _notiz = (notiz.getText().toString());
                if (!_notiz.equals("")){
                   saveMessage(_notiz, getApplicationContext());
                }
                //endregion
            }
        });

        /**
         * Set a Listener for the left Button
         */
        left.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region SpeichernCondition
                if(index == 0){
                    index = notizen.size() - 1;
                }
                String _notiz = notizen.get(index);
                notiz.setText(_notiz);

                index -= 1;
                //endregion
            }
        });
        /**
         * Set a Listener for the right Button
         */
        right.setOnClickListener(new View.OnClickListener() {
            /**
             * This will be called if the Button is clicked
             * @param v The view where the click comes from
             */
            @Override
            public void onClick(View v) {
                //region SpeichernCondition
                if(index == notizen.size()){
                    index = 0;
                }
                String _notiz = notizen.get(index);
                notiz.setText(_notiz);

                index += 1;
                //endregion
            }
        });


        //endregion
    }


    //region MessageHandler
    /**
     * This will save a Notiz in an internal File. Or Append it to others
     * @param message The message which should be saved
     * @param context The context from where openFileOutput can be called
     */
    public void saveMessage(String message, Context context){
        //Create String to read it out later
        notizen.add(message);
        String _message = message
                + "\n";
        try{
            stream = context.openFileOutput(FILE_NAME, Context.MODE_APPEND);
            stream.write(_message.getBytes());
            stream.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This Method will load all Messages from an internal File and put them in an ArrayList
     * @param context The Application Context
     * @return the ArrayList which will be returned
     */
    public ArrayList<String> loadMessages(Context context){
        ArrayList<String> tmp = new ArrayList<>();
        try {
            FileInputStream input= context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(input);
            reader = new BufferedReader(isr);
            String line = reader.readLine();
            while(line != null) {
                String message = line;
                tmp.add(message);
                line = reader.readLine();
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tmp;
    }

    //endregion
}
