package com.example.sehatin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class olahragaRingan extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga_ringan_detail);

        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("USER_EMAIL");
        String userPassword = intent.getStringExtra("USER_PASSWORD");
        databaseHelper userDataDB = new databaseHelper(olahragaRingan.this);
        Cursor userDataCursor = userDataDB.searchUserData(userEmail, userPassword);

        ImageView homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(olahragaRingan.this, SportRecommendation.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });

    }
}
