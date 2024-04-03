package com.apptimize;

import com.apptimize.fq;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class aw {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41264a = "aw";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final fq f41265b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Random f41266c;

    /* renamed from: d  reason: collision with root package name */
    private final d f41267d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f41268e;

    /* renamed from: f  reason: collision with root package name */
    private final au f41269f;

    /* renamed from: g  reason: collision with root package name */
    private final eb f41270g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f41271h = Executors.newSingleThreadExecutor();

    public abstract class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f41277a;

        /* renamed from: b  reason: collision with root package name */
        public String f41278b;

        /* renamed from: c  reason: collision with root package name */
        public String f41279c;

        /* renamed from: d  reason: collision with root package name */
        public String f41280d;

        private a() {
            this.f41277a = null;
            this.f41278b = null;
            this.f41279c = null;
            this.f41280d = null;
        }

        public abstract T a(InputStream inputStream) throws IOException;
    }

    public class b extends a<JSONArray> {
        public b(String str, String str2, String str3) {
            super();
            this.f41277a = String.format(str, new Object[]{str2, Long.valueOf(Math.abs((long) aw.this.f41266c.nextInt())), str3});
            this.f41280d = "download-authorized-pairing-tokens";
            String a11 = aw.f41264a;
            bo.a(a11, "Downloading authorized production-tokens " + this.f41277a);
        }

        /* renamed from: b */
        public JSONArray a(InputStream inputStream) throws IOException {
            return aw.this.a(inputStream);
        }
    }

    public class c extends a<JSONObject> {
        public c(String str, String str2) {
            super();
            this.f41277a = str + aw.this.f41268e + "?rid=" + Math.abs((long) aw.this.f41266c.nextInt());
            this.f41278b = str2;
            this.f41280d = "metadata-download";
        }

        /* renamed from: b */
        public JSONObject a(InputStream inputStream) throws IOException {
            try {
                return aw.this.f41265b.a(inputStream);
            } catch (fq.a e11) {
                throw new IOException(e11);
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f41284a;

        /* renamed from: b  reason: collision with root package name */
        public final String f41285b;

        public d(String str, String str2) {
            this.f41284a = str;
            this.f41285b = str2;
        }
    }

    public class e extends a<String> {
        public e(String str, String str2) {
            super();
            this.f41277a = str;
            this.f41279c = str2;
            this.f41280d = "results-post";
        }

        /* renamed from: b */
        public String a(InputStream inputStream) throws IOException {
            return new String(fd.a(inputStream), "UTF-8");
        }
    }

    public class f extends a<Set<String>> {
        public f(String str) {
            super();
            this.f41277a = str;
            this.f41280d = "secondary-metadata-download";
        }

        /* renamed from: b */
        public Set<String> a(InputStream inputStream) throws IOException {
            try {
                JSONArray jSONArray = new JSONArray(new String(fd.a(inputStream), "UTF-8"));
                HashSet hashSet = new HashSet();
                for (int i11 = 0; i11 != jSONArray.length(); i11++) {
                    hashSet.add(jSONArray.getString(i11));
                }
                return hashSet;
            } catch (JSONException unused) {
                bo.e(aw.f41264a, "Error parsing response for secondary url");
                return null;
            }
        }
    }

    public aw(fq fqVar, Random random, d dVar, String str, au auVar, eb ebVar) {
        this.f41265b = fqVar;
        this.f41266c = random;
        this.f41267d = dVar;
        this.f41268e = str;
        this.f41269f = auVar;
        this.f41270g = ebVar;
    }

    public HttpURLConnection b(URL url) throws IOException {
        c.i();
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection())));
    }

    /* access modifiers changed from: private */
    public JSONArray a(InputStream inputStream) throws IOException {
        try {
            return new JSONArray(new String(fd.a(inputStream), "UTF-8"));
        } catch (JSONException e11) {
            bo.a(f41264a, "Invalid JSON Array: ", e11);
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("User-Agent", "Android/" + this.f41267d.f41285b + " Apptimize/" + fx.a());
        httpURLConnection.setRequestProperty("X-App-Key", this.f41268e);
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.IF_NONE_MATCH, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0172 A[SYNTHETIC, Splitter:B:43:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c3 A[SYNTHETIC, Splitter:B:50:0x01c3] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021a A[SYNTHETIC, Splitter:B:57:0x021a] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0252 A[SYNTHETIC, Splitter:B:63:0x0252] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0150=Splitter:B:40:0x0150, B:47:0x01a6=Splitter:B:47:0x01a6, B:54:0x01f8=Splitter:B:54:0x01f8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized <T> void a(com.apptimize.aw.a<T> r10, com.apptimize.ax<T> r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.apptimize.eb r0 = r9.f41270g     // Catch:{ all -> 0x0288 }
            boolean r0 = r0.e()     // Catch:{ all -> 0x0288 }
            if (r0 == 0) goto L_0x000e
            r11.b()     // Catch:{ all -> 0x0288 }
            monitor-exit(r9)
            return
        L_0x000e:
            com.apptimize.au r0 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r0 = r0.e()     // Catch:{ all -> 0x0288 }
            long r0 = r0.d()     // Catch:{ all -> 0x0288 }
            java.lang.String r2 = f41264a     // Catch:{ all -> 0x0288 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r3.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r4 = "Sending "
            r3.append(r4)     // Catch:{ all -> 0x0288 }
            java.lang.String r4 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r3.append(r4)     // Catch:{ all -> 0x0288 }
            java.lang.String r4 = " request to "
            r3.append(r4)     // Catch:{ all -> 0x0288 }
            java.lang.String r4 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r3.append(r4)     // Catch:{ all -> 0x0288 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0288 }
            com.apptimize.bo.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0288 }
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x01f7, UnknownHostException -> 0x01a5, IOException -> 0x014f }
            java.lang.String r5 = r10.f41277a     // Catch:{ MalformedURLException -> 0x01f7, UnknownHostException -> 0x01a5, IOException -> 0x014f }
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x01f7, UnknownHostException -> 0x01a5, IOException -> 0x014f }
            java.net.HttpURLConnection r5 = r9.b((java.net.URL) r4)     // Catch:{ MalformedURLException -> 0x01f7, UnknownHostException -> 0x01a5, IOException -> 0x014f }
            java.lang.String r6 = r10.f41278b     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.HttpURLConnection) r5, (java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r5.setReadTimeout(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.URL) r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r4 = r10.f41279c     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            if (r4 == 0) goto L_0x0099
            r4 = 1
            r5.setDoOutput(r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r5.setRequestProperty(r4, r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.HttpURLConnection) r5, (com.apptimize.aw.a<?>) r10)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r4.<init>(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r6 = r10.f41279c     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            byte[] r6 = com.apptimize.fd.a((java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            int r7 = r6.length     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            if (r7 != 0) goto L_0x008f
            com.apptimize.au r7 = r9.f41269f     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            com.apptimize.bq r7 = r7.a()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            com.apptimize.bq$b r8 = com.apptimize.bq.b.ZeroContentLength     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r7.a((com.apptimize.bq.b) r8)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
        L_0x008f:
            r4.write(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r4.flush()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r4.close()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            goto L_0x009c
        L_0x0099:
            r9.a((java.net.HttpURLConnection) r5, (com.apptimize.aw.a<?>) r10)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
        L_0x009c:
            int r4 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6 = 304(0x130, float:4.26E-43)
            if (r4 != r6) goto L_0x00c1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r6 = "Nothing has changed in the "
            r4.append(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r6 = r10.f41280d     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r4.append(r6)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            com.apptimize.bo.f(r2, r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r11.a()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.HttpURLConnection) r5, r3)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            goto L_0x0107
        L_0x00c1:
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 != r6) goto L_0x00d9
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.Object r2 = r10.a(r2)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r11.a(r2, r5)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.HttpURLConnection) r5, r2)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            goto L_0x0107
        L_0x00d9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6.<init>()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r7 = "Apptimize "
            r6.append(r7)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r7 = r10.f41280d     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6.append(r7)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r7 = " URL: "
            r6.append(r7)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r7 = r10.f41277a     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6.append(r7)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r7 = " request returned non-200 response: "
            r6.append(r7)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r6.append(r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            java.lang.String r4 = r6.toString()     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            com.apptimize.bo.j(r2, r4)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r11.a(r5)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
            r9.a((java.net.HttpURLConnection) r5, r3)     // Catch:{ MalformedURLException -> 0x0148, UnknownHostException -> 0x0145, IOException -> 0x0142, all -> 0x013e }
        L_0x0107:
            r5.disconnect()     // Catch:{ all -> 0x0288 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r11.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r2 = "apiRequest: "
            r11.append(r2)     // Catch:{ all -> 0x0288 }
            com.apptimize.au r2 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r2 = r2.e()     // Catch:{ all -> 0x0288 }
            long r0 = r2.a(r0)     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = "ms, "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = ", "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r11.append(r10)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0288 }
        L_0x0139:
            com.apptimize.bs.a((java.lang.String) r10)     // Catch:{ all -> 0x0288 }
            goto L_0x024e
        L_0x013e:
            r11 = move-exception
            r3 = r5
            goto L_0x0250
        L_0x0142:
            r2 = move-exception
            r3 = r5
            goto L_0x0150
        L_0x0145:
            r2 = move-exception
            r3 = r5
            goto L_0x01a6
        L_0x0148:
            r2 = move-exception
            r3 = r5
            goto L_0x01f8
        L_0x014c:
            r11 = move-exception
            goto L_0x0250
        L_0x014f:
            r2 = move-exception
        L_0x0150:
            java.lang.String r4 = f41264a     // Catch:{ all -> 0x014c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
            r5.<init>()     // Catch:{ all -> 0x014c }
            java.lang.String r6 = "Apptimize "
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r6 = r10.f41280d     // Catch:{ all -> 0x014c }
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r6 = " request failed"
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x014c }
            com.apptimize.bo.d(r4, r5, r2)     // Catch:{ all -> 0x014c }
            r11.a(r3)     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x0175
            r3.disconnect()     // Catch:{ all -> 0x0288 }
        L_0x0175:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r11.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r2 = "apiRequest: "
            r11.append(r2)     // Catch:{ all -> 0x0288 }
            com.apptimize.au r2 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r2 = r2.e()     // Catch:{ all -> 0x0288 }
            long r0 = r2.a(r0)     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = "ms, "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = ", "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r11.append(r10)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0288 }
            goto L_0x0139
        L_0x01a5:
            r2 = move-exception
        L_0x01a6:
            java.lang.String r4 = f41264a     // Catch:{ all -> 0x014c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
            r5.<init>()     // Catch:{ all -> 0x014c }
            java.lang.String r6 = "Apptimize failed to resolve "
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r6 = r10.f41277a     // Catch:{ all -> 0x014c }
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x014c }
            com.apptimize.bo.d(r4, r5, r2)     // Catch:{ all -> 0x014c }
            r11.a(r3)     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x01c6
            r3.disconnect()     // Catch:{ all -> 0x0288 }
        L_0x01c6:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r11.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r2 = "apiRequest: "
            r11.append(r2)     // Catch:{ all -> 0x0288 }
            com.apptimize.au r2 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r2 = r2.e()     // Catch:{ all -> 0x0288 }
            long r0 = r2.a(r0)     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = "ms, "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = ", "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r11.append(r10)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0288 }
            goto L_0x0139
        L_0x01f7:
            r2 = move-exception
        L_0x01f8:
            java.lang.String r4 = f41264a     // Catch:{ all -> 0x014c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
            r5.<init>()     // Catch:{ all -> 0x014c }
            java.lang.String r6 = "Apptimize "
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r6 = r10.f41280d     // Catch:{ all -> 0x014c }
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r6 = " request malformed"
            r5.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x014c }
            com.apptimize.bo.d(r4, r5, r2)     // Catch:{ all -> 0x014c }
            r11.a(r3)     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x021d
            r3.disconnect()     // Catch:{ all -> 0x0288 }
        L_0x021d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r11.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r2 = "apiRequest: "
            r11.append(r2)     // Catch:{ all -> 0x0288 }
            com.apptimize.au r2 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r2 = r2.e()     // Catch:{ all -> 0x0288 }
            long r0 = r2.a(r0)     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = "ms, "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = ", "
            r11.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r11.append(r10)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0288 }
            goto L_0x0139
        L_0x024e:
            monitor-exit(r9)
            return
        L_0x0250:
            if (r3 == 0) goto L_0x0255
            r3.disconnect()     // Catch:{ all -> 0x0288 }
        L_0x0255:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0288 }
            r2.<init>()     // Catch:{ all -> 0x0288 }
            java.lang.String r3 = "apiRequest: "
            r2.append(r3)     // Catch:{ all -> 0x0288 }
            com.apptimize.au r3 = r9.f41269f     // Catch:{ all -> 0x0288 }
            com.apptimize.eu r3 = r3.e()     // Catch:{ all -> 0x0288 }
            long r0 = r3.a(r0)     // Catch:{ all -> 0x0288 }
            r2.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = "ms, "
            r2.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = r10.f41280d     // Catch:{ all -> 0x0288 }
            r2.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r0 = ", "
            r2.append(r0)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r10.f41277a     // Catch:{ all -> 0x0288 }
            r2.append(r10)     // Catch:{ all -> 0x0288 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0288 }
            com.apptimize.bs.a((java.lang.String) r10)     // Catch:{ all -> 0x0288 }
            throw r11     // Catch:{ all -> 0x0288 }
        L_0x0288:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aw.a(com.apptimize.aw$a, com.apptimize.ax):void");
    }

    public void a(final URL url) throws UnknownHostException {
        try {
            if (!((Boolean) this.f41271h.submit(new Callable<Boolean>() {
                /* renamed from: a */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(InetAddress.getByName(url.getHost()) != null);
                }
            }).get(5, TimeUnit.SECONDS)).booleanValue()) {
                throw new UnknownHostException(url.getHost());
            }
        } catch (Exception e11) {
            String str = f41264a;
            bo.d(str, "Apptimize failed to resolve " + url.getHost(), e11);
            throw new UnknownHostException(url.getHost());
        }
    }

    private void a(HttpURLConnection httpURLConnection, a<?> aVar) {
        String format = String.format("URL Request: %s\nHeaders:%s\nBody:%s", new Object[]{aVar.f41277a, httpURLConnection.getRequestProperties(), aVar.f41279c});
        String str = f41264a;
        bo.i(str, "Apptimize " + format);
    }

    private <T> void a(HttpURLConnection httpURLConnection, T t11) {
        StringBuilder sb2 = new StringBuilder("{");
        int i11 = 0;
        while (true) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i11);
            String headerField = httpURLConnection.getHeaderField(i11);
            if (headerFieldKey == null) {
                sb2.deleteCharAt(sb2.length() - 1);
                sb2.append("}");
                bo.i(f41264a, String.format("URL Response: %s\nHeaders:%s\nBody:%s", new Object[]{httpURLConnection.getURL(), sb2, t11}));
                return;
            }
            sb2.append(String.format("%s:%s,", new Object[]{headerFieldKey, headerField}));
            i11++;
        }
    }

    public synchronized HttpURLConnection a(String str, String str2, final fl flVar) {
        final AtomicReference atomicReference;
        atomicReference = new AtomicReference();
        a(new e(str, str2), new ax<String>() {
            public void b() {
                flVar.b();
                bo.h(aw.f41264a, "Not posting results because Apptimize is offline.");
            }

            public void a(String str, HttpURLConnection httpURLConnection) {
                atomicReference.set(httpURLConnection);
                flVar.b();
            }

            public void a(HttpURLConnection httpURLConnection) {
                flVar.a();
            }

            public void a() {
                flVar.b();
            }
        });
        return (HttpURLConnection) atomicReference.get();
    }

    public synchronized void a(String str, ax<Set<String>> axVar) {
        a(new f(str), axVar);
    }

    public synchronized void a(String str, String str2, ax<JSONObject> axVar) {
        a(new c(str, str2), axVar);
    }

    public synchronized void a(String str, String str2, String str3, ax<JSONArray> axVar) {
        a(new b(str, str2, str3), axVar);
    }
}
