package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", i = {1, 1}, l = {37, 38, 40}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
public final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25699h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25700i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25701j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$dropWhile$1$1<T> f25702k;

    /* renamed from: l  reason: collision with root package name */
    public int f25703l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$dropWhile$1$1$emit$1(FlowKt__LimitKt$dropWhile$1$1<? super T> flowKt__LimitKt$dropWhile$1$1, Continuation<? super FlowKt__LimitKt$dropWhile$1$1$emit$1> continuation) {
        super(continuation);
        this.f25702k = flowKt__LimitKt$dropWhile$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25701j = obj;
        this.f25703l |= Integer.MIN_VALUE;
        return this.f25702k.emit(null, this);
    }
}
