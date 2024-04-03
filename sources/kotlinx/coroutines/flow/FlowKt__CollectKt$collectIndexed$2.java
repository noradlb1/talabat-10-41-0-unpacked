package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, T, Continuation<? super Unit>, Object> f25505b;
    private int index;

    public FlowKt__CollectKt$collectIndexed$2(Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.f25505b = function3;
    }

    @Nullable
    public Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.f25505b;
        int i11 = this.index;
        this.index = i11 + 1;
        if (i11 >= 0) {
            Object invoke = function3.invoke(Boxing.boxInt(i11), t11, continuation);
            if (invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return invoke;
            }
            return Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @Nullable
    public Object emit$$forInline(T t11, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__CollectKt$collectIndexed$2$emit$1(this, continuation);
        InlineMarker.mark(5);
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.f25505b;
        int i11 = this.index;
        this.index = i11 + 1;
        if (i11 >= 0) {
            function3.invoke(Integer.valueOf(i11), t11, continuation);
            return Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
