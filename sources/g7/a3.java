package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class a3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f35185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f35186c;

    public /* synthetic */ a3(SimpleBasePlayer simpleBasePlayer, ListenableFuture listenableFuture) {
        this.f35185b = simpleBasePlayer;
        this.f35186c = listenableFuture;
    }

    public final void run() {
        this.f35185b.lambda$updateStateForPendingOperation$55(this.f35186c);
    }
}
