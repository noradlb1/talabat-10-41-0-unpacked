package okhttp3;

import com.google.common.net.HttpHeaders;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0000¢\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006F"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cache implements Closeable, Flushable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    @NotNull
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CacheResponseBody extends ResponseBody {
        @NotNull
        private final BufferedSource bodySource;
        @Nullable
        private final String contentLength;
        @Nullable
        private final String contentType;
        @NotNull
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot snapshot2, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(snapshot2, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer((Source) new ForwardingSource(snapshot2.getSource(1), this) {
                final /* synthetic */ Source $source;
                final /* synthetic */ CacheResponseBody this$0;

                {
                    this.$source = r1;
                    this.this$0 = r2;
                }

                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    super.close();
                }
            });
        }

        public long contentLength() {
            String str = this.contentLength;
            if (str == null) {
                return -1;
            }
            return Util.toLongOrDefault(str, -1);
        }

        @Nullable
        public MediaType contentType() {
            String str = this.contentType;
            if (str == null) {
                return null;
            }
            return MediaType.Companion.parse(str);
        }

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RealCacheRequest implements CacheRequest {
        @NotNull
        private final Sink body;
        @NotNull
        private final Sink cacheOut;
        private boolean done;
        /* access modifiers changed from: private */
        @NotNull
        public final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(@NotNull final Cache cache, DiskLruCache.Editor editor2) {
            Intrinsics.checkNotNullParameter(cache, "this$0");
            Intrinsics.checkNotNullParameter(editor2, "editor");
            this.this$0 = cache;
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(newSink) {
                public void close() throws IOException {
                    Cache cache = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache) {
                        if (!realCacheRequest.getDone()) {
                            realCacheRequest.setDone(true);
                            cache.setWriteSuccessCount$okhttp(cache.getWriteSuccessCount$okhttp() + 1);
                            super.close();
                            this.editor.commit();
                        }
                    }
                }
            };
        }

        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (!getDone()) {
                    setDone(true);
                    cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                    Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        @NotNull
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z11) {
            this.done = z11;
        }
    }

    public Cache(@NotNull File file, long j11, @NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j11, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    @JvmName(name = "-deprecated_directory")
    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m7925deprecated_directory() {
        return this.cache.getDirectory();
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    @NotNull
    @JvmName(name = "directory")
    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody body = response.body();
                if (body != null) {
                    Util.closeQuietly((Closeable) body);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.areEqual((Object) method, (Object) "GET")) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0, 2, (Object) null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public final void remove$okhttp(@NotNull Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i11) {
        this.writeAbortCount = i11;
    }

    public final void setWriteSuccessCount$okhttp(int i11) {
        this.writeSuccessCount = i11;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(@NotNull Response response, @NotNull Response response2) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(response, "cached");
        Intrinsics.checkNotNullParameter(response2, SDKCoreEvent.Network.TYPE_NETWORK);
        Entry entry = new Entry(response2);
        ResponseBody body = response.body();
        if (body != null) {
            try {
                editor = ((CacheResponseBody) body).getSnapshot().edit();
                if (editor != null) {
                    try {
                        entry.writeTo(editor);
                        editor.commit();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
                editor = null;
                abortQuietly(editor);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
    }

    @NotNull
    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                if (StringsKt__StringsJVMKt.equals(HttpHeaders.VARY, headers.name(i11), true)) {
                    String value = headers.value(i11);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    for (String trim : StringsKt__StringsKt.split$default((CharSequence) value, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null)) {
                        treeSet.add(StringsKt__StringsKt.trim((CharSequence) trim).toString());
                    }
                }
                i11 = i12;
            }
            if (treeSet == null) {
                return SetsKt__SetsKt.emptySet();
            }
            return treeSet;
        }

        public final boolean hasVaryAll(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl httpUrl) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            return ByteString.Companion.encodeUtf8(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource bufferedSource) throws IOException {
            boolean z11;
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            try {
                long readDecimalLong = bufferedSource.readDecimalLong();
                String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L) {
                    if (readUtf8LineStrict.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        return (int) readDecimalLong;
                    }
                }
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + '\"');
            } catch (NumberFormatException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response networkResponse = response.networkResponse();
            Intrinsics.checkNotNull(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(@NotNull Response response, @NotNull Headers headers, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "cachedResponse");
            Intrinsics.checkNotNullParameter(headers, "cachedRequest");
            Intrinsics.checkNotNullParameter(request, "newRequest");
            Set<String> varyFields = varyFields(response.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!Intrinsics.areEqual((Object) headers.values(str), (Object) request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String name2 = headers.name(i11);
                if (varyFields.contains(name2)) {
                    builder.add(name2, headers.value(i11));
                }
                i11 = i12;
            }
            return builder.build();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull File file, long j11) {
        this(file, j11, FileSystem.SYSTEM);
        Intrinsics.checkNotNullParameter(file, "directory");
    }

    @Instrumented
    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010$\u001a\u00060%R\u00020&J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0012\u0010,\u001a\u00020(2\n\u0010-\u001a\u00060.R\u00020&R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "code", "", "handshake", "Lokhttp3/Handshake;", "isHttps", "", "()Z", "message", "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "matches", "request", "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Entry {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private static final String RECEIVED_MILLIS;
        @NotNull
        private static final String SENT_MILLIS;
        private final int code;
        @Nullable
        private final Handshake handshake;
        @NotNull
        private final String message;
        @NotNull
        private final Protocol protocol;
        private final long receivedResponseMillis;
        @NotNull
        private final String requestMethod;
        @NotNull
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        @NotNull
        private final HttpUrl url;
        @NotNull
        private final Headers varyHeaders;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Platform.Companion companion = Platform.Companion;
            SENT_MILLIS = Intrinsics.stringPlus(companion.get().getPrefix(), "-Sent-Millis");
            RECEIVED_MILLIS = Intrinsics.stringPlus(companion.get().getPrefix(), "-Received-Millis");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0120, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0121, code lost:
            kotlin.io.CloseableKt.closeFinally(r0, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0124, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Entry(@org.jetbrains.annotations.NotNull okio.Source r10) throws java.io.IOException {
            /*
                r9 = this;
                java.lang.String r0 = "rawSource"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r9.<init>()
                r0 = r10
                java.io.Closeable r0 = (java.io.Closeable) r0
                r1 = r0
                okio.Source r1 = (okio.Source) r1     // Catch:{ all -> 0x011e }
                okio.BufferedSource r10 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x011e }
                java.lang.String r1 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion     // Catch:{ all -> 0x011e }
                okhttp3.HttpUrl r2 = r2.parse(r1)     // Catch:{ all -> 0x011e }
                if (r2 == 0) goto L_0x0106
                r9.url = r2     // Catch:{ all -> 0x011e }
                java.lang.String r1 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                r9.requestMethod = r1     // Catch:{ all -> 0x011e }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x011e }
                r1.<init>()     // Catch:{ all -> 0x011e }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x011e }
                int r2 = r2.readInt$okhttp(r10)     // Catch:{ all -> 0x011e }
                r3 = 0
                r4 = r3
            L_0x0033:
                if (r4 >= r2) goto L_0x003f
                int r4 = r4 + 1
                java.lang.String r5 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x011e }
                goto L_0x0033
            L_0x003f:
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x011e }
                r9.varyHeaders = r1     // Catch:{ all -> 0x011e }
                okhttp3.internal.http.StatusLine$Companion r1 = okhttp3.internal.http.StatusLine.Companion     // Catch:{ all -> 0x011e }
                java.lang.String r2 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                okhttp3.internal.http.StatusLine r1 = r1.parse(r2)     // Catch:{ all -> 0x011e }
                okhttp3.Protocol r2 = r1.protocol     // Catch:{ all -> 0x011e }
                r9.protocol = r2     // Catch:{ all -> 0x011e }
                int r2 = r1.code     // Catch:{ all -> 0x011e }
                r9.code = r2     // Catch:{ all -> 0x011e }
                java.lang.String r1 = r1.message     // Catch:{ all -> 0x011e }
                r9.message = r1     // Catch:{ all -> 0x011e }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x011e }
                r1.<init>()     // Catch:{ all -> 0x011e }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x011e }
                int r2 = r2.readInt$okhttp(r10)     // Catch:{ all -> 0x011e }
                r4 = r3
            L_0x0067:
                if (r4 >= r2) goto L_0x0073
                int r4 = r4 + 1
                java.lang.String r5 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x011e }
                goto L_0x0067
            L_0x0073:
                java.lang.String r2 = SENT_MILLIS     // Catch:{ all -> 0x011e }
                java.lang.String r4 = r1.get(r2)     // Catch:{ all -> 0x011e }
                java.lang.String r5 = RECEIVED_MILLIS     // Catch:{ all -> 0x011e }
                java.lang.String r6 = r1.get(r5)     // Catch:{ all -> 0x011e }
                r1.removeAll(r2)     // Catch:{ all -> 0x011e }
                r1.removeAll(r5)     // Catch:{ all -> 0x011e }
                r7 = 0
                if (r4 != 0) goto L_0x008b
                r4 = r7
                goto L_0x008f
            L_0x008b:
                long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x011e }
            L_0x008f:
                r9.sentRequestMillis = r4     // Catch:{ all -> 0x011e }
                if (r6 != 0) goto L_0x0094
                goto L_0x0098
            L_0x0094:
                long r7 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x011e }
            L_0x0098:
                r9.receivedResponseMillis = r7     // Catch:{ all -> 0x011e }
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x011e }
                r9.responseHeaders = r1     // Catch:{ all -> 0x011e }
                boolean r1 = r9.isHttps()     // Catch:{ all -> 0x011e }
                r2 = 0
                if (r1 == 0) goto L_0x00fe
                java.lang.String r1 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                int r4 = r1.length()     // Catch:{ all -> 0x011e }
                if (r4 <= 0) goto L_0x00b2
                r3 = 1
            L_0x00b2:
                if (r3 != 0) goto L_0x00e2
                java.lang.String r1 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                okhttp3.CipherSuite$Companion r3 = okhttp3.CipherSuite.Companion     // Catch:{ all -> 0x011e }
                okhttp3.CipherSuite r1 = r3.forJavaName(r1)     // Catch:{ all -> 0x011e }
                java.util.List r3 = r9.readCertificateList(r10)     // Catch:{ all -> 0x011e }
                java.util.List r4 = r9.readCertificateList(r10)     // Catch:{ all -> 0x011e }
                boolean r5 = r10.exhausted()     // Catch:{ all -> 0x011e }
                if (r5 != 0) goto L_0x00d7
                okhttp3.TlsVersion$Companion r5 = okhttp3.TlsVersion.Companion     // Catch:{ all -> 0x011e }
                java.lang.String r10 = r10.readUtf8LineStrict()     // Catch:{ all -> 0x011e }
                okhttp3.TlsVersion r10 = r5.forJavaName(r10)     // Catch:{ all -> 0x011e }
                goto L_0x00d9
            L_0x00d7:
                okhttp3.TlsVersion r10 = okhttp3.TlsVersion.SSL_3_0     // Catch:{ all -> 0x011e }
            L_0x00d9:
                okhttp3.Handshake$Companion r5 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x011e }
                okhttp3.Handshake r10 = r5.get(r10, r1, r3, r4)     // Catch:{ all -> 0x011e }
                r9.handshake = r10     // Catch:{ all -> 0x011e }
                goto L_0x0100
            L_0x00e2:
                java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x011e }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
                r2.<init>()     // Catch:{ all -> 0x011e }
                java.lang.String r3 = "expected \"\" but was \""
                r2.append(r3)     // Catch:{ all -> 0x011e }
                r2.append(r1)     // Catch:{ all -> 0x011e }
                r1 = 34
                r2.append(r1)     // Catch:{ all -> 0x011e }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011e }
                r10.<init>(r1)     // Catch:{ all -> 0x011e }
                throw r10     // Catch:{ all -> 0x011e }
            L_0x00fe:
                r9.handshake = r2     // Catch:{ all -> 0x011e }
            L_0x0100:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011e }
                kotlin.io.CloseableKt.closeFinally(r0, r2)
                return
            L_0x0106:
                java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x011e }
                java.lang.String r2 = "Cache corruption for "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)     // Catch:{ all -> 0x011e }
                r10.<init>(r1)     // Catch:{ all -> 0x011e }
                okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x011e }
                okhttp3.internal.platform.Platform r1 = r1.get()     // Catch:{ all -> 0x011e }
                java.lang.String r2 = "cache corruption"
                r3 = 5
                r1.log(r2, r3, r10)     // Catch:{ all -> 0x011e }
                throw r10     // Catch:{ all -> 0x011e }
            L_0x011e:
                r10 = move-exception
                throw r10     // Catch:{ all -> 0x0120 }
            L_0x0120:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r0, r10)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.<init>(okio.Source):void");
        }

        private final boolean isHttps() {
            return Intrinsics.areEqual((Object) this.url.scheme(), (Object) "https");
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                int i11 = 0;
                while (i11 < readInt$okhttp) {
                    i11++;
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(readUtf8LineStrict);
                    Intrinsics.checkNotNull(decodeBase64);
                    buffer.write(decodeBase64);
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                for (Certificate encoded : list) {
                    byte[] encoded2 = encoded.getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    Intrinsics.checkNotNullExpressionValue(encoded2, "bytes");
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, encoded2, 0, 0, 3, (Object) null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        public final boolean matches(@NotNull Request request, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            if (!Intrinsics.areEqual((Object) this.url, (Object) request.url()) || !Intrinsics.areEqual((Object) this.requestMethod, (Object) request.method()) || !Cache.Companion.varyMatches(response, this.varyHeaders, request)) {
                return false;
            }
            return true;
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot snapshot) {
            Request request;
            Response.Builder builder;
            Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            Request.Builder headers = new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders);
            if (!(headers instanceof Request.Builder)) {
                request = headers.build();
            } else {
                request = OkHttp3Instrumentation.build(headers);
            }
            Response.Builder headers2 = new Response.Builder().request(request).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders);
            CacheResponseBody cacheResponseBody = new CacheResponseBody(snapshot, str, str2);
            if (!(headers2 instanceof Response.Builder)) {
                builder = headers2.body(cacheResponseBody);
            } else {
                builder = OkHttp3Instrumentation.body(headers2, cacheResponseBody);
            }
            return builder.handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x011a, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x011b, code lost:
            kotlin.io.CloseableKt.closeFinally(r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x011e, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(@org.jetbrains.annotations.NotNull okhttp3.internal.cache.DiskLruCache.Editor r8) throws java.io.IOException {
            /*
                r7 = this;
                java.lang.String r0 = "editor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                r0 = 0
                okio.Sink r8 = r8.newSink(r0)
                okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)
                okhttp3.HttpUrl r1 = r7.url     // Catch:{ all -> 0x0118 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x0118 }
                r2 = 10
                r1.writeByte(r2)     // Catch:{ all -> 0x0118 }
                java.lang.String r1 = r7.requestMethod     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x0118 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0118 }
                int r1 = r1.size()     // Catch:{ all -> 0x0118 }
                long r3 = (long) r1     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r1 = r8.writeDecimalLong(r3)     // Catch:{ all -> 0x0118 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0118 }
                int r1 = r1.size()     // Catch:{ all -> 0x0118 }
                r3 = r0
            L_0x003b:
                java.lang.String r4 = ": "
                if (r3 >= r1) goto L_0x005e
                int r5 = r3 + 1
                okhttp3.Headers r6 = r7.varyHeaders     // Catch:{ all -> 0x0118 }
                java.lang.String r6 = r6.name(r3)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r6 = r8.writeUtf8(r6)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r4 = r6.writeUtf8(r4)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r6 = r7.varyHeaders     // Catch:{ all -> 0x0118 }
                java.lang.String r3 = r6.value(r3)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r3 = r4.writeUtf8(r3)     // Catch:{ all -> 0x0118 }
                r3.writeByte(r2)     // Catch:{ all -> 0x0118 }
                r3 = r5
                goto L_0x003b
            L_0x005e:
                okhttp3.internal.http.StatusLine r1 = new okhttp3.internal.http.StatusLine     // Catch:{ all -> 0x0118 }
                okhttp3.Protocol r3 = r7.protocol     // Catch:{ all -> 0x0118 }
                int r5 = r7.code     // Catch:{ all -> 0x0118 }
                java.lang.String r6 = r7.message     // Catch:{ all -> 0x0118 }
                r1.<init>(r3, r5, r6)     // Catch:{ all -> 0x0118 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x0118 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x0118 }
                int r1 = r1.size()     // Catch:{ all -> 0x0118 }
                int r1 = r1 + 2
                long r5 = (long) r1     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r1 = r8.writeDecimalLong(r5)     // Catch:{ all -> 0x0118 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x0118 }
                int r1 = r1.size()     // Catch:{ all -> 0x0118 }
            L_0x008a:
                if (r0 >= r1) goto L_0x00ab
                int r3 = r0 + 1
                okhttp3.Headers r5 = r7.responseHeaders     // Catch:{ all -> 0x0118 }
                java.lang.String r5 = r5.name(r0)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r5 = r8.writeUtf8(r5)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r5 = r5.writeUtf8(r4)     // Catch:{ all -> 0x0118 }
                okhttp3.Headers r6 = r7.responseHeaders     // Catch:{ all -> 0x0118 }
                java.lang.String r0 = r6.value(r0)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r5.writeUtf8(r0)     // Catch:{ all -> 0x0118 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0118 }
                r0 = r3
                goto L_0x008a
            L_0x00ab:
                java.lang.String r0 = SENT_MILLIS     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0118 }
                long r5 = r7.sentRequestMillis     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r0.writeDecimalLong(r5)     // Catch:{ all -> 0x0118 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0118 }
                java.lang.String r0 = RECEIVED_MILLIS     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0118 }
                long r3 = r7.receivedResponseMillis     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0118 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0118 }
                boolean r0 = r7.isHttps()     // Catch:{ all -> 0x0118 }
                if (r0 == 0) goto L_0x0111
                r8.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0118 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0118 }
                okhttp3.CipherSuite r0 = r0.cipherSuite()     // Catch:{ all -> 0x0118 }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x0118 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0118 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0118 }
                java.util.List r0 = r0.peerCertificates()     // Catch:{ all -> 0x0118 }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x0118 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0118 }
                java.util.List r0 = r0.localCertificates()     // Catch:{ all -> 0x0118 }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x0118 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0118 }
                okhttp3.TlsVersion r0 = r0.tlsVersion()     // Catch:{ all -> 0x0118 }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x0118 }
                okio.BufferedSink r0 = r8.writeUtf8(r0)     // Catch:{ all -> 0x0118 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0118 }
            L_0x0111:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0118 }
                r0 = 0
                kotlin.io.CloseableKt.closeFinally(r8, r0)
                return
            L_0x0118:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x011a }
            L_0x011a:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r8, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.writeTo(okhttp3.internal.cache.DiskLruCache$Editor):void");
        }

        public Entry(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
