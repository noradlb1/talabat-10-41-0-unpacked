package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"R", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f26123h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26124i;

    /* renamed from: j  reason: collision with root package name */
    public int f26125j;

    /* renamed from: k  reason: collision with root package name */
    public int f26126k;

    /* renamed from: l  reason: collision with root package name */
    public int f26127l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Flow<T>[] f26128m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<T[]> f26129n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f26130o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<R> f26131p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.f26128m = flowArr;
        this.f26129n = function0;
        this.f26130o = function3;
        this.f26131p = flowCollector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f26128m, this.f26129n, this.f26130o, this.f26131p, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e6 A[LOOP:1: B:26:0x00e6->B:32:0x0109, LOOP_START, PHI: r6 r10 
      PHI: (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:23:0x00e1, B:32:0x0109] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:23:0x00e1, B:32:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26127l
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0072
            if (r2 == r5) goto L_0x0051
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            int r2 = r0.f26126k
            int r6 = r0.f26125j
            java.lang.Object r7 = r0.f26124i
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.f26123h
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r23)
            r21 = r2
            r2 = r7
            r7 = r8
            r13 = r9
            r8 = r0
            goto L_0x015d
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            int r2 = r0.f26126k
            int r6 = r0.f26125j
            java.lang.Object r7 = r0.f26124i
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.f26123h
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r23)
            r21 = r2
            r2 = r7
            r7 = r8
            r13 = r9
            r8 = r0
            goto L_0x00c3
        L_0x0051:
            int r2 = r0.f26126k
            int r6 = r0.f26125j
            java.lang.Object r7 = r0.f26124i
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.f26123h
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r23)
            r10 = r23
            kotlinx.coroutines.channels.ChannelResult r10 = (kotlinx.coroutines.channels.ChannelResult) r10
            java.lang.Object r10 = r10.m7811unboximpl()
            r15 = r2
            r2 = r7
            r7 = r8
            r8 = r0
            goto L_0x00db
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r23)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.flow.Flow<T>[] r6 = r0.f26128m
            int r12 = r6.length
            if (r12 != 0) goto L_0x0081
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0081:
            java.lang.Object[] r13 = new java.lang.Object[r12]
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r13
            kotlin.collections.ArraysKt___ArraysJvmKt.fill$default((java.lang.Object[]) r6, (java.lang.Object) r7, (int) r8, (int) r9, (int) r10, (java.lang.Object) r11)
            r6 = 6
            r7 = 0
            kotlinx.coroutines.channels.Channel r20 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r12, r7, r7, r6, r7)
            java.util.concurrent.atomic.AtomicInteger r11 = new java.util.concurrent.atomic.AtomicInteger
            r11.<init>(r12)
            r21 = 0
            r10 = r21
        L_0x009c:
            if (r10 >= r12) goto L_0x00bd
            r7 = 0
            r8 = 0
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r9 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.Flow<T>[] r15 = r0.f26128m
            r19 = 0
            r14 = r9
            r16 = r10
            r17 = r11
            r18 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r14 = 3
            r15 = 0
            r6 = r2
            r10 = r14
            r14 = r11
            r11 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            int r10 = r16 + 1
            r11 = r14
            goto L_0x009c
        L_0x00bd:
            byte[] r2 = new byte[r12]
            r8 = r0
            r6 = r12
            r7 = r20
        L_0x00c3:
            int r9 = r21 + 1
            byte r9 = (byte) r9
            r8.L$0 = r13
            r8.f26123h = r7
            r8.f26124i = r2
            r8.f26125j = r6
            r8.f26126k = r9
            r8.f26127l = r5
            java.lang.Object r10 = r7.m7817receiveCatchingJP2dKIU(r8)
            if (r10 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            r15 = r9
            r9 = r13
        L_0x00db:
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.m7804getOrNullimpl(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00e6
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00e6:
            int r11 = r10.getIndex()
            r12 = r9[r11]
            java.lang.Object r10 = r10.getValue()
            r9[r11] = r10
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            if (r12 != r10) goto L_0x00f8
            int r6 = r6 + -1
        L_0x00f8:
            byte r10 = r2[r11]
            if (r10 == r15) goto L_0x010b
            byte r10 = (byte) r15
            r2[r11] = r10
            java.lang.Object r10 = r7.m7818tryReceivePtdJZtk()
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.m7804getOrNullimpl(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00e6
        L_0x010b:
            if (r6 != 0) goto L_0x0160
            kotlin.jvm.functions.Function0<T[]> r10 = r8.f26129n
            java.lang.Object r10 = r10.invoke()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x0132
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r8.f26130o
            kotlinx.coroutines.flow.FlowCollector<R> r11 = r8.f26131p
            r8.L$0 = r9
            r8.f26123h = r7
            r8.f26124i = r2
            r8.f26125j = r6
            r8.f26126k = r15
            r8.f26127l = r4
            java.lang.Object r10 = r10.invoke(r11, r9, r8)
            if (r10 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r13 = r9
            r21 = r15
            goto L_0x00c3
        L_0x0132:
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 14
            r18 = 0
            r11 = r9
            r12 = r10
            r4 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            java.lang.Object[] unused = kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default((java.lang.Object[]) r11, (java.lang.Object[]) r12, (int) r13, (int) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r8.f26130o
            kotlinx.coroutines.flow.FlowCollector<R> r12 = r8.f26131p
            r8.L$0 = r9
            r8.f26123h = r7
            r8.f26124i = r2
            r8.f26125j = r6
            r8.f26126k = r4
            r8.f26127l = r3
            java.lang.Object r10 = r11.invoke(r12, r10, r8)
            if (r10 != r1) goto L_0x0161
            return r1
        L_0x015d:
            r4 = 2
            goto L_0x00c3
        L_0x0160:
            r4 = r15
        L_0x0161:
            r21 = r4
            r13 = r9
            goto L_0x015d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
