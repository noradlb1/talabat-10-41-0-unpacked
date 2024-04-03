package com.instabug.chat.notification;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f46110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f46111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f46112d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f46113e;

    public g(s sVar, View view, Activity activity, FrameLayout.LayoutParams layoutParams, r rVar) {
        this.f46110b = view;
        this.f46111c = activity;
        this.f46112d = layoutParams;
        this.f46113e = rVar;
    }

    public void run() {
        if (this.f46110b.getParent() != null) {
            ((ViewGroup) this.f46110b.getParent()).removeView(this.f46110b);
        }
        ((ViewGroup) this.f46111c.getWindow().getDecorView()).addView(this.f46110b, this.f46112d);
        this.f46110b.postDelayed(this.f46113e, 100);
    }
}
