package com.iab.omid.library.deliveryhero3.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.deliveryhero3.adsession.a;
import com.iab.omid.library.deliveryhero3.devicevolume.b;
import com.iab.omid.library.deliveryhero3.devicevolume.c;
import com.iab.omid.library.deliveryhero3.devicevolume.e;
import com.iab.omid.library.deliveryhero3.internal.d;
import com.iab.omid.library.deliveryhero3.walking.TreeWalker;

public class h implements d.a, c {

    /* renamed from: f  reason: collision with root package name */
    private static h f44970f;

    /* renamed from: a  reason: collision with root package name */
    private float f44971a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final e f44972b;

    /* renamed from: c  reason: collision with root package name */
    private final b f44973c;

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.deliveryhero3.devicevolume.d f44974d;

    /* renamed from: e  reason: collision with root package name */
    private c f44975e;

    public h(e eVar, b bVar) {
        this.f44972b = eVar;
        this.f44973c = bVar;
    }

    private c a() {
        if (this.f44975e == null) {
            this.f44975e = c.c();
        }
        return this.f44975e;
    }

    public static h c() {
        if (f44970f == null) {
            f44970f = new h(new e(), new b());
        }
        return f44970f;
    }

    public void a(float f11) {
        this.f44971a = f11;
        for (a adSessionStatePublisher : a().a()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(f11);
        }
    }

    public void a(Context context) {
        this.f44974d = this.f44972b.a(new Handler(), context, this.f44973c.a(), this);
    }

    public void a(boolean z11) {
        if (z11) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.f44971a;
    }

    public void d() {
        b.g().a((d.a) this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f44974d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f44974d.d();
    }
}
