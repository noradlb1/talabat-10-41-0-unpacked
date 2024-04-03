package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", f = "Limit.kt", i = {0}, l = {130}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__LimitKt$collectWhile$collector$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25686h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25687i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$collectWhile$collector$1 f25688j;

    /* renamed from: k  reason: collision with root package name */
    public int f25689k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$collectWhile$collector$1$emit$1(FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1, Continuation<? super FlowKt__LimitKt$collectWhile$collector$1$emit$1> continuation) {
        super(continuation);
        this.f25688j = flowKt__LimitKt$collectWhile$collector$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25687i = obj;
        this.f25689k |= Integer.MIN_VALUE;
        return this.f25688j.emit(null, this);
    }
}
