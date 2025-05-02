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
                String user_weight = String.valueOf(weight.getText().toString().trim());
                Intent nextIntent = new Intent(RegisterWeight.this, RegisterAge.class);
                Intent senderIntent = new Intent(RegisterWeight.this, RegisterCalorie.class);

                if(user_weight.isEmpty()){
                    Toast.makeText(RegisterWeight.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    senderIntent.putExtra("USER_WEIGHT", user_weight);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
    }
}