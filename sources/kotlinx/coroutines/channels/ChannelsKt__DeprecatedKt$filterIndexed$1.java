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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25234h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25235i;

    /* renamed from: j  reason: collision with root package name */
    public int f25236j;

    /* renamed from: k  reason: collision with root package name */
    public int f25237k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25238l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3 f25239m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f25238l = receiveChannel;
        this.f25239m = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.f25238l, this.f25239m, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f25237k
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0053
            if (r1 == r5) goto L_0x0040
            if (r1 == r4) goto L_0x0029
            if (r1 != r3) goto L_0x0021
            int r1 = r12.f25236j
            java.lang.Object r6 = r12.f25234h
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            goto L_0x0066
        L_0x0021:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0029:
            int r1 = r12.f25236j
            java.lang.Object r6 = r12.f25235i
            java.lang.Object r7 = r12.f25234h
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r1
            r1 = r0
            r0 = r12
            r11 = r7
            r7 = r6
        L_0x003d:
            r6 = r11
            goto L_0x00a7
        L_0x0040:
            int r1 = r12.f25236j
            java.lang.Object r6 = r12.f25234h
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r12
            goto L_0x007e
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            kotlinx.coroutines.channels.ReceiveChannel r1 = r12.f25238l
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = 0
            r7 = r13
            r13 = r12
            r11 = r6
            r6 = r1
            r1 = r11
        L_0x0066:
            r13.L$0 = r7
            r13.f25234h = r6
            r13.f25235i = r2
            r13.f25236j = r1
            r13.f25237k = r5
            java.lang.Object r8 = r6.hasNext(r13)
            if (r8 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r11 = r0
            r0 = r13
            r13 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r11
        L_0x007e:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00c5
            java.lang.Object r13 = r7.next()
            kotlin.jvm.functions.Function3 r9 = r0.f25239m
            int r10 = r6 + 1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r0.L$0 = r8
            r0.f25234h = r7
            r0.f25235i = r13
            r0.f25236j = r10
            r0.f25237k = r4
            java.lang.Object r6 = r9.invoke(r6, r13, r0)
            if (r6 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            r11 = r7
            r7 = r13
            r13 = r6
            goto L_0x003d
        L_0x00a7:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00c0
            r0.L$0 = r8
            r0.f25234h = r6
            r0.f25235i = r2
            r0.f25236j = r10
            r0.f25237k = r3
            java.lang.Object r13 = r8.send(r7, r0)
            if (r13 != r1) goto L_0x00c0
            return r1
        L_0x00c0:
            r13 = r0
            r0 = r1
            r7 = r8
            r1 = r10
            goto L_0x0066
        L_0x00c5:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
