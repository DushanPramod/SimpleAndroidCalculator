package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double number1, number2;
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.answareText);
    }

    public void onNumberButtonClick(View v) {
        Button b = (Button) v;
        String str =  display.getText().toString();
        Log.d("press",str);
        if(str.equals("0"))  str = b.getText().toString();
        else str += b.getText().toString();

        display.setText(str);
    }

}