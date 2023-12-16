package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText weight,heightinft,heightininches;
        TextView textView,textView1;
        Button btn;
        weight = findViewById(R.id.weight);
        heightinft = findViewById(R.id.heightinft);
        heightininches = findViewById(R.id.heightininches);
        btn = findViewById(R.id.click);
        textView = findViewById(R.id.txtdis);
        textView1 = findViewById(R.id.textdis);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt  = Integer.parseInt(weight.getText().toString());
                int htf = Integer.parseInt(heightinft.getText().toString());
                int hti = Integer.parseInt(heightininches.getText().toString());
                int totalheight = htf*12 + hti;
                double totalheightcm = totalheight*2.54;
                double totalheightmetres = totalheightcm/100;
                double Bmi = (wt/(totalheightmetres*totalheightmetres));
                double onedigit = Math.round(Bmi * 10) / 10.0;
                String res = String.valueOf(onedigit);
                textView.setText("BMI: "+res);
                if(Bmi>=25&&Bmi<=29.9)
                {
                    textView1.setText("OVERWEIGHT");
                }
                if(Bmi<18.5)
                {
                    textView1.setText("UNDERWEIGHT");
                }
                if(Bmi>=18.5&&Bmi<=24.9)
                {
                    textView1.setText("HEALTHY WEIGHT");
                }
                if(Bmi>=30)
                {
                    textView1.setText("OBESITY");
                }

            }
        });
    }
}