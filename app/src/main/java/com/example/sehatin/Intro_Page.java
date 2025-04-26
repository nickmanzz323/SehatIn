package com.example.sehatin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_Page extends AppCompatActivity {

    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    Button prev_btn, next_btn, skip_btn;

    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    private int getItem(int i){
        return mSLideViewPager.getCurrentItem() + i;
    }

    public void setUpIndicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){
            dots[i] = new TextView(this);
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.button_color,getApplicationContext().getTheme()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        prev_btn = findViewById(R.id.button_prev);
        next_btn = findViewById(R.id.button_next);
        skip_btn = findViewById(R.id.skip_button);

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = mSLideViewPager.getCurrentItem();
                if (currentItem > 0){
                    mSLideViewPager.setCurrentItem(currentItem - 1,true);
                }
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = mSLideViewPager.getCurrentItem();
                if (currentItem < viewPagerAdapter.getCount() - 1)
                    mSLideViewPager.setCurrentItem(currentItem + 1,true);
                else {
                    Intent i = new Intent(Intro_Page.this,MainPage.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intro_Page.this, MainPage.class);
                startActivity(i);
                finish();
            }
        });

        mSLideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new ViewPagerAdapter(this);

        mSLideViewPager.setAdapter(viewPagerAdapter);

        setUpIndicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);

            if (position > 0){
                prev_btn.setVisibility(View.VISIBLE);
            }else {
                prev_btn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}