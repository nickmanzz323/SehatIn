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
    IntroViewPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Lanjut untuk selangkah lebih sehat", R.drawable.img1, "Selamat Datang !"));
        mList.add(new ScreenItem("Catat kalori harian anda dengan mudah ", R.drawable.img2, "Calories Tracking"));
        mList.add(new ScreenItem("Scan makanan untuk mengetahui kalori secara otomatis", R.drawable.img3, "Food Scaning"));
        mList.add(new ScreenItem("Dapatkan rekomendasi makanan & olahraga terbaik", R.drawable.img4, "Food & Sports "));

        screenPager = findViewById(R.id.screen_viewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
    }
}