package com.example.sehatin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
public class ViewPagerAdapter extends PagerAdapter{
    Context context;

    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
    };

    int[] headings = {
            R.string.heading_1,
            R.string.heading_2,
            R.string.heading_3,
            R.string.heading_4
    };

    int[] description = {
            R.string.desc_1,
            R.string.desc_2,
            R.string.desc_3,
            R.string.desc_4
    };

    @Override
    public int getCount() {
        return  headings.length;
    }

    public ViewPagerAdapter(Context context){
        this.context = context;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideTitleImage = view.findViewById(R.id.titleImage);
        TextView slideHeading = view.findViewById(R.id.text_Title);
        TextView slideDescription = view.findViewById(R.id.text_Description);

        slideTitleImage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    }
}
