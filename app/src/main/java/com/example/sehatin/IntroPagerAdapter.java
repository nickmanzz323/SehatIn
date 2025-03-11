package com.example.sehatin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class IntroPagerAdapter extends PagerAdapter {

    Context mContext;
    List<IntroItem> mListScreen;

    public IntroPagerAdapter(Context mContext, List<IntroItem> mListScreen){
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.intro_layout_screen, null);

        ImageView itemImage = layoutScreen.findViewById(R.id.imageView);
        TextView title = layoutScreen.findViewById(R.id.header_text);
        TextView description = layoutScreen.findViewById(R.id.description_text);

        title.setText(mListScreen.get(position).getTitle());
        description.setText(mListScreen.get(position).getDescription());
        itemImage.setImageResource(mListScreen.get(position).getItemImage());

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    public void destroyItem(@NonNull ViewGroup container, @NonNull int position, @NonNull Object object){
        container.removeView((View)object);
    }
}
