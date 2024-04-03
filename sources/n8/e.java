package n8;

import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver f35533b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver.Listener f35534c;

    public /* synthetic */ e(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.Listener listener) {
        this.f35533b = networkTypeObserver;
        this.f35534c = listener;
    }

    public final void run() {
        this.f35533b.lambda$register$0(this.f35534c);
    }
}
