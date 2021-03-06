package com.example.darshilbhayani.meetup_group1mobileapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

Context context;
LayoutInflater layoutInflater;

public SliderAdapter(Context context){
    this.context = context;
}

public int[] slide_images = {
        R.drawable.travel,
        R.drawable.sleep,
        R.drawable.rocket,
};

public String[] slide_heading ={
        "Travel",
        "Meet",
        "Explore",
};

public  String[] slide_body = {

       "Travel makes one modest. You see what a tiny place you occupy in the world." + "",
               "Let us always meet each other with smile, for the smile is the beginning of love.\n" ,
               "Life is an experiment in which you may fail or succeed. Explore more, expect least. "
};


@Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
    layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slidebody = (TextView) view.findViewById(R.id.slide_body);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slidebody.setText(slide_body[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem (ViewGroup container , int position , Object object){


//    container.removeView(RelativeLayout)object);
        ((ViewPager) container).removeView((ConstraintLayout) object);
}
}
