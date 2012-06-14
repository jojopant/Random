package com.mic.random;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        for (int i = 0; i < getIntent().getIntExtra("eventNumber", -1); i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < 2; j++) {
                EditText editText = new EditText(this);
                tableRow.addView(editText);
            }
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        }
       
    }
}
