package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlowSubscription$consumeFlow$2<T> implements FlowCollector {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlowSubscription<T> f26232b;

    public FlowSubscription$consumeFlow$2(FlowSubscription<T> flowSubscription) {
        this.f26232b = flowSubscription;
    }

    @Nullable
    public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
        this.f26232b.subscriber.onNext(t11);
        if (FlowSubscription.f26228b.decrementAndGet(this.f26232b) <= 0) {
            FlowSubscription<T> flowSubscription = this.f26232b;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            flowSubscription.producer = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }
        JobKt.ensureActive(this.f26232b.getCoroutineContext());
        return Unit.INSTANCE;
    }
}
