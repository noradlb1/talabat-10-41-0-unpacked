package com.instabug.chat.notification;

import android.app.Activity;
import android.graphics.Rect;
import android.view.ViewTreeObserver;

class h implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f46114b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s f46115c;

    public h(s sVar, Activity activity) {
        this.f46115c = sVar;
        this.f46114b = activity;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f46114b.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.f46114b.getWindow().getDecorView().getRootView().getHeight();
        if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
            boolean unused = this.f46115c.f46133c = true;
            return;
        }
        boolean unused2 = this.f46115c.f46133c = false;
        if (this.f46115c.f46134d && !this.f46115c.f46132b) {
            this.f46115c.f();
        }
    }
}
