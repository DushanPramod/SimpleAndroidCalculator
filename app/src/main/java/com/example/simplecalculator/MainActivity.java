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

    public void onAnswer(View v) {

        double ans = 0;
        String buildNum = "";
        String str = display.getText().toString();

        char lastOp = '+';

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '+' || c == '-' || c == '/' || c == 'x') {

                if(lastOp == '+'){
                    ans += Double.parseDouble(buildNum);
                }
                else if(lastOp == '-'){
                    ans -= Double.parseDouble(buildNum);
                }
                else if(lastOp == '/'){
                    ans /= Double.parseDouble(buildNum);
                }
                else {
                    ans *= Double.parseDouble(buildNum);
                }
                lastOp = c;
                buildNum = "";
            } else {
                buildNum += c;
            }
            Log.d("ans", String.valueOf(buildNum));
        }


        if(lastOp == '+'){
            ans += Double.parseDouble(String.valueOf(buildNum));
        }
        else if(lastOp == '-'){
            ans -= Double.parseDouble(String.valueOf(buildNum));
        }
        else if(lastOp == '/'){
            ans /= Double.parseDouble(String.valueOf(buildNum));
        }
        else {
            ans *= Double.parseDouble(String.valueOf(buildNum));
        }

        Log.d("ans", String.valueOf(ans));
        display.setText(String.valueOf(ans));
    }

    public void onDisplayClear(View v) {
        display.setText("0");
    }

    public void onDeleteLastChar(View v) {
        String str = display.getText().toString();
        if (str.length() == 1) display.setText("0");
        else display.setText(str.substring(0, str.length() - 1));
    }

    public void onPressDot(View v) {
        String str = display.getText().toString();
        char lastChar = str.charAt(str.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == 'x') {
            str += "0";
        }
        str += ".";
        display.setText(str);
    }

    public void onNumberButtonClick(View v) {
        Button b = (Button) v;
        String str = display.getText().toString();
        char lastChar = str.charAt(str.length() - 1);
        Log.d("press", str);
        if (str.equals("0")) {
            str = b.getText().toString();
        } else {
            if ((lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == 'x') && b.getText().charAt(0) == '0') {
                String replace = str.replace(lastChar, b.getText().charAt(0));
                str += b.getText().toString() + ".";
            } else {
                str += b.getText().toString();
            }

        }

        display.setText(str);
    }

    public void onOparationClick(View v) {
        Button b = (Button) v;
        String str = display.getText().toString();
        char lastChar = str.charAt(str.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == 'x') {
            String replace = str.replace(lastChar, b.getText().charAt(0));
            str = replace;
        } else {
            str += b.getText().toString();
        }
        display.setText(str);
    }

}