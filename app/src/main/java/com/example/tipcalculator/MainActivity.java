package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billBox;
    private EditText perBox;
    private EditText numBox;
    private EditText tipBox;
    private EditText totalBox;
    private EditText personBox;
    private RadioButton SingleRadio;
    private RadioButton MultipleRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billBox = findViewById(R.id.billBox);
        perBox = findViewById(R.id.perBox);
        numBox = findViewById(R.id.numBox);
        tipBox = findViewById(R.id.tipBox);
        totalBox = findViewById(R.id.totalBox);
        personBox = findViewById(R.id.personBox);
        SingleRadio = findViewById(R.id.SingleRadio);
        MultipleRadio = findViewById(R.id.MultipleRadio);
    }

    public void calculate(View v){
        if(SingleRadio.isChecked()) {
            String input = billBox.getText().toString();
            String input2 = perBox.getText().toString();
            if(input.length() > 0 && input2.length() > 0) {
                double billValue = Double.parseDouble(input);
                double perValue = Double.parseDouble(input2);
                double tipValue = billValue * (perValue*0.01);
                double totalValue = billValue + tipValue;
                tipBox.setText(String.format("%.1f", tipValue));
                totalBox.setText(String.format("%.1f", totalValue));
            }
            else {
                Toast.makeText(this, "One of the Boxes is not filled out", Toast.LENGTH_SHORT).show();
            }
        }
        else if(MultipleRadio.isChecked()){
            String input = billBox.getText().toString();
            String input2 = perBox.getText().toString();
            String input3 = numBox.getText().toString();
            if(input.length() > 0 && input2.length() > 0 && input3.length() > 0) {
                double billValue = Double.parseDouble(input);
                double perValue = Double.parseDouble(input2);
                double numValue = Double.parseDouble(input3);
                double tipValue = billValue * (perValue*0.01);
                double totalValue = billValue + tipValue;
                double personValue = totalValue / numValue;
                tipBox.setText(String.format("%.1f", tipValue));
                totalBox.setText(String.format("%.1f", totalValue));
                personBox.setText(String.format("%.1f", personValue));
            }
            else {
                Toast.makeText(this, "One of the Boxes is not filled out", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
