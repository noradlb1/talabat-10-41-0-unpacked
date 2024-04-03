package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", f = "Delay.kt", i = {}, l = {280}, m = "emit", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$values$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25569h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__DelayKt$sample$2$values$1.AnonymousClass1<T> f25570i;

    /* renamed from: j  reason: collision with root package name */
    public int f25571j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$values$1$1$emit$1(FlowKt__DelayKt$sample$2$values$1.AnonymousClass1<? super T> r12, Continuation<? super FlowKt__DelayKt$sample$2$values$1$1$emit$1> continuation) {
        super(continuation);
        this.f25570i = r12;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25569h = obj;
        this.f25571j |= Integer.MIN_VALUE;
        return this.f25570i.emit(null, this);
    }
}
