package com.example.user.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nHeightEditText,nWeightEditText;
    private Button nCalculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        nWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        nCalculateButton = (Button) findViewById(R.id.calculate_button);
        nCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(nHeightEditText.getText().toString());
                Double weight = Double.valueOf(nWeightEditText.getText().toString());
                Double bmi = weight/((height/100)*(height/100));
                String bmiText = getBmiText(bmi);
                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
                intent.putExtra("bmi_value",bmi);
                intent.putExtra("bmi_text",bmiText);
                startActivity(intent);
            }
        });
    }

    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi<18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi<25){
            bmiText = "น้ำหนักปกติ";
        }else if(bmi<30){
            bmiText= "น้ำหนักมาากกว่าปกติ (ท้วม)";
        }else{
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return  bmiText;
    }

}
