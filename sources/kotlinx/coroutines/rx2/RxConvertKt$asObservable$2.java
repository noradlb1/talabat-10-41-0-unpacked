package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$2", f = "RxConvert.kt", i = {0, 1}, l = {148, 149}, m = "invokeSuspend", n = {"$this$rxObservable", "$this$rxObservable"}, s = {"L$0", "L$0"})
public final class RxConvertKt$asObservable$2 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f26316h;

    /* renamed from: i  reason: collision with root package name */
    public int f26317i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<T> f26318j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asObservable$2(ReceiveChannel<? extends T> receiveChannel, Continuation<? super RxConvertKt$asObservable$2> continuation) {
        super(2, continuation);
        this.f26318j = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RxConvertKt$asObservable$2 rxConvertKt$asObservable$2 = new RxConvertKt$asObservable$2(this.f26318j, continuation);
        rxConvertKt$asObservable$2.L$0 = obj;
        return rxConvertKt$asObservable$2;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super T> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f26317i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r7.f26316h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r4
            goto L_0x003d
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            java.lang.Object r1 = r7.f26316h
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            goto L_0x004f
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlinx.coroutines.channels.ReceiveChannel<T> r1 = r7.f26318j
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L_0x003d:
            r4 = r7
        L_0x003e:
            r4.L$0 = r8
            r4.f26316h = r1
            r4.f26317i = r3
            java.lang.Object r5 = r1.hasNext(r4)
            if (r5 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r6 = r4
            r4 = r8
            r8 = r5
            r5 = r6
        L_0x004f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x006b
            java.lang.Object r8 = r1.next()
            r5.L$0 = r4
            r5.f26316h = r1
            r5.f26317i = r2
            java.lang.Object r8 = r4.send(r8, r5)
            if (r8 != r0) goto L_0x0068
            return r0
        L_0x0068:
            r8 = r4
            r4 = r5
            goto L_0x003e
        L_0x006b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxConvertKt$asObservable$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
