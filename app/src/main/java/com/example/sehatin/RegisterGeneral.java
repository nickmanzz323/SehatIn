package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterGeneral extends AppCompatActivity {

    public void moveToRegisterGoal(String name, String password, String email){
        userRegistrationData userData = new userRegistrationData();
        userData.setName(name);
        userData.setPassword(password);
        userData.setEmail(email);

        Intent intent = new Intent(RegisterGeneral.this, RegisterGoal.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_general);

        ImageView backButton = findViewById(R.id.prevButton);
        ImageView nextButton = findViewById(R.id.saveButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterGeneral.this, RegisterOption.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user_name = findViewById(R.id.input_Name);
                EditText user_password = findViewById(R.id.editTextTextPassword);
                EditText user_email = findViewById(R.id.input_Email);

                String name = String.valueOf(user_name.getText());
                String password = String.valueOf(user_password.getText());
                String email = String.valueOf(user_email.getText());

                moveToRegisterGoal(name, password, email);
            }
        });
    }
}