package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000e\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/airbnb/lottie/compose/LottieRetrySignal;", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "<set-?>", "", "isAwaitingRetry", "()Z", "setAwaitingRetry", "(Z)V", "isAwaitingRetry$delegate", "Landroidx/compose/runtime/MutableState;", "awaitRetry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
public final class LottieRetrySignal {
    @NotNull
    private final Channel<Unit> channel = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, (Function1) null, 4, (Object) null);
    @NotNull
    private final MutableState isAwaitingRetry$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);

    private final void setAwaitingRetry(boolean z11) {
        this.isAwaitingRetry$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitRetry(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1 r0 = (com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1) r0
            int r1 = r0.f40590k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f40590k = r1
            goto L_0x0018
        L_0x0013:
            com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1 r0 = new com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f40588i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f40590k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r0 = r0.f40587h
            com.airbnb.lottie.compose.LottieRetrySignal r0 = (com.airbnb.lottie.compose.LottieRetrySignal) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002e }
            goto L_0x004c
        L_0x002e:
            r6 = move-exception
            goto L_0x0054
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            r5.setAwaitingRetry(r4)     // Catch:{ all -> 0x0052 }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r6 = r5.channel     // Catch:{ all -> 0x0052 }
            r0.f40587h = r5     // Catch:{ all -> 0x0052 }
            r0.f40590k = r4     // Catch:{ all -> 0x0052 }
            java.lang.Object r6 = r6.receive(r0)     // Catch:{ all -> 0x0052 }
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r5
        L_0x004c:
            r0.setAwaitingRetry(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0052:
            r6 = move-exception
            r0 = r5
        L_0x0054:
            r0.setAwaitingRetry(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieRetrySignal.awaitRetry(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isAwaitingRetry() {
        return ((Boolean) this.isAwaitingRetry$delegate.getValue()).booleanValue();
    }

    public final void retry() {
        ChannelsKt.trySendBlocking(this.channel, Unit.INSTANCE);
    }
}
