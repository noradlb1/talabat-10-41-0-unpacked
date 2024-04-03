package com.apptimize;

import com.apptimize.bd;
import com.apptimize.bq;
import com.apptimize.ec;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class er<T> implements ao {

    /* renamed from: d  reason: collision with root package name */
    private static long f42334d = 20;

    /* renamed from: a  reason: collision with root package name */
    protected final au f42335a;

    /* renamed from: b  reason: collision with root package name */
    protected final ec f42336b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference<T> f42337c = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f42338e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f42339f;

    public er(bd.a aVar, au auVar, String str) {
        this.f42335a = auVar;
        ec ecVar = new ec(this, aVar, auVar);
        this.f42336b = ecVar;
        this.f42338e = getClass().getSimpleName();
        this.f42339f = str;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            /* renamed from: b */
            public JSONObject d() throws JSONException {
                if (er.this.f42337c.get() == null) {
                    return null;
                }
                try {
                    er erVar = er.this;
                    return erVar.a(erVar.f42337c.get());
                } catch (Exception e11) {
                    String a11 = er.this.f42338e;
                    bo.d(a11, er.this.f42339f + " exception on serializing objects", e11);
                    return null;
                }
            }

            public String a() {
                return er.this.e();
            }

            public void a(JSONObject jSONObject) throws JSONException {
                Object f11 = er.this.f();
                if (jSONObject == null && f11 == null) {
                    String a11 = er.this.f42338e;
                    bo.c(a11, er.this.f42339f + " no saved item found");
                } else if (jSONObject != null) {
                    try {
                        er.this.f42337c.set(er.this.a(jSONObject));
                        String a12 = er.this.f42338e;
                        bo.k(a12, er.this.f42339f + " loading persisted data");
                    } catch (Exception e11) {
                        String a13 = er.this.f42338e;
                        bo.d(a13, er.this.f42339f + " exception on restoring saved item", e11);
                    }
                }
            }
        });
        b();
    }

    public abstract T a(JSONObject jSONObject) throws Exception;

    public abstract JSONObject a(T t11) throws Exception;

    public T c(T t11) {
        T andSet = this.f42337c.getAndSet(t11);
        c();
        return andSet;
    }

    public void d() {
    }

    public abstract String e();

    public T f() {
        return this.f42337c.get();
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                T t11 = er.this.f42337c.get();
                if (t11 == null) {
                    return 334071097L;
                }
                try {
                    return Long.valueOf(fd.a((Map<?, ?>) fh.a(er.this.a(t11))));
                } catch (Exception e11) {
                    String a11 = er.this.f42338e;
                    bo.b(a11, er.this.f42339f + " error computing checksum: ", e11);
                    er.this.f42335a.a().a(bq.b.JsonError, e11);
                    return 0L;
                }
            }
        };
    }

    public void b(T t11) {
        this.f42337c.set(t11);
        c();
    }

    public void c() {
        if (this.f42337c.get() == null) {
            this.f42336b.a(e());
            String str = this.f42338e;
            bo.k(str, this.f42339f + " deleteItemFromDisk");
            return;
        }
        this.f42336b.a(f42334d);
        String str2 = this.f42338e;
        bo.k(str2, this.f42339f + " schedulePersist");
    }

    public void b() {
        this.f42336b.a();
        String str = this.f42338e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f42339f);
        sb2.append(" hasContent after reload:");
        sb2.append(this.f42337c.get() != null);
        bo.k(str, sb2.toString());
    }
}
