package com.framboos.socialweather.socialweather;

import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

public class ViewPagerListener implements ViewPager.OnPageChangeListener {
    private int previousPage = 0;

    public ViewPagerListener() {
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        Log.w("ViewPagerListener", "Position: " + position + "\n offset: " + offset + "\n offsetPixels: " + offsetPixels);


    }

    @Override
    public void onPageScrollStateChanged(int state) { }

    @Override
    public void onPageSelected(int position) {
        previousPage = position;
    }
}
