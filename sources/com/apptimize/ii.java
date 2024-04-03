package com.apptimize;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.webkit.ProxyConfig;
import com.apptimize.ag;
import com.apptimize.ap;
import com.apptimize.bg;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ii implements ao, bg {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43033a = "ii";

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f43034b = Collections.unmodifiableSet(new HashSet<String>() {
        {
            add("image");
            add("background");
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Map<URI, Drawable> f43035c = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Drawable, URI> f43036d = DesugarCollections.synchronizedMap(new WeakHashMap());

    /* renamed from: e  reason: collision with root package name */
    private final Set<URI> f43037e = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: f  reason: collision with root package name */
    private final Map<URI, ScheduledFuture<?>> f43038f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f43039g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f43040h = new AtomicInteger(-1);

    /* renamed from: i  reason: collision with root package name */
    private final Map<Integer, ez> f43041i = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final au f43042j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f43043k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final ig f43044l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Cif> f43045m;

    /* renamed from: n  reason: collision with root package name */
    private final a f43046n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final b f43047o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final ap f43048p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final ag f43049q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public gq f43050r;

    public class a implements ih {

        /* renamed from: b  reason: collision with root package name */
        private List<URI> f43056b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f43057c;

        /* renamed from: d  reason: collision with root package name */
        private BitmapDrawable f43058d;

        private a() {
            this.f43056b = new CopyOnWriteArrayList();
            this.f43057c = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            this.f43058d = new BitmapDrawable(a(), this.f43057c);
        }

        public URI a(Drawable drawable) {
            throw new UnsupportedOperationException();
        }

        public void b() {
            this.f43056b.clear();
        }

        public List<URI> c() {
            return new ArrayList(this.f43056b);
        }

        public Drawable a(URI uri) {
            this.f43056b.add(uri);
            return this.f43058d;
        }

        public void b(Drawable drawable) {
            throw new UnsupportedOperationException();
        }

        public Resources a() {
            return ii.this.e();
        }
    }

    public class b {

        /* renamed from: b  reason: collision with root package name */
        private final Map<URI, CountDownLatch> f43060b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<URI> f43061c;

        public void b(URI uri) {
            CountDownLatch countDownLatch;
            synchronized (this.f43060b) {
                countDownLatch = this.f43060b.get(uri);
                if (countDownLatch == null) {
                    countDownLatch = new CountDownLatch(1);
                    this.f43060b.put(uri, countDownLatch);
                }
            }
            ii.this.f43049q.a("requestUriDownload", uri.toString());
            while (countDownLatch.getCount() != 0) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e11) {
                    bo.g(ii.f43033a, "Interrupted while awaiting uri download", e11);
                }
            }
        }

        public void c(URI uri) {
            CountDownLatch remove;
            synchronized (this.f43060b) {
                this.f43061c.add(uri);
                remove = this.f43060b.remove(uri);
            }
            if (remove != null) {
                remove.countDown();
            }
            ii.this.f43048p.b("uriDownloaded", ii.this.a(), uri.toString());
        }

        private b() {
            this.f43060b = new ConcurrentHashMap();
            this.f43061c = Collections.newSetFromMap(new ConcurrentHashMap());
        }

        public boolean a(URI uri) {
            return !ii.this.f43042j.d().c();
        }

        public void a(URI uri, byte[] bArr) {
            if (ii.this.f43044l.c(uri) || ii.this.f43042j.d().b()) {
                ii.this.f43044l.a(uri, bArr);
                ii.this.f43047o.c(uri);
            }
        }

        /* access modifiers changed from: private */
        public void a() {
            if (ii.this.f43042j.d().c() || (ii.this.f43050r != null && ii.this.f43050r.d())) {
                ii.this.f43044l.a(this.f43061c);
            }
        }
    }

    public class c {
        public void a(URI uri, Bitmap bitmap) {
            ii.this.b(uri, bitmap);
        }

        private c() {
        }
    }

    public ii(Context context, ExecutorService executorService, eb ebVar, au auVar) {
        ap apVar;
        Class<String> cls = String.class;
        Class<ii> cls2 = ii.class;
        ag agVar = null;
        b bVar = new b();
        this.f43047o = bVar;
        this.f43043k = context.getApplicationContext();
        this.f43042j = auVar;
        this.f43044l = new ig(new c(), context, executorService, ebVar, bVar);
        this.f43046n = new a();
        this.f43045m = new HashMap();
        for (String put : f43034b) {
            this.f43045m.put(put, Cif.a((ih) this.f43046n));
        }
        try {
            apVar = new ap.a(this).a("uriDownloaded", cls2.getDeclaredMethod("b", new Class[]{cls})).a(auVar.d());
            try {
                agVar = new ag.a(this).a("requestUriDownload", cls2.getDeclaredMethod(c.f41585a, new Class[]{cls})).a(auVar.d());
            } catch (NoSuchMethodException e11) {
                e = e11;
                bo.e(f43033a, "Error binding", e);
                this.f43048p = apVar;
                this.f43049q = agVar;
            }
        } catch (NoSuchMethodException e12) {
            e = e12;
            apVar = null;
            bo.e(f43033a, "Error binding", e);
            this.f43048p = apVar;
            this.f43049q = agVar;
        }
        this.f43048p = apVar;
        this.f43049q = agVar;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    private void b(String str) {
        URI uri;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e11) {
            bo.g(f43033a, "Bad uri string", e11);
            uri = null;
        }
        if (uri != null) {
            this.f43047o.c(uri);
        }
    }

    private void c(String str) {
        URI uri;
        this.f43042j.d().e();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e11) {
            bo.g(f43033a, "Bad uri string", e11);
            uri = null;
        }
        if (uri != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(uri);
            c(linkedList, new ez() {
                public void a() {
                }

                public void b() {
                }
            });
        }
    }

    private byte[] d(String str) throws IOException {
        if (str.startsWith("data:image/png;base64,")) {
            return ew.a(str.substring(22));
        }
        throw new IOException("Malformed data URI " + str);
    }

    private void h() {
        if (this.f43037e.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f43041i.keySet());
            Integer valueOf = Integer.valueOf(this.f43040h.get());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                ez remove = this.f43041i.remove(num);
                if (remove != null) {
                    if (num.intValue() > valueOf.intValue()) {
                        remove.a();
                    } else {
                        remove.b();
                    }
                }
            }
            this.f43047o.a();
        }
    }

    public Resources e() {
        return this.f43043k.getResources();
    }

    public ih f() {
        return new d();
    }

    public static boolean a(String str) {
        return f43034b.contains(str);
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return 0L;
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        com.apptimize.bo.g(f43033a, "Error when prefetching images", r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[ExcHandler: hk (e com.apptimize.hk), Splitter:B:1:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.net.URI> b(java.util.List<com.apptimize.dc> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Error when prefetching images"
            java.util.List r6 = com.apptimize.dc.a((java.util.List<com.apptimize.dc>) r6)
            com.apptimize.ii$a r1 = r5.f43046n
            r1.b()
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
        L_0x000f:
            boolean r1 = r6.hasNext()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r6.next()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            com.apptimize.df r1 = (com.apptimize.df) r1     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            boolean r2 = r1 instanceof com.apptimize.di     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            if (r2 == 0) goto L_0x000f
            com.apptimize.di r1 = (com.apptimize.di) r1     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            java.util.Map<java.lang.String, com.apptimize.if> r2 = r5.f43045m     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            java.lang.String r3 = r1.a()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            boolean r2 = r2.containsKey(r3)     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            if (r2 == 0) goto L_0x000f
            java.util.Map<java.lang.String, com.apptimize.if> r2 = r5.f43045m     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            java.lang.String r3 = r1.a()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            com.apptimize.if r2 = (com.apptimize.Cif) r2     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            java.lang.Object r3 = r1.e()     // Catch:{ JSONException -> 0x0041, hk -> 0x005a }
            a(r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0041, hk -> 0x005a }
            goto L_0x000f
        L_0x0041:
            r3 = move-exception
            java.lang.String r4 = r1.b()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            com.apptimize.jj r2 = r2.a((java.lang.String) r4)     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            if (r2 == 0) goto L_0x0054
            java.lang.Object r1 = r1.e()     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            a(r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            goto L_0x000f
        L_0x0054:
            java.lang.String r1 = f43033a     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            com.apptimize.bo.g(r1, r0, r3)     // Catch:{ JSONException -> 0x005c, hk -> 0x005a }
            goto L_0x000f
        L_0x005a:
            r6 = move-exception
            goto L_0x005d
        L_0x005c:
            r6 = move-exception
        L_0x005d:
            java.lang.String r1 = f43033a
            com.apptimize.bo.g(r1, r0, r6)
        L_0x0062:
            java.lang.String r6 = f43033a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "uris:"
            r0.append(r1)
            com.apptimize.ii$a r1 = r5.f43046n
            java.util.List r1 = r1.c()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.apptimize.bo.k(r6, r0)
            com.apptimize.ii$a r6 = r5.f43046n
            java.util.List r6 = r6.c()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ii.b(java.util.List):java.util.List");
    }

    public void a(gq gqVar) {
        this.f43050r = gqVar;
    }

    private static <S, T> void a(jj<S, T> jjVar, Object obj) throws JSONException, hk {
        String str = f43033a;
        bo.k(str, "trans:" + jjVar + " value:" + obj);
        if (jjVar.a().isInstance(obj)) {
            jjVar.a(jjVar.a().cast(obj));
            return;
        }
        throw new JSONException("When extracting required images, expected GeneralDrawable but received " + obj);
    }

    public class d implements ih {
        private d() {
        }

        public URI a(Drawable drawable) throws URISyntaxException {
            synchronized (ii.this) {
                if (ii.this.f43036d.containsKey(drawable)) {
                    URI uri = (URI) ii.this.f43036d.get(drawable);
                    return uri;
                }
                URI uri2 = new URI("atz-local-image", Integer.toString(ii.this.f43036d.size()), (String) null);
                ii.this.f43036d.put(drawable, uri2);
                return uri2;
            }
        }

        public void b(Drawable drawable) {
            synchronized (ii.this) {
                try {
                    ii.this.f43035c.put(a(drawable), drawable);
                } catch (URISyntaxException e11) {
                    bo.b(ii.f43033a, "Serious invariant violation; unable to construct local URI for image");
                    throw new RuntimeException(e11);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public Drawable a(URI uri) {
            Drawable drawable;
            synchronized (ii.this) {
                drawable = (Drawable) ii.this.f43035c.get(uri);
            }
            return drawable;
        }

        public Resources a() {
            return ii.this.e();
        }
    }

    private void c(List<URI> list, ez ezVar) {
        int incrementAndGet = this.f43039g.incrementAndGet();
        for (URI next : list) {
            if (!this.f43035c.containsKey(next) && this.f43037e.add(next)) {
                String str = f43033a;
                bo.f(str, "Fetching image " + next);
                String scheme = next.getScheme();
                if (scheme.equals("atz-wysiwyg-image")) {
                    a(next, incrementAndGet);
                } else if (scheme.equals(ProxyConfig.MATCH_HTTP) || scheme.equals("https")) {
                    this.f43044l.a(next);
                } else {
                    this.f43037e.remove(next);
                    if (!scheme.equals("atz-local-image")) {
                        bo.j(str, "Unsupported image scheme: " + next);
                    }
                }
            }
        }
        if (ezVar != null) {
            this.f43041i.put(Integer.valueOf(incrementAndGet), ezVar);
        }
        h();
    }

    public void a(List<dc> list, ez ezVar) {
        b(b(list), ezVar);
    }

    private void a(final URI uri, int i11) {
        gq gqVar = this.f43050r;
        if (gqVar == null || !gqVar.d()) {
            b(uri, (Bitmap) null);
            return;
        }
        this.f43038f.put(uri, fg.f42427b.schedule(new Runnable() {
            public void run() {
                ii.this.b(uri, (Bitmap) null);
            }
        }, 500, TimeUnit.MILLISECONDS));
        this.f43050r.a(uri);
    }

    private void a(URI uri, Bitmap bitmap) {
        this.f43047o.c(uri);
        this.f43037e.remove(uri);
        ScheduledFuture remove = this.f43038f.remove(uri);
        if (remove != null) {
            remove.cancel(false);
        }
        if (bitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f43043k.getResources(), bitmap);
            this.f43035c.put(uri, bitmapDrawable);
            this.f43036d.put(bitmapDrawable, uri);
        } else if (this.f43035c.get(uri) == null) {
            a(this.f43039g.get());
        }
    }

    public void b(List<URI> list, ez ezVar) {
        if (!list.isEmpty()) {
            c(list, ezVar);
        } else if (ezVar != null) {
            ezVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void b(URI uri, Bitmap bitmap) {
        String str = f43033a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bitmap != null ? "Received image " : "Failed image ");
        sb2.append(uri);
        bo.h(str, sb2.toString());
        a(uri, bitmap);
        h();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void a(int r3) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicInteger r0 = r2.f43040h
            int r0 = r0.get()
            if (r0 >= r3) goto L_0x0010
            java.util.concurrent.atomic.AtomicInteger r1 = r2.f43040h
            boolean r0 = r1.compareAndSet(r0, r3)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ii.a(int):void");
    }

    public void a(JSONObject jSONObject) {
        try {
            byte[] d11 = d(jSONObject.getString("data"));
            Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(d11, 0, d11.length);
            URI uri = new URI(jSONObject.getString("uri"));
            this.f43047o.a(uri, d11);
            b(uri, decodeByteArray);
        } catch (JSONException e11) {
            bo.f(f43033a, "Unexpected JSON exception: ", e11);
        } catch (IOException e12) {
            bo.f(f43033a, "Unexpected IOExecption: ", e12);
        } catch (URISyntaxException e13) {
            bo.f(f43033a, "Unexpected URISyntaxException: ", e13);
        }
    }

    public void a(bg.a aVar, by byVar, bb bbVar, ez ezVar) {
        Bitmap b11;
        List<URI> b12 = b(byVar.d());
        if (aVar == bg.a.REPROCESS) {
            for (URI next : b12) {
                if (!this.f43035c.containsKey(next) && (b11 = this.f43044l.b(next)) != null) {
                    a(next, b11);
                }
            }
        }
        b(b12, ezVar);
    }

    public boolean a(List<dc> list) {
        for (URI containsKey : b(list)) {
            if (!this.f43035c.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }
}
