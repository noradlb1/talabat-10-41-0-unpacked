package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010\"J-\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J#\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J'\u0010:\u001a\u00020)*\u00020;2\u0006\u0010<\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u00106J\n\u0010?\u001a\u00020A*\u00020AJ\u0017\u0010B\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u00106J\u0017\u0010D\u001a\u00020\u001f*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u00106J\u0017\u0010F\u001a\u00020A*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u0017\u0010F\u001a\u00020A*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010HJ\u001a\u0010J\u001a\u00020)*\u00020Aø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010N\u001a\u00020Aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "overscrollPostConsumeDelta", "consumedByChain", "Landroidx/compose/ui/geometry/Offset;", "availableForOverscroll", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "overscrollPostConsumeDelta-OMhpSzk", "(JJI)V", "overscrollPreConsumeDelta", "scrollDelta", "overscrollPreConsumeDelta-OzD1aCk", "(JI)J", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "availableDelta", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ScrollingLogic {
    @NotNull
    private final FlingBehavior flingBehavior;
    @NotNull
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    @NotNull
    private final Orientation orientation;
    @Nullable
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    @NotNull
    private final ScrollableState scrollableState;

    public ScrollingLogic(@NotNull Orientation orientation2, boolean z11, @NotNull State<NestedScrollDispatcher> state, @NotNull ScrollableState scrollableState2, @NotNull FlingBehavior flingBehavior2, @Nullable OverscrollEffect overscrollEffect2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(state, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior2, "flingBehavior");
        this.orientation = orientation2;
        this.reverseDirection = z11;
        this.nestedScrollDispatcher = state;
        this.scrollableState = scrollableState2;
        this.flingBehavior = flingBehavior2;
        this.overscrollEffect = overscrollEffect2;
    }

    /* renamed from: overscrollPostConsumeDelta-OMhpSzk  reason: not valid java name */
    private final void m345overscrollPostConsumeDeltaOMhpSzk(long j11, long j12, int i11) {
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 != null && overscrollEffect2.isEnabled()) {
            this.overscrollEffect.m252consumePostScrollOMhpSzk(j11, j12, i11);
        }
    }

    /* renamed from: dispatchScroll-3eAAhYA  reason: not valid java name */
    public final long m346dispatchScroll3eAAhYA(@NotNull ScrollScope scrollScope, long j11, int i11) {
        ScrollScope scrollScope2 = scrollScope;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(scrollScope, "$this$dispatchScroll");
        long r12 = m352singleAxisOffsetMKHz9U(j11);
        long r13 = Offset.m2680minusMKHz9U(r12, m349overscrollPreConsumeDeltaOzD1aCk(r12, i12));
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long r82 = Offset.m2680minusMKHz9U(r13, value.m4205dispatchPreScrollOzD1aCk(r13, i12));
        long r14 = m351reverseIfNeededMKHz9U(m356toOffsettuRUvjQ(scrollScope.scrollBy(m355toFloatk4lQ0M(m351reverseIfNeededMKHz9U(r82)))));
        long r102 = Offset.m2680minusMKHz9U(r82, r14);
        int i13 = i11;
        long r122 = value.m4203dispatchPostScrollDzOQY0M(r14, r102, i13);
        m345overscrollPostConsumeDeltaOMhpSzk(r82, Offset.m2680minusMKHz9U(r102, r122), i13);
        return Offset.m2680minusMKHz9U(r102, r122);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m347doFlingAnimationQWom1Mo(long r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.f2200k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2200k = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L_0x0018:
            r4 = r0
            java.lang.Object r15 = r4.f2198i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f2200k
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r13 = r4.f2197h
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x005d
        L_0x002e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r5 = 1
            r6 = 0
            r4.f2197h = r15
            r4.f2200k = r2
            r2 = r3
            r3 = r11
            java.lang.Object r13 = o.c.a(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L_0x005c
            return r0
        L_0x005c:
            r13 = r15
        L_0x005d:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m5694boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m347doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @NotNull
    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Nullable
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    @NotNull
    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m348onDragStoppedsFctU(long r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.f2216l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2216l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f2214j
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f2216l
            r8 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x006d
            if (r1 == r5) goto L_0x0063
            if (r1 == r4) goto L_0x0059
            if (r1 == r3) goto L_0x004d
            if (r1 == r2) goto L_0x0042
            if (r1 != r8) goto L_0x003a
            java.lang.Object r13 = r0.f2212h
            androidx.compose.foundation.gestures.ScrollingLogic r13 = (androidx.compose.foundation.gestures.ScrollingLogic) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0116
        L_0x003a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0042:
            long r13 = r0.f2213i
            java.lang.Object r1 = r0.f2212h
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00f4
        L_0x004d:
            long r13 = r0.f2213i
            java.lang.Object r1 = r0.f2212h
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
        L_0x0056:
            r9 = r1
            goto L_0x00cf
        L_0x0059:
            long r13 = r0.f2213i
            java.lang.Object r1 = r0.f2212h
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b8
        L_0x0063:
            long r13 = r0.f2213i
            java.lang.Object r1 = r0.f2212h
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0091
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r15)
            r12.registerNestedFling(r5)
            long r13 = r12.m353singleAxisVelocityAH228Gc(r13)
            androidx.compose.foundation.OverscrollEffect r15 = r12.overscrollEffect
            if (r15 == 0) goto L_0x0098
            boolean r15 = r15.isEnabled()
            if (r15 == 0) goto L_0x0098
            androidx.compose.foundation.OverscrollEffect r15 = r12.overscrollEffect
            r0.f2212h = r12
            r0.f2213i = r13
            r0.f2216l = r5
            java.lang.Object r15 = r15.m253consumePreFlingQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x0090
            return r7
        L_0x0090:
            r1 = r12
        L_0x0091:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r5 = r15.m5712unboximpl()
            goto L_0x009f
        L_0x0098:
            androidx.compose.ui.unit.Velocity$Companion r15 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r15.m5714getZero9UxMQ8M()
            r1 = r12
        L_0x009f:
            long r13 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r13, r5)
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r15 = r1.nestedScrollDispatcher
            java.lang.Object r15 = r15.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r15 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r15
            r0.f2212h = r1
            r0.f2213i = r13
            r0.f2216l = r4
            java.lang.Object r15 = r15.m4204dispatchPreFlingQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x00b8
            return r7
        L_0x00b8:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r4 = r15.m5712unboximpl()
            long r13 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r13, r4)
            r0.f2212h = r1
            r0.f2213i = r13
            r0.f2216l = r3
            java.lang.Object r15 = r1.m347doFlingAnimationQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x0056
            return r7
        L_0x00cf:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r10 = r15.m5712unboximpl()
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r15 = r9.nestedScrollDispatcher
            java.lang.Object r15 = r15.getValue()
            r1 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
            long r13 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r13, r10)
            r0.f2212h = r9
            r0.f2213i = r10
            r0.f2216l = r2
            r2 = r13
            r4 = r10
            r6 = r0
            java.lang.Object r15 = r1.m4202dispatchPostFlingRZ2iAVY(r2, r4, r6)
            if (r15 != r7) goto L_0x00f2
            return r7
        L_0x00f2:
            r1 = r9
            r13 = r10
        L_0x00f4:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r2 = r15.m5712unboximpl()
            long r13 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r13, r2)
            androidx.compose.foundation.OverscrollEffect r15 = r1.overscrollEffect
            if (r15 == 0) goto L_0x0117
            boolean r15 = r15.isEnabled()
            if (r15 == 0) goto L_0x0117
            androidx.compose.foundation.OverscrollEffect r15 = r1.overscrollEffect
            r0.f2212h = r1
            r0.f2216l = r8
            java.lang.Object r13 = r15.m251consumePostFlingsFctU(r13, r0)
            if (r13 != r7) goto L_0x0115
            return r7
        L_0x0115:
            r13 = r1
        L_0x0116:
            r1 = r13
        L_0x0117:
            r13 = 0
            r1.registerNestedFling(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m348onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: overscrollPreConsumeDelta-OzD1aCk  reason: not valid java name */
    public final long m349overscrollPreConsumeDeltaOzD1aCk(long j11, int i11) {
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 == null || !overscrollEffect2.isEnabled()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        return this.overscrollEffect.m254consumePreScrollOzD1aCk(j11, i11);
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m350performRawScrollMKHz9U(long j11) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        return m356toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m355toFloatk4lQ0M(j11)))));
    }

    public final void registerNestedFling(boolean z11) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z11));
    }

    public final float reverseIfNeeded(float f11) {
        return this.reverseDirection ? f11 * ((float) -1) : f11;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m351reverseIfNeededMKHz9U(long j11) {
        return this.reverseDirection ? Offset.m2683timestuRUvjQ(j11, -1.0f) : j11;
    }

    public final boolean shouldScrollImmediately() {
        boolean z11;
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect2 = this.overscrollEffect;
            if (overscrollEffect2 != null) {
                z11 = overscrollEffect2.isInProgress();
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m352singleAxisOffsetMKHz9U(long j11) {
        return this.orientation == Orientation.Horizontal ? Offset.m2670copydBAh8RU$default(j11, 0.0f, 0.0f, 1, (Object) null) : Offset.m2670copydBAh8RU$default(j11, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    public final long m353singleAxisVelocityAH228Gc(long j11) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5699copyOhffZ5M$default(j11, 0.0f, 0.0f, 1, (Object) null) : Velocity.m5699copyOhffZ5M$default(j11, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m354toFloatTH1AsA0(long j11) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5703getXimpl(j11) : Velocity.m5704getYimpl(j11);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m355toFloatk4lQ0M(long j11) {
        return this.orientation == Orientation.Horizontal ? Offset.m2676getXimpl(j11) : Offset.m2677getYimpl(j11);
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m356toOffsettuRUvjQ(float f11) {
        boolean z11;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f11, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f11);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m357updateQWom1Mo(long j11, float f11) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5699copyOhffZ5M$default(j11, f11, 0.0f, 2, (Object) null) : Velocity.m5699copyOhffZ5M$default(j11, 0.0f, f11, 1, (Object) null);
    }
}
