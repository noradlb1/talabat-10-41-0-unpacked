package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
public final class FlowKt__ReduceKt$reduce$1<S, T extends S> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25805h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25806i;

    /* renamed from: j  reason: collision with root package name */
    public int f25807j;

    public FlowKt__ReduceKt$reduce$1(Continuation<? super FlowKt__ReduceKt$reduce$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25806i = obj;
        this.f25807j |= Integer.MIN_VALUE;
        return FlowKt.reduce((Flow) null, (Function3) null, this);
    }
}
