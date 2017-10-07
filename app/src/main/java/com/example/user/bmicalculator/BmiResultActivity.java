package com.example.user.bmicalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("bmi_value",0);
        String bmitext = intent.getStringExtra("bmi_text");
        TextView textBmi = (TextView)findViewById(R.id.textBmi1);
        textBmi.setText(String.format("ค่า ฺBMI ทีไ่ด้ คือ %.2f \n\n อยู่ในเกณฑ์ : %s",bmi,bmitext));
    }
}
