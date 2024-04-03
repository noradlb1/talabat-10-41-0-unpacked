package n8;

import com.google.android.exoplayer2.util.Util;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35541b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f35542c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f35543d;

    public /* synthetic */ o(SettableFuture settableFuture, Runnable runnable, Object obj) {
        this.f35541b = settableFuture;
        this.f35542c = runnable;
        this.f35543d = obj;
    }

    public final void run() {
        Util.lambda$postOrRunWithCompletion$0(this.f35541b, this.f35542c, this.f35543d);
    }
}
