package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__CollectKt$collect$3$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25502h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__CollectKt$collect$3 f25503i;

    /* renamed from: j  reason: collision with root package name */
    public int f25504j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collect$3$emit$1(FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3, Continuation<? super FlowKt__CollectKt$collect$3$emit$1> continuation) {
        super(continuation);
        this.f25503i = flowKt__CollectKt$collect$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25502h = obj;
        this.f25504j |= Integer.MIN_VALUE;
        return this.f25503i.emit(null, this);
    }
}
