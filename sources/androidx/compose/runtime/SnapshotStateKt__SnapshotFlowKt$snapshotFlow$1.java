package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {134, 138, 160}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f9247h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9248i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9249j;

    /* renamed from: k  reason: collision with root package name */
    public Object f9250k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9251l;

    /* renamed from: m  reason: collision with root package name */
    public int f9252m;

    /* renamed from: n  reason: collision with root package name */
    public int f9253n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function0<T> f9254o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.f9254o = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.f9254o, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100 A[Catch:{ all -> 0x0053 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.f9253n
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0074
            if (r2 == r6) goto L_0x0057
            if (r2 == r5) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            java.lang.Object r2 = r1.f9251l
            java.lang.Object r7 = r1.f9250k
            androidx.compose.runtime.snapshots.ObserverHandle r7 = (androidx.compose.runtime.snapshots.ObserverHandle) r7
            java.lang.Object r8 = r1.f9249j
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r1.f9248i
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r1.f9247h
            java.util.Set r10 = (java.util.Set) r10
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            goto L_0x006d
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0033:
            int r2 = r1.f9252m
            java.lang.Object r7 = r1.f9251l
            java.lang.Object r8 = r1.f9250k
            androidx.compose.runtime.snapshots.ObserverHandle r8 = (androidx.compose.runtime.snapshots.ObserverHandle) r8
            java.lang.Object r9 = r1.f9249j
            kotlinx.coroutines.channels.Channel r9 = (kotlinx.coroutines.channels.Channel) r9
            java.lang.Object r10 = r1.f9248i
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r1.f9247h
            java.util.Set r11 = (java.util.Set) r11
            java.lang.Object r12 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
            kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ all -> 0x0053 }
            r13 = r17
            r14 = r1
            goto L_0x00e4
        L_0x0053:
            r0 = move-exception
            r7 = r8
            goto L_0x015a
        L_0x0057:
            java.lang.Object r2 = r1.f9251l
            java.lang.Object r7 = r1.f9250k
            androidx.compose.runtime.snapshots.ObserverHandle r7 = (androidx.compose.runtime.snapshots.ObserverHandle) r7
            java.lang.Object r8 = r1.f9249j
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r1.f9248i
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r1.f9247h
            java.util.Set r10 = (java.util.Set) r10
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ all -> 0x0071 }
            goto L_0x00c4
        L_0x0071:
            r0 = move-exception
            goto L_0x015a
        L_0x0074:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r1.L$0
            r11 = r2
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 r9 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
            r9.<init>(r10)
            r2 = 2147483647(0x7fffffff, float:NaN)
            r7 = 6
            r8 = 0
            kotlinx.coroutines.channels.Channel r8 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r2, r8, r8, r7, r8)
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 r7 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
            r7.<init>(r8)
            androidx.compose.runtime.snapshots.ObserverHandle r7 = r2.registerApplyObserver(r7)
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.takeSnapshot(r9)     // Catch:{ all -> 0x0071 }
            kotlin.jvm.functions.Function0<T> r12 = r1.f9254o     // Catch:{ all -> 0x0071 }
            androidx.compose.runtime.snapshots.Snapshot r13 = r2.makeCurrent()     // Catch:{ all -> 0x0155 }
            java.lang.Object r12 = r12.invoke()     // Catch:{ all -> 0x014f }
            r2.restoreCurrent(r13)     // Catch:{ all -> 0x0155 }
            r2.dispose()     // Catch:{ all -> 0x0071 }
            r1.L$0 = r11     // Catch:{ all -> 0x0071 }
            r1.f9247h = r10     // Catch:{ all -> 0x0071 }
            r1.f9248i = r9     // Catch:{ all -> 0x0071 }
            r1.f9249j = r8     // Catch:{ all -> 0x0071 }
            r1.f9250k = r7     // Catch:{ all -> 0x0071 }
            r1.f9251l = r12     // Catch:{ all -> 0x0071 }
            r1.f9253n = r6     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = r11.emit(r12, r1)     // Catch:{ all -> 0x0071 }
            if (r2 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r2 = r12
        L_0x00c4:
            r12 = r1
        L_0x00c5:
            r12.L$0 = r11     // Catch:{ all -> 0x0071 }
            r12.f9247h = r10     // Catch:{ all -> 0x0071 }
            r12.f9248i = r9     // Catch:{ all -> 0x0071 }
            r12.f9249j = r8     // Catch:{ all -> 0x0071 }
            r12.f9250k = r7     // Catch:{ all -> 0x0071 }
            r12.f9251l = r2     // Catch:{ all -> 0x0071 }
            r12.f9252m = r3     // Catch:{ all -> 0x0071 }
            r12.f9253n = r5     // Catch:{ all -> 0x0071 }
            java.lang.Object r13 = r8.receive(r12)     // Catch:{ all -> 0x0071 }
            if (r13 != r0) goto L_0x00dc
            return r0
        L_0x00dc:
            r14 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r2
            r2 = r3
        L_0x00e4:
            java.util.Set r13 = (java.util.Set) r13     // Catch:{ all -> 0x0053 }
        L_0x00e6:
            if (r2 != 0) goto L_0x00f1
            boolean r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r11, r13)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r2 = r3
            goto L_0x00f2
        L_0x00f1:
            r2 = r6
        L_0x00f2:
            java.lang.Object r13 = r9.m7818tryReceivePtdJZtk()     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = kotlinx.coroutines.channels.ChannelResult.m7804getOrNullimpl(r13)     // Catch:{ all -> 0x0053 }
            java.util.Set r13 = (java.util.Set) r13     // Catch:{ all -> 0x0053 }
            if (r13 != 0) goto L_0x00e6
            if (r2 == 0) goto L_0x0146
            r11.clear()     // Catch:{ all -> 0x0053 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0053 }
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.takeSnapshot(r10)     // Catch:{ all -> 0x0053 }
            kotlin.jvm.functions.Function0<T> r13 = r14.f9254o     // Catch:{ all -> 0x0053 }
            androidx.compose.runtime.snapshots.Snapshot r15 = r2.makeCurrent()     // Catch:{ all -> 0x0141 }
            java.lang.Object r13 = r13.invoke()     // Catch:{ all -> 0x013b }
            r2.restoreCurrent(r15)     // Catch:{ all -> 0x0141 }
            r2.dispose()     // Catch:{ all -> 0x0053 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r7)     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x0146
            r14.L$0 = r12     // Catch:{ all -> 0x0053 }
            r14.f9247h = r11     // Catch:{ all -> 0x0053 }
            r14.f9248i = r10     // Catch:{ all -> 0x0053 }
            r14.f9249j = r9     // Catch:{ all -> 0x0053 }
            r14.f9250k = r8     // Catch:{ all -> 0x0053 }
            r14.f9251l = r13     // Catch:{ all -> 0x0053 }
            r14.f9253n = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r2 = r12.emit(r13, r14)     // Catch:{ all -> 0x0053 }
            if (r2 != r0) goto L_0x0134
            return r0
        L_0x0134:
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r2 = r13
            goto L_0x014c
        L_0x013b:
            r0 = move-exception
            r3 = r0
            r2.restoreCurrent(r15)     // Catch:{ all -> 0x0141 }
            throw r3     // Catch:{ all -> 0x0141 }
        L_0x0141:
            r0 = move-exception
            r2.dispose()     // Catch:{ all -> 0x0053 }
            throw r0     // Catch:{ all -> 0x0053 }
        L_0x0146:
            r2 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
        L_0x014c:
            r12 = r14
            goto L_0x00c5
        L_0x014f:
            r0 = move-exception
            r3 = r0
            r2.restoreCurrent(r13)     // Catch:{ all -> 0x0155 }
            throw r3     // Catch:{ all -> 0x0155 }
        L_0x0155:
            r0 = move-exception
            r2.dispose()     // Catch:{ all -> 0x0071 }
            throw r0     // Catch:{ all -> 0x0071 }
        L_0x015a:
            r7.dispose()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
