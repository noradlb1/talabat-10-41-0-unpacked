package com.apptimize;

import com.apptimize.ap;
import com.apptimize.bd;
import com.apptimize.bg;
import com.apptimize.ec;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class eh implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42271a = "eh";

    /* renamed from: b  reason: collision with root package name */
    private final e f42272b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final aw f42273c;

    /* renamed from: d  reason: collision with root package name */
    private final ec f42274d;

    /* renamed from: e  reason: collision with root package name */
    private ap f42275e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Set<String>> f42276f = Collections.emptyMap();

    /* renamed from: g  reason: collision with root package name */
    private final au f42277g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f42278h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final gp f42279i;

    public static class a extends cp {

        /* renamed from: a  reason: collision with root package name */
        private final bb f42282a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Set<String> f42283b = new HashSet();

        public a(bb bbVar) {
            this.f42282a = bbVar;
        }

        public boolean a(cs csVar) {
            if (!(csVar instanceof bw) && !(csVar instanceof ce)) {
                return false;
            }
            try {
                for (az c11 : csVar instanceof bw ? ((bw) csVar).b() : ((ce) csVar).c()) {
                    this.f42283b.addAll(c11.c(this.f42282a));
                }
                if (csVar instanceof bw) {
                    for (az c12 : ((bw) csVar).c()) {
                        this.f42283b.addAll(c12.c(this.f42282a));
                    }
                }
                return false;
            } catch (MalformedURLException e11) {
                bo.d(eh.f42271a, "Apptimize secondary url request malformed", e11);
                return true;
            } catch (UnsupportedEncodingException e12) {
                bo.d(eh.f42271a, "Apptimize secondary url encoding failed", e12);
                return true;
            } catch (ca e13) {
                bo.d(eh.f42271a, "Apptimize secondary url metadata invalid", e13);
                return true;
            }
        }
    }

    public enum b {
        STOP_ON_FAILURE,
        TOLERATE_FAILURES
    }

    public class c {
        public c() {
        }

        public Map<String, Set<String>> a() {
            return eh.this.f();
        }
    }

    public interface d {
        void a(String str);

        void a(String str, Set<String> set);
    }

    public eh(bd.a aVar, au auVar, aw awVar, gp gpVar, ExecutorService executorService) {
        ec ecVar = new ec(this, aVar, auVar);
        this.f42274d = ecVar;
        this.f42273c = awVar;
        this.f42272b = new e();
        this.f42277g = auVar;
        this.f42278h = executorService;
        this.f42279i = gpVar;
        ecVar.a(ec.f42220a, new ec.b<JSONObject>() {
            public String a() {
                return "SECONDARY_URL_FETCHES__4acb6804-0190-439e-a997-55f6a67adf99";
            }

            /* renamed from: b */
            public JSONObject d() throws JSONException {
                return fh.a((Map<?, ?>) eh.this.f42276f);
            }

            public void a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    bo.c(eh.f42271a, "This is the first time we've run; no persisted secondary fetches");
                    return;
                }
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : ((Map) fh.a((Object) jSONObject)).entrySet()) {
                    hashMap.put(entry.getKey(), Collections.unmodifiableSet(new HashSet((Collection) entry.getValue())));
                }
                Map unused = eh.this.f42276f = Collections.unmodifiableMap(hashMap);
            }
        });
        try {
            this.f42275e = new ap.a(this).a("setSecondaryUrlFetchResults", eh.class.getDeclaredMethod("a", new Class[]{Map.class})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42271a, "Error", e11);
        }
        b();
    }

    public bg e() {
        return this.f42272b;
    }

    public synchronized Map<String, Set<String>> f() {
        return this.f42276f;
    }

    public c g() {
        return new c();
    }

    public synchronized void b() {
        this.f42274d.a();
    }

    public void c() {
        this.f42274d.b();
    }

    public void d() {
        this.f42275e.b(a());
    }

    public class e implements bg {
        private e() {
        }

        public void a(bg.a aVar, by byVar, bb bbVar, ez ezVar) {
            if (aVar == bg.a.NEW_METADATA) {
                a(byVar, bbVar, ezVar, b.STOP_ON_FAILURE);
            } else if (aVar == bg.a.REPROCESS) {
                a(byVar, bbVar, ezVar, b.TOLERATE_FAILURES);
            }
        }

        private void a(final String str, final d dVar) {
            eh.this.f42278h.submit(new fi() {
                public void run() {
                    fe.a(eh.f42271a, (fi) new fi() {
                        public void run() {
                            eh.this.f42273c.a(str, (ax<Set<String>>) new ax<Set<String>>() {
                                public void b() {
                                    bo.c(eh.f42271a, "Did not download secondary metadata because Apptimize is in offline mode.");
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    dVar.a(str);
                                }

                                public void a(Set<String> set, HttpURLConnection httpURLConnection) {
                                    bo.h(eh.f42271a, "Downloaded new secondary metadata.");
                                    String h11 = eh.f42271a;
                                    bo.f(h11, "New secondary meta-data url:" + str + " result:" + set.toString());
                                    AnonymousClass1 r42 = AnonymousClass1.this;
                                    dVar.a(str, set);
                                }

                                public void a(HttpURLConnection httpURLConnection) {
                                    bo.h(eh.f42271a, "Request for new secondary meta-data failed.");
                                    AnonymousClass1 r22 = AnonymousClass1.this;
                                    dVar.a(str);
                                }

                                public void a() {
                                    bo.g(eh.f42271a, "Got a 304 on a secondary metadata request which shouldn't be possible.");
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    dVar.a(str);
                                }
                            });
                        }
                    }, "Exception while performing secondary fetch");
                }
            });
        }

        private void a(by byVar, bb bbVar, final ez ezVar, final b bVar) {
            if (!(byVar instanceof cb)) {
                ezVar.a();
                return;
            }
            try {
                Set<String> a11 = eh.a((cb) byVar, bbVar);
                eh.this.a(a11);
                HashSet<String> hashSet = new HashSet<>(a11);
                hashSet.removeAll(eh.this.f42276f.keySet());
                if (hashSet.isEmpty()) {
                    ezVar.a();
                    return;
                }
                final AtomicInteger atomicInteger = new AtomicInteger(hashSet.size());
                for (String a12 : hashSet) {
                    a(a12, new d() {
                        public void a(String str, Set<String> set) {
                            eh.this.a(str, set);
                            if (atomicInteger.decrementAndGet() == 0) {
                                eh.this.f42279i.d(ezVar.c());
                            }
                        }

                        public void a(String str) {
                            if (bVar == b.TOLERATE_FAILURES) {
                                bo.j(eh.f42271a, "Missing secondary fetch URL. Pilot targeting may experience error.");
                                if (atomicInteger.decrementAndGet() == 0) {
                                    eh.this.f42279i.d(ezVar.c());
                                    return;
                                }
                                return;
                            }
                            eh.this.f42279i.d(ezVar.d());
                        }
                    });
                }
            } catch (ca e11) {
                if (bVar == b.TOLERATE_FAILURES) {
                    bo.g(eh.f42271a, "Invalid secondary fetch URLs (continuing anyway)", e11);
                    ezVar.a();
                    return;
                }
                bo.g(eh.f42271a, "Invalid secondary fetch URLs (aborting)", e11);
                ezVar.b();
            }
        }
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return Long.valueOf(fd.a((Map<?, ?>) eh.this.f42276f));
            }
        };
    }

    private synchronized void a(Map<String, Set<String>> map) {
        this.f42276f = Collections.unmodifiableMap(new HashMap(map));
        this.f42275e.a("setSecondaryUrlFetchResults", a(), this.f42276f);
    }

    public synchronized void a(String str, Set<String> set) {
        HashMap hashMap = new HashMap(this.f42276f);
        hashMap.put(str, set);
        a((Map<String, Set<String>>) hashMap);
    }

    /* access modifiers changed from: private */
    public synchronized void a(Set<String> set) {
        HashMap hashMap = new HashMap(this.f42276f);
        hashMap.keySet().retainAll(set);
        a((Map<String, Set<String>>) hashMap);
    }

    public static Set<String> a(cb cbVar, bb bbVar) throws ca {
        a aVar = new a(bbVar);
        if (!cbVar.a((co) new cz(aVar))) {
            return aVar.f42283b;
        }
        throw new ca("Error encountered in computedCallServerUrls");
    }
}
