package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\b\b\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\b\r\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0000\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0007\u001a3\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "Lkotlin/Function1;", "", "timeout", "Lkotlin/time/Duration;", "debounceDuration", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "period", "sample-HG0u8IE", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__DelayKt {
    @NotNull
    @FlowPreview
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 == 0 ? flow : debounceInternal$FlowKt__DelayKt(flow, new FlowKt__DelayKt$debounce$2(j11));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @NotNull
    @FlowPreview
    /* renamed from: debounce-HG0u8IE  reason: not valid java name */
    public static final <T> Flow<T> m7825debounceHG0u8IE(@NotNull Flow<? extends T> flow, long j11) {
        return FlowKt.debounce(flow, DelayKt.m7782toDelayMillisLRDsOJo(j11));
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    @JvmName(name = "debounceDuration")
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Duration> function1) {
        return debounceInternal$FlowKt__DelayKt(flow, new FlowKt__DelayKt$debounce$3(function1));
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(function1, flow, (Continuation<? super FlowKt__DelayKt$debounceInternal$1>) null));
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (j12 < 0) {
                z12 = false;
            }
            if (z12) {
                return ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j12, j11, (Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$3>) null), 1, (Object) null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j12 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = j11;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, j11, j12);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j11) {
        boolean z11;
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$sample$2(j11, flow, (Continuation<? super FlowKt__DelayKt$sample$2>) null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @NotNull
    @FlowPreview
    /* renamed from: sample-HG0u8IE  reason: not valid java name */
    public static final <T> Flow<T> m7826sampleHG0u8IE(@NotNull Flow<? extends T> flow, long j11) {
        return FlowKt.sample(flow, DelayKt.m7782toDelayMillisLRDsOJo(j11));
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return debounceInternal$FlowKt__DelayKt(flow, function1);
    }
}
