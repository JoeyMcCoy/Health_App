package com.joeymccoy.healthcalculator;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MaxHeartRate extends AppCompatActivity {
    static final int MHR_STANDARD = 220;
    EditText age_text;
    Button calculate_mhr_btn;
    TextView mhrResult;
    int num1, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_heart_rate);
        age_text = (EditText) findViewById(R.id.age_text);
        calculate_mhr_btn = (Button) findViewById(R.id.calculate_mhr_btn);
        mhrResult = (TextView) findViewById(R.id.mhrResult);
    }
    public void onClick(View view){
        num1 = Integer.parseInt(age_text.getText().toString());
        int result = MHR_STANDARD - num1;
        mhrResult.setText("Your Max Heart Rate is: " + result + " bpm");
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_max_heart_rate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
