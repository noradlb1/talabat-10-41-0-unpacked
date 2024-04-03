package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {485, 503}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f9187h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9188i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9189j;

    /* renamed from: k  reason: collision with root package name */
    public Object f9190k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9191l;

    /* renamed from: m  reason: collision with root package name */
    public int f9192m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f9193n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9194o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.f9194o = recomposer;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2) {
        list.clear();
        list2.clear();
        list3.clear();
        set.clear();
        set2.clear();
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        list.clear();
        synchronized (recomposer.stateLock) {
            List access$getCompositionValuesAwaitingInsert$p = recomposer.compositionValuesAwaitingInsert;
            int size = access$getCompositionValuesAwaitingInsert$p.size();
            for (int i11 = 0; i11 < size; i11++) {
                list.add((MovableContentStateReference) access$getCompositionValuesAwaitingInsert$p.get(i11));
            }
            recomposer.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull MonotonicFrameClock monotonicFrameClock, @Nullable Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.f9194o, continuation);
        recomposer$runRecomposeAndApplyChanges$2.f9193n = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.f9192m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0065
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r2 = r1.f9191l
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r1.f9190k
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r1.f9189j
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.f9188i
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.f9187h
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.f9193n
            androidx.compose.runtime.MonotonicFrameClock r9 = (androidx.compose.runtime.MonotonicFrameClock) r9
            kotlin.ResultKt.throwOnFailure(r19)
            r10 = r1
            r14 = r6
            r6 = r3
            r16 = r9
            r9 = r2
            r2 = r16
            r17 = r8
            r8 = r5
            r5 = r17
            goto L_0x00fd
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0042:
            java.lang.Object r2 = r1.f9191l
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r1.f9190k
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r1.f9189j
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.f9188i
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.f9187h
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.f9193n
            androidx.compose.runtime.MonotonicFrameClock r9 = (androidx.compose.runtime.MonotonicFrameClock) r9
            kotlin.ResultKt.throwOnFailure(r19)
            r11 = r1
            r10 = r2
            r15 = r5
            r14 = r6
            r13 = r7
            r12 = r8
            r2 = r9
            goto L_0x00ab
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r2 = r1.f9193n
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r10 = r1
        L_0x0086:
            androidx.compose.runtime.Recomposer r11 = r10.f9194o
            boolean r11 = r11.getShouldKeepRecomposing()
            if (r11 == 0) goto L_0x010b
            androidx.compose.runtime.Recomposer r11 = r10.f9194o
            r10.f9193n = r2
            r10.f9187h = r5
            r10.f9188i = r6
            r10.f9189j = r7
            r10.f9190k = r8
            r10.f9191l = r9
            r10.f9192m = r4
            java.lang.Object r11 = r11.awaitWorkAvailable(r10)
            if (r11 != r0) goto L_0x00a5
            return r0
        L_0x00a5:
            r12 = r5
            r13 = r6
            r14 = r7
            r15 = r8
            r11 = r10
            r10 = r9
        L_0x00ab:
            androidx.compose.runtime.Recomposer r5 = r11.f9194o
            java.lang.Object r5 = r5.stateLock
            androidx.compose.runtime.Recomposer r6 = r11.f9194o
            monitor-enter(r5)
            boolean r7 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0108 }
            r8 = 0
            if (r7 != 0) goto L_0x00c5
            r6.recordComposerModificationsLocked()     // Catch:{ all -> 0x0108 }
            boolean r6 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0108 }
            if (r6 != 0) goto L_0x00c5
            r8 = r4
        L_0x00c5:
            monitor-exit(r5)
            if (r8 == 0) goto L_0x00cf
            r9 = r10
            r10 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            goto L_0x0086
        L_0x00cf:
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2 r9 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2
            androidx.compose.runtime.Recomposer r6 = r11.f9194o
            r5 = r9
            r7 = r12
            r8 = r13
            r4 = r9
            r9 = r15
            r19 = r10
            r10 = r14
            r3 = r11
            r11 = r19
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r3.f9193n = r2
            r3.f9187h = r12
            r3.f9188i = r13
            r3.f9189j = r14
            r3.f9190k = r15
            r9 = r19
            r3.f9191l = r9
            r6 = 2
            r3.f9192m = r6
            java.lang.Object r4 = r2.withFrameNanos(r4, r3)
            if (r4 != r0) goto L_0x00f9
            return r0
        L_0x00f9:
            r10 = r3
            r5 = r12
            r7 = r13
            r8 = r15
        L_0x00fd:
            androidx.compose.runtime.Recomposer r3 = r10.f9194o
            r3.discardUnusedValues()
            r3 = r6
            r6 = r7
            r7 = r14
            r4 = 1
            goto L_0x0086
        L_0x0108:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x010b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
