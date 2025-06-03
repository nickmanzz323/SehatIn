package com.example.sehatin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodRecommendation extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodrecommendation_page);

        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("USER_EMAIL");
        String userPassword = intent.getStringExtra("USER_PASSWORD");
        Log.d("Test", userEmail);
        Log.d("Test 2", userPassword);
        databaseHelper userDataDB = new databaseHelper(FoodRecommendation.this);
        Cursor userDataCursor = userDataDB.searchUserData(userEmail, userPassword);

        userDataCursor.moveToFirst();
        String userName = userDataCursor.getString(1);

        TextView usernameTextView = findViewById(R.id.usernameTextView);
        usernameTextView.setText(userName);

        View bakso1 = findViewById(R.id.bakso1);
        bakso1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodRecommendation.this, BaksoDetail.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });

        ImageView homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodRecommendation.this, MainPage.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });

    }
}

