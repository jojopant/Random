package com.mic.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        resultText=(TextView)findViewById(R.id.result);
        String result=getIntent().getStringExtra("result");
        Log.i("dj", "ddd"+result);
        resultText.setText(result);
        
    }
    public void backClicked(View v) {
        finish();
    }
    public void quitClicked(View v) {
        finish();
  
    }
}
