package com.apptimize;

import android.app.Activity;
import android.content.Context;
import com.apptimize.as;
import com.apptimize.bt;
import com.apptimize.t;
import com.apptimize.z;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class u {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43169a = "u";

    /* renamed from: b  reason: collision with root package name */
    private final au f43170b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f43171c;

    /* renamed from: d  reason: collision with root package name */
    private final String f43172d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f43173e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final aw f43174f;

    /* renamed from: g  reason: collision with root package name */
    private final cd f43175g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final be f43176h;

    /* renamed from: i  reason: collision with root package name */
    private final eg f43177i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f43178j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private at f43179k;

    /* renamed from: l  reason: collision with root package name */
    private final CountDownLatch f43180l = new CountDownLatch(1);

    /* renamed from: m  reason: collision with root package name */
    private Integer f43181m;

    /* renamed from: n  reason: collision with root package name */
    private i f43182n;

    public u(String str, String str2, Context context, aw awVar, cd cdVar, be beVar, eg egVar, au auVar, Properties properties) {
        this.f43171c = str;
        this.f43172d = str2;
        this.f43173e = context.getApplicationContext();
        this.f43174f = awVar;
        this.f43175g = cdVar;
        this.f43176h = beVar;
        this.f43177i = egVar;
        this.f43170b = auVar;
        a(properties);
    }

    private i f() {
        i iVar = this.f43182n;
        return iVar != null ? iVar : i.a();
    }

    private String g() {
        return f().a(this.f43173e, "PREF_SDK_VARIANT_ETAG", "0");
    }

    private boolean h() {
        if (this.f43178j.get()) {
            return false;
        }
        Date a11 = f().a(this.f43173e, "PREF_SDK_VARIANT_NEXT_UPDATE", (Date) null);
        if (a11 == null || new Date().after(a11)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void i() {
        if (h()) {
            a(this.f43175g.a());
        }
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public void b() {
        a(false, (List<String>) null);
    }

    public boolean c() {
        return f().a(this.f43173e, "PREF_SDK_VARIANT_VALUE", -999) != -999;
    }

    public t.b d() {
        long a11 = f().a(this.f43173e, "PREF_SDK_VARIANT_VALUE", -999);
        if (a11 == -999) {
            bo.k(f43169a, "No saved SdkVariant found");
            return t.b.NO_VARIANT;
        }
        t.b bVar = t.b.NO_VARIANT;
        for (t.b bVar2 : t.b.values()) {
            if (((long) bVar2.a()) == a11) {
                return bVar2;
            }
        }
        return bVar;
    }

    private boolean b(Integer num) {
        if (num == null) {
            bo.k(f43169a, "Trying to save a null variant");
            return false;
        }
        a(num);
        return true;
    }

    public void a(z zVar) {
        if (zVar == null) {
            bo.k(f43169a, "ApplicationSleepManager is null, will not subscribe for application events");
            return;
        }
        at atVar = this.f43179k;
        if (atVar != null) {
            atVar.a();
        }
        this.f43179k = zVar.a(new z.a() {
            public void a() {
            }

            public void a(Activity activity) {
                u.this.i();
            }

            public void b(Activity activity) {
            }
        });
    }

    public void a() {
        at atVar = this.f43179k;
        if (atVar != null) {
            atVar.a();
        }
    }

    private void a(Properties properties) {
        if (properties != null) {
            try {
                this.f43181m = as.d(properties);
            } catch (as.a e11) {
                e11.printStackTrace();
            }
        }
    }

    public static class a extends cp {

        /* renamed from: a  reason: collision with root package name */
        private final bb f43189a;

        /* renamed from: b  reason: collision with root package name */
        private final String f43190b;

        /* renamed from: c  reason: collision with root package name */
        private final String f43191c;

        /* renamed from: d  reason: collision with root package name */
        private Stack<Integer> f43192d = new Stack<>();

        /* renamed from: e  reason: collision with root package name */
        private Map<String, cm> f43193e = new HashMap();

        public a(bb bbVar, String str, String str2) {
            this.f43189a = bbVar;
            this.f43190b = str;
            this.f43191c = str2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
            if (com.apptimize.c.a((java.util.List) r1.b()) == false) goto L_0x0099;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0037 A[EDGE_INSN: B:31:0x0037->B:13:0x0037 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(com.apptimize.cm r8) {
            /*
                r7 = this;
                java.util.List r0 = r8.i()
                boolean r0 = com.apptimize.c.a((java.util.List) r0)
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                java.util.List r0 = r8.b()
                boolean r1 = com.apptimize.c.a((java.util.List) r0)
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x0037
                java.util.Iterator r1 = r0.iterator()
            L_0x001b:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x0037
                java.lang.Object r4 = r1.next()
                com.apptimize.az r4 = (com.apptimize.az) r4
                com.apptimize.bb r5 = r7.f43189a
                java.lang.Boolean r4 = r4.b((com.apptimize.bb) r5)
                if (r4 == 0) goto L_0x0035
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L_0x001b
            L_0x0035:
                r1 = r2
                goto L_0x0038
            L_0x0037:
                r1 = r3
            L_0x0038:
                if (r1 == 0) goto L_0x00a4
                java.util.Map<java.lang.String, com.apptimize.cm> r1 = r7.f43193e
                java.lang.String r4 = r8.f()
                boolean r1 = r1.containsKey(r4)
                if (r1 == 0) goto L_0x0098
                java.util.Map<java.lang.String, com.apptimize.cm> r1 = r7.f43193e
                java.lang.String r4 = r8.f()
                java.lang.Object r1 = r1.get(r4)
                com.apptimize.cm r1 = (com.apptimize.cm) r1
                java.util.List r4 = r1.b()
                boolean r4 = com.apptimize.c.a((java.util.List) r4)
                if (r4 != 0) goto L_0x0087
                boolean r4 = com.apptimize.c.a((java.util.List) r0)
                if (r4 != 0) goto L_0x0087
                java.lang.String r0 = com.apptimize.u.f43169a
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]
                long r5 = r1.j()
                java.lang.Long r1 = java.lang.Long.valueOf(r5)
                r4[r2] = r1
                long r1 = r8.j()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                r4[r3] = r1
                java.lang.String r1 = "Replacing matched (%d) variant with another (%d)"
                java.lang.String r1 = java.lang.String.format(r1, r4)
                com.apptimize.bo.k(r0, r1)
                goto L_0x0098
            L_0x0087:
                boolean r0 = com.apptimize.c.a((java.util.List) r0)
                if (r0 == 0) goto L_0x0098
                java.util.List r0 = r1.b()
                boolean r0 = com.apptimize.c.a((java.util.List) r0)
                if (r0 != 0) goto L_0x0098
                goto L_0x0099
            L_0x0098:
                r2 = r3
            L_0x0099:
                if (r2 == 0) goto L_0x00a4
                java.util.Map<java.lang.String, com.apptimize.cm> r0 = r7.f43193e
                java.lang.String r1 = r8.f()
                r0.put(r1, r8)
            L_0x00a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.u.a.b(com.apptimize.cm):void");
        }

        public boolean a(cs csVar) {
            if (csVar instanceof cb) {
                a(csVar.e());
                return true;
            } else if (csVar instanceof cl) {
                cl clVar = (cl) csVar;
                this.f43192d.push(clVar.a(this.f43190b, this.f43191c));
                a(clVar.e());
                this.f43192d.pop();
                return true;
            } else if (!(csVar instanceof ch)) {
                if (csVar instanceof cm) {
                    b((cm) csVar);
                }
                return false;
            } else if (this.f43192d.empty()) {
                return false;
            } else {
                a((ch) csVar, this.f43192d.peek());
                return true;
            }
        }

        public <T> T a(String str, String str2) {
            bt.f fVar;
            if (this.f43193e.size() == 0) {
                return null;
            }
            String format = String.format("%s:%s", new Object[]{str2, str});
            Iterator<bt> it = ((cm) this.f43193e.entrySet().iterator().next().getValue()).i().iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                bt next = it.next();
                if (next instanceof bt.f) {
                    fVar = (bt.f) next;
                    if (fVar.j().equals(format)) {
                        break;
                    }
                }
            }
            if (fVar == null) {
                return null;
            }
            return fVar.i();
        }

        private void a(ch chVar, Integer num) {
            List<cg> c11 = chVar.d().c();
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                if (i11 >= c11.size()) {
                    break;
                }
                cg cgVar = c11.get(i11);
                if (cgVar.b() <= num.intValue() && cgVar.c() > num.intValue()) {
                    arrayList.addAll(chVar.f());
                    break;
                }
                i11++;
            }
            arrayList.addAll(chVar.g());
            if (!arrayList.isEmpty()) {
                a((List<cs>) arrayList);
            }
        }

        private void a(List<cs> list) {
            cz czVar = new cz(this);
            for (cs a11 : list) {
                a11.a(czVar);
            }
        }
    }

    public t.b a(boolean z11, List<String> list) {
        bo.k(f43169a, String.format("Fetch new SdkVariant and wait: %b", new Object[]{Boolean.valueOf(z11)}));
        if (h()) {
            if (list == null) {
                list = this.f43175g.a();
            }
            a(list);
        }
        if (z11) {
            try {
                this.f43180l.await(300, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                bo.k(f43169a, "Apptimize thread was interrupted while awaiting SDK Variant");
            }
        }
        return d();
    }

    private void a(Integer num) {
        bo.k(f43169a, String.format("Saving new SdkVariant %d", new Object[]{num}));
        f().b(this.f43173e, "PREF_SDK_VARIANT_VALUE", (long) num.intValue());
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        f().b(this.f43173e, "PREF_SDK_VARIANT_ETAG", str);
    }

    private void a(final List<String> list) {
        this.f43178j.set(true);
        final String g11 = g();
        bo.k(f43169a, "New SdkVariant fetch initiated");
        new Thread(new fi() {
            public void run() {
                for (String str : list) {
                    try {
                        String e11 = u.f43169a;
                        bo.k(e11, "Loading SDK Variant with url  " + str);
                        u.this.f43174f.a(str, g11, (ax<JSONObject>) new ax<JSONObject>() {
                            public void b() {
                                bo.k(u.f43169a, "Apptimize is in offline mode. No SDK Variant update.");
                                u.this.a(false);
                            }

                            public void a(JSONObject jSONObject, HttpURLConnection httpURLConnection) {
                                boolean a11 = u.this.a(jSONObject);
                                if (a11) {
                                    u.this.a(httpURLConnection.getHeaderField(HttpHeaders.ETAG));
                                }
                                u.this.a(a11);
                                bo.k(u.f43169a, "Loaded SDK Variant.");
                            }

                            public void a(HttpURLConnection httpURLConnection) {
                                bo.k(u.f43169a, "Unable to load SDK Variant.");
                                u.this.a(false);
                            }

                            public void a() {
                                bo.k(u.f43169a, "SDK Variant update - no change.");
                                u.this.a(true);
                            }
                        });
                    } catch (Exception e12) {
                        String e13 = u.f43169a;
                        bo.i(e13, "Failed to load SDK Variant from " + str, e12);
                        u.this.a(false);
                    }
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        try {
            cb b11 = cb.b(jSONObject, this.f43170b);
            a aVar = new a(a(b11), this.f43172d, (String) null);
            b11.a((co) new cz(aVar));
            Integer num = (Integer) aVar.a("sdk_variant", "int");
            if (num != null) {
                return b(num);
            }
            return false;
        } catch (Exception e11) {
            String str = f43169a;
            bo.j(str, "Failed to parse sdk metadata " + e11.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        if (z11) {
            Integer num = this.f43181m;
            f().b(this.f43173e, "PREF_SDK_VARIANT_NEXT_UPDATE", new Date(new Date().getTime() + ((long) (num == null ? 86400000 : num.intValue()))));
        }
        this.f43178j.set(false);
        this.f43180l.countDown();
    }

    private bb a(cb cbVar) {
        return new bb(this.f43176h, new HashMap<String, Object>() {
            {
                put("app_key", u.this.f43171c);
                put("arch", u.this.f43176h.a("system_architecture"));
            }
        }, Collections.EMPTY_MAP, new dx(), Collections.EMPTY_MAP, cbVar.m(), cbVar.f());
    }
}
