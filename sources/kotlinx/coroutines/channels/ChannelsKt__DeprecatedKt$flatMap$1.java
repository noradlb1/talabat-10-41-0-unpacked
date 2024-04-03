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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
public final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25263h;

    /* renamed from: i  reason: collision with root package name */
    public int f25264i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25265j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2 f25266k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f25265j = receiveChannel;
        this.f25266k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.f25265j, this.f25266k, continuation);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f25264i
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0045
            if (r1 == r4) goto L_0x0035
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r9.f25263h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0053
        L_0x001d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0025:
            java.lang.Object r1 = r9.f25263h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0082
        L_0x0035:
            java.lang.Object r1 = r9.f25263h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0067
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            kotlinx.coroutines.channels.ReceiveChannel r1 = r9.f25265j
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L_0x0053:
            r10 = r9
        L_0x0054:
            r10.L$0 = r5
            r10.f25263h = r1
            r10.f25264i = r4
            java.lang.Object r6 = r1.hasNext(r10)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x0067:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0096
            java.lang.Object r10 = r5.next()
            kotlin.jvm.functions.Function2 r7 = r0.f25266k
            r0.L$0 = r6
            r0.f25263h = r5
            r0.f25264i = r3
            java.lang.Object r10 = r7.invoke(r10, r0)
            if (r10 != r1) goto L_0x0082
            return r1
        L_0x0082:
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            r0.L$0 = r6
            r0.f25263h = r5
            r0.f25264i = r2
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelsKt.toChannel(r10, r6, r0)
            if (r10 != r1) goto L_0x0091
            return r1
        L_0x0091:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L_0x0054
        L_0x0096:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
