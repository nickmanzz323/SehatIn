package com.example.sehatin;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class IntroPage extends AppCompatActivity {

    private ViewPager screenPager;
    IntroPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        List<IntroItem> mList = new ArrayList<>();
        mList.add(new IntroItem("Selamat Datang!", "Lanjut untuk selangkah lebih sehat", R.drawable.img1));
        mList.add(new IntroItem("Calories Tracking", "Catat kalori harian anda dengan mudah", R.drawable.img2));
        mList.add(new IntroItem("Food Scanning", "Scan makanan untuk mengetahui kalori secara otomatis", R.drawable.img3));
        mList.add(new IntroItem("Food & Sport", "Dapatkan rekomendasi makanan & olahraga terbaik", R.drawable.img4));

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

    }
}