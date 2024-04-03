package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H@"}, d2 = {"E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
public final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25358h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25359i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25360j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25361k;

    /* renamed from: l  reason: collision with root package name */
    public Object f25362l;

    /* renamed from: m  reason: collision with root package name */
    public int f25363m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<R> f25364n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<E> f25365o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<E, R, V> f25366p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.f25364n = receiveChannel;
        this.f25365o = receiveChannel2;
        this.f25366p = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.f25364n, this.f25365o, this.f25366p, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super V> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b9 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1 A[Catch:{ all -> 0x0106 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.f25363m
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0079
            if (r1 == r4) goto L_0x005a
            if (r1 == r3) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            java.lang.Object r1 = r13.f25361k
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r13.f25360j
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r13.f25359i
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r13.f25358h
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0111 }
            r14 = r13
            goto L_0x0093
        L_0x002c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0034:
            java.lang.Object r1 = r13.f25362l
            java.lang.Object r6 = r13.f25361k
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r13.f25360j
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r13.f25359i
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r13.f25358h
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0056 }
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r13
            goto L_0x00d9
        L_0x0056:
            r14 = move-exception
            r6 = r7
            goto L_0x0112
        L_0x005a:
            java.lang.Object r1 = r13.f25361k
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r13.f25360j
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r13.f25359i
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r13.f25358h
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0111 }
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            goto L_0x00b1
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.channels.ProducerScope r14 = (kotlinx.coroutines.channels.ProducerScope) r14
            kotlinx.coroutines.channels.ReceiveChannel<R> r1 = r13.f25364n
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            kotlinx.coroutines.channels.ReceiveChannel<E> r6 = r13.f25365o
            kotlin.jvm.functions.Function2<E, R, V> r7 = r13.f25366p
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0111 }
            r9 = r14
            r14 = r13
            r12 = r8
            r8 = r1
            r1 = r12
        L_0x0093:
            r14.L$0 = r9     // Catch:{ all -> 0x0111 }
            r14.f25358h = r8     // Catch:{ all -> 0x0111 }
            r14.f25359i = r7     // Catch:{ all -> 0x0111 }
            r14.f25360j = r6     // Catch:{ all -> 0x0111 }
            r14.f25361k = r1     // Catch:{ all -> 0x0111 }
            r14.f25362l = r5     // Catch:{ all -> 0x0111 }
            r14.f25363m = r4     // Catch:{ all -> 0x0111 }
            java.lang.Object r10 = r1.hasNext(r14)     // Catch:{ all -> 0x0111 }
            if (r10 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r12 = r0
            r0 = r14
            r14 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r12
        L_0x00b1:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0056 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0056 }
            if (r14 == 0) goto L_0x0109
            java.lang.Object r14 = r6.next()     // Catch:{ all -> 0x0056 }
            r0.L$0 = r10     // Catch:{ all -> 0x0056 }
            r0.f25358h = r9     // Catch:{ all -> 0x0056 }
            r0.f25359i = r8     // Catch:{ all -> 0x0056 }
            r0.f25360j = r7     // Catch:{ all -> 0x0056 }
            r0.f25361k = r6     // Catch:{ all -> 0x0056 }
            r0.f25362l = r14     // Catch:{ all -> 0x0056 }
            r0.f25363m = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r11 = r9.hasNext(r0)     // Catch:{ all -> 0x0056 }
            if (r11 != r1) goto L_0x00d2
            return r1
        L_0x00d2:
            r12 = r7
            r7 = r14
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r12
        L_0x00d9:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0106 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0106 }
            if (r14 == 0) goto L_0x00fe
            java.lang.Object r14 = r10.next()     // Catch:{ all -> 0x0106 }
            java.lang.Object r14 = r9.invoke(r7, r14)     // Catch:{ all -> 0x0106 }
            r0.L$0 = r11     // Catch:{ all -> 0x0106 }
            r0.f25358h = r10     // Catch:{ all -> 0x0106 }
            r0.f25359i = r9     // Catch:{ all -> 0x0106 }
            r0.f25360j = r8     // Catch:{ all -> 0x0106 }
            r0.f25361k = r6     // Catch:{ all -> 0x0106 }
            r0.f25362l = r5     // Catch:{ all -> 0x0106 }
            r0.f25363m = r2     // Catch:{ all -> 0x0106 }
            java.lang.Object r14 = r11.send(r14, r0)     // Catch:{ all -> 0x0106 }
            if (r14 != r1) goto L_0x00fe
            return r1
        L_0x00fe:
            r14 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r11
            goto L_0x0093
        L_0x0106:
            r14 = move-exception
            r6 = r8
            goto L_0x0112
        L_0x0109:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0056 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r5)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0111:
            r14 = move-exception
        L_0x0112:
            throw r14     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
