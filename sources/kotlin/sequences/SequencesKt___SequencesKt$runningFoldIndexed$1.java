package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"T", "R", "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
public final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25039h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25040i;

    /* renamed from: j  reason: collision with root package name */
    public int f25041j;

    /* renamed from: k  reason: collision with root package name */
    public int f25042k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ R f25043l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f25044m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<Integer, R, T, R> f25045n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r11, Sequence<? extends T> sequence, Function3<? super Integer, ? super R, ? super T, ? extends R> function3, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.f25043l = r11;
        this.f25044m = sequence;
        this.f25045n = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.f25043l, this.f25044m, this.f25045n, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f25042k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r9.f25041j
            java.lang.Object r3 = r9.f25040i
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.f25039h
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r4
            r4 = r1
            goto L_0x004f
        L_0x0020:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0028:
            java.lang.Object r1 = r9.L$0
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0045
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            R r10 = r9.f25043l
            r9.L$0 = r1
            r9.f25042k = r3
            java.lang.Object r10 = r1.yield(r10, r9)
            if (r10 != r0) goto L_0x0045
            return r0
        L_0x0045:
            R r10 = r9.f25043l
            kotlin.sequences.Sequence<T> r3 = r9.f25044m
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r1
        L_0x004f:
            r1 = r9
        L_0x0050:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x007f
            java.lang.Object r6 = r3.next()
            kotlin.jvm.functions.Function3<java.lang.Integer, R, T, R> r7 = r1.f25045n
            int r8 = r4 + 1
            if (r4 >= 0) goto L_0x0063
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0063:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r4 = r7.invoke(r4, r10, r6)
            r1.L$0 = r5
            r1.f25039h = r4
            r1.f25040i = r3
            r1.f25041j = r8
            r1.f25042k = r2
            java.lang.Object r10 = r5.yield(r4, r1)
            if (r10 != r0) goto L_0x007c
            return r0
        L_0x007c:
            r10 = r4
            r4 = r8
            goto L_0x0050
        L_0x007f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
