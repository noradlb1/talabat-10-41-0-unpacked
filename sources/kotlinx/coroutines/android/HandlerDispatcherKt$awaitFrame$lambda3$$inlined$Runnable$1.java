package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.android.HandlerDispatcherKt$awaitFrame$lambda-3$$inlined$Runnable$1  reason: invalid class name */
public final class HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f25148b;

    public HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1(CancellableContinuation cancellableContinuation) {
        this.f25148b = cancellableContinuation;
    }

    public final void run() {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(this.f25148b);
    }
}
