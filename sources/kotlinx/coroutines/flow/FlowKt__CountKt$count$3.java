package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {30}, m = "count", n = {"i"}, s = {"L$0"})
public final class FlowKt__CountKt$count$3<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25519h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25520i;

    /* renamed from: j  reason: collision with root package name */
    public int f25521j;

    public FlowKt__CountKt$count$3(Continuation<? super FlowKt__CountKt$count$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25520i = obj;
        this.f25521j |= Integer.MIN_VALUE;
        return FlowKt.count((Flow) null, (Function2) null, this);
    }
}
