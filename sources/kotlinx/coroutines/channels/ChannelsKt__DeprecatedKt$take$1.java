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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25329h;

    /* renamed from: i  reason: collision with root package name */
    public int f25330i;

    /* renamed from: j  reason: collision with root package name */
    public int f25331j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f25332k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25333l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i11, ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f25332k = i11;
        this.f25333l = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.f25332k, this.f25333l, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f25331j
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            int r1 = r8.f25330i
            java.lang.Object r4 = r8.f25329h
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            r5 = r8
            goto L_0x0082
        L_0x001f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0027:
            int r1 = r8.f25330i
            java.lang.Object r4 = r8.f25329h
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            goto L_0x0065
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            int r1 = r8.f25332k
            if (r1 != 0) goto L_0x0044
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0044:
            if (r1 < 0) goto L_0x0048
            r4 = r3
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x008c
            kotlinx.coroutines.channels.ReceiveChannel r4 = r8.f25333l
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r8
        L_0x0052:
            r5.L$0 = r9
            r5.f25329h = r4
            r5.f25330i = r1
            r5.f25331j = r3
            java.lang.Object r6 = r4.hasNext(r5)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r7 = r5
            r5 = r9
            r9 = r6
            r6 = r7
        L_0x0065:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0089
            java.lang.Object r9 = r4.next()
            r6.L$0 = r5
            r6.f25329h = r4
            r6.f25330i = r1
            r6.f25331j = r2
            java.lang.Object r9 = r5.send(r9, r6)
            if (r9 != r0) goto L_0x0080
            return r0
        L_0x0080:
            r9 = r5
            r5 = r6
        L_0x0082:
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x0052
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0089:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x008c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Requested element count "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " is less than zero."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
