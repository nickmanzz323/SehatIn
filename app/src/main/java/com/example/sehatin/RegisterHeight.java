package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterHeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_height);

        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        NumberPicker nmb_Height1 = (NumberPicker) findViewById(R.id.nmb_Height);
        NumberPicker nmb_Height2 = (NumberPicker) findViewById(R.id.nmb_Height2);

        nmb_Height1.setMaxValue(3);
        nmb_Height1.setMinValue(1);

        nmb_Height2.setMaxValue(99);
        nmb_Height2.setMinValue(0);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterHeight.this, RegisterWeight.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent nextIntent = new Intent(RegisterHeight.this, RegisterWeight.class);

                int height = nmb_Height1.getValue() * 100 + nmb_Height2.getValue();
                nextIntent.putExtra("USER_NAME", intent.getStringExtra("USER_NAME"));
                nextIntent.putExtra("USER_EMAIL", intent.getStringExtra("USER_EMAIL"));
                nextIntent.putExtra("USER_PASSWORD", intent.getStringExtra("USER_PASSWORD"));
                nextIntent.putExtra("USER_GOAL", intent.getStringExtra("USER_GOAL"));
                nextIntent.putExtra("USER_GENDER", intent.getStringExtra("USER_GENDER"));
                nextIntent.putExtra("USER_ACTIVE", intent.getStringExtra("USER_ACTIVE"));
                nextIntent.putExtra("USER_HEIGHT", height);

                startActivity(nextIntent);
                finish();
            }
        });


    }
}