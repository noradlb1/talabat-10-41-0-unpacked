package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2-\b\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\b\u0001\u0010\u0012\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BroadcastKt {
    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(@NotNull ReceiveChannel<? extends E> receiveChannel, int i11, @NotNull CoroutineStart coroutineStart) {
        return broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)), (CoroutineContext) null, i11, coroutineStart, new BroadcastKt$broadcast$1(receiveChannel), new BroadcastKt$broadcast$2(receiveChannel, (Continuation<? super BroadcastKt$broadcast$2>) null), 1, (Object) null);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int i11, CoroutineStart coroutineStart, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        if ((i12 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return broadcast(receiveChannel, i11, coroutineStart);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i11, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i12 & 8) != 0) {
            function1 = null;
        }
        return broadcast(coroutineScope, coroutineContext2, i13, coroutineStart2, function1, function2);
    }

    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i11, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, Unit> function1, @NotNull @BuilderInference Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        BroadcastCoroutine broadcastCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        BroadcastChannel BroadcastChannel = BroadcastChannelKt.BroadcastChannel(i11);
        if (coroutineStart.isLazy()) {
            broadcastCoroutine = new LazyBroadcastCoroutine(newCoroutineContext, BroadcastChannel, function2);
        } else {
            broadcastCoroutine = new BroadcastCoroutine(newCoroutineContext, BroadcastChannel, true);
        }
        if (function1 != null) {
            broadcastCoroutine.invokeOnCompletion(function1);
        }
        broadcastCoroutine.start(coroutineStart, broadcastCoroutine, function2);
        return broadcastCoroutine;
    }
}
