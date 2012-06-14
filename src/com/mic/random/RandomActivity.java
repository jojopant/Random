package com.mic.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class RandomActivity extends Activity {
    EditText textNumber;
    Button   buttonNext;
    int      eventNumber;
    
    Button   buttonStart;
    Button   buttonBack;
    Button   buttonExit;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.number_chosen);
        
        textNumber = (EditText) findViewById(R.id.number);
        // buttonNext = (Button) findViewById(R.id.next);
        // buttonNext.setOnClickListener(this);
        
    }
    
    public void nextClicked(View v) {
        eventNumber = Integer.parseInt(textNumber.getText().toString());
        // setContentView(R.layout.main);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("eventNumber", eventNumber);
        startActivity(intent);
        
    }
    
    //
    // @Override
    // public void onClick(View v) {
    // // TODO Auto-generated method stub
    //
    // int id = v.getId();
    // switch (id) {
    // case R.id.next: {
    //
    // }
    // case R.id.start: {
    //
    // }
    // case R.id.back:{
    // setContentView(R.layout.number_chosen);
    // }
    // case R.id.quit:{
    // System.exit(0);
    // }
    // }
    //
    // }
}