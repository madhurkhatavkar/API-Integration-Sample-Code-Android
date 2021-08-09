package com.smsAlert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
//import smsAlert.R;
import smsAlert.SMSALERT;     /* import sms alert api  */


public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);


        //Create SMS ALERT object with username and password
        SMSALERT msgSmsAlert = new SMSALERT("YOUR_USERNAME_HERE","YOUR_PASSWORD_HERE");

        //If you want to use API key for authentication uncomment below line.
        //SMSALERT msgSmsAlert = new SMSALERT("YOUR_APIKEY_HERE"); //Add your SMS Alert API key

        // compose message with senderid and text-message
        msgSmsAlert.composeMessage("CVDEMO", "This Sample message body that will be sent with sender id : CVDEMO");

        // .to(String) : will send message to single mobile number
        msgSmsAlert.to("8010551055");

        // NOTE : Before calling this function you MUST call .composeMessage & .to
        String sendStatus = msgSmsAlert.send();
        text.setText("Send Status : " + sendStatus);
    }
}
