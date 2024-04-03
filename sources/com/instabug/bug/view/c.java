package com.instabug.bug.view;

import android.graphics.drawable.AnimationDrawable;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnimationDrawable f45812b;

    public c(l lVar, AnimationDrawable animationDrawable) {
        this.f45812b = animationDrawable;
    }

    public void run() {
        this.f45812b.start();
    }
}
