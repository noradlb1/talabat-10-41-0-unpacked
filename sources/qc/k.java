package qc;

import com.instabug.library.InstabugNetworkJob;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50760b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f50761c;

    public /* synthetic */ k(String str, Runnable runnable) {
        this.f50760b = str;
        this.f50761c = runnable;
    }

    public final void run() {
        InstabugNetworkJob.lambda$enqueueJob$0(this.f50760b, this.f50761c);
    }
}
