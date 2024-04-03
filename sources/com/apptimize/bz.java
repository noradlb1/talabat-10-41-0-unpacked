package com.apptimize;

import android.app.Activity;
import com.apptimize.ag;
import com.apptimize.ap;
import com.apptimize.as;
import com.apptimize.y;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class bz implements ao, y.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41526a = "bz";

    /* renamed from: b  reason: collision with root package name */
    private final EnumSet<b> f41527b = EnumSet.noneOf(b.class);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<fm> f41528c = new AtomicReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f41529d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final d f41530e = new d();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<cc> f41531f = new AtomicReference<>((Object) null);

    /* renamed from: g  reason: collision with root package name */
    private final fl f41532g = new fl();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public eu f41533h;

    /* renamed from: i  reason: collision with root package name */
    private eg f41534i;

    /* renamed from: j  reason: collision with root package name */
    private aw f41535j;

    /* renamed from: k  reason: collision with root package name */
    private fv f41536k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public au f41537l;

    /* renamed from: m  reason: collision with root package name */
    private ap f41538m;

    /* renamed from: n  reason: collision with root package name */
    private ag f41539n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f41540o;

    /* renamed from: p  reason: collision with root package name */
    private Long f41541p;

    /* renamed from: q  reason: collision with root package name */
    private String f41542q;

    /* renamed from: r  reason: collision with root package name */
    private String f41543r;

    /* renamed from: s  reason: collision with root package name */
    private y f41544s;

    /* renamed from: t  reason: collision with root package name */
    private e f41545t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public c f41546u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public g f41547v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final CountDownLatch f41548w = new CountDownLatch(1);

    /* renamed from: com.apptimize.bz$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41566a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.apptimize.bz$a[] r0 = com.apptimize.bz.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41566a = r0
                com.apptimize.bz$a r1 = com.apptimize.bz.a.SUCCESS_CHANGED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41566a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.bz$a r1 = com.apptimize.bz.a.SUCCESS_NO_CHANGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41566a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.bz$a r1 = com.apptimize.bz.a.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41566a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apptimize.bz$a r1 = com.apptimize.bz.a.FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.bz.AnonymousClass8.<clinit>():void");
        }
    }

    public enum a {
        SUCCESS_CHANGED,
        SUCCESS_NO_CHANGE,
        OFFLINE,
        FAILED
    }

    public enum b {
        IsDownloading,
        WillDownload,
        PrefetchInProgress,
        MetadataIsStale
    }

    public interface c {
        void a();

        void a(cb cbVar, String str, String str2);

        void b();
    }

    public interface e {
        void a(EnumSet<b> enumSet);

        void a(boolean z11);
    }

    private boolean A() {
        y yVar = this.f41544s;
        if (yVar != null) {
            return yVar.a();
        }
        return true;
    }

    private void p() {
        bo.f(f41526a, "requestDownload");
        this.f41537l.d().e();
        if (this.f41548w.getCount() <= 0) {
            o();
        }
    }

    private void q() {
        bs.b("PrefetchMetadata processing");
        bo.g(f41526a, "PrefetchMetadata start processing");
        b(this.f41530e.f(), this.f41530e.g(), this.f41530e.h());
        x();
    }

    /* access modifiers changed from: private */
    public boolean r() {
        bo.a(f41526a, "downloadNowSynchronously");
        List<String> t11 = t();
        String s11 = s();
        for (String next : t11) {
            int i11 = AnonymousClass8.f41566a[a(next, s11).ordinal()];
            if (i11 == 1 || i11 == 2) {
                String str = f41526a;
                bo.c(str, "Successfully downloaded metadata from " + next);
                return true;
            } else if (i11 == 3) {
                bo.c(f41526a, "Didn't attempt to download metadata because we're offline");
                return true;
            } else if (i11 == 4) {
                String str2 = f41526a;
                bo.c(str2, "Unable to download metadata from " + next);
            }
        }
        String str3 = f41526a;
        bo.e(str3, "Unable to download metadata from any of the supplied urls: " + t11);
        return false;
    }

    private String s() {
        if (this.f41542q != null) {
            return this.f41543r;
        }
        return this.f41534i.f().o();
    }

    /* access modifiers changed from: private */
    public List<String> t() {
        if (this.f41542q != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f41542q);
            return arrayList;
        } else if (this.f41540o) {
            return this.f41534i.f().l();
        } else {
            if (this.f41548w.getCount() <= 0) {
                return this.f41534i.f().k();
            }
            if (!A() || f() == null) {
                return this.f41534i.f().i();
            }
            return this.f41534i.f().j();
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        this.f41532g.b();
        l();
    }

    /* access modifiers changed from: private */
    public void v() {
        this.f41532g.a();
        l();
    }

    /* access modifiers changed from: private */
    public void w() {
        if (av.f41243f != 0) {
            String str = f41526a;
            bo.f(str, "start delay");
            try {
                Thread.sleep(av.f41243f);
            } catch (InterruptedException unused) {
                str = f41526a;
            } catch (Throwable th2) {
                bo.f(f41526a, "end delay");
                throw th2;
            }
            bo.f(str, "end delay");
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        this.f41537l.c().b((fi) new fi() {
            public void run() {
                bo.f(bz.f41526a, "experimentManager.metadataDownloadComplete");
                if (bz.this.f41546u != null) {
                    bz.this.f41546u.b();
                }
                bz.this.o();
            }
        });
    }

    /* access modifiers changed from: private */
    public void y() {
        String str = f41526a;
        bo.c(str, "Received a 304 response; nothing changed.");
        bo.k(str, "metadataListener.onNoMetadataUpdate");
        c cVar = this.f41546u;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        bo.c(f41526a, "Did not download metadata because Apptimize is in offline mode.");
    }

    public void a_() {
        bo.f(f41526a, "*** background ***");
        l();
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    /* access modifiers changed from: private */
    public void d(boolean z11) {
        bo.f(f41526a, "PrefetchMetadata complete");
        this.f41530e.d();
        a(b.MetadataIsStale, !z11, b.PrefetchInProgress, false);
        if (this.f41529d.get()) {
            b(!z11);
        }
    }

    private void n() {
        e eVar;
        if (this.f41529d.get() && (eVar = this.f41545t) != null) {
            eVar.a(e());
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        bo.f(f41526a, "metadataDownloaded");
        this.f41548w.countDown();
        this.f41538m.b("metadataDownloaded", a(), new Object[0]);
    }

    public long c(boolean z11) {
        long j11;
        if (this.f41528c.get() == null) {
            return 0;
        }
        cj f11 = this.f41534i.f();
        this.f41532g.a(f11.e().longValue());
        Long l11 = this.f41541p;
        if (l11 != null) {
            j11 = l11.longValue();
        } else if (A()) {
            j11 = f11.e().longValue();
        } else {
            j11 = f11.d().longValue();
        }
        long b11 = this.f41532g.b(j11);
        String str = f41526a;
        bo.f(str, "updateDownloadPeriod:" + b11 + " setPace: " + z11);
        if (z11) {
            this.f41528c.get().a(b11, false);
        }
        return b11;
    }

    public synchronized EnumSet<b> e() {
        return EnumSet.copyOf(this.f41527b);
    }

    public Long f() {
        cc ccVar = this.f41531f.get();
        if (ccVar != null) {
            return Long.valueOf(ccVar.e());
        }
        return null;
    }

    public boolean g() {
        return this.f41548w.getCount() == 0;
    }

    public void h() {
        if (this.f41528c.get() != null) {
            bo.f(f41526a, "disable");
            this.f41528c.get().c();
            b(b.WillDownload, false);
        }
    }

    public void i() {
        if (this.f41528c.get() != null) {
            bo.f(f41526a, "downloadNowAsync");
            if (this.f41537l.d().c()) {
                a(b.WillDownload, true, b.MetadataIsStale, true);
                this.f41528c.get().f();
                return;
            }
            this.f41539n.a("downloadNowAsync", new Object[0]);
        }
    }

    public cd j() {
        return new cd() {
            public List<String> a() {
                return bz.this.t();
            }
        };
    }

    public void k() {
        Long f11 = f();
        if (f11 != null && f11.longValue() + 259200000 < this.f41536k.b()) {
            cj f12 = this.f41534i.f();
            if (!f12.p()) {
                String str = f41526a;
                bo.e(str, "Failed to download metadata for the last " + 72 + " hours");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Current SDK parameters: ");
                sb2.append(f12);
                bo.e(str, sb2.toString());
                bo.e(str, "Resetting metadata download URLs back to defaults");
                this.f41534i.e();
                bo.e(str, "SDK parameters after resetting metadata download URLs back to defaults: " + this.f41534i.f());
                bo.e(str, "Retrying metadata download");
                this.f41528c.get().f();
            }
        }
    }

    public long l() {
        return c(true);
    }

    public String b(Properties properties) throws as.a {
        String a11 = a(properties);
        if (a11 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a11);
        return fd.a(arrayList, new ArrayList(), new ArrayList(), new ArrayList());
    }

    public class d {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f41578b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f41579c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicBoolean f41580d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicReference<JSONObject> f41581e;

        /* renamed from: f  reason: collision with root package name */
        private final AtomicReference<HttpURLConnection> f41582f;

        /* renamed from: g  reason: collision with root package name */
        private final AtomicReference<String> f41583g;

        /* renamed from: h  reason: collision with root package name */
        private long f41584h;

        private d() {
            this.f41578b = new AtomicBoolean(false);
            this.f41579c = new AtomicBoolean(false);
            this.f41580d = new AtomicBoolean(false);
            this.f41581e = new AtomicReference<>((Object) null);
            this.f41582f = new AtomicReference<>((Object) null);
            this.f41583g = new AtomicReference<>((Object) null);
        }

        public synchronized boolean a() {
            if (!this.f41578b.compareAndSet(false, true)) {
                return false;
            }
            this.f41579c.set(true);
            return true;
        }

        public synchronized boolean b() {
            boolean z11;
            if (!this.f41578b.get() || !this.f41579c.get()) {
                z11 = false;
            } else {
                z11 = true;
            }
            return z11;
        }

        public synchronized boolean c() {
            boolean z11;
            if (!this.f41578b.get() || this.f41580d.get()) {
                z11 = true;
            } else {
                z11 = false;
            }
            return z11;
        }

        public synchronized void d() {
            if (!this.f41578b.get() || this.f41579c.compareAndSet(true, false)) {
                if (bz.this.f41533h != null) {
                    bs.a("PrefetchMetadata: " + bz.this.f41533h.a(this.f41584h) + "ms");
                }
                this.f41581e.set((Object) null);
                this.f41582f.set((Object) null);
                this.f41583g.set((Object) null);
                return;
            }
            bo.b(bz.f41526a, "PrefetchMetadata synchronization error");
        }

        public boolean e() {
            return this.f41579c.get();
        }

        public JSONObject f() {
            return this.f41581e.get();
        }

        public HttpURLConnection g() {
            return this.f41582f.get();
        }

        public String h() {
            return this.f41583g.get();
        }

        public void a(long j11) {
            this.f41584h = j11;
        }

        public void a(boolean z11) {
            this.f41580d.set(z11);
        }

        public void a(JSONObject jSONObject, HttpURLConnection httpURLConnection, String str) {
            this.f41581e.set(jSONObject);
            this.f41582f.set(httpURLConnection);
            this.f41583g.set(str);
        }
    }

    private void b(b bVar, boolean z11) {
        a(bVar, z11);
    }

    public void a(cc ccVar) {
        this.f41531f.set(ccVar);
    }

    public String a(Properties properties) throws as.a {
        String f11 = as.f(properties);
        return f11 == null ? av.f41261x : f11;
    }

    public void b(boolean z11) {
        if (this.f41528c.get() != null) {
            String str = f41526a;
            bo.f(str, "resume getImmediately:" + z11);
            boolean z12 = this.f41528c.get().a((Long) null) < 100;
            if (z11 || z12) {
                a(b.WillDownload, true, b.MetadataIsStale, true);
                this.f41528c.get().e();
                return;
            }
            this.f41528c.get().d();
        }
    }

    private synchronized void a(b bVar, boolean z11) {
        if (z11) {
            this.f41527b.add(bVar);
        } else {
            this.f41527b.remove(bVar);
        }
        n();
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z11, b bVar2, boolean z12) {
        synchronized (this) {
            a(bVar, z11);
            a(bVar2, z12);
        }
    }

    /* access modifiers changed from: private */
    public void b(final JSONObject jSONObject, final HttpURLConnection httpURLConnection, final String str) {
        String str2 = f41526a;
        bo.h(str2, "Downloaded new metadata.");
        br.a("m", jSONObject);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("metaDataDownloadSuccess: ");
        sb2.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        bo.f(str2, sb2.toString());
        this.f41537l.c().b((fi) new fi() {
            public void run() {
                try {
                    if (bz.this.f41547v != null) {
                        bz.this.f41547v.a(jSONObject);
                        if (bz.this.f41547v.b()) {
                            bz.this.d(false);
                            return;
                        }
                    }
                    cb b11 = cb.b(jSONObject, bz.this.f41537l);
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.ETAG);
                    bo.f(bz.f41526a, "call experimentManager.processNewPermanentMetaData");
                    if (bz.this.f41546u != null) {
                        bz.this.f41546u.a(b11, str, headerField);
                    }
                    bz.this.d(true);
                } catch (JSONException e11) {
                    bo.b(bz.f41526a, "Error decoding/encoding metadata.", e11);
                    bz.this.d(false);
                } catch (ca e12) {
                    bo.b(bz.f41526a, "Metadata was invalid.", e12);
                    bz.this.d(false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z11, b bVar2, boolean z12, b bVar3, boolean z13) {
        synchronized (this) {
            a(bVar, z11);
            a(bVar2, z12);
            a(bVar3, z13);
        }
    }

    public void a(boolean z11) {
        if (this.f41530e.b()) {
            d(z11);
        }
    }

    public void a(final aw awVar, final List<String> list, final String str, eu euVar) {
        if (!this.f41529d.get() && this.f41530e.a()) {
            bo.f(f41526a, "PrefetchMetadata");
            a(b.MetadataIsStale, true, b.PrefetchInProgress, true);
            this.f41533h = euVar;
            this.f41530e.a(euVar.d());
            new Thread(new fi() {
                public void run() {
                    for (String str : list) {
                        try {
                            String m11 = bz.f41526a;
                            bo.f(m11, "PrefetchMetadata from  " + str);
                            bz.this.w();
                            awVar.a(str, "0", (ax<JSONObject>) new ax<JSONObject>() {
                                public void b() {
                                    bo.f(bz.f41526a, "PrefetchMetadata in offline mode. Not prefetching metadata.");
                                    bz.this.f41530e.a(true);
                                    bz.this.d(false);
                                }

                                public void a(JSONObject jSONObject, HttpURLConnection httpURLConnection) {
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    bz.this.a(jSONObject, httpURLConnection, str);
                                    bo.h(bz.f41526a, "PrefetchMetadata received new metadata");
                                }

                                public void a(HttpURLConnection httpURLConnection) {
                                    bo.j(bz.f41526a, "PrefetchMetadata failure");
                                    bz.this.d(false);
                                }

                                public void a() {
                                    bo.f(bz.f41526a, "PrefetchMetadata no change");
                                    bz.this.d(true);
                                }
                            });
                        } catch (Exception e11) {
                            String m12 = bz.f41526a;
                            bo.j(m12, "PrefetchMetadata failure: " + e11.getMessage());
                            bz.this.d(false);
                        }
                    }
                }
            }).start();
        }
    }

    private void a(aw awVar, Properties properties, g gVar, y yVar, eg egVar, final au auVar, boolean z11) throws as.a {
        Class<bz> cls = bz.class;
        this.f41535j = awVar;
        this.f41536k = auVar.b();
        this.f41547v = gVar;
        this.f41544s = yVar;
        this.f41534i = egVar;
        this.f41537l = auVar;
        this.f41540o = z11;
        this.f41541p = as.h(properties);
        this.f41542q = a(properties);
        this.f41543r = b(properties);
        try {
            this.f41538m = new ap.a(this).a("metadataDownloaded", cls.getDeclaredMethod("o", new Class[0])).a(auVar.d());
            this.f41539n = new ag.a(this).a("requestDownload", cls.getDeclaredMethod("p", new Class[0])).a("downloadNowAsync", cls.getDeclaredMethod("i", new Class[0])).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f41526a, "Error binding", e11);
        }
        this.f41528c.set(this.f41536k.a(new fi() {
            public void run() {
                if (auVar.d().c()) {
                    bz bzVar = bz.this;
                    b bVar = b.IsDownloading;
                    b bVar2 = b.MetadataIsStale;
                    bzVar.a(bVar, true, bVar2, true, b.WillDownload, false);
                    boolean d11 = bz.this.r();
                    if (!d11) {
                        bo.e(bz.f41526a, "Failed to download metadata from all available URLs");
                        bz.this.k();
                    }
                    bz.this.o();
                    bz.this.a(bVar, false, bVar2, !d11);
                }
            }
        }, f()));
        this.f41539n.a("requestDownload", new Object[0]);
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return Long.valueOf(bz.this.f41548w.getCount());
            }
        };
    }

    public void a(aw awVar, cc ccVar, e eVar, c cVar, Properties properties, g gVar, y yVar, eg egVar, au auVar, boolean z11, boolean z12) throws as.a {
        boolean z13 = false;
        boolean z14 = true;
        if (this.f41529d.compareAndSet(false, true)) {
            bo.f(f41526a, "experimentManagerStarted");
            this.f41545t = eVar;
            this.f41546u = cVar;
            cc ccVar2 = ccVar;
            this.f41531f.set(ccVar);
            a(awVar, properties, gVar, yVar, egVar, auVar, z11);
            egVar.a(this);
            a(yVar);
            long l11 = l();
            if (!z12 || !this.f41530e.c()) {
                z14 = false;
            }
            boolean c11 = this.f41530e.c();
            Long f11 = f();
            if (z14 || f11 == null || auVar.b().b() >= f11.longValue() + l11) {
                z13 = c11;
            } else {
                o();
            }
            if (this.f41530e.f() != null) {
                q();
            }
            if (!this.f41530e.e()) {
                b(z13);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, HttpURLConnection httpURLConnection, String str) {
        bs.b("PrefetchMetadata got metadata");
        bo.g(f41526a, "PrefetchMetadata got metadata");
        this.f41530e.a(jSONObject, httpURLConnection, str);
        if (this.f41529d.get()) {
            q();
        }
    }

    public void a(long j11) {
        String str = f41526a;
        bo.f(str, "start waitForInitialMetaData " + j11);
        try {
            this.f41548w.await(j11, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            bo.g(f41526a, "Apptimize thread interrupted while awaiting metadata download.", e11);
        }
        bo.f(f41526a, "end waitForInitialMetaData");
    }

    private a a(String str, final String str2) {
        bo.c(f41526a, "starting metadata download");
        cc ccVar = this.f41531f.get();
        String d11 = (ccVar == null || ccVar.i() == null || !fx.a().equals(ccVar.i())) ? null : ccVar.d();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        w();
        this.f41535j.a(str, d11, (ax<JSONObject>) new ax<JSONObject>() {
            public void b() {
                bz.this.u();
                atomicReference.set(a.OFFLINE);
                bz.this.z();
                bz.this.x();
                bz.this.o();
            }

            public void a(JSONObject jSONObject, HttpURLConnection httpURLConnection) {
                bz.this.u();
                atomicReference.set(a.SUCCESS_CHANGED);
                bz.this.b(jSONObject, httpURLConnection, str2);
                bz.this.x();
            }

            public void a(HttpURLConnection httpURLConnection) {
                bz.this.v();
                atomicReference.set(a.FAILED);
                bz.this.a(httpURLConnection);
                bz.this.x();
            }

            public void a() {
                bz.this.u();
                atomicReference.set(a.SUCCESS_NO_CHANGE);
                bz.this.y();
                bz.this.x();
            }
        });
        return (a) atomicReference.get();
    }

    /* access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection) {
        String str = httpURLConnection == null ? "null connection" : "unknown";
        int i11 = 0;
        if (httpURLConnection != null) {
            try {
                i11 = httpURLConnection.getResponseCode();
                str = httpURLConnection.getResponseMessage();
            } catch (IOException unused) {
            }
        }
        String str2 = f41526a;
        bo.h(str2, "Request for new metadata failed code:" + i11 + " " + str);
    }

    private void a(y yVar) {
        if (yVar != null) {
            yVar.a(this);
        }
    }

    public void a(Activity activity) {
        boolean z11;
        e eVar;
        boolean z12;
        bo.f(f41526a, "*** foreground ***");
        this.f41532g.b();
        long c11 = c(false);
        if (c11 <= 0 || this.f41528c.get() == null || !this.f41528c.get().b() || this.f41545t == null) {
            z11 = false;
        } else {
            long a11 = this.f41528c.get().a();
            EnumSet<b> e11 = e();
            z11 = true;
            if (!e11.contains(b.IsDownloading) && !e11.contains(b.PrefetchInProgress)) {
                b bVar = b.WillDownload;
                if (!e11.contains(bVar)) {
                    z12 = c11 - a11 < 100;
                    a(bVar, z12);
                    this.f41545t.a(z12);
                    this.f41528c.get().a(c11, z12);
                }
            }
            this.f41545t.a(true);
            z12 = false;
            this.f41528c.get().a(c11, z12);
        }
        if (!z11 && (eVar = this.f41545t) != null) {
            eVar.a(false);
        }
    }
}
