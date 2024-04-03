package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", f = "Reduce.kt", i = {}, l = {45}, m = "emit", n = {}, s = {})
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25793h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowKt__ReduceKt$fold$2<T> f25795j;

    /* renamed from: k  reason: collision with root package name */
    public int f25796k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt$fold$2<? super T> flowKt__ReduceKt$fold$2, Continuation<? super FlowKt__ReduceKt$fold$2$emit$1> continuation) {
        super(continuation);
        this.f25795j = flowKt__ReduceKt$fold$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25794i = obj;
        this.f25796k |= Integer.MIN_VALUE;
        return this.f25795j.emit(null, this);
    }
}
