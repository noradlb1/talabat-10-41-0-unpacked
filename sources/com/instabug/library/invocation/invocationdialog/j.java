package com.instabug.library.invocation.invocationdialog;

import android.view.animation.Animation;
import android.widget.ListView;

class j implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListView f51302b;

    public j(l lVar, ListView listView) {
        this.f51302b = listView;
    }

    public void onAnimationEnd(Animation animation) {
        this.f51302b.setVerticalScrollBarEnabled(true);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f51302b.setVerticalScrollBarEnabled(false);
    }
}
