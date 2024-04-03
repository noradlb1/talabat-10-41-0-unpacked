package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BroadcastChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BroadcastChannel f25495b;

    public FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(BroadcastChannel broadcastChannel) {
        this.f25495b = broadcastChannel;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object emitAll = FlowKt.emitAll(flowCollector, this.f25495b.openSubscription(), continuation);
        if (emitAll == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitAll;
        }
        return Unit.INSTANCE;
    }
}
