package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0012\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "", "markConsumed", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "c", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "()Ljava/lang/String;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "consume", "Z", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class ChannelAsFlow<T> extends ChannelFlow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    @NotNull
    private final ReceiveChannel<T> channel;
    private final boolean consume;
    @NotNull
    private volatile /* synthetic */ int consumed;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean z11, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(receiveChannel, z11, (i12 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 8) != 0 ? -3 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void markConsumed() {
        if (this.consume) {
            boolean z11 = true;
            if (consumed$FU.getAndSet(this, 1) != 0) {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @NotNull
    public String a() {
        return "channel=" + this.channel;
    }

    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object access$emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(producerScope), this.channel, this.consume, continuation);
        return access$emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        if (this.capacity == -3) {
            markConsumed();
            Object access$emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector, this.channel, this.consume, continuation);
            if (access$emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return access$emitAllImpl$FlowKt__ChannelsKt;
            }
            return Unit.INSTANCE;
        }
        Object collect = super.collect(flowCollector, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelAsFlow(this.channel, this.consume, coroutineContext, i11, bufferOverflow);
    }

    @NotNull
    public Flow<T> dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }

    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope coroutineScope) {
        markConsumed();
        if (this.capacity == -3) {
            return this.channel;
        }
        return super.produceImpl(coroutineScope);
    }

    public ChannelAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel, boolean z11, @NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.channel = receiveChannel;
        this.consume = z11;
        this.consumed = 0;
    }
}
