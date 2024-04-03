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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
public final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25207h;

    /* renamed from: i  reason: collision with root package name */
    public int f25208i;

    /* renamed from: j  reason: collision with root package name */
    public int f25209j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f25210k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25211l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$drop$1(int i11, ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f25210k = i11;
        this.f25211l = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.f25210k, this.f25211l, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f25209j
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x004e
            if (r1 == r4) goto L_0x003b
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r9.f25207h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x009f
        L_0x0022:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002a:
            java.lang.Object r1 = r9.f25207h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x00af
        L_0x003b:
            int r1 = r9.f25208i
            java.lang.Object r5 = r9.f25207h
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x007e
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            int r1 = r9.f25210k
            if (r1 < 0) goto L_0x005b
            r5 = r4
            goto L_0x005c
        L_0x005b:
            r5 = 0
        L_0x005c:
            if (r5 == 0) goto L_0x00cd
            if (r1 <= 0) goto L_0x0097
            kotlinx.coroutines.channels.ReceiveChannel r5 = r9.f25211l
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r10
            r10 = r9
        L_0x0068:
            r10.L$0 = r6
            r10.f25207h = r5
            r10.f25208i = r1
            r10.f25209j = r4
            java.lang.Object r7 = r5.hasNext(r10)
            if (r7 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r8 = r0
            r0 = r10
            r10 = r7
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x007e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0095
            r6.next()
            int r10 = r5 + -1
            if (r10 != 0) goto L_0x008e
            goto L_0x0095
        L_0x008e:
            r5 = r6
            r6 = r7
            r8 = r1
            r1 = r10
            r10 = r0
            r0 = r8
            goto L_0x0068
        L_0x0095:
            r10 = r7
            goto L_0x0099
        L_0x0097:
            r1 = r0
            r0 = r9
        L_0x0099:
            kotlinx.coroutines.channels.ReceiveChannel r4 = r0.f25211l
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L_0x009f:
            r0.L$0 = r10
            r0.f25207h = r4
            r0.f25209j = r3
            java.lang.Object r5 = r4.hasNext(r0)
            if (r5 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x00af:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ca
            java.lang.Object r10 = r4.next()
            r0.L$0 = r5
            r0.f25207h = r4
            r0.f25209j = r2
            java.lang.Object r10 = r5.send(r10, r0)
            if (r10 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r10 = r5
            goto L_0x009f
        L_0x00ca:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00cd:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Requested element count "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = " is less than zero."
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
