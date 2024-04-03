package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", i = {0, 0}, l = {66}, m = "emit", n = {"this", "inner"}, s = {"L$0", "L$1"})
public final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26091h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26092i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f26093j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ChannelFlowMerge$collectTo$2<T> f26094k;

    /* renamed from: l  reason: collision with root package name */
    public int f26095l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$2$emit$1(ChannelFlowMerge$collectTo$2<? super T> channelFlowMerge$collectTo$2, Continuation<? super ChannelFlowMerge$collectTo$2$emit$1> continuation) {
        super(continuation);
        this.f26094k = channelFlowMerge$collectTo$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26093j = obj;
        this.f26095l |= Integer.MIN_VALUE;
        return this.f26094k.emit((Flow) null, (Continuation<? super Unit>) this);
    }
}
