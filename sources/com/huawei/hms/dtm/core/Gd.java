package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.util.Logger;

public class Gd implements Dd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f48306a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Bd f48307b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public de f48308c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f48309d;

    public class a implements ce {
        private a() {
        }

        public void a() {
            synchronized (Gd.this.f48306a) {
                Gd.this.f48307b.a();
            }
        }

        public void c() {
            synchronized (Gd.this.f48306a) {
                Gd.this.f48307b.c();
                Bd unused = Gd.this.f48307b = new Td();
            }
        }

        public void onConnected() {
            synchronized (Gd.this.f48306a) {
                Gd gd2 = Gd.this;
                Bd unused = gd2.f48307b = new Rd(gd2.f48308c);
                Gd.this.f48307b.onConnected();
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final Gd f48311a = new Gd();
    }

    private Gd() {
        this.f48306a = new Object();
        this.f48307b = new Td();
        this.f48309d = new Object();
    }

    public static Gd c() {
        return b.f48311a;
    }

    public void a() {
        synchronized (this.f48309d) {
            de deVar = this.f48308c;
            if (deVar != null) {
                deVar.disconnect();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f48309d) {
            Ed.d().a((Dd) this);
            if (this.f48308c == null) {
                this.f48308c = new ne(new a());
            }
            if (!this.f48308c.isConnected()) {
                Logger.info("DTM-AutoTrace", "begin to connect");
                this.f48308c.a();
                this.f48308c.a(str);
            }
        }
    }

    public void b() {
        synchronized (this.f48306a) {
            this.f48307b.b();
        }
    }

    public void onActivityPaused(Activity activity) {
        synchronized (this.f48306a) {
            this.f48307b.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        synchronized (this.f48306a) {
            this.f48307b.onActivityResumed(activity);
        }
    }
}
