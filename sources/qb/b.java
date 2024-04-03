package qb;

import android.app.Activity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.handler.uitrace.customuitraces.b f47231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47232c;

    public /* synthetic */ b(com.instabug.apm.handler.uitrace.customuitraces.b bVar, Activity activity) {
        this.f47231b = bVar;
        this.f47232c = activity;
    }

    public final void run() {
        this.f47231b.a(this.f47232c);
    }
}
