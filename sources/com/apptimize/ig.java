package com.apptimize;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.StrictMode;
import androidx.webkit.ProxyConfig;
import com.apptimize.ii;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.talabat.helpers.TalabatVolley;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

@Instrumented
public class ig {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43022a = "ig";

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f43023b;

    /* renamed from: c  reason: collision with root package name */
    private ii.c f43024c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f43025d;

    /* renamed from: e  reason: collision with root package name */
    private final eb f43026e;

    /* renamed from: f  reason: collision with root package name */
    private final ii.b f43027f;

    public ig(ii.c cVar, Context context, ExecutorService executorService, eb ebVar, ii.b bVar) {
        this.f43024c = cVar;
        this.f43025d = context;
        this.f43023b = executorService;
        this.f43026e = ebVar;
        this.f43027f = bVar;
        executorService.submit(new fi() {
            public void run() {
                ig.this.a();
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(URI uri) {
        Bitmap b11;
        if (!c(uri) || (b11 = b(uri)) == null) {
            Bitmap e11 = e(uri);
            this.f43027f.c(uri);
            this.f43024c.a(uri, e11);
            return;
        }
        this.f43027f.c(uri);
        this.f43024c.a(uri, b11);
    }

    private Bitmap e(URI uri) {
        if (this.f43026e.e()) {
            String str = f43022a;
            bo.a(str, "Not downloading image because Apptimize is in offline mode: " + uri);
            return null;
        } else if (this.f43027f.a(uri)) {
            this.f43027f.b(uri);
            return b(uri);
        } else {
            try {
                c.i();
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(uri.toURL().openConnection()));
                uRLConnection.setConnectTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
                uRLConnection.setReadTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
                uRLConnection.connect();
                byte[] a11 = fd.a((InputStream) new BufferedInputStream(uRLConnection.getInputStream()));
                a(uri, a11);
                return BitmapFactoryInstrumentation.decodeByteArray(a11, 0, a11.length);
            } catch (MalformedURLException e11) {
                bo.f(f43022a, "Malformed URL: ", e11);
                return null;
            } catch (SocketTimeoutException unused) {
                String str2 = f43022a;
                bo.h(str2, "Timeout when fetching image " + uri);
                return null;
            } catch (IOException e12) {
                bo.g(f43022a, "Unexpected IOException when fetching image: ", e12);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public String f(URI uri) {
        return uri.toString().replace('/', '_');
    }

    public boolean c(URI uri) {
        String scheme = uri.getScheme();
        if (scheme.equals(ProxyConfig.MATCH_HTTP) || scheme.equals("https")) {
            return true;
        }
        return false;
    }

    public void a(final URI uri) {
        this.f43023b.submit(new fi() {
            public void run() {
                ig.this.d(uri);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[SYNTHETIC, Splitter:B:19:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap b(java.net.URI r8) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r7.f43025d
            java.io.File r1 = a((android.content.Context) r1)
            java.lang.String r2 = r7.f(r8)
            r0.<init>(r1, r2)
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskWrites()
            boolean r2 = r0.exists()     // Catch:{ all -> 0x0056 }
            r3 = 0
            if (r2 != 0) goto L_0x001e
            android.os.StrictMode.setThreadPolicy(r1)
            return r3
        L_0x001e:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0035 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0035 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0035 }
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeStream(r2)     // Catch:{ Exception -> 0x0033 }
            r2.close()     // Catch:{ Exception -> 0x0033 }
            android.os.StrictMode.setThreadPolicy(r1)
            return r0
        L_0x0033:
            r0 = move-exception
            goto L_0x0037
        L_0x0035:
            r0 = move-exception
            r2 = r3
        L_0x0037:
            java.lang.String r4 = f43022a     // Catch:{ all -> 0x0056 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r5.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r6 = "Unexpected FileNotFoundException for "
            r5.append(r6)     // Catch:{ all -> 0x0056 }
            r5.append(r8)     // Catch:{ all -> 0x0056 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0056 }
            com.apptimize.bo.f(r4, r8, r0)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            android.os.StrictMode.setThreadPolicy(r1)
            return r3
        L_0x0056:
            r8 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ig.b(java.net.URI):android.graphics.Bitmap");
    }

    public void a(URI uri, byte[] bArr) {
        StrictMode.ThreadPolicy allowThreadDiskWrites;
        File file = new File(a(this.f43025d), f(uri));
        try {
            allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            FileChannel channel = new FileOutputStream(file).getChannel();
            channel.write(ByteBuffer.wrap(bArr));
            channel.close();
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        } catch (Exception e11) {
            String str = f43022a;
            bo.f(str, "Unexpected IO exception when caching " + uri, e11);
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th2;
        }
    }

    public static File a(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            return new File(context.getFilesDir().getPath(), "apptimize_images");
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            a(this.f43025d).mkdir();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public void a(final Set<URI> set) {
        this.f43023b.submit(new fi() {
            public void run() {
                HashSet hashSet = new HashSet();
                for (URI b11 : set) {
                    hashSet.add(ig.this.f(b11));
                }
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    for (File file : ig.a(ig.this.f43025d).listFiles()) {
                        if (!hashSet.contains(file.getName())) {
                            file.delete();
                        }
                    }
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                }
            }
        });
    }
}
