package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class l implements q {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f48659a;

    /* renamed from: b  reason: collision with root package name */
    public q f48660b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final l f48661a = new l((C0473e) null);
    }

    public l() {
        this.f48660b = new p();
        this.f48659a = Executors.newSingleThreadExecutor(new r("DTM-Handle"));
    }

    public /* synthetic */ l(C0473e eVar) {
        this();
    }

    public static l a() {
        return a.f48661a;
    }

    public void a(Context context) {
        a(context, (Map<Object, Object>) null);
    }

    public void a(Context context, Context context2, Map<Object, Object> map) {
    }

    public void a(Context context, Map<Object, Object> map) {
        this.f48659a.execute(new C0473e(this, context, map));
    }

    public void a(C0472d dVar) {
        this.f48659a.execute(new j(this, dVar));
    }

    public void logAutoEvent(String str, Bundle bundle) {
        this.f48659a.execute(new i(this, str, bundle));
    }

    public void logEvent(String str, Bundle bundle) {
        this.f48659a.execute(new h(this, str, bundle));
    }

    public void preview(String str) {
        this.f48659a.execute(new C0474f(this, str));
    }

    public void setParameter(Map<Object, Object> map) {
        this.f48659a.execute(new k(this, map));
    }

    public void startVisualTrace(String str) {
        this.f48659a.execute(new g(this, str));
    }
}
