package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalCache.Segment f44632b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f44633c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f44634d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ LocalCache.LoadingValueReference f44635e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f44636f;

    public /* synthetic */ c(LocalCache.Segment segment, Object obj, int i11, LocalCache.LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
        this.f44632b = segment;
        this.f44633c = obj;
        this.f44634d = i11;
        this.f44635e = loadingValueReference;
        this.f44636f = listenableFuture;
    }

    public final void run() {
        this.f44632b.lambda$loadAsync$0(this.f44633c, this.f44634d, this.f44635e, this.f44636f);
    }
}
