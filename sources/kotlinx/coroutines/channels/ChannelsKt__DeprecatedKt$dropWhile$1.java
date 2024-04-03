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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
public final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25212h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25213i;

    /* renamed from: j  reason: collision with root package name */
    public int f25214j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25215k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2 f25216l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f25215k = receiveChannel;
        this.f25216l = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.f25215k, this.f25216l, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f1  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f25214j
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0070
            if (r1 == r6) goto L_0x0060
            if (r1 == r5) goto L_0x004e
            if (r1 == r4) goto L_0x0042
            if (r1 == r3) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            java.lang.Object r1 = r12.f25212h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r1
            r9 = r4
            r1 = r0
            r0 = r12
            goto L_0x00d9
        L_0x0029:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0031:
            java.lang.Object r1 = r12.f25212h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r4
            r4 = r1
            r1 = r0
            r0 = r12
            goto L_0x00e9
        L_0x0042:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r1
            r1 = r0
            r0 = r12
            goto L_0x00cc
        L_0x004e:
            java.lang.Object r1 = r12.f25213i
            java.lang.Object r8 = r12.f25212h
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r9
            r9 = r1
            r1 = r0
            r0 = r12
            goto L_0x00b5
        L_0x0060:
            java.lang.Object r1 = r12.f25212h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r8
            r8 = r1
            r1 = r0
            r0 = r12
            goto L_0x0094
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            kotlinx.coroutines.channels.ReceiveChannel r1 = r12.f25215k
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r8 = r13
            r13 = r12
        L_0x007f:
            r13.L$0 = r8
            r13.f25212h = r1
            r13.f25213i = r7
            r13.f25214j = r6
            java.lang.Object r9 = r1.hasNext(r13)
            if (r9 != r0) goto L_0x008e
            return r0
        L_0x008e:
            r11 = r0
            r0 = r13
            r13 = r9
            r9 = r8
            r8 = r1
            r1 = r11
        L_0x0094:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00d3
            java.lang.Object r13 = r8.next()
            kotlin.jvm.functions.Function2 r10 = r0.f25216l
            r0.L$0 = r9
            r0.f25212h = r8
            r0.f25213i = r13
            r0.f25214j = r5
            java.lang.Object r10 = r10.invoke(r13, r0)
            if (r10 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            r11 = r9
            r9 = r13
            r13 = r10
            r10 = r11
        L_0x00b5:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x00ce
            r0.L$0 = r10
            r0.f25212h = r7
            r0.f25213i = r7
            r0.f25214j = r4
            java.lang.Object r13 = r10.send(r9, r0)
            if (r13 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            r9 = r10
            goto L_0x00d3
        L_0x00ce:
            r13 = r0
            r0 = r1
            r1 = r8
            r8 = r10
            goto L_0x007f
        L_0x00d3:
            kotlinx.coroutines.channels.ReceiveChannel r13 = r0.f25215k
            kotlinx.coroutines.channels.ChannelIterator r13 = r13.iterator()
        L_0x00d9:
            r0.L$0 = r9
            r0.f25212h = r13
            r0.f25214j = r3
            java.lang.Object r4 = r13.hasNext(r0)
            if (r4 != r1) goto L_0x00e6
            return r1
        L_0x00e6:
            r11 = r4
            r4 = r13
            r13 = r11
        L_0x00e9:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0104
            java.lang.Object r13 = r4.next()
            r0.L$0 = r9
            r0.f25212h = r4
            r0.f25214j = r2
            java.lang.Object r13 = r9.send(r13, r0)
            if (r13 != r1) goto L_0x0102
            return r1
        L_0x0102:
            r13 = r4
            goto L_0x00d9
        L_0x0104:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
