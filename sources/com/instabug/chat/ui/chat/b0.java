package com.instabug.chat.ui.chat;

import android.graphics.Bitmap;

class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f46189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f46190c;

    public b0(c0 c0Var, Bitmap bitmap) {
        this.f46190c = c0Var;
        this.f46189b = bitmap;
    }

    public void run() {
        this.f46190c.f46195a.f46197c.setImageBitmap(this.f46189b);
        d0 d0Var = this.f46190c.f46195a;
        if (d0Var.f46198d && d0Var.f46199e.f46221g) {
            this.f46190c.f46195a.f46199e.f46219e.setSelection(this.f46190c.f46195a.f46199e.getCount() - 1);
            boolean unused = this.f46190c.f46195a.f46199e.f46221g = false;
        }
    }
}
