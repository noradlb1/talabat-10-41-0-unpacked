package com.instabug.library.invocation.invoker;

import android.view.GestureDetector;
import android.view.MotionEvent;

class o extends GestureDetector.SimpleOnGestureListener {
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        if (Math.abs(motionEvent2.getX() - motionEvent.getX()) >= 90.0f || motionEvent2.getY() - motionEvent.getY() <= 90.0f) {
            return false;
        }
        return true;
    }
}
