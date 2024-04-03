package androidx.compose.runtime;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "frameTimeNanos", "", "doFrame"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DefaultChoreographerFrameClock$withFrameNanos$2$callback$1 implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<R> f9112b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, R> f9113c;

    public DefaultChoreographerFrameClock$withFrameNanos$2$callback$1(CancellableContinuation<? super R> cancellableContinuation, Function1<? super Long, ? extends R> function1) {
        this.f9112b = cancellableContinuation;
        this.f9113c = function1;
    }

    public final void doFrame(long j11) {
        Object obj;
        CancellableContinuation<R> cancellableContinuation = this.f9112b;
        DefaultChoreographerFrameClock defaultChoreographerFrameClock = DefaultChoreographerFrameClock.INSTANCE;
        Function1<Long, R> function1 = this.f9113c;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(function1.invoke(Long.valueOf(j11)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        cancellableContinuation.resumeWith(obj);
    }
}
