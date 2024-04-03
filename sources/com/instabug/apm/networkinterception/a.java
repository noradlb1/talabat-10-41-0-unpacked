package com.instabug.apm.networkinterception;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.apm.networkinterception.utils.b;
import com.instabug.apm.networkinterception.utils.c;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.instabug.library.util.ObjectMapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@Instrumented
public class a extends HttpURLConnection implements com.instabug.apm.networkinterception.utils.a {

    /* renamed from: j  reason: collision with root package name */
    private static Random f45537j = new SecureRandom(new byte[4]);

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45538a = com.instabug.apm.di.a.f();

    /* renamed from: b  reason: collision with root package name */
    private final HttpURLConnection f45539b;

    /* renamed from: c  reason: collision with root package name */
    private long f45540c;

    /* renamed from: d  reason: collision with root package name */
    private final long f45541d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f45542e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final APMNetworkLog f45543f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45544g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private c f45545h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private b f45546i;

    public a(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        APMNetworkLog aPMNetworkLog = new APMNetworkLog();
        this.f45543f = aPMNetworkLog;
        this.f45539b = httpURLConnection;
        this.f45540c = System.currentTimeMillis() * 1000;
        this.f45541d = System.nanoTime();
        aPMNetworkLog.setUrl(httpURLConnection.getURL().toString());
    }

