package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterGender extends AppCompatActivity {

    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gender);

        TextView backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        Button btn_Male = findViewById(R.id.btn_Male);
        btn_Male.setTag(false);

        Button btn_Female = findViewById(R.id.btn_Female);
        btn_Female.setTag(false);

        btn_Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) btn_Male.getTag();
                btn_Male.setTag(isActive);

                if(isActive){
                    btn_Male.setBackgroundResource(R.drawable.button_pressed);
                    btn_Female.setEnabled(false);
                    option = 1;
                }
                else{
                    btn_Male.setBackgroundResource(R.drawable.button_unpressed);
                    btn_Female.setEnabled(true);
                    option = 0;
                }
            }
        });

        btn_Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isActive = !(boolean) btn_Female.getTag();
                btn_Female.setTag(isActive);

                if(isActive){
                    btn_Female.setBackgroundResource(R.drawable.button_pressed);
                    btn_Male.setEnabled(false);
                    option = 2;
                }
                else{
                    btn_Female.setBackgroundResource(R.drawable.button_unpressed);
                    btn_Male.setEnabled(true);
                    option = 0;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent senderIntent = new Intent(RegisterGender.this, RegisterCalorie.class);
                Intent nextIntent = new Intent(RegisterGender.this, RegisterActive.class);

                switch(option){
                    case 0:
                        Toast.makeText(RegisterGender.this, "Choose one!", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        senderIntent.putExtra("USER_GENDER", "Male");
                        startActivity(nextIntent);
                        finish();
                        break;

                    case 2:
                        senderIntent.putExtra("USER_GENDER", "Female");
                        startActivity(nextIntent);
                        finish();
                        break;
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterGender.this, RegisterGoal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}