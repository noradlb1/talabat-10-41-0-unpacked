package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", i = {0, 0}, l = {30}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
public final class ChannelFlowTransformLatest$flowCollect$3$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26111h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26112i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26113j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f26114k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<T> f26115l;

    /* renamed from: m  reason: collision with root package name */
    public int f26116m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3$1$emit$1(ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<? super T> r12, Continuation<? super ChannelFlowTransformLatest$flowCollect$3$1$emit$1> continuation) {
        super(continuation);
        this.f26115l = r12;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26114k = obj;
        this.f26116m |= Integer.MIN_VALUE;
        return this.f26115l.emit(null, this);
    }
}
