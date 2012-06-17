package com.mic.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class NumberChosenActivity extends Activity {
    
    EditText textNumber;
    Button   buttonNext;
    int      eventNumber;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.number_chosen);
        
        textNumber = (EditText) findViewById(R.id.number);      
    }
    
    public void nextClicked(View v) {
        if(textNumber.getText().toString().equals("")) return;
        eventNumber = Integer.parseInt(textNumber.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("eventNumber", eventNumber);
        startActivity(intent);  
        finish();
    }
}