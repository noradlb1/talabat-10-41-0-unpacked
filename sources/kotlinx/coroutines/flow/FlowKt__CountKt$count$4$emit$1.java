package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", i = {0}, l = {31}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__CountKt$count$4$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25524h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25525i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowKt__CountKt$count$4<T> f25526j;

    /* renamed from: k  reason: collision with root package name */
    public int f25527k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CountKt$count$4$emit$1(FlowKt__CountKt$count$4<? super T> flowKt__CountKt$count$4, Continuation<? super FlowKt__CountKt$count$4$emit$1> continuation) {
        super(continuation);
        this.f25526j = flowKt__CountKt$count$4;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25525i = obj;
        this.f25527k |= Integer.MIN_VALUE;
        return this.f25526j.emit(null, this);
    }
}
