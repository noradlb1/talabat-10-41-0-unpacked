package kotlinx.coroutines.rx2;

import io.reactivex.CompletableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/rx2/RxCompletableCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "value", "n", "(Lkotlin/Unit;)V", "", "cause", "", "handled", "m", "Lio/reactivex/CompletableEmitter;", "subscriber", "Lio/reactivex/CompletableEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/CompletableEmitter;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
final class RxCompletableCoroutine extends AbstractCoroutine<Unit> {
    @NotNull
    private final CompletableEmitter subscriber;

    public RxCompletableCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull CompletableEmitter completableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = completableEmitter;
    }

    public void m(@NotNull Throwable th2, boolean z11) {
        try {
            if (this.subscriber.tryOnError(th2)) {
                return;
            }
        } catch (Throwable th3) {
            ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
        }
        RxCancellableKt.handleUndeliverableException(th2, getContext());
    }

    /* renamed from: n */
    public void onCompleted(@NotNull Unit unit) {
        try {
            this.subscriber.onComplete();
        } catch (Throwable th2) {
            RxCancellableKt.handleUndeliverableException(th2, getContext());
        }
    }
}
