package q00;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerDispatcherKt;

public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f28156b;

    public /* synthetic */ b(CancellableContinuation cancellableContinuation) {
        this.f28156b = cancellableContinuation;
    }

    public final void doFrame(long j11) {
        HandlerDispatcherKt.m7787postFrameCallback$lambda6(this.f28156b, j11);
    }
}
