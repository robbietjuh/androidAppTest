package com.framboos.socialweather.socialweather.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.framboos.socialweather.socialweather.R;
import com.framboos.socialweather.socialweather.ScreenSlidePageFragment;
import com.framboos.socialweather.socialweather.ViewPagerListener;
import com.framboos.socialweather.socialweather.fragments.IntroFragment;

public class PhotoContainerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The photo_container_view is a placeholder view, which will get filled by a ViewPager
        // which will enable us to show multiple views by swiping left/right.
        setContentView(R.layout.photo_container_view);

        // We need to set up a ViewPager that will handle the user's touch events, such as
        // swiping left and right, to switch pages.
        ViewPager pagerView = (ViewPager) findViewById(R.id.photo_container_view);

        // The ViewPager needs an adapter that returns the pages that are available.
        // This is something like a delegate in iOS. Let's set it up:
        PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pagerView.setAdapter(pagerAdapter);

        // Let's listen for events on the pagerView
        pagerView.addOnPageChangeListener(new ViewPagerListener());

        // We won't have to initialize anything else here. The PhotoContainer is literally
        // a container; all logic shall be in the containing controllers, such as the
        // IntroController and PhotoController.
//        View beneathView = (View) findViewById(R.id.imageView);//the view that beneath blur view
//        View blurView= (View) findViewById(R.id.blurredOverlay);//blur View
//
//        BlurDrawable blurDrawable = new BlurDrawable(beneathView, 20);
//
//        blurView.setBackground(blurDrawable);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        // We want to set this up as a class var so we don't have to re-create it every time
        // the user goes to position==0. Saves some CPU time at the cost of a little memory.
        IntroFragment introFragment = new IntroFragment();

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // TODO: fetch this from a shared data model instance
            return (position == 0) ? this.introFragment : new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            // TODO: fetch this from a shared data model instance
            return 5;
        }
    }

//    public Bitmap blurBitmap(Bitmap bitmap) {
//
//        //Let's create an empty bitmap with the same size of the bitmap we want to blur
//        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//
//        //Instantiate a new Renderscript
//        RenderScript rs = RenderScript.create(getApplicationContext());
//
//        //Create an Intrinsic Blur Script using the Renderscript
//        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
//
//        //Create the in/out Allocations with the Renderscript and the in/out bitmaps
//        Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
//        Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
//
//        //Set the radius of the blur
//        blurScript.setRadius(25.f);
//
//        //Perform the Renderscript
//        blurScript.setInput(allIn);
//        blurScript.forEach(allOut);
//
//        //Copy the final bitmap created by the out Allocation to the outBitmap
//        allOut.copyTo(outBitmap);
//
//        //recycle the original bitmap
//        bitmap.recycle();
//
//        //After finishing everything, we destroy the Renderscript.
//        rs.destroy();
//
//        return outBitmap;
//    }
}
