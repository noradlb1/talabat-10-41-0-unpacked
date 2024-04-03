package com.apptimize;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import com.apptimize.ag;
import com.apptimize.bd;
import com.apptimize.dp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class dr {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41957a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f41958b = "dr";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final bd.a f41959c;

    /* renamed from: d  reason: collision with root package name */
    private final dm f41960d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final eg f41961e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ev f41962f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final au f41963g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ds f41964h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ag f41965i;

    /* renamed from: j  reason: collision with root package name */
    private b f41966j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final long f41967k;

    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final File f42005b;

        private File b(String str) {
            File file = this.f42005b;
            return new File(file, b() + str);
        }

        /* access modifiers changed from: private */
        public String b() {
            return "apptimize_event_";
        }

        private a(File file) {
            this.f42005b = file;
        }

        public void a(dp.d<?, ?> dVar) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            String uuid = UUID.randomUUID().toString();
            dVar.a(uuid);
            File b11 = b(uuid);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(b11);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(dVar);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e11) {
                String j11 = dr.f41958b;
                bo.k(j11, "Failed to save an event to file " + b11.getAbsolutePath());
                String j12 = dr.f41958b;
                bo.k(j12, "Failed to save an event to file " + e11.getMessage());
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }

        public List<dp.d<?, ?>> a() {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            File[] listFiles = this.f42005b.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(a.this.b());
                }
            });
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    arrayList.add((dp.d) objectInputStream.readObject());
                    objectInputStream.close();
                    fileInputStream.close();
                    if (!file.exists()) {
                    }
                } catch (Exception e11) {
                    bo.k(dr.f41958b, "Failed to restore an event from file " + file.getAbsolutePath());
                    bo.k(dr.f41958b, "Failed to restore an event from file " + e11.getMessage());
                    if (!file.exists()) {
                    }
                } catch (Throwable th2) {
                    if (file.exists()) {
                        file.delete();
                    }
                    throw th2;
                }
                file.delete();
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return arrayList;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            if (str != null) {
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                File b11 = b(str);
                if (b11.exists()) {
                    b11.delete();
                }
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public interface b {
        void a();

        void a(dp.d<?, ?> dVar, dq dqVar);

        void a(String str);

        void a(List<JSONObject> list, HttpURLConnection httpURLConnection);

        void a(Set<dp.k> set);

        boolean b();

        void c();

        void d();

        void e();
    }

    public dr(Context context, bd.a aVar, dm dmVar, eg egVar, au auVar, ds dsVar, ev evVar) {
        Class<dr> cls = dr.class;
        this.f41959c = aVar;
        this.f41960d = dmVar;
        this.f41961e = egVar;
        this.f41963g = auVar;
        this.f41964h = dsVar;
        this.f41962f = evVar;
        this.f41967k = auVar.e().e();
        try {
            this.f41965i = new ag.a(this).a("addEntry", cls.getDeclaredMethod("b", new Class[]{dp.d.class, dq.class})).a("setUserId", cls.getDeclaredMethod("a", new Class[]{String.class})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f41958b, "Error binding", e11);
        }
        this.f41966j = a(context);
    }

    public void b(List<db> list) {
    }

    public boolean h() {
        if (this.f41963g.d().c() && i() != 0) {
            return true;
        }
        return false;
    }

    public int i() {
        int e11;
        this.f41963g.d().e();
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            bd b11 = this.f41959c.b();
            synchronized (this.f41964h) {
                bh b12 = b11.b();
                try {
                    e11 = b12.e() + this.f41964h.b();
                    b12.b();
                } finally {
                    b12.c();
                }
            }
            return e11;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public void c() {
        this.f41966j.d();
    }

    public void d() {
        this.f41966j.e();
    }

    public void e() {
        c(dp.b.c(), dq.LAZY);
    }

    public void f() {
        c(dp.a.c(), dq.EAGER);
    }

    public List<JSONObject> g() {
        List<JSONObject> d11;
        this.f41963g.d().e();
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            bd b11 = this.f41959c.b();
            synchronized (this.f41964h) {
                this.f41964h.c();
                bh b12 = b11.b();
                try {
                    d11 = b12.d();
                    b12.b();
                } finally {
                    b12.c();
                }
            }
            return d11;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    private void c(dp.d<?, ?> dVar, dq dqVar) {
        if (!this.f41966j.b()) {
            a(dVar);
            a(dVar, dqVar);
        }
    }

    public void a(String str) {
        this.f41966j.a(str);
    }

    public void b() {
        this.f41966j.c();
    }

    private void b(dp.d<?, ?> dVar, dq dqVar) {
        this.f41966j.a(dVar, dqVar);
    }

    public void a() {
        this.f41966j.a();
    }

    /* access modifiers changed from: private */
    public void b(dp.d<?, ?> dVar) {
        if (dVar.e() == 0) {
            dVar.c(this.f41963g.e().b());
        }
        if (dVar.d() == 0) {
            dVar.b(this.f41963g.e().c());
        }
        dVar.a(this.f41967k);
    }

    public void a(Set<dp.k> set) {
        this.f41966j.a(set);
    }

    public void a(dp.d<?, ?> dVar, dq dqVar) {
        b(dVar, dqVar);
    }

    public void a(String str, dp.k kVar, Map<String, Object> map) {
        c(dp.g.c().c(str).a(kVar).b(map), dq.EAGER);
    }

    public void a(String str, Map<String, Object> map) {
        c(dp.h.c().c(str).b(map), dq.LAZY);
    }

    public void a(ek ekVar) {
        c(dp.p.c().f(ekVar.b()).a(ekVar), dq.EAGER);
    }

    public void a(int i11, Set<Long> set, List<ek> list) {
        c(dp.j.c().a(i11).a(set).a(list), dq.EAGER);
    }

    public void a(Set<Long> set, List<ek> list) {
        c(dp.c.c().a(set).a(list).b(this.f41960d.a(dl.b())), dq.EAGER);
    }

    public void a(List<db> list) {
        c(dp.f.c().a(list), dq.LAZY);
    }

    public void a(List<JSONObject> list, HttpURLConnection httpURLConnection) {
        this.f41966j.a(list, httpURLConnection);
    }

    /* access modifiers changed from: private */
    public void a(dp.d<?, ?> dVar) {
        dVar.a(this.f41960d.a(dl.b()));
    }

    private b a(final Context context) {
        return new b() {
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public final b f41970c = this;

            /* renamed from: d  reason: collision with root package name */
            private volatile boolean f41971d = false;

            /* renamed from: e  reason: collision with root package name */
            private long f41972e = 0;

            /* renamed from: f  reason: collision with root package name */
            private long f41973f = 0;

            /* renamed from: g  reason: collision with root package name */
            private int f41974g = 0;

            /* renamed from: h  reason: collision with root package name */
            private boolean f41975h = false;

            /* renamed from: i  reason: collision with root package name */
            private String f41976i = null;

            /* renamed from: j  reason: collision with root package name */
            private String f41977j = null;
            /* access modifiers changed from: private */

            /* renamed from: k  reason: collision with root package name */
            public AtomicReference<CountDownLatch> f41978k = new AtomicReference<>((Object) null);

            /* renamed from: l  reason: collision with root package name */
            private boolean f41979l = false;
            /* access modifiers changed from: private */

            /* renamed from: m  reason: collision with root package name */
            public a f41980m;

            /* renamed from: n  reason: collision with root package name */
            private Map<String, Object> f41981n;
            /* access modifiers changed from: private */

            /* renamed from: o  reason: collision with root package name */
            public boolean f41982o = false;

            /* renamed from: p  reason: collision with root package name */
            private List<dp.d> f41983p = new ArrayList();

            /* renamed from: q  reason: collision with root package name */
            private Handler f41984q;

            /* renamed from: com.apptimize.dr$1$a */
            public class a extends Thread {

                /* renamed from: b  reason: collision with root package name */
                private Looper f42002b;

                /* renamed from: c  reason: collision with root package name */
                private CountDownLatch f42003c = new CountDownLatch(1);

                public a() {
                }

                public Looper a() {
                    try {
                        this.f42003c.await();
                        return this.f42002b;
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }

                public void run() {
                    Looper.prepare();
                    this.f42002b = Looper.myLooper();
                    this.f42003c.countDown();
                    Looper.loop();
                }
            }

            {
                f();
                this.f41984q = null;
            }

            private void f() {
                g();
                if (dr.this.f41963g.d().c()) {
                    dr.this.f41962f.a(new fi() {
                        public void run() {
                            AnonymousClass1.this.i();
                            AnonymousClass1.this.h();
                            for (dp.d<?, ?> a11 : AnonymousClass1.this.f41980m.a()) {
                                AnonymousClass1.this.a(a11, dq.LAZY);
                            }
                        }
                    });
                }
            }

            private void g() {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                this.f41980m = new a(context.getCacheDir());
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }

            /* access modifiers changed from: private */
            public void h() {
                bh b11;
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    b11 = dr.this.f41959c.b().b();
                    try {
                        JSONObject f11 = b11.f();
                        int e11 = b11.e();
                        b11.b();
                        if (f11 != null) {
                            this.f41973f = dp.a(f11);
                            this.f41972e = dp.b(f11);
                            this.f41981n = Collections.unmodifiableMap(new HashMap(dp.c(f11)));
                            this.f41974g = e11;
                            String d11 = dp.d(f11);
                            this.f41976i = d11;
                            this.f41977j = d11;
                        }
                    } catch (JSONException e12) {
                        bo.e(dr.f41958b, "entry_store did not hold a JSON value in the expected format", e12);
                    }
                    b11.c();
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                } catch (Throwable th2) {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th2;
                }
            }

            /* access modifiers changed from: private */
            public void i() {
                if (dr.f41957a) {
                    if (this.f41984q == null) {
                        a aVar = new a();
                        aVar.start();
                        this.f41984q = new Handler(aVar.a());
                    }
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.f41984q.post(new fi() {
                        public void run() {
                            synchronized (AnonymousClass1.this.f41970c) {
                                countDownLatch.countDown();
                            }
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                    }
                }
            }

            private void e(dp.d<?, ?> dVar) {
                long e11 = dVar.e();
                long j11 = this.f41972e;
                if (e11 > j11) {
                    dVar.d(dVar.e());
                    this.f41972e = dVar.e();
                    return;
                }
                dVar.d(j11 + 1);
                this.f41972e++;
            }

            public synchronized boolean b() {
                return this.f41971d;
            }

            public void c() {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                if (i.b.a(this.f41978k, (Object) null, countDownLatch)) {
                    dr.this.f41962f.a(new fi() {
                        public void run() {
                            try {
                                AnonymousClass1.this.i();
                                countDownLatch.await(1, TimeUnit.SECONDS);
                                i.b.a(AnonymousClass1.this.f41978k, countDownLatch, (Object) null);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                }
            }

            public void d() {
                CountDownLatch andSet = this.f41978k.getAndSet((Object) null);
                if (andSet != null) {
                    andSet.countDown();
                }
            }

            /* access modifiers changed from: private */
            public void b(String str) {
                if (!this.f41971d) {
                    this.f41977j = str;
                    if (!fx.a((Object) this.f41976i, (Object) str) && a(2)) {
                        dp.n.a<?> c11 = dp.n.c();
                        c11.c(str);
                        dr.this.a((dp.d<?, ?>) c11);
                        dr.this.b((dp.d<?, ?>) c11);
                        a((dp.d<?, ?>) c11);
                        String str2 = this.f41976i;
                        this.f41976i = str;
                        dp.o.a<?> c12 = dp.o.c();
                        c12.c(str2);
                        dr.this.a((dp.d<?, ?>) c12);
                        dr.this.b((dp.d<?, ?>) c12);
                        a((dp.d<?, ?>) c12);
                    }
                }
            }

            private void d(dp.d<?, ?> dVar) {
                if (dVar.e() <= this.f41972e - 60000) {
                    a(dVar.e(), dVar.d());
                }
            }

            private void c(dp.d<?, ?> dVar) {
                dr.this.f41963g.d().e();
                Map<String, Object> g11 = dVar.g();
                Map<String, Object> map = this.f41981n;
                if (!(map == null || ey.a(g11, map) || dVar.h() == dp.m.ATTRIBUTES_CHANGED)) {
                    bo.l(dr.f41958b, "Prefixed attributes changed, but Entry is not an AttributesChangedEntry.");
                }
                this.f41981n = g11;
            }

            public synchronized void a() {
                if (!this.f41971d) {
                    this.f41971d = true;
                    dr.this.f41964h.a();
                }
            }

            public void e() {
                dr.this.f41962f.a(new fi() {
                    public void run() {
                        AnonymousClass1.this.i();
                        boolean unused = AnonymousClass1.this.f41982o = true;
                    }
                });
            }

            public void a(final String str) {
                dr.this.f41962f.a(new fi() {
                    public void run() {
                        if (dr.this.f41963g.d().c()) {
                            AnonymousClass1.this.i();
                            AnonymousClass1.this.b(str);
                            return;
                        }
                        dr.this.f41965i.a("setUserId", str);
                    }
                });
            }

            public void a(final dp.d<?, ?> dVar, final dq dqVar) {
                dr.this.f41962f.a(new fi() {
                    public void run() {
                        if (dr.this.f41963g.d().c()) {
                            dr.this.b((dp.d<?, ?>) dVar);
                            AnonymousClass1.this.i();
                            AnonymousClass1.this.b((dp.d<?, ?>) dVar, dqVar);
                            AnonymousClass1.this.f41980m.a(dVar.b());
                            return;
                        }
                        AnonymousClass1.this.f41980m.a((dp.d<?, ?>) dVar);
                        dr.this.f41965i.a("addEntry", dVar, dqVar);
                    }
                });
            }

            /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[SYNTHETIC, Splitter:B:11:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private com.apptimize.dp.d<?, ?> c(java.util.List<org.json.JSONObject> r10, java.net.HttpURLConnection r11) {
                /*
                    r9 = this;
                    com.apptimize.dr r0 = com.apptimize.dr.this
                    com.apptimize.au r0 = r0.f41963g
                    com.apptimize.ak r0 = r0.d()
                    r0.e()
                    r0 = 0
                    r1 = -1
                    java.lang.Object r0 = r10.get(r0)     // Catch:{ JSONException -> 0x002d }
                    org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x002d }
                    long r3 = com.apptimize.dp.a((org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x002d }
                    int r0 = r10.size()     // Catch:{ JSONException -> 0x002b }
                    int r0 = r0 + -1
                    java.lang.Object r10 = r10.get(r0)     // Catch:{ JSONException -> 0x002b }
                    org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ JSONException -> 0x002b }
                    long r5 = com.apptimize.dp.a((org.json.JSONObject) r10)     // Catch:{ JSONException -> 0x002b }
                    goto L_0x0039
                L_0x002b:
                    r10 = move-exception
                    goto L_0x002f
                L_0x002d:
                    r10 = move-exception
                    r3 = r1
                L_0x002f:
                    java.lang.String r0 = com.apptimize.dr.f41958b
                    java.lang.String r5 = "Entry JSON did not have Entry ID."
                    com.apptimize.bo.e(r0, r5, r10)
                    r5 = r1
                L_0x0039:
                    java.lang.String r10 = "Date"
                    java.lang.String r10 = r11.getHeaderField(r10)
                    if (r10 == 0) goto L_0x006b
                    java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0051 }
                    java.lang.String r0 = "EEE, dd MMM yyyy HH:mm:ss zzz"
                    r11.<init>(r0)     // Catch:{ ParseException -> 0x0051 }
                    java.util.Date r11 = r11.parse(r10)     // Catch:{ ParseException -> 0x0051 }
                    long r1 = r11.getTime()     // Catch:{ ParseException -> 0x0051 }
                    goto L_0x0074
                L_0x0051:
                    r11 = move-exception
                    java.lang.String r0 = com.apptimize.dr.f41958b
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "Could not parse date from server: "
                    r7.append(r8)
                    r7.append(r10)
                    java.lang.String r10 = r7.toString()
                    com.apptimize.bo.b(r0, r10, r11)
                    goto L_0x0074
                L_0x006b:
                    java.lang.String r10 = com.apptimize.dr.f41958b
                    java.lang.String r11 = "No Date header was found in results posting response. This is expected if using a local backend."
                    com.apptimize.bo.c(r10, r11)
                L_0x0074:
                    com.apptimize.dp$l$a r10 = com.apptimize.dp.l.c()
                    com.apptimize.dr r11 = com.apptimize.dr.this
                    r11.a((com.apptimize.dp.d<?, ?>) r10)
                    com.apptimize.dr r11 = com.apptimize.dr.this
                    r11.b((com.apptimize.dp.d<?, ?>) r10)
                    com.apptimize.dp$l$a r10 = r10.f(r1)
                    com.apptimize.dp$l$a r10 = r10.g(r3)
                    com.apptimize.dp$l$a r10 = r10.h(r5)
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dr.AnonymousClass1.c(java.util.List, java.net.HttpURLConnection):com.apptimize.dp$d");
            }

            public void a(final List<JSONObject> list, final HttpURLConnection httpURLConnection) {
                dr.this.f41962f.a(new fi() {
                    public void run() {
                        AnonymousClass1.this.i();
                        AnonymousClass1.this.b((List<JSONObject>) list, httpURLConnection);
                    }
                });
            }

            private void a(dp.d<?, ?> dVar) {
                dVar.b(this.f41976i);
                e(dVar);
                if (this.f41982o) {
                    this.f41983p.add(dVar);
                } else {
                    b(dVar);
                }
            }

            private boolean a(int i11) {
                int size = this.f41974g + this.f41983p.size();
                boolean z11 = this.f41975h;
                if (!z11 && i11 + size <= 1000) {
                    return true;
                }
                if (z11) {
                    return false;
                }
                dp.e.a<?> c11 = dp.e.c();
                dr.this.a((dp.d<?, ?>) c11);
                dr.this.b((dp.d<?, ?>) c11);
                c11.a(size);
                a((dp.d<?, ?>) c11);
                this.f41975h = true;
                return false;
            }

            /* access modifiers changed from: private */
            public void b(dp.d<?, ?> dVar, dq dqVar) {
                dr.this.f41963g.d().e();
                if (!this.f41971d) {
                    c(dVar);
                    boolean z11 = dVar.h() == dp.m.ELEMENT_SHOWN;
                    if (!z11 || !this.f41979l) {
                        this.f41979l = z11;
                        if (a(2)) {
                            d(dVar);
                            a(dVar);
                            if (dqVar == dq.EAGER) {
                                dr.this.f41964h.c();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    bo.a(dr.f41958b, "This and previous entry are of type 'es'; skipping.");
                }
            }

            private void a(long j11, long j12) {
                if (!this.f41971d) {
                    dp.i.a c11 = dp.i.c();
                    dr.this.a((dp.d<?, ?>) c11);
                    c11.c(j11);
                    c11.b(j12);
                    c11.a(dr.this.f41967k);
                    this.f41972e = j11 - 1;
                    c11.f(this.f41972e + 1).g(j11);
                    a((dp.d<?, ?>) c11);
                }
            }

            /* JADX WARNING: type inference failed for: r5v0, types: [com.apptimize.dp$d<?, ?>, com.apptimize.dp$d] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void b(com.apptimize.dp.d<?, ?> r5) {
                /*
                    r4 = this;
                    long r0 = r4.f41973f     // Catch:{ JSONException -> 0x0024 }
                    r2 = 1
                    long r0 = r0 + r2
                    r5.e((long) r0)     // Catch:{ JSONException -> 0x0024 }
                    long r0 = r4.f41973f     // Catch:{ JSONException -> 0x0024 }
                    long r0 = r0 + r2
                    r4.f41973f = r0     // Catch:{ JSONException -> 0x0024 }
                    com.apptimize.dp r5 = r5.f()     // Catch:{ JSONException -> 0x0024 }
                    r5.b()     // Catch:{ JSONException -> 0x0024 }
                    com.apptimize.dr r0 = com.apptimize.dr.this     // Catch:{ JSONException -> 0x0024 }
                    com.apptimize.ds r0 = r0.f41964h     // Catch:{ JSONException -> 0x0024 }
                    r0.a((com.apptimize.dp) r5)     // Catch:{ JSONException -> 0x0024 }
                    int r5 = r4.f41974g     // Catch:{ JSONException -> 0x0024 }
                    int r5 = r5 + 1
                    r4.f41974g = r5     // Catch:{ JSONException -> 0x0024 }
                    goto L_0x0030
                L_0x0024:
                    r5 = move-exception
                    java.lang.String r0 = com.apptimize.dr.f41958b
                    java.lang.String r5 = r5.getMessage()
                    com.apptimize.bo.g(r0, r5)
                L_0x0030:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dr.AnonymousClass1.b(com.apptimize.dp$d):void");
            }

            public void a(final Set<dp.k> set) {
                dr.this.f41962f.a(new fi() {
                    public void run() {
                        AnonymousClass1.this.i();
                        AnonymousClass1.this.b((Set<dp.k>) set);
                    }
                });
            }

            public void b(List<JSONObject> list, HttpURLConnection httpURLConnection) {
                dr.this.f41963g.d().e();
                if (list.size() != 0) {
                    boolean z11 = this.f41975h;
                    StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        bd b11 = dr.this.f41959c.b();
                        synchronized (dr.this.f41964h) {
                            bi c11 = b11.c();
                            try {
                                c11.a(list, dr.this.f41961e.f().h().intValue());
                                int e11 = c11.e() + dr.this.f41964h.b();
                                this.f41974g = e11;
                                if (e11 == 0) {
                                    this.f41975h = false;
                                }
                                if (a(1)) {
                                    a(c(list, httpURLConnection));
                                }
                                if (!fx.a((Object) this.f41977j, (Object) this.f41976i)) {
                                    b(this.f41977j);
                                }
                                dr.this.f41964h.a(c11);
                                c11.b();
                                c11.c();
                                dr.this.f41964h.d();
                                this.f41974g = dr.this.i();
                            } catch (Throwable th2) {
                                c11.c();
                                this.f41975h = z11;
                                this.f41974g = dr.this.i();
                                throw th2;
                            }
                        }
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    }
                }
            }

            /* access modifiers changed from: private */
            public void b(Set<dp.k> set) {
                if (this.f41982o) {
                    this.f41982o = false;
                    for (dp.d next : this.f41983p) {
                        dp.k c11 = next.c();
                        if (c11 == null || set.contains(c11)) {
                            b((dp.d<?, ?>) next);
                        }
                    }
                    this.f41983p.clear();
                    dr.this.f41964h.c();
                }
            }
        };
    }
}
