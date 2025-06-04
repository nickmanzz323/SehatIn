package com.example.sehatin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAddMeal extends Fragment {

    public FragmentAddMeal() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_makanan_grams, container, false);


        View darkOverlay = view.findViewById(R.id.darkOverlay);

        // Set an OnClickListener for the dark overlay
        darkOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                }
            }
        });

        Button btnCancel = view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                }
            }
        });


        TextView dialogTitle = view.findViewById(R.id.dialogTitle);
        TextView tvTotalCalories = view.findViewById(R.id.tv_total_calories_dialog);
        TextView tvTotalProteins = view.findViewById(R.id.tv_total_proteins_dialog);
        TextView tvTotalFats = view.findViewById(R.id.tv_total_fats_dialog);
        TextView tvTotalCarbs = view.findViewById(R.id.tv_total_carbs_dialog);
        EditText etGramsInput = view.findViewById(R.id.et_grams_input);
        TextView tvGramsLabel = view.findViewById(R.id.tv_grams_label);
        Button btnOk = view.findViewById(R.id.btn_ok);

        // ... Add logic for other buttons or views as needed ...

        return view;
    }
}