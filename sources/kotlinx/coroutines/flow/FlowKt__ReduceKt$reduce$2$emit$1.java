package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2", f = "Reduce.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
public final class FlowKt__ReduceKt$reduce$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25810h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25811i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowKt__ReduceKt$reduce$2<T> f25812j;

    /* renamed from: k  reason: collision with root package name */
    public int f25813k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ReduceKt$reduce$2$emit$1(FlowKt__ReduceKt$reduce$2<? super T> flowKt__ReduceKt$reduce$2, Continuation<? super FlowKt__ReduceKt$reduce$2$emit$1> continuation) {
        super(continuation);
        this.f25812j = flowKt__ReduceKt$reduce$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25811i = obj;
        this.f25813k |= Integer.MIN_VALUE;
        return this.f25812j.emit(null, this);
    }
}
