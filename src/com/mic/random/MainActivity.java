package com.mic.random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class MainActivity extends Activity {
    int         eventNumber;
    String      result;
    double      poss[];
    String      events[];
    TableLayout tableLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    
    public void addClicked(View v) {
        TableRow tableRow = new TableRow(this);
        EditText editTextEvent = new EditText(this);
        LayoutParams LP1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.4f);
        LayoutParams LP2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.2f);
        EditText editTextPoss = new EditText(this);
        editTextPoss.setInputType(InputType.TYPE_CLASS_NUMBER);
        Button buttonDel = new Button(this);
        buttonDel.setText(R.string.del);
        buttonDel.setOnClickListener(new DelClickListener(tableRow));
        tableRow.addView(editTextEvent, LP1);
        tableRow.addView(editTextPoss, LP1);
        tableRow.addView(buttonDel, LP2);
        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    
    class DelClickListener implements OnClickListener {
        private View mTableRow;
        
        public DelClickListener(TableRow tableRow) {
            // TODO Auto-generated constructor stub
            mTableRow = tableRow;
        }
        
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            tableLayout.removeViewInLayout(mTableRow);
            // tableLayout.refreshDrawableState();
            tableLayout.requestLayout();
            
        }
    }
    
    public void resetClicked(View v) {
        init();
    }
    
    public void startClicked(View v) {
        eventNumber = tableLayout.getChildCount() - 1;
        poss = new double[eventNumber];
        events = new String[eventNumber];
        getData();
        showResult();
    }
    
    public void getData() {
        for (int i = 0; i < eventNumber; i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i + 1);
            String eventString = ((EditText) tableRow.getChildAt(0)).getText()
                .toString();
            String possString = ((EditText) tableRow.getChildAt(1)).getText()
                .toString();
            
            events[i] = eventString;
            poss[i] = Double.parseDouble(possString);
        }
    }
    
    public String calculate() {
        double random = Math.random() * 100;
        Log.i("dj", "random:" + random);
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
    
    public void init() {
        setContentView(R.layout.main);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        eventNumber = 0;
        result = "error";
    }
    public void showResult(){
        final AlertDialog.Builder outerDialog = new AlertDialog.Builder(this);
        outerDialog.setTitle("Result");
        outerDialog.setMessage(getString(R.string.please)+calculate());
        outerDialog.setPositiveButton("again",
          new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
               showResult();
           }
          });
        outerDialog.setNegativeButton("ok",
          new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
           }
          });
        
        outerDialog.create().show();
    }
}
