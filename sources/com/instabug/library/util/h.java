package com.instabug.library.util;

import android.app.Activity;
import android.view.ViewTreeObserver;

class h implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f52065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f52066b;

    public h(j jVar) {
        this.f52066b = jVar;
        this.f52065a = jVar.b((Activity) jVar.f52068b.get());
    }

    public void onGlobalLayout() {
        j jVar = this.f52066b;
        boolean b11 = jVar.b((Activity) jVar.f52068b.get());
        if (b11 != this.f52065a) {
            this.f52066b.a(b11);
            this.f52065a = b11;
        }
    }
}
