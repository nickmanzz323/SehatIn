package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BaksoDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakso_detail_page);

        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("USER_EMAIL");
        String userPassword = intent.getStringExtra("USER_PASSWORD");

        ImageButton closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaksoDetail.this, FoodRecommendation.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
                finish();
            }
        });
    }
}

