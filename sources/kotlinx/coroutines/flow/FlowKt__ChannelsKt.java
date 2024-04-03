package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> broadcastChannel) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A[SYNTHETIC, Splitter:B:35:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.f25500l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25500l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f25499k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25500l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            boolean r6 = r0.f25498j
            java.lang.Object r7 = r0.f25497i
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r0.f25496h
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0055 }
        L_0x0035:
            r5 = r8
            r8 = r6
            r6 = r5
            goto L_0x005d
        L_0x0039:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0041:
            boolean r6 = r0.f25498j
            java.lang.Object r7 = r0.f25497i
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r0.f25496h
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.channels.ChannelResult r9 = (kotlinx.coroutines.channels.ChannelResult) r9     // Catch:{ all -> 0x0055 }
            java.lang.Object r9 = r9.m7811unboximpl()     // Catch:{ all -> 0x0055 }
            goto L_0x006f
        L_0x0055:
            r8 = move-exception
            goto L_0x009c
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.flow.FlowKt.ensureActive(r6)
        L_0x005d:
            r0.f25496h = r6     // Catch:{ all -> 0x0098 }
            r0.f25497i = r7     // Catch:{ all -> 0x0098 }
            r0.f25498j = r8     // Catch:{ all -> 0x0098 }
            r0.f25500l = r4     // Catch:{ all -> 0x0098 }
            java.lang.Object r9 = r7.m7817receiveCatchingJP2dKIU(r0)     // Catch:{ all -> 0x0098 }
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x006f:
            boolean r2 = kotlinx.coroutines.channels.ChannelResult.m7807isClosedimpl(r9)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0085
            java.lang.Throwable r8 = kotlinx.coroutines.channels.ChannelResult.m7803exceptionOrNullimpl(r9)     // Catch:{ all -> 0x0055 }
            if (r8 != 0) goto L_0x0084
            if (r6 == 0) goto L_0x0081
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
        L_0x0081:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0084:
            throw r8     // Catch:{ all -> 0x0055 }
        L_0x0085:
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelResult.m7805getOrThrowimpl(r9)     // Catch:{ all -> 0x0055 }
            r0.f25496h = r8     // Catch:{ all -> 0x0055 }
            r0.f25497i = r7     // Catch:{ all -> 0x0055 }
            r0.f25498j = r6     // Catch:{ all -> 0x0055 }
            r0.f25500l = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r9 = r8.emit(r9, r0)     // Catch:{ all -> 0x0055 }
            if (r9 != r1) goto L_0x0035
            return r1
        L_0x0098:
            r6 = move-exception
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x009c:
            throw r8     // Catch:{ all -> 0x009d }
        L_0x009d:
            r9 = move-exception
            if (r6 == 0) goto L_0x00a3
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8)
        L_0x00a3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @FlowPreview
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }
}
