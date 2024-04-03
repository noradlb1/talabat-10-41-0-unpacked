package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¤@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J!\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001eR9\u0010$\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001f8@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "fuse", "d", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "", "c", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "toString", "Lkotlin/coroutines/CoroutineContext;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "collectToFun", "getProduceCapacity$kotlinx_coroutines_core", "()I", "produceCapacity", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    @JvmField
    public final int capacity;
    @NotNull
    @JvmField
    public final CoroutineContext context;
    @NotNull
    @JvmField
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        this.context = coroutineContext;
        this.capacity = i11;
        this.onBufferOverflow = bufferOverflow;
    }

    public static /* synthetic */ Object b(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(flowCollector, channelFlow, (Continuation<? super ChannelFlow$collect$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Nullable
    public String a() {
        return null;
    }

    @Nullable
    public abstract Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return b(this, flowCollector, continuation);
    }

    @NotNull
    public abstract ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow);

    @Nullable
    public Flow<T> dropChannelOperators() {
        return null;
    }

    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.context);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i12 = this.capacity;
            if (i12 != -3) {
                if (i11 != -3) {
                    if (i12 != -2) {
                        if (i11 != -2 && (i12 = i12 + i11) < 0) {
                            i11 = Integer.MAX_VALUE;
                        }
                    }
                }
                i11 = i12;
            }
            bufferOverflow = this.onBufferOverflow;
        }
        if (Intrinsics.areEqual((Object) plus, (Object) this.context) && i11 == this.capacity && bufferOverflow == this.onBufferOverflow) {
            return this;
        }
        return d(plus, i11, bufferOverflow);
    }

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core() {
        return new ChannelFlow$collectToFun$1(this, (Continuation<? super ChannelFlow$collectToFun$1>) null);
    }

    public final int getProduceCapacity$kotlinx_coroutines_core() {
        int i11 = this.capacity;
        if (i11 == -3) {
            return -2;
        }
        return i11;
    }

    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.produce$default(coroutineScope, this.context, getProduceCapacity$kotlinx_coroutines_core(), this.onBufferOverflow, CoroutineStart.ATOMIC, (Function1) null, getCollectToFun$kotlinx_coroutines_core(), 16, (Object) null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String a11 = a();
        if (a11 != null) {
            arrayList.add(a11);
        }
        if (this.context != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            arrayList.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.onBufferOverflow);
        }
        return DebugStringsKt.getClassSimpleName(this) + '[' + CollectionsKt___CollectionsKt.joinToString$default(arrayList, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + AbstractJsonLexerKt.END_LIST;
    }
}
