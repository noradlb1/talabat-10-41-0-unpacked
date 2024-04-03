package kotlinx.coroutines.rx2;

import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/rx2/RxSingleCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "value", "", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "m", "Lio/reactivex/SingleEmitter;", "subscriber", "Lio/reactivex/SingleEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/SingleEmitter;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
final class RxSingleCoroutine<T> extends AbstractCoroutine<T> {
    @NotNull
    private final SingleEmitter<T> subscriber;

    public RxSingleCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull SingleEmitter<T> singleEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = singleEmitter;
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

    public void onCompleted(@NotNull T t11) {
        try {
            this.subscriber.onSuccess(t11);
        } catch (Throwable th2) {
            RxCancellableKt.handleUndeliverableException(th2, getContext());
        }
    }
}
