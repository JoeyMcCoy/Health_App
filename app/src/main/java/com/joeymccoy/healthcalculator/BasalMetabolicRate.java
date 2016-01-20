package com.joeymccoy.healthcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class BasalMetabolicRate extends AppCompatActivity {
    static final double BMR_WEIGHT_MULTIPLIER = 10;
    static final double BMR_HEIGHT_MULTIPLIER = 6.25;
    static final int SUB = 5;
    static final int ADD_MEN = 5;
    static final int SUBTRACT_WOMEN = 161;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;
    EditText weightText;
    EditText heightText;
    EditText ageText;
    Button calculate_bmr_btn;
    TextView bmrResult;
    double num1, num2, num3, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basal_metabolic_rate);
        maleRadioButton = (RadioButton) findViewById(R.id.maleRadioBtn);
        femaleRadioButton = (RadioButton) findViewById(R.id.femaleRadioBtn);
        weightText = (EditText) findViewById(R.id.weightTextBmr);
        heightText = (EditText) findViewById(R.id.heightTextBmr);
        ageText = (EditText) findViewById(R.id.ageTextBmr);
        calculate_bmr_btn = (Button) findViewById(R.id.calculate_bmr_btn);
        bmrResult = (TextView) findViewById(R.id.bmrResult);
    }
    public void onClick(View view){
        num1 = Double.parseDouble(weightText.getText().toString());
        num2 = Double.parseDouble(heightText.getText().toString());
        num3 = Double.parseDouble(ageText.getText().toString());
        if(maleRadioButton.isChecked())
        {
            result = (BMR_WEIGHT_MULTIPLIER * (num1/2.20462)) + (BMR_HEIGHT_MULTIPLIER * (num2*2.54)) - (SUB * num3) + ADD_MEN;
            bmrResult.setText("Your BMR Is: " + String.format("%.0f",result) + "Calories/day");
        }
        else if(femaleRadioButton.isChecked())
        {
            result = (BMR_WEIGHT_MULTIPLIER * (num1/2.20462)) + (BMR_HEIGHT_MULTIPLIER * (num2*2.54)) - (SUB * num3) - SUBTRACT_WOMEN;
            bmrResult.setText("Your BMR Is: " + String.format("%.0f",result) + "Calories/day");
        }
       else{Toast.makeText(BasalMetabolicRate.this,
                    "Please specify your gender", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basal_metabolic_rate, menu);
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
