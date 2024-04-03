package com.apptimize;

import com.apptimize.bd;
import com.apptimize.bq;
import com.apptimize.ec;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class dv implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42185a = "dv";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final au f42186b;

    /* renamed from: c  reason: collision with root package name */
    private final ec f42187c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<cc> f42188d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<cc> f42189e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<cc> f42190f = new AtomicReference<>((Object) null);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f42191g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private boolean f42192h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final String f42193i;

    public dv(bd.a aVar, final au auVar, String str) {
        this.f42193i = str;
        ec ecVar = new ec(this, aVar, auVar);
        this.f42187c = ecVar;
        this.f42186b = auVar;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "META_META_DATA__ab825030-6304-11e3-949a-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                cc ccVar = (cc) dv.this.f42188d.get();
                if (ccVar != null) {
                    return ccVar.a();
                }
                return null;
            }

            public void a(JSONObject jSONObject) throws JSONException {
                cc ccVar = (cc) dv.this.f42188d.get();
                if (jSONObject == null && ccVar == null) {
                    String i11 = dv.f42185a;
                    bo.k(i11, dv.this.f42193i + " there is no previous metaMetaData");
                } else if (jSONObject != null) {
                    try {
                        dv.this.f42188d.set(cc.a(jSONObject, auVar));
                        String i12 = dv.f42185a;
                        bo.k(i12, dv.this.f42193i + " loading metaMetaData from storage");
                    } catch (ca | JSONException e11) {
                        String i13 = dv.f42185a;
                        bo.d(i13, dv.this.f42193i + " metadata was invalid", e11);
                    }
                }
            }
        });
        b();
    }

    public void c() {
    }

    public void d() {
    }

    public boolean e() {
        return this.f42192h;
    }

    public void f() {
        this.f42187c.a("META_META_DATA__ab825030-6304-11e3-949a-0800200c9a66");
        if (this.f42188d.get() != null) {
            String str = f42185a;
            bo.k(str, this.f42193i + " deleted MetaMetaData");
        }
    }

    public void g() {
        f();
    }

    public cc h() {
        return b(this.f42192h);
    }

    public void a(boolean z11) {
        this.f42192h = z11;
        if (!z11) {
            this.f42189e.set((Object) null);
        }
    }

    public void b() {
        this.f42187c.a();
        String str = f42185a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f42193i);
        sb2.append(" has content after reload:");
        sb2.append(this.f42188d.get() != null);
        sb2.append(" isWysiwyg:");
        sb2.append(e());
        bo.k(str, sb2.toString());
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                try {
                    cc ccVar = (cc) dv.this.f42188d.get();
                    if (ccVar == null) {
                        return 334071097L;
                    }
                    return Long.valueOf(fd.a((Map<?, ?>) fh.a(ccVar.a())));
                } catch (JSONException e11) {
                    String i11 = dv.f42185a;
                    bo.b(i11, dv.this.f42193i + " error computing ResultsV3 checksum: ", e11);
                    dv.this.f42186b.a().a(bq.b.JsonError, (Exception) e11);
                    return 0L;
                }
            }
        };
    }

    public cc b(boolean z11) {
        if (z11) {
            return this.f42189e.get();
        }
        return this.f42188d.get();
    }

    public void a(cc ccVar) {
        a(ccVar, this.f42192h);
    }

    public void a(cc ccVar, boolean z11) {
        String str = f42185a;
        bo.k(str, this.f42193i + " update metaMetaData isWysiwyg:" + z11);
        if (z11) {
            this.f42189e.set(ccVar);
        } else {
            this.f42188d.set(ccVar);
        }
        this.f42190f.set(ccVar);
        this.f42191g.incrementAndGet();
    }
}
