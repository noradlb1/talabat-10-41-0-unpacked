package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
public final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25229h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25230i;

    /* renamed from: j  reason: collision with root package name */
    public int f25231j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<E> f25232k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> f25233l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.f25232k = receiveChannel;
        this.f25233l = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.f25232k, this.f25233l, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f25231j
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0048
            if (r1 == r5) goto L_0x0038
            if (r1 == r4) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            java.lang.Object r1 = r10.f25229h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0056
        L_0x001e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0026:
            java.lang.Object r1 = r10.f25230i
            java.lang.Object r6 = r10.f25229h
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r10
            goto L_0x008d
        L_0x0038:
            java.lang.Object r1 = r10.f25229h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r10
            goto L_0x006c
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r10.f25232k
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = r11
        L_0x0056:
            r11 = r10
        L_0x0057:
            r11.L$0 = r6
            r11.f25229h = r1
            r11.f25230i = r2
            r11.f25231j = r5
            java.lang.Object r7 = r1.hasNext(r11)
            if (r7 != r0) goto L_0x0066
            return r0
        L_0x0066:
            r9 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x006c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00a9
            java.lang.Object r11 = r6.next()
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r0.f25233l
            r0.L$0 = r7
            r0.f25229h = r6
            r0.f25230i = r11
            r0.f25231j = r4
            java.lang.Object r8 = r8.invoke(r11, r0)
            if (r8 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r9 = r7
            r7 = r11
            r11 = r8
            r8 = r9
        L_0x008d:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00a4
            r0.L$0 = r8
            r0.f25229h = r6
            r0.f25230i = r2
            r0.f25231j = r3
            java.lang.Object r11 = r8.send(r7, r0)
            if (r11 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r11 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            goto L_0x0057
        L_0x00a9:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
