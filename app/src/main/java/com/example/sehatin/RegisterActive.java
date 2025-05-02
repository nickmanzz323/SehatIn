package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActive extends AppCompatActivity {

    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_active);

        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        Button sedentaryButton = findViewById(R.id.btn_Sedentary);
        sedentaryButton.setTag(false);

        Button lowActiveButton = findViewById(R.id.btn_LowActive);
        lowActiveButton.setTag(false);

        Button activeButton = findViewById(R.id.btn_Active);
        activeButton.setTag(false);

        Button veryActiveButton = findViewById(R.id.btn_VeryActive);
        veryActiveButton.setTag(false);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActive.this, RegisterGender.class);
                startActivity(intent);
                finish();
            }
        });

        sedentaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) sedentaryButton.getTag();
                sedentaryButton.setTag(isActive);

                if(isActive){
                    sedentaryButton.setBackgroundResource(R.drawable.button_pressed);
                    lowActiveButton.setEnabled(false);
                    activeButton.setEnabled(false);
                    veryActiveButton.setEnabled(false);
                    option = 1;
                }else{
                    sedentaryButton.setBackgroundResource(R.drawable.button_unpressed);
                    lowActiveButton.setEnabled(true);
                    activeButton.setEnabled(true);
                    veryActiveButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        lowActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) lowActiveButton.getTag();
                lowActiveButton.setTag(isActive);

                if(isActive){
                    lowActiveButton.setBackgroundResource(R.drawable.button_pressed);
                    sedentaryButton.setEnabled(false);
                    activeButton.setEnabled(false);
                    veryActiveButton.setEnabled(false);
                    option = 2;
                }else{
                    lowActiveButton.setBackgroundResource(R.drawable.button_unpressed);
                    sedentaryButton.setEnabled(true);
                    activeButton.setEnabled(true);
                    veryActiveButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        activeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) activeButton.getTag();
                activeButton.setTag(isActive);

                if(isActive){
                    activeButton.setBackgroundResource(R.drawable.button_pressed);
                    sedentaryButton.setEnabled(false);
                    lowActiveButton.setEnabled(false);
                    veryActiveButton.setEnabled(false);
                    option = 3;
                }
                else{
                    activeButton.setBackgroundResource(R.drawable.button_unpressed);
                    sedentaryButton.setEnabled(true);
                    lowActiveButton.setEnabled(true);
                    veryActiveButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        veryActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) veryActiveButton.getTag();
                veryActiveButton.setTag(isActive);

                if(isActive){
                    veryActiveButton.setBackgroundResource(R.drawable.button_pressed);
                    sedentaryButton.setEnabled(false);
                    lowActiveButton.setEnabled(false);
                    activeButton.setEnabled(false);
                    option = 4;
                }
                else{
                    veryActiveButton.setBackgroundResource(R.drawable.button_unpressed);
                    sedentaryButton.setEnabled(true);
                    lowActiveButton.setEnabled(true);
                    activeButton.setEnabled(true);
                    option = 0;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent senderIntent = new Intent(RegisterActive.this, RegisterCalorie.class);
                Intent nextIntent = new Intent(RegisterActive.this, RegisterHeight.class);

                switch(option){
                    case 0:
                        Toast.makeText(RegisterActive.this, "Choose one!", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        senderIntent.putExtra("USER_ACTIVE", "Sedentary");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 2:
                        senderIntent.putExtra("USER_ACTIVE", "Low Active");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 3:
                        senderIntent.putExtra("USER_ACTIVE", "Active");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 4:
                        senderIntent.putExtra("USER_ACTIVE", "Very Active");
                        startActivity(nextIntent);
                        finish();
                        break;
                }
            }
        });
    }
}