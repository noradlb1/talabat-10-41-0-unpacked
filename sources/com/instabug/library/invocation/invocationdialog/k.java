package com.instabug.library.invocation.invocationdialog;

import android.view.animation.Animation;
import android.widget.ListView;

class k implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListView f51303b;

    public k(l lVar, ListView listView) {
        this.f51303b = listView;
    }

    public void onAnimationEnd(Animation animation) {
        this.f51303b.setVerticalScrollBarEnabled(true);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f51303b.setVerticalScrollBarEnabled(false);
    }
}
