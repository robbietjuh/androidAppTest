package com.framboos.socialweather.socialweather.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.framboos.socialweather.socialweather.R;

public class PhotoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Return an instance of the photo view for it to be the root view for this fragment
        return inflater.inflate(R.layout.photo_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the scroll view from the layout
        final NestedScrollView scrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);

        // Listen for changes in the scroll state of the scrollView
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // The user has scrolled. We'll need to get the scrollY position and calculate
                // the 'amount' of blur that we want to see.
                float alpha = Math.min(scrollY / 100.0f, 1.0f);
                Log.w("PhotoFragment", "Alpha: " + alpha);
            }
        });

    }
}
