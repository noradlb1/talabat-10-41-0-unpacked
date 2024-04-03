package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {183}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
public final class FlowKt__ReduceKt$first$3<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25775h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25776i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25777j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25778k;

    /* renamed from: l  reason: collision with root package name */
    public int f25779l;

    public FlowKt__ReduceKt$first$3(Continuation<? super FlowKt__ReduceKt$first$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25778k = obj;
        this.f25779l |= Integer.MIN_VALUE;
        return FlowKt.first((Flow) null, (Function2) null, this);
    }
}
