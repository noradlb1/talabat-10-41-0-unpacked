package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {222, 355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25530h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25531i;

    /* renamed from: j  reason: collision with root package name */
    public int f25532j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25533k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Long> f25534l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f25535m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.f25534l = function1;
        this.f25535m = flow;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.f25534l, this.f25535m, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.f25533k = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:7|29|30|33|34|35|(1:37)|38|41|(1:43)|(1:45)(1:46)|45) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f8, code lost:
        r10.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0 A[Catch:{ all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.f25532j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            java.lang.Object r2 = r1.f25531i
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r2 = r1.f25530h
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r6 = r1.f25533k
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r8 = r7
            r7 = r6
            r6 = r2
            r2 = r1
            goto L_0x006f
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0031:
            java.lang.Object r2 = r1.f25531i
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r6 = r1.f25530h
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r1.f25533k
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r18)
            r9 = r2
            r2 = r1
            goto L_0x00b6
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r1.L$0
            r6 = r2
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            java.lang.Object r2 = r1.f25533k
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r7 = 0
            r8 = 0
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r9 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r10 = r1.f25535m
            r9.<init>(r10, r5)
            r10 = 3
            r11 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = kotlinx.coroutines.channels.ProduceKt.produce$default(r6, r7, r8, r9, r10, r11)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r8 = r2
            r2 = r1
            r16 = r7
            r7 = r6
            r6 = r16
        L_0x006f:
            T r9 = r6.element
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r9 == r10) goto L_0x0111
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            T r10 = r6.element
            if (r10 == 0) goto L_0x00b8
            kotlin.jvm.functions.Function1<T, java.lang.Long> r11 = r2.f25534l
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            if (r10 != r12) goto L_0x0085
            r10 = r5
        L_0x0085:
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            long r10 = r10.longValue()
            r9.element = r10
            r13 = 0
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x0099
            r15 = r4
            goto L_0x009a
        L_0x0099:
            r15 = 0
        L_0x009a:
            if (r15 == 0) goto L_0x00c1
            int r10 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r10 != 0) goto L_0x00b8
            T r10 = r6.element
            if (r10 != r12) goto L_0x00a5
            r10 = r5
        L_0x00a5:
            r2.L$0 = r8
            r2.f25533k = r7
            r2.f25530h = r6
            r2.f25531i = r9
            r2.f25532j = r4
            java.lang.Object r10 = r8.emit(r10, r2)
            if (r10 != r0) goto L_0x00b6
            return r0
        L_0x00b6:
            r6.element = r5
        L_0x00b8:
            r16 = r2
            r2 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r16
            goto L_0x00cd
        L_0x00c1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Debounce timeout should not be negative"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00cd:
            r7.L$0 = r9
            r7.f25533k = r8
            r7.f25530h = r6
            r7.f25531i = r0
            r7.f25532j = r3
            kotlinx.coroutines.selects.SelectBuilderImpl r10 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r10.<init>(r7)
            T r11 = r6.element     // Catch:{ all -> 0x00f7 }
            if (r11 == 0) goto L_0x00ea
            long r11 = r0.element     // Catch:{ all -> 0x00f7 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1     // Catch:{ all -> 0x00f7 }
            r0.<init>(r9, r6, r5)     // Catch:{ all -> 0x00f7 }
            r10.onTimeout(r11, r0)     // Catch:{ all -> 0x00f7 }
        L_0x00ea:
            kotlinx.coroutines.selects.SelectClause1 r0 = r8.getOnReceiveCatching()     // Catch:{ all -> 0x00f7 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r11 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2     // Catch:{ all -> 0x00f7 }
            r11.<init>(r6, r9, r5)     // Catch:{ all -> 0x00f7 }
            r10.invoke(r0, r11)     // Catch:{ all -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r0 = move-exception
            r10.handleBuilderException(r0)
        L_0x00fb:
            java.lang.Object r0 = r10.getResult()
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r10) goto L_0x0108
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7)
        L_0x0108:
            if (r0 != r2) goto L_0x010b
            return r2
        L_0x010b:
            r0 = r2
            r2 = r7
            r7 = r8
            r8 = r9
            goto L_0x006f
        L_0x0111:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
