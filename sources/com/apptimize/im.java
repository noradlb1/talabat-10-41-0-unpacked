package com.apptimize;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class im extends io {

    /* renamed from: a  reason: collision with root package name */
    private BitmapDrawable f43067a;

    public im(iq iqVar, BitmapDrawable bitmapDrawable) {
        super(iqVar);
        this.f43067a = bitmapDrawable;
    }

    public BitmapDrawable a() {
        return this.f43067a;
    }

    public String b() {
        return "image";
    }

    public void a(ih ihVar) {
        ihVar.b(this.f43067a);
    }

    public Drawable a(io ioVar) {
        return this.f43067a;
    }
}
