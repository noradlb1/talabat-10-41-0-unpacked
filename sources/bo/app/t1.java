package bo.app;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.util.Constants;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\bH\u0002JP\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\b0\u000f2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0014"}, d2 = {"Lbo/app/t1;", "Lbo/app/k2;", "Ljava/net/URL;", "url", "Lorg/json/JSONObject;", "payload", "", "", "Lcom/braze/communication/HttpHeaders;", "headers", "Ljava/net/HttpURLConnection;", "a", "Lbo/app/v4;", "requestTarget", "requestHeaders", "Lkotlin/Pair;", "", "socketTimeout", "<init>", "(I)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class t1 implements k2 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39404b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final int f39405c = ((int) TimeUnit.SECONDS.toMillis(15));

    /* renamed from: a  reason: collision with root package name */
    private final int f39406a;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0010"}, d2 = {"Lbo/app/t1$a;", "", "Ljava/net/HttpURLConnection;", "connection", "Ljava/io/InputStream;", "a", "", "CONNECTION_ESTABLISHED_TIMEOUT_MS", "I", "getCONNECTION_ESTABLISHED_TIMEOUT_MS$annotations", "()V", "", "GZIP", "Ljava/lang/String;", "UTF_8", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final InputStream a(HttpURLConnection httpURLConnection) {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode / 100 != 2) {
                throw new r3("Bad HTTP response code from Braze: [" + responseCode + "] to url: " + httpURLConnection.getURL());
            } else if (StringsKt__StringsJVMKt.equals(Constants.Network.ContentType.GZIP, httpURLConnection.getContentEncoding(), true)) {
                return new GZIPInputStream(httpURLConnection.getInputStream());
            } else {
                return new BufferedInputStream(httpURLConnection.getInputStream());
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONException f39407b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONException jSONException) {
            super(0);
            this.f39407b = jSONException;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to parse json response from server. Response: [" + this.f39407b + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ URL f39408b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(URL url) {
            super(0);
            this.f39408b = url;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get result from [" + this.f39408b + "].";
        }
    }

    public t1(int i11) {
        this.f39406a = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.Pair<org.json.JSONObject, java.util.Map<java.lang.String, java.lang.String>> a(bo.app.v4 r10, java.util.Map<java.lang.String, java.lang.String> r11, org.json.JSONObject r12) {
        /*
            r9 = this;
            java.lang.String r0 = "requestTarget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "requestHeaders"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r0)
            java.net.URL r10 = r10.b()
            r0 = 93
            java.net.HttpURLConnection r11 = r9.a((java.net.URL) r10, (org.json.JSONObject) r12, (java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            bo.app.t1$a r12 = f39404b     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.io.InputStream r12 = r12.a(r11)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            r2.<init>(r12, r1)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            boolean r12 = r2 instanceof java.io.BufferedReader     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            if (r12 == 0) goto L_0x0032
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            goto L_0x003a
        L_0x0032:
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r12.<init>(r2, r1)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            r2 = r12
        L_0x003a:
            java.lang.String r12 = kotlin.io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x005a }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            r1.<init>((java.lang.String) r12)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.util.Map r11 = r11.getHeaderFields()     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.lang.String r12 = "connection.headerFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            java.util.Map r11 = bo.app.v1.a((java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>>) r11)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            kotlin.Pair r12 = new kotlin.Pair     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            r12.<init>(r1, r11)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            return r12
        L_0x005a:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x005c }
        L_0x005c:
            r12 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r11)     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
            throw r12     // Catch:{ IOException -> 0x0098, JSONException -> 0x0061 }
        L_0x0061:
            r11 = move-exception
            com.braze.support.BrazeLogger r12 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.t1$b r6 = new bo.app.t1$b
            r6.<init>(r11)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r1 = r12
            r2 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.t1$c r6 = new bo.app.t1$c
            r6.<init>(r10)
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Failed to get result from ["
            r12.append(r1)
            r12.append(r10)
            r12.append(r0)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x0098:
            r11 = move-exception
            bo.app.r3 r12 = new bo.app.r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed request to ["
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "], with message: ["
            r1.append(r10)
            java.lang.String r10 = r11.getMessage()
            r1.append(r10)
            r1.append(r0)
            java.lang.String r10 = r1.toString()
            r12.<init>(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.t1.a(bo.app.v4, java.util.Map, org.json.JSONObject):kotlin.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection a(java.net.URL r3, org.json.JSONObject r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r2 = this;
            boolean r0 = r4 instanceof org.json.JSONObject
            if (r0 != 0) goto L_0x0009
            java.lang.String r4 = r4.toString()
            goto L_0x000d
        L_0x0009:
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)
        L_0x000d:
            java.lang.String r0 = "payload.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.String r0 = "UTF-8"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            java.lang.String r1 = "forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            byte[] r4 = r4.getBytes(r0)
            java.lang.String r0 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            bo.app.s6 r0 = bo.app.s6.f39358a
            java.net.HttpURLConnection r3 = r0.a(r3)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0034:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0050
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.setRequestProperty(r1, r0)
            goto L_0x0034
        L_0x0050:
            int r5 = f39405c
            r3.setConnectTimeout(r5)
            int r5 = r2.f39406a
            r3.setReadTimeout(r5)
            r5 = 0
            r3.setUseCaches(r5)
            r3.setInstanceFollowRedirects(r5)
            java.lang.String r5 = "POST"
            r3.setRequestMethod(r5)
            r5 = 1
            r3.setDoOutput(r5)
            int r5 = r4.length
            r3.setFixedLengthStreamingMode(r5)
            java.io.OutputStream r5 = r3.getOutputStream()
            r5.write(r4)     // Catch:{ all -> 0x007c }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007c }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r4)
            return r3
        L_0x007c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x007e }
        L_0x007e:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.t1.a(java.net.URL, org.json.JSONObject, java.util.Map):java.net.HttpURLConnection");
    }
}
