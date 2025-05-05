package com.example.sehatin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Objects;

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

        if (user_gender.equals("Female")) {
            user_calorie = (int) (655.1 + (9.563 * user_weight) + (1.850 * user_height) - (4.676 * user_age));
        } else {
            user_calorie = (int) (66.5 + (13.75 * user_weight) + (5.003 * user_height) - (6.75 * user_age));
        }

        int user_protein = (int) ((user_calorie * 0.25) / 4);
        int user_carbs = (int) ((user_calorie * 0.6) / 4);
        int user_fats = (int) ((user_calorie * 0.15) / 4);

        text_userCalorie.setText(String.format("%d Cal", user_calorie));
        text_userProtein.setText(String.format("%d Gram", user_protein));
        text_userFats.setText(String.format("%d Gram", user_fats));
        text_userCarbs.setText(String.format("%d Gram", user_carbs));

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
                recomendCalorie.setText(String.format("Recommended: %d Cal", user_calorie));

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int input = 0;
                        input = Integer.valueOf(newUserCalorie.getText().toString().trim());
                        if(input == 0){
                            Toast.makeText(RegisterCalorie.this, "Can't be empty!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            int user_protein = (int) ((input * 0.25) / 4);
                            int user_carbs = (int) ((input * 0.6) / 4);
                            int user_fats = (int) ((user_calorie * 0.15) / 4);

                            text_userCalorie.setText(String.format("%d Cal", input));
                            text_userProtein.setText(String.format("%d Gram", user_protein));
                            text_userFats.setText(String.format("%d Gram", user_fats));
                            text_userCarbs.setText(String.format("%d Gram", user_carbs));
                            bottomSheetDialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}