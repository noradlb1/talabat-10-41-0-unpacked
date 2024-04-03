package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TickerChannelsKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object fixedDelayTicker(long r6, long r8, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.f25382k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25382k = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.f25381j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25382k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            long r6 = r0.f25379h
            java.lang.Object r8 = r0.f25380i
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            kotlin.ResultKt.throwOnFailure(r11)
        L_0x0034:
            r10 = r8
            goto L_0x0063
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            long r6 = r0.f25379h
            java.lang.Object r8 = r0.f25380i
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0073
        L_0x0048:
            long r6 = r0.f25379h
            java.lang.Object r8 = r0.f25380i
            r10 = r8
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0063
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.f25380i = r10
            r0.f25379h = r6
            r0.f25382k = r5
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r8, r0)
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r0.f25380i = r10
            r0.f25379h = r6
            r0.f25382k = r4
            java.lang.Object r8 = r10.send(r8, r0)
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r8 = r10
        L_0x0073:
            r0.f25380i = r8
            r0.f25379h = r6
            r0.f25382k = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r9 != r1) goto L_0x0034
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object fixedPeriodTicker(long r18, long r20, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) r1
            int r2 = r1.f25387l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.f25387l = r2
            goto L_0x001a
        L_0x0015:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.f25386k
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.f25387l
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0079
            if (r3 == r7) goto L_0x006b
            if (r3 == r6) goto L_0x005f
            if (r3 == r5) goto L_0x004c
            if (r3 != r4) goto L_0x0044
            long r7 = r1.f25384i
            long r9 = r1.f25383h
            java.lang.Object r3 = r1.f25385j
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r11 = r4
            r0 = r5
        L_0x003d:
            r16 = r7
            r7 = r9
            r9 = r16
            goto L_0x0115
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            long r7 = r1.f25384i
            long r9 = r1.f25383h
            java.lang.Object r3 = r1.f25385j
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r5
        L_0x0058:
            r16 = r7
            r7 = r9
            r9 = r16
            goto L_0x00fc
        L_0x005f:
            long r7 = r1.f25384i
            long r9 = r1.f25383h
            java.lang.Object r3 = r1.f25385j
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00c2
        L_0x006b:
            long r7 = r1.f25384i
            long r9 = r1.f25383h
            java.lang.Object r3 = r1.f25385j
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r3
            r10 = r9
            goto L_0x00a6
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource()
            if (r0 == 0) goto L_0x0087
            long r8 = r0.nanoTime()
            goto L_0x008b
        L_0x0087:
            long r8 = java.lang.System.nanoTime()
        L_0x008b:
            long r10 = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(r20)
            long r8 = r8 + r10
            r0 = r22
            r1.f25385j = r0
            r10 = r18
            r1.f25383h = r10
            r1.f25384i = r8
            r1.f25387l = r7
            r12 = r20
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r12, r1)
            if (r3 != r2) goto L_0x00a5
            return r2
        L_0x00a5:
            r7 = r8
        L_0x00a6:
            long r9 = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(r10)
        L_0x00aa:
            long r7 = r7 + r9
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r1.f25385j = r0
            r1.f25383h = r7
            r1.f25384i = r9
            r1.f25387l = r6
            java.lang.Object r3 = r0.send(r3, r1)
            if (r3 != r2) goto L_0x00bc
            return r2
        L_0x00bc:
            r3 = r0
            r16 = r7
            r7 = r9
            r9 = r16
        L_0x00c2:
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource()
            if (r0 == 0) goto L_0x00cd
            long r11 = r0.nanoTime()
            goto L_0x00d1
        L_0x00cd:
            long r11 = java.lang.System.nanoTime()
        L_0x00d1:
            long r13 = r9 - r11
            r4 = 0
            long r13 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((long) r13, (long) r4)
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 != 0) goto L_0x0100
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0100
            long r4 = r11 - r9
            long r4 = r4 % r7
            long r4 = r7 - r4
            long r9 = r11 + r4
            long r4 = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(r4)
            r1.f25385j = r3
            r1.f25383h = r9
            r1.f25384i = r7
            r0 = 3
            r1.f25387l = r0
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r1)
            if (r4 != r2) goto L_0x0058
            return r2
        L_0x00fc:
            r5 = r0
            r0 = r3
            r4 = 4
            goto L_0x00aa
        L_0x0100:
            r0 = 3
            long r4 = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(r13)
            r1.f25385j = r3
            r1.f25383h = r9
            r1.f25384i = r7
            r11 = 4
            r1.f25387l = r11
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r1)
            if (r4 != r2) goto L_0x003d
            return r2
        L_0x0115:
            r5 = r0
            r0 = r3
            r4 = r11
            goto L_0x00aa
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @ObsoleteCoroutinesApi
    public static final ReceiveChannel<Unit> ticker(long j11, long j12, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        boolean z11;
        long j13 = j12;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (j13 < 0) {
                z12 = false;
            }
            if (z12) {
                CoroutineContext coroutineContext2 = coroutineContext;
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j11, j12, (Continuation<? super TickerChannelsKt$ticker$3>) null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j12 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j11, long j12, CoroutineContext coroutineContext, TickerMode tickerMode, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = j11;
        }
        if ((i11 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j11, j12, coroutineContext, tickerMode);
    }
}
