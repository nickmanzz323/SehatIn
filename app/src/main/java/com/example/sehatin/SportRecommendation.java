package com.example.sehatin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SportRecommendation extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportsrecommendation_page);

        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("USER_EMAIL");
        String userPassword = intent.getStringExtra("USER_PASSWORD");
        databaseHelper userDataDB = new databaseHelper(SportRecommendation.this);
        Cursor userDataCursor = userDataDB.searchUserData(userEmail, userPassword);

        TextView userNameTextView = findViewById(R.id.usernameTextView);
        userDataCursor.moveToFirst();
        String userName = userDataCursor.getString(1);

        userNameTextView.setText(userName);

        ImageView homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportRecommendation.this, MainPage.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });

        View sport1 = findViewById(R.id.sport1);
        sport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportRecommendation.this, olahragaRingan.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });

    }
}
