package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {167}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
public final class FlowKt__ReduceKt$lastOrNull$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25801h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25802i;

    /* renamed from: j  reason: collision with root package name */
    public int f25803j;

    public FlowKt__ReduceKt$lastOrNull$1(Continuation<? super FlowKt__ReduceKt$lastOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25802i = obj;
        this.f25803j |= Integer.MIN_VALUE;
        return FlowKt.lastOrNull((Flow) null, this);
    }
}
