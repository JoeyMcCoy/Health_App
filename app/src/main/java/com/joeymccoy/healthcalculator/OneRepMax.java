package com.joeymccoy.healthcalculator;

import android.app.ActionBar;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;

public class OneRepMax extends AppCompatActivity {
    static final int REPS_COEFFICIENT = 30;
    static final int DIVIDE_BY = 1;
    EditText weightText;
    EditText repsText;
    Button calculate_1rm_btn;
    TextView mResult;
    double num1, num2, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_rep_max);
        weightText = (EditText) findViewById(R.id.weight_text_1rm);
        repsText = (EditText) findViewById(R.id.reps_text_1rm);
        calculate_1rm_btn = (Button) findViewById(R.id.calculate_1rm_btn);
        mResult = (TextView) findViewById(R.id.mResult);

    }

    public void onClick(View view) {
        //weight variable
        num1 = Double.parseDouble(weightText.getText().toString());
        //reps variable
        num2 = Double.parseDouble(repsText.getText().toString());
        double repsAdjusted = (num2/REPS_COEFFICIENT)+DIVIDE_BY;
        result = num1 * repsAdjusted;
        mResult.setText("Your One Rep Max Is: " + String.format("%.2f",result)+ " lbs") ;
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_one_rep_max, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

