package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }

            }
        });

    }

    private void updatText(String strToAdd){

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }


    public void zeroBTN(View view){
        updatText("0");

    }

    public void oneBTN(View view){
        updatText("1");

    }

    public void twoBTN(View view){
        updatText("2");

    }

    public void threeBTN(View view){
        updatText("3");

    }

    public void fourBTN(View view){
        updatText("4");

    }

    public void fiveBTN(View view){
        updatText("5");

    }

    public void sixBTN(View view){
        updatText("6");

    }

    public void sevenBTN(View view){
        updatText("7");

    }

    public void eightBTN(View view){
        updatText("8");

    }

    public void nineBTN(View view){
        updatText("9");

    }

    public void clearBTN(View view){
        display.setText("");

    }

    public void exponentBTN(View view){
        updatText("^");

    }

    public void parenthesesBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closePar += 1;
            }
        }

        if (openPar == closePar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updatText("(");
//            display.setSelection(cursorPos + 1);
        }
        else if (closePar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updatText(")");
//            display.setSelection(cursorPos + 1);
        }
        display.setSelection(cursorPos + 1);

    }

    public void divideBTN(View view){
        updatText("÷");

    }

    public void multiplyBTN(View view){
        updatText("×");

    }

    public void addBTN(View view){
        updatText("+");

    }

    public void subtractBTN(View view){
        updatText("-");

    }

    public void plusMinusBTN(View view){
        updatText("-");

    }

    public void pointBTN(View view){
        updatText(".");

    }

    public void equalsBTN(View view){
    String userExp = display.getText().toString();

    userExp = userExp.replaceAll("÷", "/");
    userExp = userExp.replaceAll("×", "*");

    Expression exp = new Expression(userExp);

    String result = String.valueOf(exp.calculate());

    display.setText(result);
    display.setSelection(result.length());

    }

    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

}