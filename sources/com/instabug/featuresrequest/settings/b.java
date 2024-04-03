package com.instabug.featuresrequest.settings;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f46589c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f46590a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f46591b = true;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = f46589c;
            if (bVar == null) {
                bVar = new b();
                f46589c = bVar;
            }
        }
        return bVar;
    }

    public void a(boolean z11) {
        this.f46591b = z11;
    }

    public void b(boolean z11) {
        this.f46590a = z11;
    }

    public boolean b() {
        return this.f46591b;
    }

    public boolean c() {
        return this.f46590a;
    }
}
