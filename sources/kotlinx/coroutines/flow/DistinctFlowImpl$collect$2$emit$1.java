package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", i = {}, l = {81}, m = "emit", n = {}, s = {})
public final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25423h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl$collect$2<T> f25424i;

    /* renamed from: j  reason: collision with root package name */
    public int f25425j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl$collect$2<? super T> distinctFlowImpl$collect$2, Continuation<? super DistinctFlowImpl$collect$2$emit$1> continuation) {
        super(continuation);
        this.f25424i = distinctFlowImpl$collect$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25423h = obj;
        this.f25425j |= Integer.MIN_VALUE;
        return this.f25424i.emit(null, this);
    }
}
