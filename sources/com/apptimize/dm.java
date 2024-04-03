package com.apptimize;

import com.apptimize.ap;
import com.apptimize.bd;
import com.apptimize.dl;
import com.apptimize.ec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class dm implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41841a = "dm";

    /* renamed from: b  reason: collision with root package name */
    private au f41842b;

    /* renamed from: c  reason: collision with root package name */
    private ec f41843c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public dl f41844d = new dl();

    /* renamed from: e  reason: collision with root package name */
    private ap f41845e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicInteger f41846f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private AtomicInteger f41847g = new AtomicInteger(0);

    public dm(bd.a aVar, au auVar) {
        ec ecVar = new ec(this, aVar, auVar);
        this.f41843c = ecVar;
        this.f41842b = auVar;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "USER_ATTRIBUTES__ab825030-6304-11e3-949a-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return null;
            }

            public boolean c() {
                return true;
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    bo.c(dm.f41841a, "Importing CustomAttributes from UserAttributes");
                    dl unused = dm.this.f41844d = dl.b(jSONObject);
                }
            }
        });
        this.f41843c.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "CUSTOM_ATTRIBUTES__11de2a00-1c3e-11e4-8c21-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return dm.this.f41844d.a();
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    bo.c(dm.f41841a, "This is the first time we've run; no custom attributes");
                } else {
                    dl unused = dm.this.f41844d = dl.a(jSONObject);
                }
            }
        });
        this.f41845e = new ap.a(this).a(auVar.d());
        b();
    }

    public synchronized void b() {
        this.f41843c.a();
    }

    public void c() {
        this.f41842b.d().e();
        this.f41846f.incrementAndGet();
        this.f41843c.b();
        String str = f41841a;
        bo.k(str, "requestPersist " + this.f41847g.get());
    }

    public synchronized void d() {
        this.f41842b.d().e();
        this.f41845e.b(a());
        this.f41847g.incrementAndGet();
        String str = f41841a;
        bo.k(str, "notifyPersisted " + this.f41847g.get());
    }

    public void e() {
        long j11 = 0;
        while (this.f41847g.get() < this.f41846f.get() && j11 < 4000) {
            long j12 = (long) 50;
            try {
                Thread.sleep(j12);
                j11 += j12;
            } catch (InterruptedException unused) {
            }
        }
    }

    public synchronized Map<String, Object> f() {
        return this.f41844d.b(dl.b.UserAttribute);
    }

    public synchronized Map<String, Object> g() {
        return this.f41844d.c();
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return Long.valueOf(fd.a((Map<?, ?>) dm.this.f41844d.c()));
            }
        };
    }

    public synchronized Map<String, Object> b(dl.b bVar) {
        return this.f41844d.b(bVar);
    }

    public synchronized boolean a(dl.b bVar, boolean z11, Map<String, Object> map) {
        boolean z12;
        boolean z13;
        HashMap hashMap = new HashMap(map);
        z12 = true;
        if (z11) {
            a(bVar);
            z13 = true;
        } else {
            z13 = false;
        }
        if (!this.f41844d.a(bVar, (Map<String, Object>) hashMap) && !z13) {
            z12 = false;
        }
        return z12;
    }

    public synchronized void a(dl.b bVar) {
        this.f41844d.a(bVar);
    }

    public synchronized Map<String, Object> a(dl.a aVar) {
        return this.f41844d.a(aVar);
    }

    public synchronized Object a(dl.b bVar, String str) {
        return this.f41844d.a(bVar, str);
    }
}
