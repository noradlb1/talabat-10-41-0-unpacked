package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", i = {}, l = {61, 63}, m = "emit", n = {}, s = {})
public final class FlowKt__LimitKt$take$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25710h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$take$2$1<T> f25711i;

    /* renamed from: j  reason: collision with root package name */
    public int f25712j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$take$2$1$emit$1(FlowKt__LimitKt$take$2$1<? super T> flowKt__LimitKt$take$2$1, Continuation<? super FlowKt__LimitKt$take$2$1$emit$1> continuation) {
        super(continuation);
        this.f25711i = flowKt__LimitKt$take$2$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25710h = obj;
        this.f25712j |= Integer.MIN_VALUE;
        return this.f25711i.emit(null, this);
    }
}
