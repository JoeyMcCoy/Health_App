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

public class BodyMassIndex extends AppCompatActivity {
    static final int BMI_MULTIPLIER = 703;
    EditText weightText;
    EditText heightText;
    Button calculate_bmi_btn;
    TextView bmiResult;
    TextView healthTextView;
    double num1, num2, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);
        weightText = (EditText) findViewById(R.id.weightTextBmi);
        heightText = (EditText) findViewById(R.id.heightTextBmi);
        calculate_bmi_btn = (Button) findViewById(R.id.calculate_bmi_btn);
        bmiResult = (TextView) findViewById(R.id.bmiResult);
        healthTextView = (TextView) findViewById(R.id.healthTextView);
    }
    public void onClick(View view){
        //weight variable
        num1 = Double.parseDouble(weightText.getText().toString());
        //height variable
        num2 = Double.parseDouble(heightText.getText().toString());
        double weightAdjusted = num1 * BMI_MULTIPLIER;
        result = weightAdjusted / (num2 * num2);
        bmiResult.setText("Your BMI Is: " + String.format("%.2f",result));
        if(result < 18.5){
            healthTextView.setText("You are considered Underweight");
        }
        else if(result >= 18.5 && result <= 24.9999){
            healthTextView.setText("You are considered Healthy");
        }
        else if(result >= 25 && result <= 29.9999){
            healthTextView.setText("You are considered Overweight");
        }
        else{
            healthTextView.setText("You are considered Obese");
        }
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_body_mass_index, menu);
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
