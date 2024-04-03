package com.instabug.library.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class InstabugViewPager extends ViewPager {
    private boolean autoHeight = false;
    private boolean swipeable = true;

    public InstabugViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.swipeable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void onMeasure(int i11, int i12) {
        if (this.autoHeight) {
            int i13 = 0;
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                View childAt = getChildAt(i14);
                childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i13) {
                    i13 = measuredHeight;
                }
            }
            if (i13 != 0) {
                i12 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            }
        }
        super.onMeasure(i11, i12);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.swipeable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void scrollBackward(boolean z11) {
        scrollBackwardWithOffset(z11, 1);
    }

    public void scrollBackwardWithOffset(boolean z11, int i11) {
        if (getAdapter() != null && getCurrentItem() > 0) {
            setCurrentItem(getCurrentItem() - i11, z11);
        }
    }

    public void scrollForward(boolean z11) {
        if (getAdapter() != null && getAdapter().getCount() - 1 > getCurrentItem()) {
            setCurrentItem(getCurrentItem() + 1, z11);
        }
    }

    public void setAutoHeight(boolean z11) {
        this.autoHeight = z11;
    }

    public void setSwipeable(boolean z11) {
        this.swipeable = z11;
    }
}
