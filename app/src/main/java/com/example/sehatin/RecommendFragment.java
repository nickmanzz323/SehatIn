package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button; // atau bisa View jika tombol bukan Button

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecommendFragment extends Fragment {

    public RecommendFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate layout untuk fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Tombol close
        ImageView closeButton = view.findViewById(R.id.close_button);
        closeButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity()
                        .getSupportFragmentManager()
                        .popBackStack();
            }
        });

        // Tombol foodRecommend
        View foodRecommendButton = view.findViewById(R.id.foodRecommend);
        foodRecommendButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                MainPage mainPage = (MainPage) getActivity();
                String userEmail = mainPage.userEmail;
                String userPassword = mainPage.userPassword;
                Intent intent = new Intent(getActivity(), FoodRecommendation.class);
                intent.putExtra("USER_EMAIL", userEmail);
                intent.putExtra("USER_PASSWORD", userPassword);
                startActivity(intent);
            }
        });

        View sportRecommendButton = view.findViewById(R.id.imageView12);
        sportRecommendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    MainPage mainPage = (MainPage) getActivity();
                    String userEmail = mainPage.userEmail;
                    String userPassword = mainPage.userPassword;
                    Intent intent = new Intent(getActivity(), SportRecommendation.class);
                    intent.putExtra("USER_EMAIL", userEmail);
                    intent.putExtra("USER_PASSWORD", userPassword);
                    startActivity(intent);
                }
            }
        });
    }
}
