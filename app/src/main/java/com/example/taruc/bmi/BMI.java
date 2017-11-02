package com.example.taruc.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    private EditText textHeight;
    private EditText textWeight;
    private TextView textViewResult;
    private ImageView imageViewResult;
    private double height;
    private double weight;
    private double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        textHeight = (EditText) findViewById(R.id.editTextHeight);
        textWeight = (EditText) findViewById(R.id.editTextWeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageView);
    }

    public void displayBMI(View view){

        height = Double.parseDouble(textHeight.getText().toString());
        height *= 0.01;

        weight = Double.parseDouble(textWeight.getText().toString());
        bmi = (weight / (height * height));

        textViewResult.setText("BMI : " + String.format("%.2f", bmi));

        if (bmi <= 18.5) {
            imageViewResult.setImageResource(R.drawable.under);
        } else if (bmi >= 25) {
            imageViewResult.setImageResource(R.drawable.over);
        } else if (bmi > 18.5 && bmi < 25) {
            imageViewResult.setImageResource(R.drawable.normal);
        } else {
            imageViewResult.setImageResource(R.drawable.empty);
        }

    }
    //sad
    public void reset(View view){
        textHeight.setText("");
        textWeight.setText("");
        textViewResult.setText("BMI:");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
