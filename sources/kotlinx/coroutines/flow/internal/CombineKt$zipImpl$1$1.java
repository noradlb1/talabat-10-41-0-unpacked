package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
public final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26142h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<R> f26143i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Flow<T2> f26144j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Flow<T1> f26145k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> f26146l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.f26143i = flowCollector;
        this.f26144j = flow;
        this.f26145k = flow2;
        this.f26146l = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f26143i, this.f26144j, this.f26145k, this.f26146l, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f26142h
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 != r9) goto L_0x001e
            java.lang.Object r0 = r8.L$0
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ AbortFlowException -> 0x001b }
            goto L_0x0086
        L_0x0018:
            r0 = move-exception
            goto L_0x009e
        L_0x001b:
            r0 = move-exception
            goto L_0x0095
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.Flow<T2> r2 = r8.f26144j
            r5.<init>(r2, r10)
            r6 = 3
            r7 = 0
            r2 = r1
            kotlinx.coroutines.channels.ReceiveChannel r7 = kotlinx.coroutines.channels.ProduceKt.produce$default(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r2 = kotlinx.coroutines.JobKt.Job$default((kotlinx.coroutines.Job) r10, (int) r9, (java.lang.Object) r10)
            r3 = r7
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            kotlinx.coroutines.flow.FlowCollector<R> r5 = r8.f26143i
            r4.<init>(r2, r5)
            r3.invokeOnClose(r4)
            kotlin.coroutines.CoroutineContext r13 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(r13)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r2)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r3 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlinx.coroutines.flow.Flow<T1> r12 = r8.f26145k     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlinx.coroutines.flow.FlowCollector<R> r5 = r8.f26143i     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r6 = r8.f26146l     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r18 = 0
            r11 = r4
            r15 = r7
            r16 = r5
            r17 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r6 = 4
            r11 = 0
            r8.L$0 = r7     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r8.f26142h = r9     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r5 = r19
            r12 = r7
            r7 = r11
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x008c, all -> 0x008a }
            if (r1 != r0) goto L_0x0085
            return r0
        L_0x0085:
            r1 = r12
        L_0x0086:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r1, (java.util.concurrent.CancellationException) r10, (int) r9, (java.lang.Object) r10)
            goto L_0x009b
        L_0x008a:
            r0 = move-exception
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            goto L_0x0094
        L_0x008e:
            r0 = move-exception
            r12 = r7
        L_0x0090:
            r1 = r12
            goto L_0x009e
        L_0x0092:
            r0 = move-exception
            r12 = r7
        L_0x0094:
            r1 = r12
        L_0x0095:
            kotlinx.coroutines.flow.FlowCollector<R> r2 = r8.f26143i     // Catch:{ all -> 0x0018 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x0086
        L_0x009b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x009e:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r1, (java.util.concurrent.CancellationException) r10, (int) r9, (java.lang.Object) r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
