package com.example.sree.currencyconverterassignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyConversion extends AppCompatActivity
{
    Button convertCurrency;
    EditText usdAmount;
    EditText inrAmount;
    double amount,result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conversion);

        usdAmount = (EditText)findViewById(R.id.usdAmount);
        inrAmount = (EditText)findViewById(R.id.inrAmount);

        convertCurrency = (Button)findViewById(R.id.convertCurrency);
        //currency convertion
        convertCurrency.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                amount = 0;
                result = 0;
                if (usdAmount.getText().toString().equals(""))
                {
                    if(inrAmount.getText().toString().equals(""))
                        return;
                }
                if(!(usdAmount.getText().toString().equals("")) && inrAmount.getText().toString().equals(""))
                {
                    amount = Double.parseDouble(usdAmount.getText().toString());
                    result = amount * 63.89;
                    inrAmount.setText(String.format("%.2f",result));
                }
                else if(!(inrAmount.getText().toString().equals("")) && usdAmount.getText().toString().equals(""))
                {
                    amount = Double.parseDouble(inrAmount.getText().toString());
                    result = amount * 0.016;
                    usdAmount.setText(String.format("%.2f",result));
                }
                else if(!(usdAmount.getText().toString().equals("")) && usdAmount.hasFocus())
                {
                    amount = Double.parseDouble(usdAmount.getText().toString());
                    result = amount * 63.89;
                    inrAmount.setText(String.format("%.2f",result));
                }
                else if(!(inrAmount.getText().toString().equals("")) && inrAmount.hasFocus())
                {
                    amount = Double.parseDouble(inrAmount.getText().toString());
                    result = amount * 0.016;
                    usdAmount.setText(String.format("%.2f",result));
                }
            }
        });
        usdAmount.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if(actionId== EditorInfo.IME_ACTION_DONE)
                {
                    usdAmount.requestFocus();
                }
                return false;
            }
        });
    }
}
