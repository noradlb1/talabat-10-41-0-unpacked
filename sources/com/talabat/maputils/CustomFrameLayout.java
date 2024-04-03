package com.talabat.maputils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class CustomFrameLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public IDragCallback dragListener;
    private GestureDetector gestureDetector;

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (CustomFrameLayout.this.dragListener == null) {
                return false;
            }
            CustomFrameLayout.this.dragListener.onDrag();
            return false;
        }
    }

    public interface IDragCallback {
        void onDrag();
    }

    public CustomFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        return false;
    }
}
