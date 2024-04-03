package com.apptimize;

import com.apptimize.ag;
import com.apptimize.ap;
import com.apptimize.bd;
import com.apptimize.bq;
import com.apptimize.ec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ef implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42252a = "ef";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public au f42253b;

    /* renamed from: c  reason: collision with root package name */
    private final ec f42254c;

    /* renamed from: d  reason: collision with root package name */
    private ap f42255d;

    /* renamed from: e  reason: collision with root package name */
    private ag f42256e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f42257f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ee f42258g = new ee();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f42259h = -1;

    public ef(bd.a aVar, final au auVar) {
        Class<String> cls = String.class;
        Class<ef> cls2 = ef.class;
        this.f42253b = auVar;
        ec ecVar = new ec(this, aVar, auVar);
        this.f42254c = ecVar;
        ecVar.a(ec.f42222c, new ec.b<Long>() {
            public String a() {
                return "LAST_SEQUENCE_NUMBER_SUCCESSFULLY_SENT__ab825031-6304-11e3-949a-0800200c9a66";
            }

            /* renamed from: b */
            public Long d() throws JSONException {
                return Long.valueOf(ef.this.f42259h);
            }

            public void a(Long l11) throws JSONException {
                if (l11 == null) {
                    bo.c(ef.f42252a, "Never sent anything previously to server");
                } else {
                    long unused = ef.this.f42259h = l11.longValue();
                }
            }
        });
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "CURRENT_RESULTS_V3__ab825030-6304-11e3-949a-0800200c9a66";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return ef.this.f42258g.b();
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null && ef.this.f42258g == null) {
                    bo.c(ef.f42252a, "This is the first time we've run; no previous ResultsV3");
                    ee unused = ef.this.f42258g = new ee();
                } else if (jSONObject != null) {
                    try {
                        ee unused2 = ef.this.f42258g = ee.a(jSONObject, auVar);
                    } catch (JSONException unused3) {
                        bo.e(ef.f42252a, "Could not parse ResultsV3; either a bug or a backwards incompatible change.");
                        ee unused4 = ef.this.f42258g = new ee();
                    }
                }
            }
        });
        try {
            this.f42255d = new ap.a(this).a("incrementRunCount", cls2.getDeclaredMethod("a", new Class[]{Long.TYPE})).a("setMetric", cls2.getDeclaredMethod("b", new Class[]{cls, Double.TYPE})).a("addToMetric", cls2.getDeclaredMethod("a", new Class[]{cls, Double.TYPE})).a(auVar.d());
            this.f42256e = new ag.a(this).a("updateResultsV3ForMetadataProcess", cls2.getDeclaredMethod("a", new Class[]{Map.class})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42252a, "Error binding", e11);
        }
        b();
    }

    private synchronized void j() {
        this.f42258g = new ee(this.f42258g.a(), this.f42258g.c(), this.f42258g.d() + 1);
    }

    public void d() {
        this.f42253b.d().e();
        this.f42255d.b(a());
    }

    public synchronized void e() {
        this.f42257f = true;
        this.f42254c.c();
    }

    public synchronized ee f() {
        return this.f42258g;
    }

    public synchronized long g() {
        return this.f42259h;
    }

    public synchronized void h() {
        a(f());
    }

    public void b() {
        this.f42254c.a();
    }

    public void c() {
        this.f42253b.d().e();
        this.f42254c.b();
    }

    public synchronized void b(String str, double d11) {
        if (!this.f42257f) {
            for (el next : this.f42258g.a().values()) {
                String str2 = f42252a;
                bo.i(str2, "Logging metric for test '" + next.f42303a.f() + "'.");
                next.f42304b.b(str, d11);
            }
            j();
            this.f42255d.a("setMetric", a(), str, Double.valueOf(d11));
        }
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                try {
                    return Long.valueOf(fd.a((Map<?, ?>) fh.a(ef.this.f42258g.b())));
                } catch (JSONException e11) {
                    bo.b(ef.f42252a, "Error computing ResultsV3 checksum: ", e11);
                    ef.this.f42253b.a().a(bq.b.JsonError, (Exception) e11);
                    return 0L;
                }
            }
        };
    }

    public synchronized void a(ee eeVar) {
        if (!this.f42257f) {
            this.f42253b.d().e();
            if (eeVar.d() < 0) {
                throw new IllegalStateException("Sequence number cannot go below 0.");
            } else if (eeVar.d() < this.f42259h) {
                bo.g(f42252a, "sequenceNumberLastSuccessfullySent decreased; ignoring.");
            } else if (eeVar.d() == this.f42259h) {
                bo.e(f42252a, "sequenceNumberLastSuccessfullySent did not change; ignoring.");
            } else {
                this.f42259h = eeVar.d();
                HashSet hashSet = new HashSet();
                for (el elVar : eeVar.c()) {
                    hashSet.add(Long.valueOf(elVar.f42303a.j()));
                }
                ArrayList arrayList = new ArrayList();
                boolean z11 = false;
                for (el next : this.f42258g.c()) {
                    if (hashSet.contains(Long.valueOf(next.f42303a.j()))) {
                        z11 = true;
                    } else {
                        arrayList.add(next);
                    }
                }
                if (z11) {
                    if (this.f42258g.d() != eeVar.d()) {
                        this.f42258g = new ee(this.f42258g.a(), arrayList, this.f42258g.d() + 1);
                    } else if (!arrayList.equals(this.f42258g.c())) {
                        long d11 = this.f42258g.d();
                        if (!arrayList.isEmpty()) {
                            d11++;
                        }
                        this.f42258g = new ee(this.f42258g.a(), arrayList, d11);
                    }
                }
                this.f42255d.a(a());
            }
        }
    }

    public synchronized void a(long j11) {
        br.b("incrementRunCountForVariant variantId", Long.valueOf(j11));
        if (!this.f42257f) {
            el elVar = this.f42258g.a().get(Long.valueOf(j11));
            br.a("incrementRunCountForVariant variantData", (Object) elVar);
            if (elVar != null) {
                elVar.b();
                j();
                this.f42255d.a("incrementRunCount", a(), Long.valueOf(j11));
            }
        }
    }

    public synchronized void a(String str, double d11) {
        if (!this.f42257f) {
            for (el next : this.f42258g.a().values()) {
                String str2 = f42252a;
                bo.i(str2, "Logging metric for test '" + next.f42303a.f() + "'.");
                next.f42304b.a(str, d11);
            }
            j();
            this.f42255d.a("addToMetric", a(), str, Double.valueOf(d11));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.Map<java.lang.Long, com.apptimize.el> r5, java.util.List<com.apptimize.el> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x000c
            com.apptimize.ee r5 = r4.f42258g     // Catch:{ all -> 0x000a }
            java.util.Map r5 = r5.a()     // Catch:{ all -> 0x000a }
            goto L_0x000c
        L_0x000a:
            r5 = move-exception
            goto L_0x006b
        L_0x000c:
            if (r6 != 0) goto L_0x0014
            com.apptimize.ee r6 = r4.f42258g     // Catch:{ all -> 0x000a }
            java.util.List r6 = r6.c()     // Catch:{ all -> 0x000a }
        L_0x0014:
            com.apptimize.au r0 = r4.f42253b     // Catch:{ all -> 0x000a }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x000a }
            boolean r0 = r0.c()     // Catch:{ all -> 0x000a }
            if (r0 != 0) goto L_0x0048
            com.apptimize.ee r0 = new com.apptimize.ee     // Catch:{ JSONException -> 0x0033 }
            r1 = -1
            r0.<init>(r5, r6, r1)     // Catch:{ JSONException -> 0x0033 }
            org.json.JSONObject r5 = r0.b()     // Catch:{ JSONException -> 0x0033 }
            java.util.Map r5 = com.apptimize.fh.a((org.json.JSONObject) r5)     // Catch:{ JSONException -> 0x0033 }
            r4.a((java.util.Map<java.lang.Object, java.lang.Object>) r5)     // Catch:{ JSONException -> 0x0033 }
            goto L_0x0046
        L_0x0033:
            r5 = move-exception
            java.lang.String r6 = f42252a     // Catch:{ all -> 0x000a }
            java.lang.String r0 = "Error sending ResultsV3 update to main process"
            com.apptimize.bo.e(r6, r0)     // Catch:{ all -> 0x000a }
            com.apptimize.au r6 = r4.f42253b     // Catch:{ all -> 0x000a }
            com.apptimize.bq r6 = r6.a()     // Catch:{ all -> 0x000a }
            com.apptimize.bq$b r0 = com.apptimize.bq.b.JsonError     // Catch:{ all -> 0x000a }
            r6.a((com.apptimize.bq.b) r0, (java.lang.Exception) r5)     // Catch:{ all -> 0x000a }
        L_0x0046:
            monitor-exit(r4)
            return
        L_0x0048:
            com.apptimize.ee r0 = r4.f42258g     // Catch:{ all -> 0x000a }
            long r0 = r0.d()     // Catch:{ all -> 0x000a }
            r2 = 1
            long r0 = r0 + r2
            com.apptimize.ee r2 = new com.apptimize.ee     // Catch:{ all -> 0x000a }
            r2.<init>(r5, r6, r0)     // Catch:{ all -> 0x000a }
            r4.f42258g = r2     // Catch:{ all -> 0x000a }
            com.apptimize.au r5 = r4.f42253b     // Catch:{ all -> 0x000a }
            com.apptimize.ak r5 = r5.d()     // Catch:{ all -> 0x000a }
            boolean r5 = r5.c()     // Catch:{ all -> 0x000a }
            if (r5 == 0) goto L_0x0069
            com.apptimize.ec r5 = r4.f42254c     // Catch:{ all -> 0x000a }
            r5.b()     // Catch:{ all -> 0x000a }
        L_0x0069:
            monitor-exit(r4)
            return
        L_0x006b:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ef.a(java.util.Map, java.util.List):void");
    }

    private synchronized void a(Map<Object, Object> map) {
        if (this.f42253b.d().c()) {
            try {
                ee a11 = ee.a(fh.a((Map<?, ?>) map), this.f42253b);
                a(a11.a(), a11.c());
            } catch (JSONException e11) {
                bo.e(f42252a, "Error sending ResultsV3 update to main process");
                this.f42253b.a().a(bq.b.JsonError, (Exception) e11);
            }
        } else {
            this.f42256e.a("updateResultsV3ForMetadataProcess", map);
        }
    }
}
