package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterGeneral extends AppCompatActivity {

    public void moveToRegisterGoal(String name, String password, String email){
        Intent nextIntent = new Intent(RegisterGeneral.this, RegisterGoal.class);
        nextIntent.putExtra("USER_NAME", name);
        nextIntent.putExtra("USER_PASSWORD", password);
        nextIntent.putExtra("USER_EMAIL", email);
        startActivity(nextIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_general);

        ImageView backButton = findViewById(R.id.prevButton);
        ImageView nextButton = findViewById(R.id.saveButton);

        EditText user_name = findViewById(R.id.input_Name);
        EditText user_password = findViewById(R.id.editTextTextPassword);
        EditText user_email = findViewById(R.id.input_Email);

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
                String name = String.valueOf(user_name.getText().toString().trim());
                String password = String.valueOf(user_password.getText().toString().trim());
                String email = String.valueOf(user_email.getText().toString().trim());

                if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
                    Toast.makeText(RegisterGeneral.this, "Box cant be empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseHelper db = new databaseHelper(RegisterGeneral.this);
                    Boolean checkEmail = db.checkEmail(email);
                    if(!checkEmail){
                        moveToRegisterGoal(name, password, email);
                    }
                    else{
                        Toast.makeText(RegisterGeneral.this, "Email already used!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}