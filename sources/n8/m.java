package n8;

import com.google.android.exoplayer2.util.Util;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35536b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f35537c;

    public /* synthetic */ m(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        this.f35536b = settableFuture;
        this.f35537c = listenableFuture;
    }

    public final void run() {
        Util.lambda$transformFutureAsync$1(this.f35536b, this.f35537c);
    }
}
