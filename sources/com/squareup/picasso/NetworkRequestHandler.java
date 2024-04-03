package com.squareup.picasso;

import android.net.NetworkInfo;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Source;

@Instrumented
class NetworkRequestHandler extends RequestHandler {
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private final Downloader downloader;
    private final Stats stats;

    public static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    public static final class ResponseException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f53428b;

        /* renamed from: c  reason: collision with root package name */
        public final int f53429c;

        public ResponseException(int i11, int i12) {
            super("HTTP " + i11);
            this.f53428b = i11;
            this.f53429c = i12;
        }
    }

    public NetworkRequestHandler(Downloader downloader2, Stats stats2) {
        this.downloader = downloader2;
        this.stats = stats2;
    }

    private static Request createRequest(Request request, int i11) {
        CacheControl cacheControl;
        if (i11 == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i11)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i11)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i11)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(request.uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        if (!(url instanceof Request.Builder)) {
            return url.build();
        }
        return OkHttp3Instrumentation.build(url);
    }

    public boolean canHandleRequest(Request request) {
        String scheme = request.uri.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    public int d() {
        return 2;
    }

    public boolean f(boolean z11, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public boolean g() {
        return true;
    }

    public RequestHandler.Result load(Request request, int i11) throws IOException {
        Picasso.LoadedFrom loadedFrom;
        Response load = this.downloader.load(createRequest(request, i11));
        ResponseBody body = load.body();
        if (load.isSuccessful()) {
            if (load.cacheResponse() == null) {
                loadedFrom = Picasso.LoadedFrom.NETWORK;
            } else {
                loadedFrom = Picasso.LoadedFrom.DISK;
            }
            if (loadedFrom == Picasso.LoadedFrom.DISK && body.contentLength() == 0) {
                body.close();
                throw new ContentLengthException("Received response with 0 content-length header.");
            }
            if (loadedFrom == Picasso.LoadedFrom.NETWORK && body.contentLength() > 0) {
                this.stats.f(body.contentLength());
            }
            return new RequestHandler.Result((Source) body.source(), loadedFrom);
        }
        body.close();
        throw new ResponseException(load.code(), request.f53460c);
    }
}
