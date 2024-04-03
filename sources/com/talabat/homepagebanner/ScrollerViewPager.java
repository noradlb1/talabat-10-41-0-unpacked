package com.talabat.homepagebanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class ScrollerViewPager extends ViewPager {
    private boolean isPagingEnabled = false;

    public ScrollerViewPager(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z11) {
        this.isPagingEnabled = z11;
    }

    public ScrollerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
