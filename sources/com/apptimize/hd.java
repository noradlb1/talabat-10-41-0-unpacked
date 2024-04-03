package com.apptimize;

import android.view.View;
import java.lang.reflect.Method;

public class hd extends gk {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42913a = "hd";

    /* renamed from: b  reason: collision with root package name */
    private final hg f42914b;

    /* renamed from: c  reason: collision with root package name */
    private final hj<?, ?, ?> f42915c;

    /* renamed from: d  reason: collision with root package name */
    private Method f42916d;

    public hd(hg hgVar, hj hjVar, Method method) {
        this.f42914b = hgVar;
        this.f42915c = hjVar;
        this.f42916d = method;
    }

    public void a(Method method, Object obj, Object[] objArr) {
        if (!(obj instanceof View)) {
            bo.e(f42913a, String.format("Unexpected %s; expecting View ", new Object[]{obj}));
            return;
        }
        hf b11 = this.f42914b.b((View) obj);
        if (b11 != null) {
            b11.a(this.f42915c, method);
        }
    }
}
