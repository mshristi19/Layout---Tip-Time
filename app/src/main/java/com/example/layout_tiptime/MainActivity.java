package com.example.layout_tiptime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText costEditText;
    private Button calculateButton;
    private TextView roundUpText;
    private RadioGroup radioGroup;
    private Switch switchButton;
    private double Amount;
    private double Percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        costEditText = findViewById(R.id.costEditText);
        calculateButton = findViewById(R.id.calculateButton);
        radioGroup = findViewById(R.id.radioGroup);
        switchButton = findViewById(R.id.switchButton);
        roundUpText = findViewById(R.id.roundUpTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = costEditText.getText().toString();
                int costAmount = Integer.parseInt(cost);
                int radioButtonChecked = radioGroup.getCheckedRadioButtonId();
                
                if(radioButtonChecked == R.id.Amazing){
                    Percent = 0.2;
                } else if (radioButtonChecked == R.id.Good) {
                    Percent = 0.18;
                } else if (radioButtonChecked == R.id.Okay) {
                    Percent = 0.15;
                }else {
                    Percent = 0.0;
                }

                Amount = costAmount * Percent;
                if(switchButton.isChecked()){
                    Amount = Math.round(Amount);
                }

                roundUpText.setText("" + Amount);
            }
        });
    }
}