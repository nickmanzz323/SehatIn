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

public class RegisterAge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_age);

        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        EditText age = findViewById(R.id.editTextAge);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterAge.this, RegisterWeight.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_age = String.valueOf(age.getText().toString().trim());
                Intent nextIntent = new Intent(RegisterAge.this, RegisterCalorie.class);

                if(user_age.isEmpty()){
                    Toast.makeText(RegisterAge.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    nextIntent.putExtra("USER_AGE", user_age);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
    }
}