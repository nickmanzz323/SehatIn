package com.example.sehatin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

    Intent recieverIntent;
    String user_name, user_password, user_email, user_goal, user_gender, user_active;
    int user_height, user_weight, user_age, userCalorie, userProtein, userFats, userCarbs;

    TextView backButton, text_userCalorie, text_userProtein, text_userCarbs, text_userFats;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_calorie);

        recieverIntent = getIntent();
        try{
            user_name = recieverIntent.getStringExtra("USER_NAME");
            user_password = recieverIntent.getStringExtra("USER_PASSWORD");
            user_email = recieverIntent.getStringExtra("USER_EMAIL");
            user_goal = recieverIntent.getStringExtra("USER_GOAL");
            user_gender = recieverIntent.getStringExtra("USER_GENDER");
            user_active = recieverIntent.getStringExtra("USER_ACTIVE");
            user_height = Integer.parseInt(recieverIntent.getStringExtra("USER_HEIGHT"));
            user_weight = Integer.parseInt(recieverIntent.getStringExtra("USER_WEIGHT"));
            user_age = Integer.parseInt(recieverIntent.getStringExtra("USER_AGE"));
        }catch(NumberFormatException e){
            Toast.makeText(this, "Failed to read Data", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        backButton = findViewById(R.id.backButton);
        text_userCalorie = findViewById(R.id.text_userCalories);
        text_userProtein = findViewById(R.id.text_userProtein);
        text_userCarbs = findViewById(R.id.text_userCarbs);
        text_userFats = findViewById(R.id.text_userFats);
        doneButton = findViewById(R.id.button);

        calculateAndDisplayMacros(user_gender.equals("Female"));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCalorie.this, RegisterAge.class);
                startActivity(intent);
                finish();
            }
        });

        text_userCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(RegisterCalorie.this);
                View view1 = LayoutInflater.from(RegisterCalorie.this).inflate(R.layout.bottom_sheet_layout, null);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();

                EditText newUserCalorie = view1.findViewById(R.id.editTextCalories);
                TextView recomendCalorie = view1.findViewById(R.id.textViewRecommendation);
                Button changeButton = view1.findViewById(R.id.btnDone);

                recomendCalorie.setText(String.format("Recommended: %d Cal", userCalorie));

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int user_newCalorie = Integer.parseInt(newUserCalorie.getText().toString().trim());
                        if(newUserCalorie.getText().toString().trim().isEmpty()){
                            Toast.makeText(RegisterCalorie.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            userCalorie = user_newCalorie;
                            bottomSheetDialog.dismiss();
                        }
                    }
                });

                bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if(user_gender.equals("Female")){
                            userProtein = (int) ((userCalorie * 0.25)/4);
                            userCarbs = (int) ((userCalorie * 0.6)/4);
                            userFats = (int) ((userCalorie * 0.15)/4);

                            text_userCalorie.setText(String.format("%d Cal", userCalorie));
                            text_userFats.setText(String.format("%d Gram", userFats));
                            text_userCarbs.setText(String.format("%d Gram", userCarbs));
                            text_userProtein.setText(String.format("%d Gram", userProtein));
                        }

                        else{
                            userProtein = (int) ((userCalorie * 0.25)/4);
                            userCarbs = (int) ((userCalorie * 0.6)/4);
                            userFats = (int) ((userCalorie * 0.15)/4);

                            text_userCalorie.setText(String.format("%d Cal", userCalorie));
                            text_userFats.setText(String.format("%d Gram", userFats));
                            text_userCarbs.setText(String.format("%d Gram", userCarbs));
                            text_userProtein.setText(String.format("%d Gram", userProtein));
                        }
                    }
                });
            }
        });
    }


    private void calculateAndDisplayMacros(boolean isFemale) {
        if (isFemale) {
            userCalorie = (int) (655.1 + (9.563 * user_weight) + (1.850 * user_height) - (4.676 * user_age));
        } else {
            userCalorie = (int) (66.5 + (13.75 * user_weight) + (5.003 * user_height) - (6.75 * user_age));
        }

        userProtein = (int) ((userCalorie * 0.25) / 4);
        userCarbs = (int) ((userCalorie * 0.6) / 4);
        userFats = (int) ((userCalorie * 0.15) / 4);

        text_userCalorie.setText(String.format("%d Cal", userCalorie));
        text_userProtein.setText(String.format("%d Gram", userProtein));
        text_userFats.setText(String.format("%d Gram", userFats));
        text_userCarbs.setText(String.format("%d Gram", userCarbs));
    }
}