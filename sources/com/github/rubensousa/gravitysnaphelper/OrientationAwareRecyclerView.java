package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class OrientationAwareRecyclerView extends RecyclerView {
    private float lastX;
    private float lastY;
    /* access modifiers changed from: private */
    public boolean scrolling;

    public OrientationAwareRecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z12 = true;
        if (actionMasked == 0) {
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
            if (this.scrolling) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(1);
                return super.onInterceptTouchEvent(obtain);
            }
        } else if (actionMasked == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (Math.abs(y11 - this.lastY) > Math.abs(x11 - this.lastX)) {
                z11 = layoutManager.canScrollVertically();
            } else {
                z11 = layoutManager.canScrollHorizontally();
            }
            z12 = z11;
        }
        if (!z12) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public OrientationAwareRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrientationAwareRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.scrolling = false;
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i11) {
                boolean z11;
                super.onScrollStateChanged(recyclerView, i11);
                OrientationAwareRecyclerView orientationAwareRecyclerView = OrientationAwareRecyclerView.this;
                if (i11 != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean unused = orientationAwareRecyclerView.scrolling = z11;
            }
        });
    }
}
