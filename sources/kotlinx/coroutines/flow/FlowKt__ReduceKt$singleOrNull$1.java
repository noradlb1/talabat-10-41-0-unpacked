package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
public final class FlowKt__ReduceKt$singleOrNull$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25818h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25819i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25820j;

    /* renamed from: k  reason: collision with root package name */
    public int f25821k;

    public FlowKt__ReduceKt$singleOrNull$1(Continuation<? super FlowKt__ReduceKt$singleOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25820j = obj;
        this.f25821k |= Integer.MIN_VALUE;
        return FlowKt.singleOrNull((Flow) null, this);
    }
}
