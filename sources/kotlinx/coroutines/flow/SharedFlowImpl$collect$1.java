package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {373, 380, 383}, m = "collect$suspendImpl", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
public final class SharedFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26039h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26040i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26041j;

    /* renamed from: k  reason: collision with root package name */
    public Object f26042k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f26043l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SharedFlowImpl<T> f26044m;

    /* renamed from: n  reason: collision with root package name */
    public int f26045n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super SharedFlowImpl$collect$1> continuation) {
        super(continuation);
        this.f26044m = sharedFlowImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26043l = obj;
        this.f26045n |= Integer.MIN_VALUE;
        return SharedFlowImpl.e(this.f26044m, (FlowCollector) null, this);
    }
}
