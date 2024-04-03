package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__CollectKt$collectIndexed$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25506h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__CollectKt$collectIndexed$2 f25507i;

    /* renamed from: j  reason: collision with root package name */
    public int f25508j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collectIndexed$2$emit$1(FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2, Continuation<? super FlowKt__CollectKt$collectIndexed$2$emit$1> continuation) {
        super(continuation);
        this.f25507i = flowKt__CollectKt$collectIndexed$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25506h = obj;
        this.f25508j |= Integer.MIN_VALUE;
        return this.f25507i.emit(null, this);
    }
}
