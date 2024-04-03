package u6;

import com.facebook.bolts.CancellationTokenSource;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f34699b;

    public /* synthetic */ a(CancellationTokenSource cancellationTokenSource) {
        this.f34699b = cancellationTokenSource;
    }

    public final void run() {
        CancellationTokenSource.m8932cancelAfter$lambda6$lambda5(this.f34699b);
    }
}
