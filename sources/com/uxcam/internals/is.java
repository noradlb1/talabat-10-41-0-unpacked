package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

public class is implements View.OnTouchListener {
    public is(it itVar) {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        hk hkVar = hm.f13568k;
        if (hkVar == null) {
            return false;
        }
        hkVar.a(motionEvent);
        return false;
    }
}
