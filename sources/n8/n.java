package n8;

import com.google.android.exoplayer2.util.Util;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f35538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35539c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AsyncFunction f35540d;

    public /* synthetic */ n(ListenableFuture listenableFuture, SettableFuture settableFuture, AsyncFunction asyncFunction) {
        this.f35538b = listenableFuture;
        this.f35539c = settableFuture;
        this.f35540d = asyncFunction;
    }

    public final void run() {
        Util.lambda$transformFutureAsync$2(this.f35538b, this.f35539c, this.f35540d);
    }
}
