package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {230}, m = "collect", n = {"safeCollector"}, s = {"L$0"})
public final class AbstractFlow$collect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25408h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25409i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AbstractFlow<T> f25410j;

    /* renamed from: k  reason: collision with root package name */
    public int f25411k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractFlow$collect$1(AbstractFlow<T> abstractFlow, Continuation<? super AbstractFlow$collect$1> continuation) {
        super(continuation);
        this.f25410j = abstractFlow;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25409i = obj;
        this.f25411k |= Integer.MIN_VALUE;
        return this.f25410j.collect((FlowCollector) null, this);
    }
}
