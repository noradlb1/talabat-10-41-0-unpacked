package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "Lkotlinx/coroutines/channels/ProducerScope;", "", "c", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Ljava/lang/Iterable;", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {
    @NotNull
    private final Iterable<Flow<T>> flows;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -2 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        SendingCollector sendingCollector = new SendingCollector(producerScope);
        for (Flow<T> channelLimitedFlowMerge$collectTo$2$1 : this.flows) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(producerScope, (CoroutineContext) null, (CoroutineStart) null, new ChannelLimitedFlowMerge$collectTo$2$1(channelLimitedFlowMerge$collectTo$2$1, sendingCollector, (Continuation<? super ChannelLimitedFlowMerge$collectTo$2$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.flows, coroutineContext, i11, bufferOverflow);
    }

    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }

    public ChannelLimitedFlowMerge(@NotNull Iterable<? extends Flow<? extends T>> iterable, @NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.flows = iterable;
    }
}
