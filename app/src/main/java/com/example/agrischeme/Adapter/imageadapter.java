package com.example.agrischeme.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.agrischeme.R;

public class imageadapter extends PagerAdapter {
    Context mcontext;
    private View view;
    private Object object;

    public imageadapter(Context mcontext) {
        this.mcontext = mcontext;
    }


    public boolean isViewFromObject(View view, Object object) {
        this.view = view;
        this.object = object;
        return view == ((ImageView) object);
    }

    private int[] sliderImageId = new int[]{
            R.drawable.enum_yojna, R.drawable.krishi_sichai_yojna, R.drawable.enum_yojna,R.drawable.pasu_kisan_credit,
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }
}

