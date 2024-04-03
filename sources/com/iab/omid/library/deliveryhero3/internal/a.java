package com.iab.omid.library.deliveryhero3.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.deliveryhero3.internal.d;
import com.iab.omid.library.deliveryhero3.utils.f;
import java.util.Date;

public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    private static a f44947f = new a(new d());

    /* renamed from: a  reason: collision with root package name */
    public f f44948a = new f();

    /* renamed from: b  reason: collision with root package name */
    private Date f44949b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f44950c;

    /* renamed from: d  reason: collision with root package name */
    private d f44951d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f44952e;

    private a(d dVar) {
        this.f44951d = dVar;
    }

    public static a a() {
        return f44947f;
    }

    private void c() {
        if (this.f44950c && this.f44949b != null) {
            for (com.iab.omid.library.deliveryhero3.adsession.a adSessionStatePublisher : c.c().a()) {
                adSessionStatePublisher.getAdSessionStatePublisher().a(b());
            }
        }
    }

    public void a(@NonNull Context context) {
        if (!this.f44950c) {
            this.f44951d.a(context);
            this.f44951d.a((d.a) this);
            this.f44951d.e();
            this.f44952e = this.f44951d.c();
            this.f44950c = true;
        }
    }

    public void a(boolean z11) {
        if (!this.f44952e && z11) {
            d();
        }
        this.f44952e = z11;
    }

    public Date b() {
        Date date = this.f44949b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date a11 = this.f44948a.a();
        Date date = this.f44949b;
        if (date == null || a11.after(date)) {
            this.f44949b = a11;
            c();
        }
    }
}
