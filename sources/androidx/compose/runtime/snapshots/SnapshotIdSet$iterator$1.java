package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
public final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f9527h;

    /* renamed from: i  reason: collision with root package name */
    public int f9528i;

    /* renamed from: j  reason: collision with root package name */
    public int f9529j;

    /* renamed from: k  reason: collision with root package name */
    public int f9530k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SnapshotIdSet f9531l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.f9531l = snapshotIdSet;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.f9531l, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super Integer> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9530k
            r3 = 0
            r4 = 1
            r6 = 3
            r7 = 2
            r8 = 64
            r10 = 0
            r12 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r12) goto L_0x003c
            if (r2 == r7) goto L_0x0030
            if (r2 != r6) goto L_0x0028
            int r2 = r0.f9528i
            java.lang.Object r7 = r0.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r21)
            r9 = r2
            r13 = r6
            r2 = r0
            goto L_0x00f4
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            int r2 = r0.f9528i
            java.lang.Object r13 = r0.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r21)
            r9 = r0
            goto L_0x00b7
        L_0x003c:
            int r2 = r0.f9529j
            int r13 = r0.f9528i
            java.lang.Object r14 = r0.f9527h
            int[] r14 = (int[]) r14
            java.lang.Object r15 = r0.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.ResultKt.throwOnFailure(r21)
            r9 = r0
            goto L_0x007b
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r0.f9531l
            int[] r13 = r13.belowBound
            if (r13 == 0) goto L_0x0080
            int r14 = r13.length
            r9 = r0
            r15 = r2
            r2 = r14
            r14 = r13
            r13 = 0
        L_0x0062:
            if (r13 >= r2) goto L_0x007e
            r17 = r14[r13]
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            r9.L$0 = r15
            r9.f9527h = r14
            r9.f9528i = r13
            r9.f9529j = r2
            r9.f9530k = r12
            java.lang.Object r6 = r15.yield(r6, r9)
            if (r6 != r1) goto L_0x007b
            return r1
        L_0x007b:
            int r13 = r13 + r12
            r6 = 3
            goto L_0x0062
        L_0x007e:
            r2 = r15
            goto L_0x0081
        L_0x0080:
            r9 = r0
        L_0x0081:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.f9531l
            long r13 = r6.lowerSet
            int r6 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00ba
            r13 = r2
            r2 = 0
        L_0x008d:
            if (r2 >= r8) goto L_0x00b9
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.f9531l
            long r14 = r6.lowerSet
            long r18 = r4 << r2
            long r14 = r14 & r18
            int r6 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00b7
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.f9531l
            int r6 = r6.lowerBound
            int r6 = r6 + r2
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r9.L$0 = r13
            r9.f9527h = r3
            r9.f9528i = r2
            r9.f9530k = r7
            java.lang.Object r6 = r13.yield(r6, r9)
            if (r6 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            int r2 = r2 + r12
            goto L_0x008d
        L_0x00b9:
            r2 = r13
        L_0x00ba:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.f9531l
            long r6 = r6.upperSet
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00f6
            r7 = r2
            r2 = r9
            r9 = 0
        L_0x00c7:
            if (r9 >= r8) goto L_0x00f6
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r2.f9531l
            long r13 = r6.upperSet
            long r15 = r4 << r9
            long r13 = r13 & r15
            int r6 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00f3
            int r6 = r9 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r2.f9531l
            int r13 = r13.lowerBound
            int r6 = r6 + r13
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r2.L$0 = r7
            r2.f9527h = r3
            r2.f9528i = r9
            r13 = 3
            r2.f9530k = r13
            java.lang.Object r6 = r7.yield(r6, r2)
            if (r6 != r1) goto L_0x00f4
            return r1
        L_0x00f3:
            r13 = 3
        L_0x00f4:
            int r9 = r9 + r12
            goto L_0x00c7
        L_0x00f6:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
