package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u000bJ%\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/paging/TemporaryDownstream;", "T", "", "()V", "historyChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "close", "", "consumeHistory", "Lkotlinx/coroutines/flow/Flow;", "send", "", "event", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
final class TemporaryDownstream<T> {
    private final Channel<IndexedValue<PageEvent<T>>> historyChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    public final void close() {
        SendChannel.DefaultImpls.close$default(this.historyChannel, (Throwable) null, 1, (Object) null);
    }

    @NotNull
    public final Flow<IndexedValue<PageEvent<T>>> consumeHistory() {
        return FlowKt.consumeAsFlow(this.historyChannel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object send(@org.jetbrains.annotations.NotNull kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.TemporaryDownstream$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.TemporaryDownstream$send$1 r0 = (androidx.paging.TemporaryDownstream$send$1) r0
            int r1 = r0.f37171i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37171i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.TemporaryDownstream$send$1 r0 = new androidx.paging.TemporaryDownstream$send$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f37170h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37171i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ ClosedSendChannelException -> 0x003f }
            goto L_0x0040
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<androidx.paging.PageEvent<T>>> r6 = r4.historyChannel     // Catch:{ ClosedSendChannelException -> 0x003f }
            r0.f37171i = r3     // Catch:{ ClosedSendChannelException -> 0x003f }
            java.lang.Object r5 = r6.send(r5, r0)     // Catch:{ ClosedSendChannelException -> 0x003f }
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x003f:
            r3 = 0
        L_0x0040:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.TemporaryDownstream.send(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
