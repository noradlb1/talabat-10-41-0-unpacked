package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ReduceKt$lastOrNull$2<T> implements FlowCollector {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<T> f25804b;

    public FlowKt__ReduceKt$lastOrNull$2(Ref.ObjectRef<T> objectRef) {
        this.f25804b = objectRef;
    }

    @Nullable
    public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
        this.f25804b.element = t11;
        return Unit.INSTANCE;
    }
}
