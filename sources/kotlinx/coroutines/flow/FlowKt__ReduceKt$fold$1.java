package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
public final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25788h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25789i;

    /* renamed from: j  reason: collision with root package name */
    public int f25790j;

    public FlowKt__ReduceKt$fold$1(Continuation<? super FlowKt__ReduceKt$fold$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25789i = obj;
        this.f25790j |= Integer.MIN_VALUE;
        return FlowKt__ReduceKt.fold((Flow) null, null, (Function3) null, this);
    }
}
