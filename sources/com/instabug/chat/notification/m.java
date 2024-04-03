package com.instabug.chat.notification;

import android.graphics.Bitmap;

class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f46124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f46125c;

    public m(n nVar, Bitmap bitmap) {
        this.f46125c = nVar;
        this.f46124b = bitmap;
    }

    public void run() {
        o oVar = this.f46125c.f46126a;
        oVar.f46130e.a(oVar.f46128c, this.f46124b);
        if (!this.f46125c.f46126a.f46130e.f46132b) {
            this.f46125c.f46126a.f46130e.f();
        } else if (this.f46125c.f46126a.f46129d.getVisibility() != 0) {
            this.f46125c.f46126a.f46129d.setVisibility(0);
        }
    }
}
