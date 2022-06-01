package com.example.rivera_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {

    TextView textemp, texttype, texthours, texttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textemp = findViewById(R.id.textemp);
        texttype = findViewById(R.id.texttype);
        texthours = findViewById(R.id.texthours);
        texttotal = findViewById(R.id.texttotal);

        Intent i = getIntent();
        String texttypes = i.getStringExtra("type");
        String textemp = i.getStringExtra("textemp");
        Double texthoursz = Double.parseDouble(i.getStringExtra("hours"));

        texttype.setText("Employee Name: " + textemp);
        texttype.setText("Employee Type: " + String.valueOf(texttypes));
        texthours.setText("Hours Rendered: " + String.valueOf(texthoursz));

        Double TotalWage = 0.0;


        if(texthoursz > 0.0){

        }
        else{
            if (texttypes.equals("Full.time")) {
                TotalWage = texthoursz * 100;
                texttotal.setText("Total Wagge: " + String.valueOf(TotalWage));

            }
            else if (texttype.equals("Part-time")) {
                TotalWage = texthoursz * 75;
                texttotal.setText("Total Wage: " + String.valueOf(TotalWage));

            }
            else{
                TotalWage = texthoursz * 90;
                texttotal.setText("Total Wage: " +String.valueOf(TotalWage));

            }
            if (texttypes.equals("Probationary")){
                TotalWage = 720 + (100 * (texthoursz - 8.0));
                texttotal.setText("Total Wage with Overtime: " + String.valueOf(TotalWage));

            }

        }
    }
}