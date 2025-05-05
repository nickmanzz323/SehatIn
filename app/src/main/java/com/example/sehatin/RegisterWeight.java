package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_weight);

        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        EditText weight = findViewById(R.id.editTextWeight);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterWeight.this, RegisterHeight.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int user_weight = 0;
                user_weight = Integer.parseInt(String.valueOf(weight.getText()));
                Intent nextIntent = new Intent(RegisterWeight.this, RegisterAge.class);
                Intent intent = getIntent();

                if(user_weight == 0){
                    Toast.makeText(RegisterWeight.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    nextIntent.putExtra("USER_NAME", intent.getStringExtra("USER_NAME"));
                    nextIntent.putExtra("USER_EMAIL", intent.getStringExtra("USER_EMAIL"));
                    nextIntent.putExtra("USER_PASSWORD", intent.getStringExtra("USER_PASSWORD"));
                    nextIntent.putExtra("USER_GOAL", intent.getStringExtra("USER_GOAL"));
                    nextIntent.putExtra("USER_GENDER", intent.getStringExtra("USER_GENDER"));
                    nextIntent.putExtra("USER_ACTIVE", intent.getStringExtra("USER_ACTIVE"));
                    nextIntent.putExtra("USER_HEIGHT", intent.getIntExtra("USER_HEIGHT", 100));
                    nextIntent.putExtra("USER_WEIGHT", user_weight);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
    }
}