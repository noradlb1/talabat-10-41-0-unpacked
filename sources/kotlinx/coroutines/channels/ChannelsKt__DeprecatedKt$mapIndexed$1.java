package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25297h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25298i;

    /* renamed from: j  reason: collision with root package name */
    public int f25299j;

    /* renamed from: k  reason: collision with root package name */
    public int f25300k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<E> f25301l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> f25302m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.f25301l = receiveChannel;
        this.f25302m = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.f25301l, this.f25302m, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f25300k
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x004c
            if (r1 == r4) goto L_0x003d
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            int r1 = r11.f25299j
            java.lang.Object r5 = r11.f25297h
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r6
            r6 = r11
            goto L_0x005e
        L_0x0021:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0029:
            int r1 = r11.f25299j
            java.lang.Object r5 = r11.f25298i
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r6 = r11.f25297h
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            goto L_0x009b
        L_0x003d:
            int r1 = r11.f25299j
            java.lang.Object r5 = r11.f25297h
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r11
            goto L_0x0071
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r11.f25301l
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = 0
            r6 = r11
            r10 = r5
            r5 = r1
            r1 = r10
        L_0x005e:
            r6.L$0 = r12
            r6.f25297h = r5
            r6.f25299j = r1
            r6.f25300k = r4
            java.lang.Object r7 = r5.hasNext(r6)
            if (r7 != r0) goto L_0x006d
            return r0
        L_0x006d:
            r10 = r6
            r6 = r12
            r12 = r7
            r7 = r10
        L_0x0071:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00b1
            java.lang.Object r12 = r5.next()
            kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r7.f25302m
            int r9 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r7.L$0 = r6
            r7.f25297h = r5
            r7.f25298i = r6
            r7.f25299j = r9
            r7.f25300k = r3
            java.lang.Object r12 = r8.invoke(r1, r12, r7)
            if (r12 != r0) goto L_0x0096
            return r0
        L_0x0096:
            r8 = r7
            r1 = r9
            r7 = r6
            r6 = r5
            r5 = r7
        L_0x009b:
            r8.L$0 = r7
            r8.f25297h = r6
            r9 = 0
            r8.f25298i = r9
            r8.f25299j = r1
            r8.f25300k = r2
            java.lang.Object r12 = r5.send(r12, r8)
            if (r12 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            r5 = r6
            r12 = r7
            r6 = r8
            goto L_0x005e
        L_0x00b1:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
