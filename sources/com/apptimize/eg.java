package com.apptimize;

import com.apptimize.ap;
import com.apptimize.as;
import com.apptimize.bq;
import com.apptimize.cj;
import i.b;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

public class eg implements ao {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42264a = "eg";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final au f42265b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42266c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<cj> f42267d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<bz> f42268e = new AtomicReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private final ap f42269f;

    public eg(au auVar, String str) throws as.a {
        AtomicReference<cj> atomicReference = new AtomicReference<>((Object) null);
        this.f42267d = atomicReference;
        this.f42265b = auVar;
        this.f42266c = str;
        cj.a aVar = new cj.a(cj.a());
        aVar.a(str);
        atomicReference.set(aVar.b());
        this.f42269f = g();
    }

    private ap g() {
        try {
            return new ap.a(this).a("sdkParametersUpdated", eg.class.getDeclaredMethod("a", new Class[]{cj.class})).a(this.f42265b.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42264a, "Error:", e11);
            return null;
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        cj.a aVar = new cj.a(this.f42267d.get());
        aVar.a(cj.b());
        aVar.a(this.f42266c);
        a(aVar.b());
    }

    public cj f() {
        return this.f42267d.get();
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                try {
                    return Long.valueOf(fd.a((Map<?, ?>) fh.a(((cj) eg.this.f42267d.get()).c())));
                } catch (JSONException e11) {
                    eg.this.f42265b.a().a(bq.b.JsonError, (Exception) e11);
                    return 0L;
                }
            }
        };
    }

    public void a(cj cjVar) {
        cj.a aVar = new cj.a(cjVar);
        aVar.a(this.f42266c);
        this.f42267d.set(aVar.b());
        if (this.f42268e.get() != null) {
            this.f42268e.get().l();
        }
        this.f42269f.b("sdkParametersUpdated", a(), this.f42267d.get());
    }

    public void a(bz bzVar) {
        if (!b.a(this.f42268e, (Object) null, bzVar)) {
            bo.b(f42264a, "Attempted to set MetaDataDownloader more than once.");
        }
    }
}
