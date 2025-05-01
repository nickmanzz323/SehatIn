package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterGoal extends AppCompatActivity {
    int option = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_goal);


        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        Button loseWeightButton = findViewById(R.id.btn_LoseWeight);
        loseWeightButton.setTag(false);

        Button keepWeightButton = findViewById(R.id.btn_KeepWeight);
        keepWeightButton.setTag(false);

        Button gainWeightButton = findViewById(R.id.btn_GainWeight);
        gainWeightButton.setTag(false);

        loseWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) loseWeightButton.getTag();
                loseWeightButton.setTag(isActive);

                if(isActive){
                    loseWeightButton.setBackgroundResource(R.drawable.button_pressed);
                    keepWeightButton.setEnabled(false);
                    gainWeightButton.setEnabled(false);
                    option = 1;
                }else{
                    loseWeightButton.setBackgroundResource(R.drawable.button_unpressed);
                    keepWeightButton.setEnabled(true);
                    gainWeightButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        keepWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) keepWeightButton.getTag();
                keepWeightButton.setTag(isActive);

                if(isActive){
                    keepWeightButton.setBackgroundResource(R.drawable.button_pressed);
                    loseWeightButton.setEnabled(false);
                    gainWeightButton.setEnabled(false);
                    option = 2;
                }else{
                    keepWeightButton.setBackgroundResource(R.drawable.button_unpressed);
                    loseWeightButton.setEnabled(true);
                    gainWeightButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        gainWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) gainWeightButton.getTag();
                gainWeightButton.setTag(isActive);

                if(isActive){
                    gainWeightButton.setBackgroundResource(R.drawable.button_pressed);
                    keepWeightButton.setEnabled(false);
                    loseWeightButton.setEnabled(false);
                    option = 3;
                }else{
                    gainWeightButton.setBackgroundResource(R.drawable.button_unpressed);
                    keepWeightButton.setEnabled(true);
                    loseWeightButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent senderIntent = new Intent(RegisterGoal.this, RegisterCalorie.class);
                Intent nextIntent = new Intent(RegisterGoal.this, RegisterGender.class);

                switch(option){
                    case 0:
                        Toast.makeText(RegisterGoal.this, "Choose one!", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        senderIntent.putExtra("USER_GOAL", "Loose Weight");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 2:
                        senderIntent.putExtra("USER_GOAL", "Keep Weight");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 3:
                        senderIntent.putExtra("USER_GOAL", "Gain Weight");
                        startActivity(nextIntent);
                        finish();
                        break;
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterGoal.this, RegisterGeneral.class);
                startActivity(intent);
                finish();
            }
        });
    }
}