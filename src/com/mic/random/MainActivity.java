package com.mic.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {
    int         eventNumber;
    String      result = "error";
    double      poss[];
    String      events[];
    TableLayout tableLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        eventNumber = getIntent().getIntExtra("eventNumber", -1);
        poss = new double[eventNumber];
        events = new String[eventNumber];
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        for (int i = 0; i < eventNumber; i++) {
            TableRow tableRow = new TableRow(this);
            EditText editTextEvent = new EditText(this);
            EditText editTextPoss = new EditText(this);
            editTextPoss.setInputType(InputType.TYPE_CLASS_NUMBER);
            tableRow.addView(editTextEvent);
            tableRow.addView(editTextPoss);
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }
    
    public void startClicked(View v) {
        getData();
        result=calculate();
        Log.i("dj", result);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);        
    }
    
    public void backClicked(View v) {
        startActivity(new Intent(this, NumberChosenActivity.class));
        finish();
    }
    
    public void getData() {
        for (int i = 0; i < eventNumber; i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i+1);
            String eventString = ((EditText) tableRow.getChildAt(0)).getText()
                .toString();
            String possString = ((EditText) tableRow.getChildAt(1)).getText()
                .toString();
            
            events[i] = eventString;
            poss[i] = Double.parseDouble(possString);
        }
    }
    
    public String calculate() {
        double random = Math.random()*100;
        Log.i("dj", "random:"+random);
        double min = 0;
        double max = poss[0];
        for (int i = 0; i < poss.length; i++) {
            if (min <= random && random < max) {
                return events[i];
            }
            min = max;
            max = max + poss[i + 1];
        }
        return "unknown";   
    }
}
