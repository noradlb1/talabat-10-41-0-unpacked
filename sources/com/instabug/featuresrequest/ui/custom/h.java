package com.instabug.featuresrequest.ui.custom;

import android.view.MotionEvent;
import android.view.View;

class h implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f46707b;

    public h(q qVar) {
        this.f46707b = qVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f46707b.c();
        return false;
    }
}
