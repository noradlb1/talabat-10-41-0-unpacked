package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
public final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25290h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25291i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25292j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25293k;

    /* renamed from: l  reason: collision with root package name */
    public int f25294l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<E> f25295m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<E, Continuation<? super R>, Object> f25296n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.f25295m = receiveChannel;
        this.f25296n = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.f25295m, this.f25296n, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f25294l
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0063
            if (r1 == r5) goto L_0x004e
            if (r1 == r4) goto L_0x0030
            if (r1 != r3) goto L_0x0028
            java.lang.Object r1 = r12.f25292j
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.f25291i
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.f25290h
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x00d1 }
            r13 = r8
            r8 = r12
            goto L_0x0076
        L_0x0028:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0030:
            java.lang.Object r1 = r12.f25293k
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            java.lang.Object r6 = r12.f25292j
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.f25291i
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r12.f25290h
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x004a }
            r10 = r12
            goto L_0x00b0
        L_0x004a:
            r13 = move-exception
            r6 = r7
            goto L_0x00d2
        L_0x004e:
            java.lang.Object r1 = r12.f25292j
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.f25291i
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.f25290h
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x00d1 }
            r9 = r12
            goto L_0x008b
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            kotlinx.coroutines.channels.ReceiveChannel<E> r6 = r12.f25295m
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r12.f25296n
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x00d1 }
            r8 = r12
            r11 = r7
            r7 = r1
            r1 = r11
        L_0x0076:
            r8.L$0 = r13     // Catch:{ all -> 0x00d1 }
            r8.f25290h = r7     // Catch:{ all -> 0x00d1 }
            r8.f25291i = r6     // Catch:{ all -> 0x00d1 }
            r8.f25292j = r1     // Catch:{ all -> 0x00d1 }
            r8.f25294l = r5     // Catch:{ all -> 0x00d1 }
            java.lang.Object r9 = r1.hasNext(r8)     // Catch:{ all -> 0x00d1 }
            if (r9 != r0) goto L_0x0087
            return r0
        L_0x0087:
            r11 = r8
            r8 = r13
            r13 = r9
            r9 = r11
        L_0x008b:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x00d1 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x00d1 }
            if (r13 == 0) goto L_0x00c9
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x00d1 }
            r9.L$0 = r8     // Catch:{ all -> 0x00d1 }
            r9.f25290h = r7     // Catch:{ all -> 0x00d1 }
            r9.f25291i = r6     // Catch:{ all -> 0x00d1 }
            r9.f25292j = r1     // Catch:{ all -> 0x00d1 }
            r9.f25293k = r8     // Catch:{ all -> 0x00d1 }
            r9.f25294l = r4     // Catch:{ all -> 0x00d1 }
            java.lang.Object r13 = r7.invoke(r13, r9)     // Catch:{ all -> 0x00d1 }
            if (r13 != r0) goto L_0x00aa
            return r0
        L_0x00aa:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00b0:
            r10.L$0 = r9     // Catch:{ all -> 0x004a }
            r10.f25290h = r8     // Catch:{ all -> 0x004a }
            r10.f25291i = r7     // Catch:{ all -> 0x004a }
            r10.f25292j = r6     // Catch:{ all -> 0x004a }
            r10.f25293k = r2     // Catch:{ all -> 0x004a }
            r10.f25294l = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r13 = r1.send(r13, r10)     // Catch:{ all -> 0x004a }
            if (r13 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r1 = r6
            r6 = r7
            r7 = r8
            r13 = r9
            r8 = r10
            goto L_0x0076
        L_0x00c9:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r2)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00d1:
            r13 = move-exception
        L_0x00d2:
            throw r13     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
