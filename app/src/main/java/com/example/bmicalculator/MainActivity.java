package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculate;
    TextView currentheight;
    TextView currentage, currentweight;
    ImageView increamentage, increamentweight, decreamentage, decreamentweight;
    SeekBar seekbarforheight;
    RelativeLayout male,female;

    int intweight = 55;
    int intage = 22;
    int currentprogress;
    String mprogress = "200";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mcalculate = findViewById(R.id.calculate);
        currentage = findViewById(R.id.currentAge);
        currentweight = findViewById(R.id.currentWeight);
        currentheight = findViewById(R.id.currentHeight);
        increamentage = findViewById(R.id.inc_age);
        decreamentage = findViewById(R.id.dec_age);
        increamentweight = findViewById(R.id.inc_weight);
        decreamentweight = findViewById(R.id.dec_weight);
        seekbarforheight = findViewById(R.id.seekBarH);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_notfocus));
                typeofuser= "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_notfocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                typeofuser= "Female";
            }
        });

        seekbarforheight.setMax(400);
        seekbarforheight.setProgress(200);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mprogress= String.valueOf(currentprogress);
                currentheight.setText(mprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        increamentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage+1;
                age2 = String.valueOf(intage);
                currentage.setText(age2);
            }
        });

        decreamentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                currentage.setText(age2);
            }
        });


        increamentweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });

        decreamentweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });



        mcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeofuser.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your Gender first", Toast.LENGTH_SHORT).show();

                }
                else if(mprogress.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your Height first", Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 || intage<0){
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 || intweight<0){
                    Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent =new Intent(MainActivity.this,BMI.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);

                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}