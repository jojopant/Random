package com.mic.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class RandomActivity extends Activity implements OnClickListener {
	EditText textNumber;
	Button buttonNext;
	int eventNumber;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.number_chosen);
        
        textNumber = (EditText)findViewById(R.id.number);
        buttonNext = (Button)findViewById(R.id.next);
        buttonNext.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == buttonNext){
			eventNumber = Integer.parseInt(textNumber.getText().toString());
	        setContentView(R.layout.main);
		}

	}
}