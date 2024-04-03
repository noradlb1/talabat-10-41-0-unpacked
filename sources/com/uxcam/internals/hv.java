package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class hv implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final View.OnTouchListener f13607a;

    /* renamed from: b  reason: collision with root package name */
    public int f13608b;

    public hv(View.OnTouchListener onTouchListener, int i11) {
        this.f13607a = onTouchListener;
        this.f13608b = i11;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                fj.f13339g = new ArrayList();
            }
            hr hrVar = new hr(view);
            hrVar.f13592d = this.f13608b;
            fj.f13339g.add(hrVar);
            if (this.f13607a != null && Thread.currentThread().getStackTrace()[3].getClassName().equals(View.class.getName())) {
                return this.f13607a.onTouch(view, motionEvent);
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
