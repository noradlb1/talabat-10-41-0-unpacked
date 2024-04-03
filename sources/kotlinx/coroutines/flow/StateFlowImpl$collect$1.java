package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {386, 398, 403}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class StateFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26059h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26060i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26061j;

    /* renamed from: k  reason: collision with root package name */
    public Object f26062k;

    /* renamed from: l  reason: collision with root package name */
    public Object f26063l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f26064m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ StateFlowImpl<T> f26065n;

    /* renamed from: o  reason: collision with root package name */
    public int f26066o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, Continuation<? super StateFlowImpl$collect$1> continuation) {
        super(continuation);
        this.f26065n = stateFlowImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26064m = obj;
        this.f26066o |= Integer.MIN_VALUE;
        return this.f26065n.collect((FlowCollector) null, this);
    }
}
