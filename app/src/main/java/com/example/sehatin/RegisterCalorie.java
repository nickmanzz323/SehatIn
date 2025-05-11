package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class RegisterCalorie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_calorie);

        Intent recieverIntent = getIntent();

        String user_name = recieverIntent.getStringExtra("USER_NAME");
        String user_email = recieverIntent.getStringExtra("USER_EMAIL");
        String user_password = recieverIntent.getStringExtra("USER_PASSWORD");

        String user_active = recieverIntent.getStringExtra("USER_ACTIVE");
        String user_goal = recieverIntent.getStringExtra("USER_GOAL");
        String user_gender = recieverIntent.getStringExtra("USER_GENDER");

        int user_age = recieverIntent.getIntExtra("USER_AGE", 0);
        int user_weight = recieverIntent.getIntExtra("USER_WEIGHT", 0);
        int user_height = recieverIntent.getIntExtra("USER_HEIGHT", 0);

        int user_calorie;
        TextView backButton = findViewById(R.id.backButton);

        TextView text_userCalorie = findViewById(R.id.text_userCalories);
        TextView text_userProtein = findViewById(R.id.text_userProtein);
        TextView text_userCarbs = findViewById(R.id.text_userCarbs);
        TextView text_userFats = findViewById(R.id.text_userFats);

        Button doneButton = findViewById(R.id.button);

        // Hitung BMR (kalori dasar)
        if (user_gender.equals("Female")) {
            user_calorie = (int) (655.1 + (9.563 * user_weight) + (1.850 * user_height) - (4.676 * user_age));
        } else {
            user_calorie = (int) (66.5 + (13.75 * user_weight) + (5.003 * user_height) - (6.75 * user_age));
        }

        // ini buat hitung
        int user_protein = (int) ((user_calorie * 0.25) / 4);
        int user_carbs = (int) ((user_calorie * 0.6) / 4);
        int user_fats = (int) ((user_calorie * 0.15) / 4);

        //  Display hasil
        text_userCalorie.setText(String.valueOf(user_calorie));
        text_userProtein.setText(String.valueOf(user_protein));
        text_userFats.setText(String.valueOf(user_fats));
        text_userCarbs.setText(String.valueOf(user_carbs));

        // Tombol kembali
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCalorie.this, RegisterAge.class);
                startActivity(intent);
                finish();
            }
        });

        // Tombol done (save)
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inputCalorie = Integer.parseInt(text_userCalorie.getText().toString());
                int updatedProtein = (int) ((inputCalorie * 0.25) / 4);
                int updatedCarbs = (int) ((inputCalorie * 0.6) / 4);
                int updatedFats = (int) ((inputCalorie * 0.15) / 4);

                databaseHelper myDB = new databaseHelper(RegisterCalorie.this);
                myDB.insertUserData(2, user_name, user_email, user_password, user_gender, user_goal, user_active,
                        user_height, user_weight, user_age, inputCalorie);

                // Kirim data ke MainPage
                Intent intent = new Intent(RegisterCalorie.this, MainPage.class);
                intent.putExtra("USER_NAME", user_name);
                intent.putExtra("CALORIES", inputCalorie);
                intent.putExtra("PROTEIN", updatedProtein);
                intent.putExtra("CARBS", updatedCarbs);
                intent.putExtra("FATS", updatedFats);
                startActivity(intent);
                finish();
            }
        });

        // Bottom sheet untuk mengubah kalori manual
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

                recomendCalorie.setText(String.format("Recommended: %d", user_calorie));

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputStr = newUserCalorie.getText().toString().trim();
                        if (inputStr.isEmpty() || Integer.parseInt(inputStr) == 0) {
                            Toast.makeText(RegisterCalorie.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                        } else {
                            int input = Integer.parseInt(inputStr);
                            int newProtein = (int) ((input * 0.25) / 4);
                            int newCarbs = (int) ((input * 0.6) / 4);
                            int newFats = (int) ((input * 0.15) / 4);

                            text_userCalorie.setText(String.valueOf(input));
                            text_userProtein.setText(String.valueOf(newProtein));
                            text_userFats.setText(String.valueOf(newFats));
                            text_userCarbs.setText(String.valueOf(newCarbs));

                            bottomSheetDialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
