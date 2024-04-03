package kotlinx.coroutines.reactive;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b\u001a,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\b\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\r\u001a\u00020\u000bH\u0000\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"contextInjectors", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "[Lkotlinx/coroutines/reactive/ContextInjector;", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "", "Lorg/reactivestreams/Publisher;", "asPublisher", "context", "Lkotlin/coroutines/CoroutineContext;", "injectCoroutineContext", "coroutineContext", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ReactiveFlowKt {
    @NotNull
    private static final ContextInjector[] contextInjectors;

    static {
        Class<ContextInjector> cls = ContextInjector.class;
        Object[] array = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator())).toArray(new ContextInjector[0]);
        if (array != null) {
            contextInjectors = (ContextInjector[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Publisher<T> publisher) {
        return new PublisherAsFlow(publisher, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> Publisher<T> asPublisher(@NotNull Flow<? extends T> flow) {
        return asPublisher$default(flow, (CoroutineContext) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> Publisher<T> asPublisher(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return new FlowAsPublisher(flow, Dispatchers.getUnconfined().plus(coroutineContext));
    }

    public static /* synthetic */ Publisher asPublisher$default(Flow flow, CoroutineContext coroutineContext, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asPublisher(flow, coroutineContext);
    }

    @NotNull
    public static final <T> Publisher<T> injectCoroutineContext(@NotNull Publisher<T> publisher, @NotNull CoroutineContext coroutineContext) {
        for (ContextInjector injectCoroutineContext : contextInjectors) {
            publisher = injectCoroutineContext.injectCoroutineContext(publisher, coroutineContext);
        }
        return publisher;
    }
}
