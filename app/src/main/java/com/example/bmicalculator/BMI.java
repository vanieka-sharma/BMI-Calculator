package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    android.widget.Button mrecalculate;

    TextView bmidisplay,bmicategory,gender;
    Intent intent;
    ImageView imageView;
    String bmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        getSupportActionBar().hide();
        mrecalculate = findViewById(R.id.recalculate);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        bmidisplay=findViewById(R.id.BMI);
        bmicategory = findViewById(R.id.categorie);
        gender = findViewById(R.id.gender);
        background = findViewById(R.id.content);
        imageView = findViewById(R.id.imageview);
        mrecalculate = findViewById(R.id.recalculate);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight= Float.parseFloat(height);
        intweight= Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);
        bmi = Float.toString(intbmi);

        if(intbmi<16){
            bmicategory.setText("Severe Thinnes");
//            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.cross);

        }
        else if(intbmi<16.9 && intbmi>16){
            bmicategory.setText("Moderate Thinnes");
//            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi<18.4 && intbmi>17){
            bmicategory.setText("Mild Thinnes");
//            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi<25 && intbmi>18.4){
                bmicategory.setText("Normal");

                imageView.setImageResource(R.drawable.ok);
            }
        else if(intbmi<29.4 && intbmi>25){
            bmicategory.setText("Overweight");
//            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.warning);
        }
        else {
                bmicategory.setText("Obese");

                imageView.setImageResource(R.drawable.warning);
            }

        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);


        mrecalculate.setOnClickListener(v -> {
            Intent intent = new Intent(BMI.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}