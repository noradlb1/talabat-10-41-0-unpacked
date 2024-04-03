package com.instabug.apm.networkinterception;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.apm.networkinterception.utils.a;
import com.instabug.apm.networkinterception.utils.c;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.instabug.library.util.ObjectMapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONObject;

@Instrumented
public class b extends HttpsURLConnection implements a {

    /* renamed from: j  reason: collision with root package name */
    private static final Random f45547j = new SecureRandom(new byte[4]);

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45548a = com.instabug.apm.di.a.f();

    /* renamed from: b  reason: collision with root package name */
    private final HttpsURLConnection f45549b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45550c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap f45551d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final APMNetworkLog f45552e;

    /* renamed from: f  reason: collision with root package name */
    private long f45553f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45554g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private c f45555h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.instabug.apm.networkinterception.utils.b f45556i;

    public b(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        APMNetworkLog aPMNetworkLog = new APMNetworkLog();
        this.f45552e = aPMNetworkLog;
        this.f45549b = httpsURLConnection;
        this.f45553f = System.currentTimeMillis() * 1000;
        this.f45550c = System.nanoTime();
        aPMNetworkLog.setUrl(httpsURLConnection.getURL().toString());
    }

    @Nullable
    private InputStream a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        com.instabug.apm.networkinterception.utils.b bVar = new com.instabug.apm.networkinterception.utils.b(inputStream, this, this.f45554g);
        this.f45556i = bVar;
        return bVar;
    }

    @Nullable
    private String a() {
        c cVar = this.f45555h;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    private void a(long j11, @Nullable Long l11, @Nullable Exception exc) {
        c cVar = this.f45555h;
        if (cVar == null) {
            this.f45552e.setRequestBodySize(0);
        } else {
            this.f45552e.setRequestBodySize(cVar.b().longValue());
        }
        if (l11 != null) {
            this.f45552e.setResponseBodySize(l11.longValue());
        }
        this.f45552e.setStartTime(Long.valueOf(j11));
        this.f45552e.setTotalDuration(b(this.f45550c));
        APMNetworkLog aPMNetworkLog = this.f45552e;
        JSONObject json = ObjectMapper.toJson((Map<String, String>) this.f45551d);
        aPMNetworkLog.setRequestHeaders(!(json instanceof JSONObject) ? json.toString() : JSONObjectInstrumentation.toString(json));
        this.f45552e.setRequestBody(a());
        this.f45552e.setResponseBody(b());
        if (this.f45552e.getResponseCode() > 0) {
            this.f45552e.setErrorMessage((String) null);
        }
        this.f45552e.insert(exc);
    }

    private void a(@Nullable Exception exc) {
        a(this.f45553f, (Long) null, exc);
    }

    private long b(long j11) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j11);
    }

    @Nullable
    private String b() {
        com.instabug.apm.networkinterception.utils.b bVar = this.f45556i;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    private boolean c() {
        return false;
    }

    public void a(long j11) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f45549b.getHeaderFields().entrySet()) {
            if (next.getKey() != null) {
                hashMap.put(next.getKey().toString(), next.getValue().toString());
                if (next.getKey().toString().equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                    String obj = next.getValue().toString();
                    this.f45552e.setResponseContentType(obj);
                    boolean isMultipartType = BodyBufferHelper.isMultipartType(obj);
                    this.f45554g = isMultipartType;
                    com.instabug.apm.networkinterception.utils.b bVar = this.f45556i;
                    if (bVar != null) {
                        bVar.a(isMultipartType);
                    }
                }
            }
        }
        APMNetworkLog aPMNetworkLog = this.f45552e;
        JSONObject json = ObjectMapper.toJson((Map<String, String>) hashMap);
        aPMNetworkLog.setResponseHeaders(!(json instanceof JSONObject) ? json.toString() : JSONObjectInstrumentation.toString(json));
        a(this.f45553f, Long.valueOf(j11), (Exception) null);
    }

    public void addRequestProperty(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            this.f45551d.put(str, str2);
            if (str.equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                c cVar = this.f45555h;
                if (cVar != null) {
                    cVar.a(BodyBufferHelper.isMultipartType(str2));
                }
                this.f45552e.setRequestContentType(str2);
            }
            if (str2 != null) {
                this.f45549b.addRequestProperty(str, str2);
            }
        }
    }

    public void connect() {
        this.f45553f = System.currentTimeMillis() * 1000;
        this.f45548a.a("Request [$method] $url has started.".replace("$method", this.f45549b.getRequestMethod()).replace("$url", this.f45549b.getURL().toString()));
        a((Exception) null);
        try {
            TrafficStats.setThreadStatsTag(f45547j.nextInt());
            this.f45549b.connect();
            TrafficStats.clearThreadStatsTag();
        } catch (Exception e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a(e11);
            throw e11;
        } catch (Throwable th2) {
            TrafficStats.clearThreadStatsTag();
            throw th2;
        }
    }

    public void disconnect() {
        a((Exception) null);
        this.f45549b.disconnect();
    }

    public boolean getAllowUserInteraction() {
        return this.f45549b.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        return this.f45549b.getCipherSuite();
    }

    public int getConnectTimeout() {
        return this.f45549b.getConnectTimeout();
    }

    public Object getContent() {
        try {
            return this.f45549b.getContent();
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.f45549b.getContent(clsArr);
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public String getContentEncoding() {
        return this.f45549b.getContentEncoding();
    }

    public int getContentLength() {
        int contentLength = this.f45549b.getContentLength();
        if (this.f45552e.getResponseBodySize() == 0) {
            this.f45552e.setResponseBodySize((long) contentLength);
            a((Exception) null);
        }
        return contentLength;
    }

    @RequiresApi(api = 24)
    public long getContentLengthLong() {
        return this.f45549b.getContentLengthLong();
    }

    public String getContentType() {
        return this.f45549b.getContentType();
    }

    public long getDate() {
        return this.f45549b.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f45549b.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f45549b.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f45549b.getDoOutput();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public InputStream getErrorStream() {
        InputStream inputStream;
        if (this.f45549b.getContentLength() <= 0 || (inputStream = a(this.f45549b.getErrorStream())) == null) {
            inputStream = this.f45549b.getErrorStream();
        }
        a((Exception) null);
        return inputStream;
    }

    public long getExpiration() {
        return this.f45549b.getExpiration();
    }

    public String getHeaderField(int i11) {
        return this.f45549b.getHeaderField(i11);
    }

    public String getHeaderField(String str) {
        return str != null ? this.f45549b.getHeaderField(str) : "";
    }

    public long getHeaderFieldDate(String str, long j11) {
        return this.f45549b.getHeaderFieldDate(str, j11);
    }

    public int getHeaderFieldInt(String str, int i11) {
        return this.f45549b.getHeaderFieldInt(str, i11);
    }

    public String getHeaderFieldKey(int i11) {
        return this.f45549b.getHeaderFieldKey(i11);
    }

    @RequiresApi(api = 24)
    public long getHeaderFieldLong(String str, long j11) {
        return this.f45549b.getHeaderFieldLong(str, j11);
    }

    public Map getHeaderFields() {
        return this.f45549b.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.f45549b.getIfModifiedSince();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    public InputStream getInputStream() {
        try {
            InputStream a11 = a(this.f45549b.getInputStream());
            return a11 != null ? a11 : this.f45549b.getInputStream();
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.f45549b.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.f45549b.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        return this.f45549b.getLocalCertificates();
    }

    public OutputStream getOutputStream() {
        try {
            if (this.f45555h == null) {
                this.f45555h = new c(this.f45549b.getOutputStream(), c());
            }
            return this.f45555h;
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Principal getPeerPrincipal() {
        try {
            return this.f45549b.getPeerPrincipal();
        } catch (SSLPeerUnverifiedException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Permission getPermission() {
        try {
            return this.f45549b.getPermission();
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public int getReadTimeout() {
        return this.f45549b.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.f45549b.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.f45549b.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f45549b.getRequestProperty(str);
    }

    public int getResponseCode() {
        try {
            int responseCode = this.f45549b.getResponseCode();
            this.f45552e.setResponseCode(responseCode);
            a((Exception) null);
            return responseCode;
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            throw e11;
        }
    }

    public String getResponseMessage() {
        try {
            return this.f45549b.getResponseMessage();
        } catch (IOException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Certificate[] getServerCertificates() {
        try {
            return this.f45549b.getServerCertificates();
        } catch (Exception e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a(e11);
            throw e11;
        }
    }

    public URL getURL() {
        return this.f45549b.getURL();
    }

    public boolean getUseCaches() {
        return this.f45549b.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z11) {
        this.f45549b.setAllowUserInteraction(z11);
    }

    public void setChunkedStreamingMode(int i11) {
        this.f45549b.setChunkedStreamingMode(i11);
    }

    public void setConnectTimeout(int i11) {
        this.f45549b.setConnectTimeout(i11);
    }

    public void setDefaultUseCaches(boolean z11) {
        this.f45549b.setDefaultUseCaches(z11);
    }

    public void setDoInput(boolean z11) {
        this.f45549b.setDoInput(z11);
    }

    public void setDoOutput(boolean z11) {
        this.f45549b.setDoOutput(z11);
    }

    public void setFixedLengthStreamingMode(int i11) {
        this.f45549b.setFixedLengthStreamingMode(i11);
    }

    @RequiresApi(api = 19)
    public void setFixedLengthStreamingMode(long j11) {
        this.f45549b.setFixedLengthStreamingMode(j11);
    }

    public void setIfModifiedSince(long j11) {
        this.f45549b.setIfModifiedSince(j11);
    }

    public void setInstanceFollowRedirects(boolean z11) {
        this.f45549b.setInstanceFollowRedirects(z11);
    }

    public void setReadTimeout(int i11) {
        this.f45549b.setReadTimeout(i11);
    }

    public void setRequestMethod(String str) {
        try {
            this.f45549b.setRequestMethod(str);
            this.f45552e.setMethod(str);
        } catch (ProtocolException e11) {
            this.f45552e.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public void setRequestProperty(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            this.f45551d.put(str, str2);
            if (str.equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                this.f45552e.setRequestContentType(str2);
            }
            if (str2 != null) {
                this.f45549b.setRequestProperty(str, str2);
            }
        }
    }

    public void setUseCaches(boolean z11) {
        this.f45549b.setUseCaches(z11);
    }

    @NonNull
    public String toString() {
        return this.f45549b.toString();
    }

    public boolean usingProxy() {
        return this.f45549b.usingProxy();
    }
}
