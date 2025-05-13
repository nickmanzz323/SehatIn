package com.example.sehatin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView forgotPassword = findViewById(R.id.forgotPassword);
        Button loginButton = findViewById(R.id.buttonLogin);
        Button signUpButton = findViewById(R.id.buttonSignUp);

        EditText input_Email = findViewById(R.id.input_Email);
        EditText input_Password = findViewById(R.id.editTextTextPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginPage.this, "Not Available", Toast.LENGTH_SHORT).show();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterGeneral.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = String.valueOf(input_Email.getText().toString().trim());
                String userPassword = String.valueOf(input_Password.getText().toString().trim());
                databaseHelper db = new databaseHelper(LoginPage.this);

                Boolean correctLogin = db.checkUserPassword(userEmail, userPassword);
                Cursor cursor = db.searchUserData(userEmail, userPassword);

                if(correctLogin && cursor.moveToFirst()) {
                    Intent intent = new Intent(LoginPage.this, MainPage.class);
                    intent.putExtra("USER_EMAIL", userEmail);
                    intent.putExtra("USER_PASSWORD", userPassword);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginPage.this, "Wrong Email or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}