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

        // Ambil data dari intent sebelumnya
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

        // Inisialisasi view
        TextView backButton = findViewById(R.id.backButton);
        TextView text_userCalorie = findViewById(R.id.text_userCalories);
        TextView text_userProtein = findViewById(R.id.text_userProtein);
        TextView text_userCarbs = findViewById(R.id.text_userCarbs);
        TextView text_userFats = findViewById(R.id.text_userFats);
        Button doneButton = findViewById(R.id.button);

        // Hitung kalori awal berdasarkan gender
        int user_calorie;
        if ("Female".equals(user_gender)) {
            user_calorie = (int) (655.1 + (9.563 * user_weight) + (1.850 * user_height) - (4.676 * user_age));
        } else {
            user_calorie = (int) (66.5 + (13.75 * user_weight) + (5.003 * user_height) - (6.75 * user_age));
        }

        int user_protein = (int) ((user_calorie * 0.25) / 4);
        int user_carbs = (int) ((user_calorie * 0.6) / 4);
        int user_fats = (int) ((user_calorie * 0.15) / 4);

        // Tampilkan ke UI
        text_userCalorie.setText(String.valueOf(user_calorie));
        text_userProtein.setText(String.valueOf(user_protein));
        text_userFats.setText(String.valueOf(user_fats));
        text_userCarbs.setText(String.valueOf(user_carbs));

        // Tombol kembali
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterCalorie.this, RegisterAge.class);
            startActivity(intent);
            finish();
        });

        // Tombol selesai
        doneButton.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterCalorie.this, MainPage.class);

            // Kirim semua data ke MainPage
            intent.putExtra("USER_NAME", user_name);
            intent.putExtra("USER_HEIGHT", user_height);
            intent.putExtra("USER_WEIGHT", user_weight);
            intent.putExtra("CALORIES", Integer.parseInt(text_userCalorie.getText().toString()));
            intent.putExtra("PROTEIN", Integer.parseInt(text_userProtein.getText().toString()));
            intent.putExtra("CARBS", Integer.parseInt(text_userCarbs.getText().toString()));
            intent.putExtra("FATS", Integer.parseInt(text_userFats.getText().toString()));

            // Simpan ke database
            databaseHelper myDB = new databaseHelper(RegisterCalorie.this);
            myDB.insertUserData(
                    3,
                    user_name,
                    user_email,
                    user_password,
                    user_gender,
                    user_goal,
                    user_active,
                    user_height,
                    user_weight,
                    user_age,
                    Integer.parseInt(text_userCalorie.getText().toString())
            );

            startActivity(intent);
            finish();
        });

        // Edit manual kalori
        text_userCalorie.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(RegisterCalorie.this);
            View view1 = LayoutInflater.from(RegisterCalorie.this).inflate(R.layout.bottom_sheet_layout, null);
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

            EditText newUserCalorie = view1.findViewById(R.id.editTextCalories);
            TextView recomendCalorie = view1.findViewById(R.id.textViewRecommendation);
            Button changeButton = view1.findViewById(R.id.btnDone);

            recomendCalorie.setText(String.format("Recommended: %d", user_calorie));

            changeButton.setOnClickListener(view -> {
                String inputStr = newUserCalorie.getText().toString().trim();
                if (inputStr.isEmpty()) {
                    Toast.makeText(RegisterCalorie.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int input = Integer.parseInt(inputStr);
                int user_protein_manual = (int) ((input * 0.25) / 4);
                int user_carbs_manual = (int) ((input * 0.6) / 4);
                int user_fats_manual = (int) ((input * 0.15) / 4);

                text_userCalorie.setText(String.valueOf(input));
                text_userProtein.setText(String.valueOf(user_protein_manual));
                text_userFats.setText(String.valueOf(user_fats_manual));
                text_userCarbs.setText(String.valueOf(user_carbs_manual));
                bottomSheetDialog.dismiss();
            });
        });
    }
}
