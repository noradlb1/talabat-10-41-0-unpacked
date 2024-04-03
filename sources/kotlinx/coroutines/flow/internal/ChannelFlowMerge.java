package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BA\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "Lkotlinx/coroutines/channels/ProducerScope;", "", "c", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "I", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    private final int concurrency;
    @NotNull
    private final Flow<Flow<T>> flow;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowMerge(Flow flow2, int i11, CoroutineContext coroutineContext, int i12, BufferOverflow bufferOverflow, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow2, i11, (i13 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i13 & 8) != 0 ? -2 : i12, (i13 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @NotNull
    public String a() {
        return "concurrency=" + this.concurrency;
    }

    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new ChannelFlowMerge$collectTo$2((Job) continuation.getContext().get(Job.Key), SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, (Object) null), producerScope, new SendingCollector(producerScope)), continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.flow, this.concurrency, coroutineContext, i11, bufferOverflow);
    }

    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }

    public ChannelFlowMerge(@NotNull Flow<? extends Flow<? extends T>> flow2, int i11, @NotNull CoroutineContext coroutineContext, int i12, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i12, bufferOverflow);
        this.flow = flow2;
        this.concurrency = i11;
    }
}
