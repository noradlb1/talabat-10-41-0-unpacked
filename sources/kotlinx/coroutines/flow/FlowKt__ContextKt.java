package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000f"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ContextKt {
    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> flow, int i11, @NotNull BufferOverflow bufferOverflow) {
        BufferOverflow bufferOverflow2;
        int i12;
        boolean z11 = true;
        if (i11 >= 0 || i11 == -2 || i11 == -1) {
            if (i11 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z11 = false;
            }
            if (z11) {
                if (i11 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i12 = 0;
                } else {
                    i12 = i11;
                    bufferOverflow2 = bufferOverflow;
                }
                if (flow instanceof FusibleFlow) {
                    return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, (CoroutineContext) null, i12, bufferOverflow2, 1, (Object) null);
                }
                return new ChannelFlowOperatorImpl(flow, (CoroutineContext) null, i12, bufferOverflow2, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i11).toString());
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -2;
        }
        if ((i12 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, i11, bufferOverflow);
    }

    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> flow) {
        if (flow instanceof CancellableFlow) {
            return flow;
        }
        return new CancellableFlowImpl(flow);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        boolean z11;
        if (coroutineContext.get(Job.Key) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
        }
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> flow) {
        return buffer$default(flow, -1, (BufferOverflow) null, 2, (Object) null);
    }

    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (Intrinsics.areEqual((Object) coroutineContext, (Object) EmptyCoroutineContext.INSTANCE)) {
            return flow;
        }
        if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineContext, 0, (BufferOverflow) null, 6, (Object) null);
        }
        return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, (BufferOverflow) null, 12, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -2;
        }
        return buffer$default(flow, i11, (BufferOverflow) null, 2, (Object) null);
    }
}
