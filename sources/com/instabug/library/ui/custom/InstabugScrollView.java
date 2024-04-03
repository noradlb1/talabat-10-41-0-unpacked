package com.instabug.library.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.annotation.Nullable;

public class InstabugScrollView extends ScrollView {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public OnScrollListener f51958b;

    public interface OnScrollListener {
        void onBottomReached();

        void onScrolling();

        void onTopReached();
    }

    public InstabugScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        OnScrollListener onScrollListener;
        OnScrollListener onScrollListener2;
        OnScrollListener onScrollListener3;
        int bottom = getChildAt(getChildCount() - 1).getBottom() - (getHeight() + getScrollY());
        if (bottom == 0 && (onScrollListener3 = this.f51958b) != null) {
            onScrollListener3.onBottomReached();
        } else if (getScrollY() == 0 && (onScrollListener2 = this.f51958b) != null) {
            onScrollListener2.onTopReached();
        } else if (bottom > 0 && (onScrollListener = this.f51958b) != null) {
            onScrollListener.onScrolling();
        }
        super.onScrollChanged(i11, i12, i13, i14);
    }

    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.f51958b = onScrollListener;
    }

    public InstabugScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstabugScrollView(Context context) {
        super(context);
    }
}
