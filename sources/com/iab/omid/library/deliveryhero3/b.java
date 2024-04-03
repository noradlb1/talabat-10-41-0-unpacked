package com.iab.omid.library.deliveryhero3;

import android.content.Context;
import com.iab.omid.library.deliveryhero3.internal.f;
import com.iab.omid.library.deliveryhero3.internal.h;
import com.iab.omid.library.deliveryhero3.utils.a;
import com.iab.omid.library.deliveryhero3.utils.c;
import com.iab.omid.library.deliveryhero3.utils.e;
import com.iab.omid.library.deliveryhero3.utils.g;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44934a;

    private void b(Context context) {
        g.a((Object) context, "Application Context cannot be null");
    }

    public String a() {
        return "1.4.8-Deliveryhero3";
    }

    public void c(Context context) {
        b(context);
        if (!e()) {
            d(true);
            h.c().a(context);
            com.iab.omid.library.deliveryhero3.internal.b.g().a(context);
            a.a(context);
            c.a(context);
            e.a(context);
            f.b().a(context);
            com.iab.omid.library.deliveryhero3.internal.a.a().a(context);
        }
    }

    public void d(boolean z11) {
        this.f44934a = z11;
    }

    public boolean e() {
        return this.f44934a;
    }

    public void f() {
        g.a();
        com.iab.omid.library.deliveryhero3.internal.a.a().d();
    }
}
