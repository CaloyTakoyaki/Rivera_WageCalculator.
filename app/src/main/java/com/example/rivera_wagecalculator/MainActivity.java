package com.example.rivera_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ethours, etemp;
    RadioGroup rgtype;
    RadioButton bselected;
    Button buttonhours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etemp = findViewById(R.id.etemp);
        ethours = findViewById(R.id.ethours);
        rgtype = findViewById(R.id.rgtype);
        buttonhours = findViewById(R.id.buttonhours);
        buttonhours.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

         switch (view.getId()){
             case R.id.buttonhours:
                 int selectedEmployeeType = rgtype.getCheckedRadioButtonId();
                 buttonhours = findViewById(selectedEmployeeType);

                 String type = buttonhours.getText().toString();
                 String name = etemp.getText().toString();
                 String totalHours =  (ethours.getText().toString());

                 Intent intent = new Intent(this, Display.class);

                 intent.putExtra("type",type);
                 intent.putExtra("etemp",name);
                 intent.putExtra("hours",totalHours);
                 startActivity(intent);

                 break;
         }

    }
}