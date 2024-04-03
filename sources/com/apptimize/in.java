package com.apptimize;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class in extends io {

    /* renamed from: a  reason: collision with root package name */
    private int f43068a;

    public in(iq iqVar, int i11) {
        super(iqVar);
        this.f43068a = i11;
    }

    public int a() {
        return this.f43068a;
    }

    public void a(ih ihVar) {
    }

    public String b() {
        return "color";
    }

    public Drawable a(io ioVar) {
        return new ColorDrawable(this.f43068a);
    }
}
