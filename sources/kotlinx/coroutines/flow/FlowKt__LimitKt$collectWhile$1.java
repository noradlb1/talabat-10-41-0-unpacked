package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {136}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
public final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25682h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25683i;

    /* renamed from: j  reason: collision with root package name */
    public int f25684j;

    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25683i = obj;
        this.f25684j |= Integer.MIN_VALUE;
        return FlowKt__LimitKt.collectWhile((Flow) null, (Function2) null, this);
    }
}
