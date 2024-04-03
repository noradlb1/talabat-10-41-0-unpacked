package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", i = {}, l = {275}, m = "emit", n = {}, s = {})
public final class CancellableFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25417h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CancellableFlowImpl$collect$2<T> f25418i;

    /* renamed from: j  reason: collision with root package name */
    public int f25419j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellableFlowImpl$collect$2$emit$1(CancellableFlowImpl$collect$2<? super T> cancellableFlowImpl$collect$2, Continuation<? super CancellableFlowImpl$collect$2$emit$1> continuation) {
        super(continuation);
        this.f25418i = cancellableFlowImpl$collect$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25417h = obj;
        this.f25419j |= Integer.MIN_VALUE;
        return this.f25418i.emit(null, this);
    }
}
