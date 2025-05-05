package com.example.sehatin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class RegisterCalorie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_calorie);

        Intent recieverIntent = getIntent();

        // RegisterGeneral
        String user_name = recieverIntent.getStringExtra("USER_NAME");
        String user_email = recieverIntent.getStringExtra("USER_EMAIL");
        String user_password = recieverIntent.getStringExtra("USER_PASSWORD");

        String user_active = recieverIntent.getStringExtra("USER_ACTIVE");
        String user_goal = recieverIntent.getStringExtra("USER_GOAL");
        String user_gender = recieverIntent.getStringExtra("USER_GENDER");

        int user_age = recieverIntent.getIntExtra("USER_AGE", 0);
        int user_weight = recieverIntent.getIntExtra("USER_WEIGHT", 0);
        int user_height = recieverIntent.getIntExtra("USER_HEIGHT", 0);

        Log.d("RegisterCalorie", "USER_NAME: " + user_name);
        Log.d("RegisterCalorie", "USER_EMAIL: " + user_email);
        Log.d("RegisterCalorie", "USER_PASSWORD: " + user_password);
        Log.d("RegisterCalorie", "USER_ACTIVE: " + user_active);
        Log.d("RegisterCalorie", "USER_GOAL: " + user_goal);
        Log.d("RegisterCalorie", "USER_GENDER: " + user_gender);
        Log.d("RegisterCalorie", "USER_AGE: " + user_age);
        Log.d("RegisterCalorie", "USER_WEIGHT: " + user_weight);
        Log.d("RegisterCalorie", "USER_HEIGHT: " + user_height);
    }
}