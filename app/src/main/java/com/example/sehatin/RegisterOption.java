package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_option);

        ImageView continueAsGuestButton = findViewById(R.id.guestButton);
        ImageView continueWithEmailButton = findViewById(R.id.continueWithEmailButton);

        continueAsGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect ke MainPage
                Intent intent = new Intent(RegisterOption.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });

        continueWithEmailButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterOption.this, RegisterGeneral.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
