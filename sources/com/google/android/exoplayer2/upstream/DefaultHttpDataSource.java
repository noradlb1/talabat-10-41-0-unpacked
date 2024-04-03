package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.net.HttpHeaders;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

@Instrumented
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesToRead;
    private final int connectTimeoutMillis;
    @Nullable
    private HttpURLConnection connection;
    @Nullable
    private Predicate<String> contentTypePredicate;
    @Nullable
    private DataSpec dataSpec;
    @Nullable
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    @Nullable
    private InputStream inputStream;
    private final boolean keepPostFor302Redirects;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private int responseCode;
    @Nullable
    private final String userAgent;

    public static final class Factory implements HttpDataSource.Factory {
        private boolean allowCrossProtocolRedirects;
        private int connectTimeoutMs = 8000;
        @Nullable
        private Predicate<String> contentTypePredicate;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private boolean keepPostFor302Redirects;
        private int readTimeoutMs = 8000;
        @Nullable
        private TransferListener transferListener;
        @Nullable
        private String userAgent;

        @CanIgnoreReturnValue
        public Factory setAllowCrossProtocolRedirects(boolean z11) {
            this.allowCrossProtocolRedirects = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setConnectTimeoutMs(int i11) {
            this.connectTimeoutMs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setContentTypePredicate(@Nullable Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setKeepPostFor302Redirects(boolean z11) {
            this.keepPostFor302Redirects = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setReadTimeoutMs(int i11) {
            this.readTimeoutMs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setTransferListener(@Nullable TransferListener transferListener2) {
            this.transferListener = transferListener2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory setUserAgent(@Nullable String str) {
            this.userAgent = str;
            return this;
        }

        @CanIgnoreReturnValue
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMs, this.readTimeoutMs, this.allowCrossProtocolRedirects, this.defaultRequestProperties, this.contentTypePredicate, this.keepPostFor302Redirects);
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                defaultHttpDataSource.addTransferListener(transferListener2);
            }
            return defaultHttpDataSource;
        }
    }

    public static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {
        private final Map<String, List<String>> headers;

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.headers = map;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public boolean containsValue(@Nullable Object obj) {
            return super.standardContainsValue(obj);
        }

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.filter(super.entrySet(), new c());
        }

        public boolean equals(@Nullable Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        public int hashCode() {
            return super.standardHashCode();
        }

        public boolean isEmpty() {
            if (!super.isEmpty()) {
                return super.size() == 1 && super.containsKey((Object) null);
            }
            return true;
        }

        public Set<String> keySet() {
            return Sets.filter(super.keySet(), new b());
        }

        public int size() {
            return super.size() - (super.containsKey((Object) null) ? 1 : 0);
        }

        public Map<String, List<String>> delegate() {
            return this.headers;
        }

        @Nullable
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                Log.e(TAG, "Unexpected error while disconnecting", e11);
            }
            this.connection = null;
        }
    }

    private URL handleRedirect(URL url, @Nullable String str, DataSpec dataSpec2) throws HttpDataSource.HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                    throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec2, 2001, 1);
                } else if (this.allowCrossProtocolRedirects || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec2, 2001, 1);
                }
            } catch (MalformedURLException e11) {
                throw new HttpDataSource.HttpDataSourceException((IOException) e11, dataSpec2, 2001, 1);
            }
        } else {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec2, 2001, 1);
        }
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) {
        return Constants.Network.ContentType.GZIP.equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec2) throws IOException {
        HttpURLConnection makeConnection;
        DataSpec dataSpec3 = dataSpec2;
        URL url = new URL(dataSpec3.uri.toString());
        int i11 = dataSpec3.httpMethod;
        byte[] bArr = dataSpec3.httpBody;
        long j11 = dataSpec3.position;
        long j12 = dataSpec3.length;
        boolean isFlagSet = dataSpec3.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects && !this.keepPostFor302Redirects) {
            return makeConnection(url, i11, bArr, j11, j12, isFlagSet, true, dataSpec3.httpRequestHeaders);
        }
        URL url2 = url;
        int i12 = i11;
        byte[] bArr2 = bArr;
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (i13 <= 20) {
                long j13 = j11;
                long j14 = j11;
                int i15 = i12;
                int i16 = i14;
                URL url3 = url2;
                long j15 = j12;
                makeConnection = makeConnection(url2, i12, bArr2, j13, j12, isFlagSet, false, dataSpec3.httpRequestHeaders);
                int responseCode2 = makeConnection.getResponseCode();
                String headerField = makeConnection.getHeaderField("Location");
                if ((i15 == 1 || i15 == 3) && (responseCode2 == 300 || responseCode2 == 301 || responseCode2 == 302 || responseCode2 == 303 || responseCode2 == 307 || responseCode2 == 308)) {
                    makeConnection.disconnect();
                    url2 = handleRedirect(url3, headerField, dataSpec3);
                    i12 = i15;
                } else if (i15 != 2 || (responseCode2 != 300 && responseCode2 != 301 && responseCode2 != 302 && responseCode2 != 303)) {
                    return makeConnection;
                } else {
                    makeConnection.disconnect();
                    if (!(this.keepPostFor302Redirects && responseCode2 == 302)) {
                        bArr2 = null;
                        i12 = 1;
                    } else {
                        i12 = i15;
                    }
                    url2 = handleRedirect(url3, headerField, dataSpec3);
                }
                i13 = i16;
                j11 = j14;
                j12 = j15;
            } else {
                throw new HttpDataSource.HttpDataSourceException((IOException) new NoRouteToHostException("Too many redirects: " + i14), dataSpec3, 2001, 1);
            }
        }
        return makeConnection;
    }

    private static void maybeTerminateInputStream(@Nullable HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection != null && (i11 = Util.SDK_INT) >= 19 && i11 <= 20) {
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (j11 == -1) {
                    if (inputStream2.read() == -1) {
                        return;
                    }
                } else if (j11 <= 2048) {
                    return;
                }
                String name2 = inputStream2.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name2) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name2)) {
                    Method declaredMethod = ((Class) Assertions.checkNotNull(inputStream2.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream2, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int readInternal(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesToRead;
        if (j11 != -1) {
            long j12 = j11 - this.bytesRead;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min((long) i12, j12);
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.bytesRead += (long) read;
        bytesTransferred(read);
        return read;
    }

    private void skipFully(long j11, DataSpec dataSpec2) throws IOException {
        if (j11 != 0) {
            byte[] bArr = new byte[4096];
            while (j11 > 0) {
                int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, 0, (int) Math.min(j11, (long) 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new HttpDataSource.HttpDataSourceException((IOException) new InterruptedIOException(), dataSpec2, 2000, 1);
                } else if (read != -1) {
                    j11 -= (long) read;
                    bytesTransferred(read);
                } else {
                    throw new HttpDataSource.HttpDataSourceException(dataSpec2, 2008, 1);
                }
            }
        }
    }

    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                long j11 = this.bytesToRead;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.bytesRead;
                }
                maybeTerminateInputStream(this.connection, j12);
                inputStream2.close();
            }
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e11) {
            throw new HttpDataSource.HttpDataSourceException(e11, (DataSpec) Util.castNonNull(this.dataSpec), 2000, 3);
        } catch (Throwable th2) {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th2;
        }
    }

    public int getResponseCode() {
        int i11;
        if (this.connection == null || (i11 = this.responseCode) <= 0) {
            return -1;
        }
        return i11;
    }

    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return ImmutableMap.of();
        }
        return new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public long open(DataSpec dataSpec2) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        DataSourceException dataSourceException;
        this.dataSpec = dataSpec2;
        long j11 = 0;
        this.bytesRead = 0;
        this.bytesToRead = 0;
        transferInitializing(dataSpec2);
        try {
            HttpURLConnection makeConnection = makeConnection(dataSpec2);
            this.connection = makeConnection;
            this.responseCode = makeConnection.getResponseCode();
            String responseMessage = makeConnection.getResponseMessage();
            int i11 = this.responseCode;
            long j12 = -1;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = makeConnection.getHeaderFields();
                if (this.responseCode == 416) {
                    if (dataSpec2.position == HttpUtil.getDocumentSize(makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                        this.opened = true;
                        transferStarted(dataSpec2);
                        long j13 = dataSpec2.length;
                        if (j13 != -1) {
                            return j13;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = makeConnection.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = Util.toByteArray(errorStream);
                    } catch (IOException unused) {
                        bArr = Util.EMPTY_BYTE_ARRAY;
                    }
                } else {
                    bArr = Util.EMPTY_BYTE_ARRAY;
                }
                byte[] bArr2 = bArr;
                closeConnectionQuietly();
                if (this.responseCode == 416) {
                    dataSourceException = new DataSourceException(2008);
                } else {
                    dataSourceException = null;
                }
                throw new HttpDataSource.InvalidResponseCodeException(this.responseCode, responseMessage, dataSourceException, headerFields, dataSpec2, bArr2);
            }
            String contentType = makeConnection.getContentType();
            Predicate<String> predicate = this.contentTypePredicate;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.responseCode == 200) {
                    long j14 = dataSpec2.position;
                    if (j14 != 0) {
                        j11 = j14;
                    }
                }
                boolean isCompressed = isCompressed(makeConnection);
                if (!isCompressed) {
                    long j15 = dataSpec2.length;
                    if (j15 != -1) {
                        this.bytesToRead = j15;
                    } else {
                        long contentLength = HttpUtil.getContentLength(makeConnection.getHeaderField("Content-Length"), makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        if (contentLength != -1) {
                            j12 = contentLength - j11;
                        }
                        this.bytesToRead = j12;
                    }
                } else {
                    this.bytesToRead = dataSpec2.length;
                }
                try {
                    this.inputStream = makeConnection.getInputStream();
                    if (isCompressed) {
                        this.inputStream = new GZIPInputStream(this.inputStream);
                    }
                    this.opened = true;
                    transferStarted(dataSpec2);
                    try {
                        skipFully(j11, dataSpec2);
                        return this.bytesToRead;
                    } catch (IOException e11) {
                        closeConnectionQuietly();
                        if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                            throw ((HttpDataSource.HttpDataSourceException) e11);
                        }
                        throw new HttpDataSource.HttpDataSourceException(e11, dataSpec2, 2000, 1);
                    }
                } catch (IOException e12) {
                    closeConnectionQuietly();
                    throw new HttpDataSource.HttpDataSourceException(e12, dataSpec2, 2000, 1);
                }
            } else {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec2);
            }
        } catch (IOException e13) {
            closeConnectionQuietly();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e13, dataSpec2, 1);
        }
    }

    @VisibleForTesting
    public HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection())));
    }

    public int read(byte[] bArr, int i11, int i12) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    @Deprecated
    public void setContentTypePredicate(@Nullable Predicate<String> predicate) {
        this.contentTypePredicate = predicate;
    }

    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Deprecated
    public DefaultHttpDataSource() {
        this((String) null, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i11, int i12) {
        this(str, i11, i12, false, (HttpDataSource.RequestProperties) null);
    }

    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i11, int i12, boolean z11, @Nullable HttpDataSource.RequestProperties requestProperties2) {
        this(str, i11, i12, z11, requestProperties2, (Predicate<String>) null, false);
    }

    private DefaultHttpDataSource(@Nullable String str, int i11, int i12, boolean z11, @Nullable HttpDataSource.RequestProperties requestProperties2, @Nullable Predicate<String> predicate, boolean z12) {
        super(true);
        this.userAgent = str;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.allowCrossProtocolRedirects = z11;
        this.defaultRequestProperties = requestProperties2;
        this.contentTypePredicate = predicate;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.keepPostFor302Redirects = z12;
    }

    private HttpURLConnection makeConnection(URL url, int i11, @Nullable byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map<String, String> map) throws IOException {
        HttpURLConnection openConnection = openConnection(url);
        openConnection.setConnectTimeout(this.connectTimeoutMillis);
        openConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties2 = this.defaultRequestProperties;
        if (requestProperties2 != null) {
            hashMap.putAll(requestProperties2.getSnapshot());
        }
        hashMap.putAll(this.requestProperties.getSnapshot());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j11, j12);
        if (buildRangeRequestHeader != null) {
            openConnection.setRequestProperty(HttpHeaders.RANGE, buildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            openConnection.setRequestProperty("User-Agent", str);
        }
        openConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z11 ? Constants.Network.ContentType.GZIP : Constants.Network.ContentType.IDENTITY);
        openConnection.setInstanceFollowRedirects(z12);
        openConnection.setDoOutput(bArr != null);
        openConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i11));
        if (bArr != null) {
            openConnection.setFixedLengthStreamingMode(bArr.length);
            openConnection.connect();
            OutputStream outputStream = openConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            openConnection.connect();
        }
        return openConnection;
    }
}
