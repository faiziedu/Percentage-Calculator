package com.example.percentagecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
    private Context context; // Declare a variable to store the context
    TextView totalTextView;
    EditText percentageTxt;
    EditText numberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext(); // Assign the context in onCreate() method


        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageTxt = (EditText) findViewById(R.id.percentageTxt);
        numberTxt = (EditText) findViewById(R.id.numberTxt);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String percent = percentageTxt.getText().toString();
                String num = numberTxt.getText().toString();
                if (TextUtils.isEmpty(percent)) {
                    Toast.makeText(context, "Enter Percentage", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(num)) {
                    Toast.makeText(context, "Enter Number", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform calculation and display result
                    float percentage = Float.parseFloat(percentageTxt.getText().toString());
                    float dec = percentage / 100;
                    float total = dec * Float.parseFloat(numberTxt.getText().toString());
                    totalTextView.setText(Float.toString(total));

                }

            }
        });
    }
}
