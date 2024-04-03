package kotlinx.coroutines.rx2;

import io.reactivex.MaybeEmitter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/rx2/RxMaybeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "value", "", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "m", "Lio/reactivex/MaybeEmitter;", "subscriber", "Lio/reactivex/MaybeEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/MaybeEmitter;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
final class RxMaybeCoroutine<T> extends AbstractCoroutine<T> {
    @NotNull
    private final MaybeEmitter<T> subscriber;

    public RxMaybeCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull MaybeEmitter<T> maybeEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = maybeEmitter;
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

    public void onCompleted(T t11) {
        if (t11 == null) {
            try {
                this.subscriber.onComplete();
            } catch (Throwable th2) {
                RxCancellableKt.handleUndeliverableException(th2, getContext());
            }
        } else {
            this.subscriber.onSuccess(t11);
        }
    }
}
