package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002MNB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010!\u001a\u00020\"2\u001d\u0010#\u001a\u0019\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0$¢\u0006\u0002\b(ø\u0001\u0000J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020,J\u0012\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0017\u00101\u001a\u00020,2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020,02H\bJ\u0006\u00103\u001a\u00020,J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\b\b\u0002\u00107\u001a\u00020\u0010H\u0002J(\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0013H\u0002J2\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<H\u0002¢\u0006\u0002\u0010AJ.\u0010>\u001a\b\u0012\u0004\u0012\u00020C0B2\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<¢\u0006\u0002\u0010DJ:\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\n2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<H\u0002¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\u0004\u0018\u00010\u00032\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "nodeToNodeState", "", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "createNodeAt", "index", "disposeCurrentNodes", "", "disposeOrReuseStartingFromIndex", "startIndex", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "NodeState", "Scope", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeSubcompositionsState {
    @NotNull
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    @Nullable
    private CompositionContext compositionContext;
    /* access modifiers changed from: private */
    public int currentIndex;
    @NotNull
    private final Map<LayoutNode, NodeState> nodeToNodeState = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final Map<Object, LayoutNode> precomposeMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public int precomposedCount;
    /* access modifiers changed from: private */
    public int reusableCount;
    @NotNull
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet((Set) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final LayoutNode root;
    /* access modifiers changed from: private */
    @NotNull
    public final Scope scope = new Scope();
    @NotNull
    private final Map<Object, LayoutNode> slotIdToNode = new LinkedHashMap();
    @NotNull
    private SubcomposeSlotReusePolicy slotReusePolicy;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        @NotNull
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        public float getDensity() {
            return this.density;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        @NotNull
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public /* synthetic */ MeasureResult layout(int i11, int i12, Map map, Function1 function1) {
            return MeasureScope.CC.a(this, i11, i12, map, function1);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ int m4483roundToPxR2X_6o(long j11) {
            return a.a(this, j11);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public /* synthetic */ int m4484roundToPx0680j_4(float f11) {
            return a.b(this, f11);
        }

        public void setDensity(float f11) {
            this.density = f11;
        }

        public void setFontScale(float f11) {
            this.fontScale = f11;
        }

        public void setLayoutDirection(@NotNull LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        @NotNull
        public List<Measurable> subcompose(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "content");
            return LayoutNodeSubcompositionsState.this.subcompose(obj, function2);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public /* synthetic */ float m4485toDpGaN1DYA(long j11) {
            return a.c(this, j11);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m4486toDpu2uoSUM(float f11) {
            return a.d(this, f11);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m4487toDpu2uoSUM(int i11) {
            return a.e(this, i11);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public /* synthetic */ long m4488toDpSizekrfVVM(long j11) {
            return a.f(this, j11);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ float m4489toPxR2X_6o(long j11) {
            return a.g(this, j11);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public /* synthetic */ float m4490toPx0680j_4(float f11) {
            return a.h(this, f11);
        }

        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return a.i(this, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public /* synthetic */ long m4491toSizeXkaWNTQ(long j11) {
            return a.j(this, j11);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public /* synthetic */ long m4492toSp0xMU5do(float f11) {
            return a.k(this, f11);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m4493toSpkPz2Gy4(float f11) {
            return a.l(this, f11);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m4494toSpkPz2Gy4(int i11) {
            return a.m(this, i11);
        }
    }

    public LayoutNodeSubcompositionsState(@NotNull LayoutNode layoutNode, @NotNull SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        Intrinsics.checkNotNullParameter(subcomposeSlotReusePolicy, "slotReusePolicy");
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    public static /* synthetic */ void a(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i13 = 1;
        }
        layoutNodeSubcompositionsState.move(i11, i12, i13);
    }

    private final LayoutNode createNodeAt(int i11) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, (DefaultConstructorMarker) null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(i11, layoutNode);
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    private final Object getSlotIdAtIndex(int i11) {
        NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(i11));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    private final void ignoreRemeasureRequests(Function0<Unit> function0) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        function0.invoke();
        layoutNode.ignoreRemeasureRequests = false;
    }

    /* access modifiers changed from: private */
    public final void move(int i11, int i12, int i13) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(i11, i12, i13);
        layoutNode.ignoreRemeasureRequests = false;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private final Composition subcomposeInto(Composition composition, LayoutNode layoutNode, CompositionContext compositionContext2, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (composition == null || composition.isDisposed()) {
            composition = Wrapper_androidKt.createSubcomposition(layoutNode, compositionContext2);
        }
        composition.setContent(function2);
        return composition;
    }

    private final LayoutNode takeNodeFromReusables(Object obj) {
        int i11;
        if (this.reusableCount == 0) {
            return null;
        }
        int size = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int i12 = size - this.reusableCount;
        int i13 = size - 1;
        int i14 = i13;
        while (true) {
            if (i14 < i12) {
                i11 = -1;
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(i14), obj)) {
                i11 = i14;
                break;
            } else {
                i14--;
            }
        }
        if (i11 == -1) {
            while (true) {
                if (i13 < i12) {
                    i14 = i13;
                    break;
                }
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(i13));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (this.slotReusePolicy.areCompatible(obj, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(obj);
                    i14 = i13;
                    i11 = i14;
                    break;
                }
                i13--;
            }
        }
        if (i11 == -1) {
            return null;
        }
        if (i14 != i12) {
            move(i14, i12, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(i12);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActive(true);
        nodeState4.setForceRecompose(true);
        Snapshot.Companion.sendApplyNotifications();
        return layoutNode;
    }

    @NotNull
    public final MeasurePolicy createMeasurePolicy(@NotNull Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1(this, function2, this.NoIntrinsicsMessage);
    }

    public final void disposeCurrentNodes() {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        for (NodeState composition : this.nodeToNodeState.values()) {
            Composition composition2 = composition.getComposition();
            if (composition2 != null) {
                composition2.dispose();
            }
        }
        this.root.removeAll$ui_release();
        layoutNode.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    public final void disposeOrReuseStartingFromIndex(int i11) {
        this.reusableCount = 0;
        int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        if (i11 <= size) {
            this.reusableSlotIdsSet.clear();
            if (i11 <= size) {
                int i12 = i11;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i12));
                    if (i12 == size) {
                        break;
                    }
                    i12++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            while (size >= i11) {
                LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(size);
                NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                Object slotId = nodeState2.getSlotId();
                if (this.reusableSlotIdsSet.contains(slotId)) {
                    layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                    this.reusableCount++;
                    nodeState2.setActive(false);
                } else {
                    LayoutNode layoutNode2 = this.root;
                    layoutNode2.ignoreRemeasureRequests = true;
                    this.nodeToNodeState.remove(layoutNode);
                    Composition composition = nodeState2.getComposition();
                    if (composition != null) {
                        composition.dispose();
                    }
                    this.root.removeAt$ui_release(size, 1);
                    layoutNode2.ignoreRemeasureRequests = false;
                }
                this.slotIdToNode.remove(slotId);
                size--;
            }
        }
        makeSureStateIsConsistent();
    }

    public final void forceRecomposeChildren() {
        for (Map.Entry<LayoutNode, NodeState> value : this.nodeToNodeState.entrySet()) {
            ((NodeState) value.getValue()).setForceRecompose(true);
        }
        if (!this.root.getMeasurePending$ui_release()) {
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, 1, (Object) null);
        }
    }

    @Nullable
    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    @NotNull
    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void makeSureStateIsConsistent() {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (this.nodeToNodeState.size() == this.root.getFoldedChildren$ui_release().size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if ((this.root.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount >= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (this.precomposeMap.size() != this.precomposedCount) {
                    z13 = false;
                }
                if (!z13) {
                    throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Total children " + this.root.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        }
        throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + this.root.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
    }

    @NotNull
    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(obj)) {
            Map<Object, LayoutNode> map = this.precomposeMap;
            LayoutNode layoutNode = map.get(obj);
            if (layoutNode == null) {
                layoutNode = takeNodeFromReusables(obj);
                if (layoutNode != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(layoutNode), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNode = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                map.put(obj, layoutNode);
            }
            subcompose(layoutNode, obj, function2);
        }
        return new LayoutNodeSubcompositionsState$precompose$1(this, obj);
    }

    public final void setCompositionContext(@Nullable CompositionContext compositionContext2) {
        this.compositionContext = compositionContext2;
    }

    public final void setSlotReusePolicy(@NotNull SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        Intrinsics.checkNotNullParameter(subcomposeSlotReusePolicy, "value");
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            disposeOrReuseStartingFromIndex(0);
        }
    }

    @NotNull
    public final List<Measurable> subcompose(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        boolean z11 = false;
        if (layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
            Map<Object, LayoutNode> map = this.slotIdToNode;
            LayoutNode layoutNode = map.get(obj);
            if (layoutNode == null) {
                layoutNode = this.precomposeMap.remove(obj);
                if (layoutNode != null) {
                    int i11 = this.precomposedCount;
                    if (i11 > 0) {
                        z11 = true;
                    }
                    if (z11) {
                        this.precomposedCount = i11 - 1;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    layoutNode = takeNodeFromReusables(obj);
                    if (layoutNode == null) {
                        layoutNode = createNodeAt(this.currentIndex);
                    }
                }
                map.put(obj, layoutNode);
            }
            LayoutNode layoutNode2 = layoutNode;
            int indexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNode2);
            int i12 = this.currentIndex;
            if (indexOf >= i12) {
                if (i12 != indexOf) {
                    a(this, indexOf, i12, 0, 4, (Object) null);
                }
                this.currentIndex++;
                subcompose(layoutNode2, obj, function2);
                return layoutNode2.getChildMeasurables$ui_release();
            }
            throw new IllegalArgumentException("Key " + obj + " was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
        }
        throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Landroidx/compose/runtime/MutableState;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NodeState {
        @NotNull
        private final MutableState active$delegate;
        @Nullable
        private Composition composition;
        @NotNull
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        @Nullable
        private Object slotId;

        public NodeState(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composition composition2) {
            Intrinsics.checkNotNullParameter(function2, "content");
            this.slotId = obj;
            this.content = function2;
            this.composition = composition2;
            this.active$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        public final boolean getActive() {
            return ((Boolean) this.active$delegate.getValue()).booleanValue();
        }

        @Nullable
        public final Composition getComposition() {
            return this.composition;
        }

        @NotNull
        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        @Nullable
        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setActive(boolean z11) {
            this.active$delegate.setValue(Boolean.valueOf(z11));
        }

        public final void setComposition(@Nullable Composition composition2) {
            this.composition = composition2;
        }

        public final void setContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final void setForceRecompose(boolean z11) {
            this.forceRecompose = z11;
        }

        public final void setSlotId(@Nullable Object obj) {
            this.slotId = obj;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i11 & 4) != 0 ? null : composition2);
        }
    }

    private final void subcompose(LayoutNode layoutNode, Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        Map<LayoutNode, NodeState> map = this.nodeToNodeState;
        NodeState nodeState = map.get(layoutNode);
        if (nodeState == null) {
            nodeState = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m4441getLambda1$ui_release(), (Composition) null, 4, (DefaultConstructorMarker) null);
            map.put(layoutNode, nodeState);
        }
        NodeState nodeState2 = nodeState;
        Composition composition = nodeState2.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState2.getContent() != function2 || hasInvalidations || nodeState2.getForceRecompose()) {
            nodeState2.setContent(function2);
            subcompose(layoutNode, nodeState2);
            nodeState2.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode layoutNode, NodeState nodeState) {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            LayoutNode layoutNode2 = this.root;
            layoutNode2.ignoreRemeasureRequests = true;
            Function2<Composer, Integer, Unit> content = nodeState.getContent();
            Composition composition = nodeState.getComposition();
            CompositionContext compositionContext2 = this.compositionContext;
            if (compositionContext2 != null) {
                nodeState.setComposition(subcomposeInto(composition, layoutNode, compositionContext2, ComposableLambdaKt.composableLambdaInstance(-34810602, true, new LayoutNodeSubcompositionsState$subcompose$2$1$1(nodeState, content))));
                layoutNode2.ignoreRemeasureRequests = false;
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                return;
            }
            throw new IllegalStateException("parent composition reference not set".toString());
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }
}
