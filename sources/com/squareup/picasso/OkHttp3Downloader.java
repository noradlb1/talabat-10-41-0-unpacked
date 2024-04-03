package com.squareup.picasso;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Instrumented
public final class OkHttp3Downloader implements Downloader {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Call.Factory f53430a;
    private final Cache cache;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.f(context));
    }

    @NonNull
    public Response load(@NonNull Request request) throws IOException {
        Call.Factory factory = this.f53430a;
        return FirebasePerfOkHttpClient.execute(!(factory instanceof OkHttpClient) ? factory.newCall(request) : OkHttp3Instrumentation.newCall((OkHttpClient) factory, request));
    }

    public void shutdown() {
        Cache cache2;
        if (!this.sharedClient && (cache2 = this.cache) != null) {
            try {
                cache2.close();
            } catch (IOException unused) {
            }
        }
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.a(file));
    }

    public OkHttp3Downloader(Context context, long j11) {
        this(Utils.f(context), j11);
    }

    public OkHttp3Downloader(File file, long j11) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j11)).build());
        this.sharedClient = false;
    }

    public OkHttp3Downloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.f53430a = okHttpClient;
        this.cache = okHttpClient.cache();
    }

    public OkHttp3Downloader(Call.Factory factory) {
        this.sharedClient = true;
        this.f53430a = factory;
        this.cache = null;
    }
}
