package com.apptimize;

import com.apptimize.bd;
import java.util.concurrent.TimeUnit;

public class r implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43143a = "r";

    /* renamed from: b  reason: collision with root package name */
    private final bd.a f43144b;

    /* renamed from: c  reason: collision with root package name */
    private final au f43145c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ec f43146d;

    public r(bd.a aVar, au auVar) {
        this.f43144b = aVar;
        this.f43145c = auVar;
        this.f43146d = new ec(this, aVar, auVar);
        fg.f42427b.schedule(new Runnable() {
            public void run() {
                r.this.f43146d.a("BEHAVIOR_SET_05725dd7-85e2-490f-a4fe-42f4b0df5d64");
                r.this.f43146d.a("CURRENT_STATE__ab825030-6304-11e3-949a-0800200c9a66");
                r.this.f43146d.c();
                ec unused = r.this.f43146d = null;
                bo.k(r.f43143a, "delete BEHAVIOR_SET_05725dd7-85e2-490f-a4fe-42f4b0df5d64");
            }
        }, 1, TimeUnit.MINUTES);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return 0L;
            }
        };
    }
}