    @Nullable
    private InputStream a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        b bVar = new b(inputStream, this, this.f45544g);
        this.f45546i = bVar;
        return bVar;
    }

    @Nullable
    private String a() {
        c cVar = this.f45545h;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    private void a(long j11, @Nullable Long l11, @Nullable Exception exc) {
        c cVar = this.f45545h;
        if (cVar == null) {
            this.f45543f.setRequestBodySize(0);
        } else {
            this.f45543f.setRequestBodySize(cVar.b().longValue());
        }
        if (l11 != null) {
            this.f45543f.setResponseBodySize(l11.longValue());
        }
        this.f45543f.setStartTime(Long.valueOf(j11));
        this.f45543f.setTotalDuration(b(this.f45541d));
        APMNetworkLog aPMNetworkLog = this.f45543f;
        JSONObject json = ObjectMapper.toJson((Map<String, String>) this.f45542e);
        aPMNetworkLog.setRequestHeaders(!(json instanceof JSONObject) ? json.toString() : JSONObjectInstrumentation.toString(json));
        this.f45543f.setRequestBody(a());
        this.f45543f.setResponseBody(b());
        if (this.f45543f.getResponseCode() > 0) {
            this.f45543f.setErrorMessage((String) null);
        }
        this.f45543f.insert(exc);
    }

    private void a(@Nullable Exception exc) {
        a(this.f45540c, (Long) null, exc);
    }

    private long b(long j11) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j11);
    }

    @Nullable
    private String b() {
        b bVar = this.f45546i;
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
        for (Map.Entry next : this.f45539b.getHeaderFields().entrySet()) {
            if (next.getKey() != null) {
                hashMap.put(next.getKey().toString(), next.getValue().toString());
                if (next.getKey().toString().equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                    String obj = next.getValue().toString();
                    this.f45543f.setResponseContentType(obj);
                    boolean isMultipartType = BodyBufferHelper.isMultipartType(obj);
                    this.f45544g = isMultipartType;
                    b bVar = this.f45546i;
                    if (bVar != null) {
                        bVar.a(isMultipartType);
                    }
                }
            }
        }
        APMNetworkLog aPMNetworkLog = this.f45543f;
        JSONObject json = ObjectMapper.toJson((Map<String, String>) hashMap);
        aPMNetworkLog.setResponseHeaders(!(json instanceof JSONObject) ? json.toString() : JSONObjectInstrumentation.toString(json));
        a(this.f45540c, Long.valueOf(j11), (Exception) null);
    }

    public void addRequestProperty(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            this.f45542e.put(str, str2);
            if (str.equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                c cVar = this.f45545h;
                if (cVar != null) {
                    cVar.a(BodyBufferHelper.isMultipartType(str2));
                }
                this.f45543f.setRequestContentType(str2);
            }
            if (str2 != null) {
                this.f45539b.addRequestProperty(str, str2);
            }
        }
    }

    public void connect() {
        this.f45540c = System.currentTimeMillis() * 1000;
        this.f45538a.a("Request [$method] $url has started.".replace("$method", this.f45539b.getRequestMethod()).replace("$url", this.f45539b.getURL().toString()));
        a((Exception) null);
        try {
            TrafficStats.setThreadStatsTag(f45537j.nextInt());
            this.f45539b.connect();
            TrafficStats.clearThreadStatsTag();
        } catch (Exception e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a(e11);
            throw e11;
        } catch (Throwable th2) {
            TrafficStats.clearThreadStatsTag();
            throw th2;
        }
    }

    public void disconnect() {
        a((Exception) null);
        this.f45539b.disconnect();
    }

    public boolean getAllowUserInteraction() {
        return this.f45539b.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.f45539b.getConnectTimeout();
    }

    public Object getContent() {
        try {
            return this.f45539b.getContent();
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.f45539b.getContent(clsArr);
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public String getContentEncoding() {
        return this.f45539b.getContentEncoding();
    }

    public int getContentLength() {
        int contentLength = this.f45539b.getContentLength();
        if (this.f45543f.getResponseBodySize() == 0) {
            this.f45543f.setResponseBodySize((long) contentLength);
            a((Exception) null);
        }
        return contentLength;
    }

    @RequiresApi(api = 24)
    public long getContentLengthLong() {
        return this.f45539b.getContentLengthLong();
    }

    public String getContentType() {
        return this.f45539b.getContentType();
    }

    public long getDate() {
        return this.f45539b.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f45539b.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f45539b.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f45539b.getDoOutput();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public InputStream getErrorStream() {
        InputStream inputStream;
        if (this.f45539b.getContentLength() <= 0 || (inputStream = a(this.f45539b.getErrorStream())) == null) {
            inputStream = this.f45539b.getErrorStream();
        }
        a((Exception) null);
        return inputStream;
    }

    public long getExpiration() {
        return this.f45539b.getExpiration();
    }

    public String getHeaderField(int i11) {
        return this.f45539b.getHeaderField(i11);
    }

    public String getHeaderField(String str) {
        return str != null ? this.f45539b.getHeaderField(str) : "";
    }

    public long getHeaderFieldDate(String str, long j11) {
        return this.f45539b.getHeaderFieldDate(str, j11);
    }

    public int getHeaderFieldInt(String str, int i11) {
        return this.f45539b.getHeaderFieldInt(str, i11);
    }

    public String getHeaderFieldKey(int i11) {
        return this.f45539b.getHeaderFieldKey(i11);
    }

    @RequiresApi(api = 24)
    public long getHeaderFieldLong(String str, long j11) {
        return this.f45539b.getHeaderFieldLong(str, j11);
    }

    public Map getHeaderFields() {
        return this.f45539b.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.f45539b.getIfModifiedSince();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public InputStream getInputStream() {
        try {
            InputStream a11 = a(this.f45539b.getInputStream());
            return a11 != null ? a11 : this.f45539b.getInputStream();
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.f45539b.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.f45539b.getLastModified();
    }

    public OutputStream getOutputStream() {
        try {
            if (this.f45545h == null) {
                this.f45545h = new c(this.f45539b.getOutputStream(), c());
            }
            return this.f45545h;
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public Permission getPermission() {
        try {
            return this.f45539b.getPermission();
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public int getReadTimeout() {
        return this.f45539b.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.f45539b.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.f45539b.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f45539b.getRequestProperty(str);
    }

    public int getResponseCode() {
        try {
            int responseCode = this.f45539b.getResponseCode();
            this.f45543f.setResponseCode(responseCode);
            a((Exception) null);
            return responseCode;
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public String getResponseMessage() {
        try {
            return this.f45539b.getResponseMessage();
        } catch (IOException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public URL getURL() {
        return this.f45539b.getURL();
    }

    public boolean getUseCaches() {
        return this.f45539b.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z11) {
        this.f45539b.setAllowUserInteraction(z11);
    }

    public void setChunkedStreamingMode(int i11) {
        this.f45539b.setChunkedStreamingMode(i11);
    }

    public void setConnectTimeout(int i11) {
        this.f45539b.setConnectTimeout(i11);
    }

    public void setDefaultUseCaches(boolean z11) {
        this.f45539b.setDefaultUseCaches(z11);
    }

    public void setDoInput(boolean z11) {
        this.f45539b.setDoInput(z11);
    }

    public void setDoOutput(boolean z11) {
        this.f45539b.setDoOutput(z11);
    }

    public void setFixedLengthStreamingMode(int i11) {
        this.f45539b.setFixedLengthStreamingMode(i11);
    }

    @RequiresApi(api = 19)
    public void setFixedLengthStreamingMode(long j11) {
        this.f45539b.setFixedLengthStreamingMode(j11);
    }

    public void setIfModifiedSince(long j11) {
        this.f45539b.setIfModifiedSince(j11);
    }

    public void setInstanceFollowRedirects(boolean z11) {
        this.f45539b.setInstanceFollowRedirects(z11);
    }

    public void setReadTimeout(int i11) {
        this.f45539b.setReadTimeout(i11);
    }

    public void setRequestMethod(String str) {
        try {
            this.f45539b.setRequestMethod(str);
            this.f45543f.setMethod(str);
        } catch (ProtocolException e11) {
            this.f45543f.setErrorMessage(e11.getClass().getSimpleName());
            a((Exception) e11);
            throw e11;
        }
    }

    public void setRequestProperty(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            this.f45542e.put(str, str2);
            if (str.equalsIgnoreCase(NetworkLog.CONTENT_TYPE)) {
                this.f45543f.setRequestContentType(str2);
            }
            if (str2 != null) {
                this.f45539b.setRequestProperty(str, str2);
            }
        }
    }

    public void setUseCaches(boolean z11) {
        this.f45539b.setUseCaches(z11);
    }

    @NonNull
    public String toString() {
        return this.f45539b.toString();
    }

    public boolean usingProxy() {
        return this.f45539b.usingProxy();
    }
}
