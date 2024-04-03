package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;

class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f46232b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f46233c;

    public m(n nVar, Bitmap bitmap) {
        this.f46233c = nVar;
        this.f46232b = bitmap;
    }

    public void run() {
        if (this.f46233c.f46234a.f46235b.f46238c != null) {
            this.f46233c.f46234a.f46235b.a(this.f46232b);
        }
    }
}
