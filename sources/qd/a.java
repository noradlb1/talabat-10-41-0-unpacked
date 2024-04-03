package qd;

import com.instabug.library.util.threading.PoolProvider;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f57185b;

    public /* synthetic */ a(Runnable runnable) {
        this.f57185b = runnable;
    }

    public final void run() {
        PoolProvider.lambda$postDelayedTaskAtFixedDelay$0(this.f57185b);
    }
}
