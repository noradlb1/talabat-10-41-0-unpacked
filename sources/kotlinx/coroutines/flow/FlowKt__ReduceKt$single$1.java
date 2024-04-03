package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {57}, m = "single", n = {"result"}, s = {"L$0"})
public final class FlowKt__ReduceKt$single$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25814h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25815i;

    /* renamed from: j  reason: collision with root package name */
    public int f25816j;

    public FlowKt__ReduceKt$single$1(Continuation<? super FlowKt__ReduceKt$single$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25815i = obj;
        this.f25816j |= Integer.MIN_VALUE;
        return FlowKt.single((Flow) null, this);
    }
}
