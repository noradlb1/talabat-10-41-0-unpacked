package com.apptimize;

import com.apptimize.ap;
import com.apptimize.bd;
import com.apptimize.ec;
import java.util.Map;
import java.util.Set;
import java.util.zip.Adler32;
import java.util.zip.Checksum;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apptimize.do  reason: invalid class name */
public class Cdo implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41853a = "do";

    /* renamed from: b  reason: collision with root package name */
    private au f41854b;

    /* renamed from: c  reason: collision with root package name */
    private ec f41855c;

    /* renamed from: d  reason: collision with root package name */
    private ap f41856d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public dn f41857e = new dn();

    public Cdo(bd.a aVar, au auVar) {
        Class<Cdo> cls = Cdo.class;
        this.f41854b = auVar;
        ec ecVar = new ec(this, aVar, auVar);
        this.f41855c = ecVar;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "ENROLLMENT_INFO__ab825030-6304-11e3-949a-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return Cdo.this.f41857e.a();
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    bo.c(Cdo.f41853a, "This is the first time we've run; no previous EnrollmentInfo");
                } else {
                    dn unused = Cdo.this.f41857e = dn.a(jSONObject);
                }
            }
        });
        try {
            ap.a aVar2 = new ap.a(this);
            Class cls2 = Long.TYPE;
            this.f41856d = aVar2.a("updateEnrollmentInfo", cls.getDeclaredMethod("a", new Class[]{Set.class, cls2})).a("updateVariantRun", cls.getDeclaredMethod("a", new Class[]{cls2, cls2, cls2})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.b(f41853a, "Error: ", e11);
        }
        b();
    }

    public synchronized void b() {
        this.f41855c.a();
    }

    public void c() {
        this.f41854b.d().e();
        this.f41855c.b();
    }

    public void d() {
        this.f41854b.d().e();
        this.f41856d.b(a());
    }

    public synchronized Map<Long, Long> e() {
        return this.f41857e.b();
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                Adler32 adler32 = new Adler32();
                fd.a((Checksum) adler32, fd.a((Map<?, ?>) Cdo.this.f41857e.b()));
                fd.a((Checksum) adler32, fd.a((Map<?, ?>) Cdo.this.f41857e.c()));
                return Long.valueOf(adler32.getValue());
            }
        };
    }

    public synchronized void a(ed edVar) {
        a(edVar == null ? null : edVar.i(), this.f41854b.e().b());
    }

    private synchronized void a(Set<Long> set, long j11) {
        if (this.f41857e.a(set, j11)) {
            this.f41856d.a("updateEnrollmentInfo", a(), set, Long.valueOf(j11));
        }
    }

    public synchronized boolean a(long j11, long j12) {
        return a(j11, j12, this.f41854b.e().b());
    }

    private synchronized boolean a(long j11, long j12, long j13) {
        boolean a11;
        a11 = this.f41857e.a(j11, j12, j13);
        if (a11) {
            this.f41856d.a("updateVariantRun", a(), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13));
        }
        return a11;
    }

    public synchronized boolean a(long j11) {
        return this.f41857e.a(j11);
    }
}
