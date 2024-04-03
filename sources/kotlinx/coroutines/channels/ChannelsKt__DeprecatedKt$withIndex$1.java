package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25354h;

    /* renamed from: i  reason: collision with root package name */
    public int f25355i;

    /* renamed from: j  reason: collision with root package name */
    public int f25356j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25357k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f25357k = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.f25357k, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f25356j
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            int r1 = r11.f25355i
            java.lang.Object r4 = r11.f25354h
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r5
            r5 = r11
            r9 = r4
            r4 = r1
            r1 = r9
            goto L_0x0047
        L_0x0021:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0029:
            int r1 = r11.f25355i
            java.lang.Object r4 = r11.f25354h
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r6 = r11
            goto L_0x005d
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel r1 = r11.f25357k
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r4 = 0
            r5 = r11
        L_0x0047:
            r5.L$0 = r12
            r5.f25354h = r1
            r5.f25355i = r4
            r5.f25356j = r3
            java.lang.Object r6 = r1.hasNext(r5)
            if (r6 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r9 = r5
            r5 = r12
            r12 = r6
            r6 = r9
            r10 = r4
            r4 = r1
            r1 = r10
        L_0x005d:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0084
            java.lang.Object r12 = r4.next()
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
            int r8 = r1 + 1
            r7.<init>(r1, r12)
            r6.L$0 = r5
            r6.f25354h = r4
            r6.f25355i = r8
            r6.f25356j = r2
            java.lang.Object r12 = r5.send(r7, r6)
            if (r12 != r0) goto L_0x007f
            return r0
        L_0x007f:
            r1 = r4
            r12 = r5
            r5 = r6
            r4 = r8
            goto L_0x0047
        L_0x0084:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
