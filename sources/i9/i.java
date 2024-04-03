package i9;

import java.util.concurrent.Future;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Future f47119b;

    public /* synthetic */ i(Future future) {
        this.f47119b = future;
    }

    public final void run() {
        this.f47119b.cancel(false);
    }
}
