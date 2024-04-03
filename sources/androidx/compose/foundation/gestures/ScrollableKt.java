package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001aO\u0010\u0016\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\"\u001aR\u0010#\u001a\u00020\u0012*\u00020\u00122\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007\u001aF\u0010#\u001a\u00020\u0012*\u00020\u00122\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"ModifierLocalScrollableContainer", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "getModifierLocalScrollableContainer", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollableNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "awaitScrollEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseWheelScroll", "Landroidx/compose/ui/Modifier;", "scrollingLogicState", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "pointerScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "controller", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "scrollable", "state", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt {
    @NotNull
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(ScrollableKt$ModifierLocalScrollableContainer$1.INSTANCE);
    /* access modifiers changed from: private */
    @NotNull
    public static final ScrollScope NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    public static final java.lang.Object awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1) r0
            int r1 = r0.f2167j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2167j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f2166i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2167j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f2165h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x0038:
            r0.f2165h = r5
            r0.f2167j = r3
            r6 = 0
            java.lang.Object r6 = i0.b.t(r5, r6, r0, r3, r6)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            int r2 = r6.m4251getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m4267getScroll7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m4258equalsimpl0(r2, r4)
            if (r2 == 0) goto L_0x0038
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }

    private static final Modifier mouseWheelScroll(Modifier modifier, State<ScrollingLogic> state, ScrollConfig scrollConfig) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, state, scrollConfig, new ScrollableKt$mouseWheelScroll$1(scrollConfig, state, (Continuation<? super ScrollableKt$mouseWheelScroll$1>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier pointerScrollable(androidx.compose.ui.Modifier r24, androidx.compose.foundation.interaction.MutableInteractionSource r25, androidx.compose.foundation.gestures.Orientation r26, boolean r27, androidx.compose.foundation.gestures.ScrollableState r28, androidx.compose.foundation.gestures.FlingBehavior r29, androidx.compose.foundation.OverscrollEffect r30, boolean r31, androidx.compose.runtime.Composer r32, int r33) {
        /*
            r0 = r32
            r1 = -2012025036(0xffffffff8812ef34, float:-4.421646E-34)
            r0.startReplaceableGroup(r1)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0016
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:239)"
            r4 = r33
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r4, r2, r3)
        L_0x0016:
            r1 = -1730186366(0xffffffff98df7382, float:-5.7760782E-24)
            r0.startReplaceableGroup(r1)
            if (r29 != 0) goto L_0x0027
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r2 = 6
            androidx.compose.foundation.gestures.FlingBehavior r1 = r1.flingBehavior(r0, r2)
            r7 = r1
            goto L_0x0029
        L_0x0027:
            r7 = r29
        L_0x0029:
            r32.endReplaceableGroup()
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r1)
            java.lang.Object r2 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r9.getEmpty()
            r10 = 0
            if (r2 != r3) goto L_0x004c
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r2.<init>()
            r3 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r10, r3, r10)
            r0.updateRememberedValue(r2)
        L_0x004c:
            r32.endReplaceableGroup()
            r11 = r2
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.foundation.gestures.ScrollingLogic r12 = new androidx.compose.foundation.gestures.ScrollingLogic
            r2 = r12
            r3 = r26
            r4 = r27
            r5 = r11
            r6 = r28
            r8 = r30
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r2 = 0
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r0, r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r31)
            r5 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r5)
            boolean r4 = r0.changed((java.lang.Object) r4)
            java.lang.Object r6 = r32.rememberedValue()
            if (r4 != 0) goto L_0x0084
            java.lang.Object r4 = r9.getEmpty()
            if (r6 != r4) goto L_0x0081
            goto L_0x0084
        L_0x0081:
            r4 = r31
            goto L_0x008d
        L_0x0084:
            r4 = r31
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = scrollableNestedScrollConnection(r3, r4)
            r0.updateRememberedValue(r6)
        L_0x008d:
            r32.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r6
            r0.startReplaceableGroup(r1)
            java.lang.Object r1 = r32.rememberedValue()
            java.lang.Object r7 = r9.getEmpty()
            if (r1 != r7) goto L_0x00a7
            androidx.compose.foundation.gestures.ScrollDraggableState r1 = new androidx.compose.foundation.gestures.ScrollDraggableState
            r1.<init>(r3)
            r0.updateRememberedValue(r1)
        L_0x00a7:
            r32.endReplaceableGroup()
            r13 = r1
            androidx.compose.foundation.gestures.ScrollDraggableState r13 = (androidx.compose.foundation.gestures.ScrollDraggableState) r13
            androidx.compose.foundation.gestures.ScrollConfig r1 = androidx.compose.foundation.gestures.AndroidScrollable_androidKt.platformScrollConfig(r0, r2)
            androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1 r14 = androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1.INSTANCE
            r0.startReplaceableGroup(r5)
            boolean r2 = r0.changed((java.lang.Object) r3)
            java.lang.Object r5 = r32.rememberedValue()
            if (r2 != 0) goto L_0x00c6
            java.lang.Object r2 = r9.getEmpty()
            if (r5 != r2) goto L_0x00ce
        L_0x00c6:
            androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2$1 r5 = new androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2$1
            r5.<init>(r3)
            r0.updateRememberedValue(r5)
        L_0x00ce:
            r32.endReplaceableGroup()
            r18 = r5
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r2)
            boolean r2 = r0.changed((java.lang.Object) r11)
            boolean r5 = r0.changed((java.lang.Object) r3)
            r2 = r2 | r5
            java.lang.Object r5 = r32.rememberedValue()
            if (r2 != 0) goto L_0x00f2
            java.lang.Object r2 = r9.getEmpty()
            if (r5 != r2) goto L_0x00fa
        L_0x00f2:
            androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1 r5 = new androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1
            r5.<init>(r11, r3, r10)
            r0.updateRememberedValue(r5)
        L_0x00fa:
            r32.endReplaceableGroup()
            r20 = r5
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            r21 = 0
            r22 = 64
            r23 = 0
            r12 = r24
            r15 = r26
            r16 = r31
            r17 = r25
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.ui.Modifier r1 = mouseWheelScroll(r2, r3, r1)
            java.lang.Object r2 = r11.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll(r1, r6, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x012a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x012a:
            r32.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.pointerScrollable(androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.gestures.Orientation, boolean, androidx.compose.foundation.gestures.ScrollableState, androidx.compose.foundation.gestures.FlingBehavior, androidx.compose.foundation.OverscrollEffect, boolean, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    @NotNull
    public static final Modifier scrollable(@NotNull Modifier modifier, @NotNull ScrollableState scrollableState, @NotNull Orientation orientation, boolean z11, boolean z12, @Nullable FlingBehavior flingBehavior, @Nullable MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scrollableState, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return scrollable(modifier, scrollableState, orientation, (OverscrollEffect) null, z11, z12, flingBehavior, mutableInteractionSource);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z11, boolean z12, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i11 & 8) != 0) {
            z12 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z13, z12, (i11 & 16) != 0 ? null : flingBehavior, (i11 & 32) != 0 ? null : mutableInteractionSource);
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection scrollableNestedScrollConnection(State<ScrollingLogic> state, boolean z11) {
        return new ScrollableKt$scrollableNestedScrollConnection$1(state, z11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.foundation.gestures.ScrollableKt$scrollable$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.foundation.gestures.ScrollableKt$scrollable$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier scrollable(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollableState r14, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r15, @org.jetbrains.annotations.Nullable androidx.compose.foundation.OverscrollEffect r16, boolean r17, boolean r18, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r19, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r20) {
        /*
            r0 = r13
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "state"
            r10 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "orientation"
            r11 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x002b
            androidx.compose.foundation.gestures.ScrollableKt$scrollable$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.foundation.gestures.ScrollableKt$scrollable$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r15
            r4 = r14
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x002f
        L_0x002b:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x002f:
            androidx.compose.foundation.gestures.ScrollableKt$scrollable$2 r12 = new androidx.compose.foundation.gestures.ScrollableKt$scrollable$2
            r2 = r12
            r3 = r15
            r4 = r14
            r5 = r18
            r6 = r20
            r7 = r19
            r8 = r16
            r9 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.composed(r13, r1, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.scrollable(androidx.compose.ui.Modifier, androidx.compose.foundation.gestures.ScrollableState, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.OverscrollEffect, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, androidx.compose.foundation.interaction.MutableInteractionSource):androidx.compose.ui.Modifier");
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z11, boolean z12, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i11, Object obj) {
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, (i11 & 8) != 0 ? true : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? null : flingBehavior, (i11 & 64) != 0 ? null : mutableInteractionSource);
    }
}
