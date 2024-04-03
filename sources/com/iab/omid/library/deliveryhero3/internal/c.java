package com.iab.omid.library.deliveryhero3.internal;

import com.iab.omid.library.deliveryhero3.adsession.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f44954c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f44955a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a> f44956b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f44954c;
    }

    public Collection<a> a() {
        return Collections.unmodifiableCollection(this.f44956b);
    }

    public void a(a aVar) {
        this.f44955a.add(aVar);
    }

    public Collection<a> b() {
        return Collections.unmodifiableCollection(this.f44955a);
    }

    public void b(a aVar) {
        boolean d11 = d();
        this.f44955a.remove(aVar);
        this.f44956b.remove(aVar);
        if (d11 && !d()) {
            h.c().e();
        }
    }

    public void c(a aVar) {
        boolean d11 = d();
        this.f44956b.add(aVar);
        if (!d11) {
            h.c().d();
        }
    }

    public boolean d() {
        return this.f44956b.size() > 0;
    }
}
