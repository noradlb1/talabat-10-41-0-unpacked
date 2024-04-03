package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\bJ%\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b*J%\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b,J\u000e\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003J\u0018\u0010.\u001a\u00020\b2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000100J#\u0010.\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0006\u00103\u001a\u00020$J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0003J\u0017\u00106\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u00020$00H\bJ\u0010\u00108\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u000e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0013J\u0010\u0010;\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010<\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0018\u0010=\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u0018\u0010?\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u000e\u0010@\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003J\u0018\u0010A\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u0018\u0010B\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u001b\u0010C\u001a\u00020$2\u0006\u0010)\u001a\u00020\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0018\u0010!\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringMeasureLayout", "", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "measureAffectsParent", "getMeasureAffectsParent", "callOnLayoutCompletedListeners", "", "dispatchOnPositionedCallbacks", "forceDispatch", "doLookaheadRemeasure", "layoutNode", "constraints", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "forceMeasureTheSubtree", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "measureOnly", "onNodeDetached", "node", "performMeasureAndLayout", "block", "recurseRemeasure", "registerOnLayoutCompletedListener", "listener", "remeasureAndRelayoutIfNeeded", "remeasureOnly", "requestLookaheadRelayout", "forced", "requestLookaheadRemeasure", "requestOnPositionedCallback", "requestRelayout", "requestRemeasure", "updateRootConstraints", "updateRootConstraints-BRTryo0", "(J)V", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MeasureAndLayoutDelegate {
    @Nullable
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private long measureIteration = 1;
    @NotNull
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
    @NotNull
    private final OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
    @NotNull
    private final MutableVector<PostponedRequest> postponedMeasureRequests;
    @NotNull
    private final DepthSortedSet relayoutNodes;
    /* access modifiers changed from: private */
    @NotNull
    public final LayoutNode root;
    @Nullable
    private Constraints rootConstraints;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PostponedRequest {
        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        @NotNull
        private final LayoutNode node;

        public PostponedRequest(@NotNull LayoutNode layoutNode, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(layoutNode, "node");
            this.node = layoutNode;
            this.isLookahead = z11;
            this.isForced = z12;
        }

        @NotNull
        public final LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(@NotNull LayoutNode layoutNode) {
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker;
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        this.root = layoutNode;
        Owner.Companion companion = Owner.Companion;
        DepthSortedSet depthSortedSet = new DepthSortedSet(companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSet;
        MutableVector<PostponedRequest> mutableVector = new MutableVector<>(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = mutableVector;
        if (companion.getEnableExtraAssertions()) {
            layoutTreeConsistencyChecker = new LayoutTreeConsistencyChecker(layoutNode, depthSortedSet, mutableVector.asMutableList());
        } else {
            layoutTreeConsistencyChecker = null;
        }
        this.consistencyChecker = layoutTreeConsistencyChecker;
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                ((Owner.OnLayoutCompletedListener) content[i11]).onLayoutComplete();
                i11++;
            } while (i11 < size);
        }
        this.onLayoutCompletedListeners.clear();
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z11);
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m4693doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean z11;
        if (layoutNode.getMLookaheadScope$ui_release() == null) {
            return false;
        }
        if (constraints != null) {
            z11 = layoutNode.m4623lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        } else {
            z11 = LayoutNode.m4619lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (z11 && parent$ui_release != null) {
            if (parent$ui_release.getMLookaheadScope$ui_release() == null) {
                requestRemeasure$default(this, parent$ui_release, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestLookaheadRemeasure$default(this, parent$ui_release, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestLookaheadRelayout$default(this, parent$ui_release, false, 2, (Object) null);
            }
        }
        return z11;
    }

    /* renamed from: doRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m4694doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean z11;
        if (constraints != null) {
            z11 = layoutNode.m4624remeasure_Sx5XlM$ui_release(constraints);
        } else {
            z11 = LayoutNode.m4620remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (z11 && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure$default(this, parent$ui_release, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout$default(this, parent$ui_release, false, 2, (Object) null);
            }
        }
        return z11;
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getMeasurePending$ui_release() && getMeasureAffectsParent(layoutNode);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        boolean z11;
        AlignmentLines alignmentLines;
        if (!layoutNode.getLookaheadLayoutPending$ui_release()) {
            return false;
        }
        if (layoutNode.getMeasuredByParentInLookahead$ui_release() != LayoutNode.UsageByParent.InMeasureBlock) {
            AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
            if (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                return false;
            }
        }
        return true;
    }

    private final boolean getMeasureAffectsParent(LayoutNode layoutNode) {
        if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(function0);
    }

    /* JADX INFO: finally extract failed */
    private final void performMeasureAndLayout(Function0<Unit> function0) {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                function0.invoke();
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    private final void recurseRemeasure(LayoutNode layoutNode) {
        remeasureOnly(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i11];
                if (getMeasureAffectsParent(layoutNode2)) {
                    recurseRemeasure(layoutNode2);
                }
                i11++;
            } while (i11 < size);
        }
        remeasureOnly(layoutNode);
    }

    /* access modifiers changed from: private */
    public final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode) {
        boolean z11;
        boolean z12;
        Constraints constraints;
        int i11 = 0;
        if (!layoutNode.isPlaced() && !getCanAffectParent(layoutNode) && !Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) Boolean.TRUE) && !getCanAffectParentInLookahead(layoutNode) && !layoutNode.getAlignmentLinesRequired$ui_release()) {
            return false;
        }
        if (layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getMeasurePending$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                z11 = m4693doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            } else {
                z11 = false;
            }
            z12 = m4694doRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            z12 = false;
            z11 = false;
        }
        if ((z11 || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) Boolean.TRUE)) {
            layoutNode.lookaheadReplace$ui_release();
        }
        if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
            if (layoutNode == this.root) {
                layoutNode.place$ui_release(0, 0);
            } else {
                layoutNode.replace$ui_release();
            }
            this.onPositionedDispatcher.onNodePositioned(layoutNode);
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        }
        if (this.postponedMeasureRequests.isNotEmpty()) {
            MutableVector<PostponedRequest> mutableVector = this.postponedMeasureRequests;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    PostponedRequest postponedRequest = (PostponedRequest) content[i11];
                    if (postponedRequest.getNode().isAttached()) {
                        if (!postponedRequest.isLookahead()) {
                            requestRemeasure(postponedRequest.getNode(), postponedRequest.isForced());
                        } else {
                            requestLookaheadRemeasure(postponedRequest.getNode(), postponedRequest.isForced());
                        }
                    }
                    i11++;
                } while (i11 < size);
            }
            this.postponedMeasureRequests.clear();
        }
        return z12;
    }

    private final void remeasureOnly(LayoutNode layoutNode) {
        Constraints constraints;
        if (layoutNode.getMeasurePending$ui_release() || layoutNode.getLookaheadMeasurePending$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                m4693doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            }
            m4694doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public static /* synthetic */ boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z11);
    }

    public static /* synthetic */ boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z11);
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z11);
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z11);
    }

    public final void dispatchOnPositionedCallbacks(boolean z11) {
        if (z11) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (!this.relayoutNodes.isEmpty()) {
            if (!this.duringMeasureLayout) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!layoutNode.getMeasurePending$ui_release()) {
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i11 = 0;
                    do {
                        LayoutNode layoutNode2 = (LayoutNode) content[i11];
                        if (layoutNode2.getMeasurePending$ui_release() && this.relayoutNodes.remove(layoutNode2)) {
                            remeasureAndRelayoutIfNeeded(layoutNode2);
                        }
                        if (!layoutNode2.getMeasurePending$ui_release()) {
                            forceMeasureTheSubtree(layoutNode2);
                        }
                        i11++;
                    } while (i11 < size);
                }
                if (layoutNode.getMeasurePending$ui_release() && this.relayoutNodes.remove(layoutNode)) {
                    remeasureAndRelayoutIfNeeded(layoutNode);
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return !this.relayoutNodes.isEmpty();
    }

    public final long getMeasureIteration() {
        if (this.duringMeasureLayout) {
            return this.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    /* JADX INFO: finally extract failed */
    public final boolean measureAndLayout(@Nullable Function0<Unit> function0) {
        boolean z11;
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.duringMeasureLayout) {
            boolean z12 = false;
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                try {
                    if (!this.relayoutNodes.isEmpty()) {
                        DepthSortedSet depthSortedSet = this.relayoutNodes;
                        z11 = false;
                        while (!depthSortedSet.isEmpty()) {
                            LayoutNode pop = depthSortedSet.pop();
                            boolean access$remeasureAndRelayoutIfNeeded = remeasureAndRelayoutIfNeeded(pop);
                            if (pop == this.root && access$remeasureAndRelayoutIfNeeded) {
                                z11 = true;
                            }
                        }
                        if (function0 != null) {
                            function0.invoke();
                        }
                    } else {
                        z11 = false;
                    }
                    this.duringMeasureLayout = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                    z12 = z11;
                } catch (Throwable th2) {
                    this.duringMeasureLayout = false;
                    throw th2;
                }
            }
            callOnLayoutCompletedListeners();
            return z12;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public final void m4695measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j11) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (!(!Intrinsics.areEqual((Object) layoutNode, (Object) this.root))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.duringMeasureLayout) {
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                try {
                    this.relayoutNodes.remove(layoutNode);
                    boolean r12 = m4693doLookaheadRemeasuresdFAvZA(layoutNode, Constraints.m5410boximpl(j11));
                    m4694doRemeasuresdFAvZA(layoutNode, Constraints.m5410boximpl(j11));
                    if ((r12 || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) Boolean.TRUE)) {
                        layoutNode.lookaheadReplace$ui_release();
                    }
                    if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                        layoutNode.replace$ui_release();
                        this.onPositionedDispatcher.onNodePositioned(layoutNode);
                    }
                    this.duringMeasureLayout = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th2) {
                    this.duringMeasureLayout = false;
                    throw th2;
                }
            }
            callOnLayoutCompletedListeners();
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void measureOnly() {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                recurseRemeasure(this.root);
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th2) {
                this.duringMeasureLayout = false;
                throw th2;
            }
        }
    }

    public final void onNodeDetached(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.relayoutNodes.remove(layoutNode);
    }

    public final void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        Intrinsics.checkNotNullParameter(onLayoutCompletedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onLayoutCompletedListeners.add(onLayoutCompletedListener);
    }

    public final boolean requestLookaheadRelayout(@NotNull LayoutNode layoutNode, boolean z11) {
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (!(i11 == 4 || i11 == 5)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !z11) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                return false;
            }
            layoutNode.markLookaheadLayoutPending$ui_release();
            layoutNode.markLayoutPending$ui_release();
            if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) Boolean.TRUE)) {
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                if (parent$ui_release == null || !parent$ui_release.getLookaheadMeasurePending$ui_release()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!z12) {
                    if (parent$ui_release == null || !parent$ui_release.getLookaheadLayoutPending$ui_release()) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z13) {
                        this.relayoutNodes.add(layoutNode);
                    }
                }
            }
            if (!this.duringMeasureLayout) {
                return true;
            }
            return false;
        }
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
        if (layoutTreeConsistencyChecker2 != null) {
            layoutTreeConsistencyChecker2.assertConsistent();
        }
        return false;
    }

    public final boolean requestLookaheadRemeasure(@NotNull LayoutNode layoutNode, boolean z11) {
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.getMLookaheadScope$ui_release() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
            if (i11 != 1) {
                if (i11 == 2 || i11 == 3 || i11 == 4) {
                    this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, z11));
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } else if (i11 != 5) {
                    throw new NoWhenBranchMatchedException();
                } else if (!layoutNode.getLookaheadMeasurePending$ui_release() || z11) {
                    layoutNode.markLookaheadMeasurePending$ui_release();
                    layoutNode.markMeasurePending$ui_release();
                    if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode)) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (parent$ui_release == null || !parent$ui_release.getLookaheadMeasurePending$ui_release()) {
                            z13 = false;
                        } else {
                            z13 = true;
                        }
                        if (!z13) {
                            this.relayoutNodes.add(layoutNode);
                        }
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadLayout".toString());
    }

    public final void requestOnPositionedCallback(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    public final boolean requestRelayout(@NotNull LayoutNode layoutNode, boolean z11) {
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        } else if (i11 != 5) {
            throw new NoWhenBranchMatchedException();
        } else if (z11 || (!layoutNode.getMeasurePending$ui_release() && !layoutNode.getLayoutPending$ui_release())) {
            layoutNode.markLayoutPending$ui_release();
            if (layoutNode.isPlaced()) {
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                if (parent$ui_release == null || !parent$ui_release.getLayoutPending$ui_release()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!z12) {
                    if (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z13) {
                        this.relayoutNodes.add(layoutNode);
                    }
                }
            }
            if (!this.duringMeasureLayout) {
                return true;
            }
        } else {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
            if (layoutTreeConsistencyChecker2 != null) {
                layoutTreeConsistencyChecker2.assertConsistent();
            }
        }
        return false;
    }

    public final boolean requestRemeasure(@NotNull LayoutNode layoutNode, boolean z11) {
        boolean z12;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 == 3 || i11 == 4) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, z11));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            } else if (!layoutNode.getMeasurePending$ui_release() || z11) {
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (!z12) {
                        this.relayoutNodes.add(layoutNode);
                    }
                }
                if (!this.duringMeasureLayout) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: updateRootConstraints-BRTryo0  reason: not valid java name */
    public final void m4696updateRootConstraintsBRTryo0(long j11) {
        boolean z11;
        Constraints constraints = this.rootConstraints;
        if (constraints == null) {
            z11 = false;
        } else {
            z11 = Constraints.m5415equalsimpl0(constraints.m5428unboximpl(), j11);
        }
        if (z11) {
            return;
        }
        if (!this.duringMeasureLayout) {
            this.rootConstraints = Constraints.m5410boximpl(j11);
            this.root.markMeasurePending$ui_release();
            this.relayoutNodes.add(this.root);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
