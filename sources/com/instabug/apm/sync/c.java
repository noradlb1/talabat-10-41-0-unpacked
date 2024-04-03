package com.instabug.apm.sync;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f45569a = com.instabug.apm.di.a.f();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.instabug.apm.configuration.c f45570b = com.instabug.apm.di.a.c();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.instabug.apm.handler.session.c f45571c = com.instabug.apm.di.a.W();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private f f45572d = com.instabug.apm.di.a.Y();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private com.instabug.apm.handler.applaunch.a f45573e = com.instabug.apm.di.a.n();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private com.instabug.apm.handler.networklog.a f45574f = com.instabug.apm.di.a.P();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private com.instabug.apm.handler.executiontraces.a f45575g = com.instabug.apm.di.a.A();
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private com.instabug.apm.cache.handler.uitrace.c f45576h = com.instabug.apm.di.a.i0();
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.instabug.apm.networking.handler.a f45577i = com.instabug.apm.di.a.b0();
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.instabug.apm.handler.experiment.a f45578j = com.instabug.apm.di.a.D();
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private com.instabug.apm.handler.fragment.a f45579k = com.instabug.apm.di.a.L();
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    public boolean f45580l = false;
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    public Request.Callbacks f45581m = new b(this);

    @Nullable
    private com.instabug.apm.cache.model.f a(String str) {
        com.instabug.apm.cache.model.f a11 = this.f45571c.a(str);
        if (a11 != null) {
            a(a11);
        }
        return a11;
    }

    private void a(@Nullable com.instabug.apm.cache.model.f fVar) {
        if (fVar != null) {
            String id2 = fVar.getId();
            f fVar2 = this.f45572d;
            if (fVar2 != null) {
                fVar.a(fVar2.a(id2));
            }
            fVar.a(this.f45573e.b(id2));
            fVar.e(this.f45574f.a(id2));
            fVar.b(this.f45575g.a(id2));
            fVar.f(this.f45576h.a(id2));
            com.instabug.apm.handler.experiment.a aVar = this.f45578j;
            if (aVar != null) {
                fVar.c(aVar.b(id2));
            }
            com.instabug.apm.handler.fragment.a aVar2 = this.f45579k;
            if (aVar2 != null) {
                fVar.d(aVar2.a(id2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(RateLimitedException rateLimitedException) {
        this.f45570b.h(rateLimitedException.getPeriod());
        c();
    }

    private void a(@NonNull List list) {
        if (!list.isEmpty()) {
            this.f45580l = true;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((com.instabug.apm.cache.model.f) it.next()).getId());
            }
            this.f45571c.a(arrayList, 0);
            if (this.f45570b.c0()) {
                c();
                return;
            }
            this.f45570b.e(System.currentTimeMillis());
            this.f45577i.a(list, this.f45581m);
        } else if (this.f45580l) {
            this.f45570b.m(System.currentTimeMillis());
        }
    }

    private boolean a(int i11, int i12, int i13, int i14, int i15, int i16) {
        return ((long) i11) > this.f45570b.m() || ((long) i12) > this.f45570b.j() || ((long) i13) > this.f45570b.o() || ((long) i14) > this.f45570b.k() || i15 > this.f45570b.q() || i16 > this.f45570b.W();
    }

    private void c() {
        f();
        this.f45571c.a(0);
        g();
    }

    private boolean d() {
        return this.f45570b.v() && com.instabug.apm.di.a.w().a();
    }

    private boolean e() {
        return System.currentTimeMillis() - this.f45570b.G() >= this.f45570b.u() * 1000;
    }

    private void f() {
        this.f45569a.a(String.format(RateLimitedException.RATE_LIMIT_REACHED, new Object[]{"APM"}));
    }

    /* access modifiers changed from: private */
    public void g() {
        com.instabug.apm.cache.model.f a11;
        ArrayList arrayList = new ArrayList();
        String str = "-1";
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        do {
            a11 = a(str);
            if (a11 != null) {
                List a12 = a11.a();
                int size = i11 + (a12 != null ? a12.size() : 0);
                List g11 = a11.g();
                int size2 = i12 + (g11 != null ? g11.size() : 0);
                List j11 = a11.j();
                int size3 = i13 + (j11 != null ? j11.size() : 0);
                List d11 = a11.d();
                int size4 = i14 + (d11 != null ? d11.size() : 0);
                List e11 = a11.e();
                int size5 = i15 + (e11 != null ? e11.size() : 0);
                List f11 = a11.f();
                int size6 = i16 + (f11 != null ? f11.size() : 0);
                if (a(size, size2, size3, size4, size5, size6)) {
                    break;
                }
                arrayList.add(a11);
                str = a11.getId();
                i11 = size;
                i12 = size2;
                i13 = size3;
                i14 = size4;
                i15 = size5;
                i16 = size6;
                continue;
            }
        } while (a11 != null);
        a((List) arrayList);
        this.f45569a.d("syncNextSessionsChunk: " + arrayList.size());
    }

    public void a() {
        if (b()) {
            h();
        }
    }

    public void a(boolean z11) {
        if (z11 || b()) {
            h();
        }
    }

    public boolean b() {
        return (this.f45570b.H() && e()) || d();
    }

    public void h() {
        List<com.instabug.apm.cache.model.f> a11 = this.f45571c.a();
        if (!a11.isEmpty()) {
            for (com.instabug.apm.cache.model.f a12 : a11) {
                a(a12);
            }
            a((List) a11);
            return;
        }
        g();
    }
}
