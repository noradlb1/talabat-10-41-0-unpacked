package com.instabug.chat.notification;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.view.View;
import com.instabug.library.Instabug;
import com.instabug.library.util.ScreenUtility;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f46106b;

    public b(s sVar) {
        this.f46106b = sVar;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void run() {
        View view = this.f46106b.f46131a != null ? (View) this.f46106b.f46131a.get() : null;
        if (view != null) {
            view.setVisibility(0);
            view.animate().y((float) (ScreenUtility.getScreenHeight(Instabug.getApplicationContext()) - view.getHeight())).setListener((Animator.AnimatorListener) null).start();
            boolean unused = this.f46106b.f46132b = true;
        }
    }
}
