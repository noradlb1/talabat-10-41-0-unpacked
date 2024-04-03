package com.apptimize;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.reflect.Method;

public class ie<V extends View> implements iw<io, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43016a = "ie";

    /* renamed from: b  reason: collision with root package name */
    private ih f43017b;

    /* renamed from: c  reason: collision with root package name */
    private iw<Drawable, V> f43018c;

    public ie(ih ihVar, iw<Drawable, V> iwVar) {
        this.f43017b = ihVar;
        this.f43018c = iwVar;
    }

    public Class<V> b() {
        return this.f43018c.b();
    }

    public Method a() throws NoSuchMethodException {
        return this.f43018c.a();
    }

    public void a(V v11, io ioVar) throws hk {
        io a11 = a(v11);
        a11.a(this.f43017b);
        this.f43018c.a(v11, ioVar.b(a11));
    }

    public io a(V v11) throws hk {
        return ip.a(this.f43018c.a(v11));
    }
}
