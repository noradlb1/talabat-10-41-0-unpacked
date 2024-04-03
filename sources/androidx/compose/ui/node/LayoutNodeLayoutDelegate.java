package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0002TUB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020>J\r\u0010?\u001a\u00020>H\u0000¢\u0006\u0002\b@J\r\u0010A\u001a\u00020>H\u0000¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020>H\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020>H\u0000¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u00020>2\b\u0010H\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020>2\u0006\u0010L\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010NJ\u0006\u0010Q\u001a\u00020>J\u0006\u0010R\u001a\u00020>J\f\u0010S\u001a\u00020\u0010*\u00020\u0003H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0013R*\u0010.\u001a\b\u0018\u00010-R\u00020\u00002\f\u0010\u001e\u001a\b\u0018\u00010-R\u00020\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u00101\u001a\u000602R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0013R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "()Z", "setCoordinatesAccessedDuringPlacement", "(Z)V", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "<set-?>", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "width", "getWidth$ui_release", "markChildrenDirty", "", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onLookaheadScopeChanged", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "onLookaheadScopeChanged$ui_release", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "isOutMostLookaheadRoot", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    /* access modifiers changed from: private */
    @NotNull
    public final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public boolean layoutPending;
    /* access modifiers changed from: private */
    public boolean layoutPendingForAlignment;
    /* access modifiers changed from: private */
    @NotNull
    public LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Idle;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPending;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    @Nullable
    private LookaheadPassDelegate lookaheadPassDelegate;
    @NotNull
    private final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate();
    private boolean measurePending;

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\bm\u0010nJ!\u0010\b\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\bJ\b\u0010\t\u001a\u00020\u0006H\u0002J\f\u0010\u000b\u001a\u00020\u0006*\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0006\u0010\u0017\u001a\u00020\u0006J\u001d\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010 \u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ@\u0010(\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b&H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0011\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0016J\u0010\u00101\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0016J\u000e\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u001dJ\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006R\u0014\u00108\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020\u001d8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010;R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010;R!\u0010B\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\bB\u0010CR\u001f\u0010D\u001a\u00020!8\u0002@\u0002X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u001d8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bF\u0010;\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?R\u0016\u0010H\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010;R\u001a\u0010J\u001a\u00020I8\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020N8\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u001d8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bQ\u0010;\u001a\u0004\bR\u0010=\"\u0004\bS\u0010?R(\u0010V\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010T8\u0016@RX\u000e¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001c\u0010\\\u001a\u0004\u0018\u00010\u00188Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00020a8@X\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0016\u0010g\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010j\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010i\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006o"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Lkotlin/Function1;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "block", "forEachChildDelegate", "markSubtreeNotPlaced", "Landroidx/compose/ui/node/LayoutNode;", "trackLookaheadMeasurementByParent", "onIntrinsicsQueried", "requestSubtreeForLookahead", "onBeforeLayoutChildren", "layoutChildren", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "calculateAlignmentLines", "forEachChildAlignmentLinesOwner", "requestLayout", "requestMeasure", "notifyChildrenUsingCoordinatesWhilePlacing", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "remeasure-BRTryo0", "(J)Z", "remeasure", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "alignmentLine", "get", "height", "minIntrinsicWidth", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "forceRequest", "invalidateIntrinsicsParent", "updateParentData", "onPlaced", "replace", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "duringAlignmentLinesQuery", "Z", "getDuringAlignmentLinesQuery$ui_release", "()Z", "setDuringAlignmentLinesQuery$ui_release", "(Z)V", "placedOnce", "measuredOnce", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lastPosition", "J", "isPlaced", "setPlaced", "isPreviouslyPlaced", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "childMeasurablesDirty", "getChildMeasurablesDirty$ui_release", "setChildMeasurablesDirty$ui_release", "", "<set-?>", "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "getMeasuredWidth", "()I", "measuredWidth", "getMeasuredHeight", "measuredHeight", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;Landroidx/compose/ui/layout/LookaheadScope;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        @NotNull
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        @NotNull
        private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LayoutNodeLayoutDelegate f9922b;
        private boolean childMeasurablesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced = true;
        /* access modifiers changed from: private */
        public boolean isPreviouslyPlaced;
        private long lastPosition = IntOffset.Companion.m5606getZeronOccac();
        @Nullable
        private Constraints lookaheadConstraints;
        @NotNull
        private final LookaheadScope lookaheadScope;
        private boolean measuredOnce;
        @Nullable
        private Object parentData;
        private boolean placedOnce;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public LookaheadPassDelegate(@NotNull LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LookaheadScope lookaheadScope2) {
            Intrinsics.checkNotNullParameter(lookaheadScope2, "lookaheadScope");
            this.f9922b = layoutNodeLayoutDelegate;
            this.lookaheadScope = lookaheadScope2;
            this.parentData = layoutNodeLayoutDelegate.getMeasurePassDelegate$ui_release().getParentData();
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = this.f9922b.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i11]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    function1.invoke(lookaheadPassDelegate$ui_release);
                    i11++;
                } while (i11 < size);
            }
        }

        /* access modifiers changed from: private */
        public final void markSubtreeNotPlaced() {
            int i11 = 0;
            setPlaced(false);
            MutableVector<LayoutNode> mutableVector = this.f9922b.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i11]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.markSubtreeNotPlaced();
                    i11++;
                } while (i11 < size);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode access$getLayoutNode$p = this.f9922b.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.f9922b;
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i11];
                    if (layoutNode.getLookaheadMeasurePending$ui_release() && layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        Constraints r62 = m4668getLastConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(r62);
                        if (lookaheadPassDelegate$ui_release.m4670remeasureBRTryo0(r62.m5428unboximpl())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, (Object) null);
                        }
                    }
                    i11++;
                } while (i11 < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.f9922b.layoutNode, false, 1, (Object) null);
            LayoutNode parent$ui_release = this.f9922b.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && this.f9922b.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = this.f9922b.layoutNode;
                int i11 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i11 == 2) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i11 != 3) {
                    usageByParent = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                } else {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        private final void requestSubtreeForLookahead() {
            MutableVector<LayoutNode> mutableVector = this.f9922b.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i11];
                    layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.requestSubtreeForLookahead();
                    i11++;
                } while (i11 < size);
            }
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode layoutNode) {
            boolean z11;
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i11 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    } else if (i11 == 3 || i11 == 4) {
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    } else {
                        throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                    }
                    layoutNode.setMeasuredByParentInLookahead$ui_release(usageByParent);
                    return;
                }
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + layoutNode.getMeasuredByParentInLookahead$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + '.').toString());
            }
            layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
        }

        @NotNull
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (this.f9922b.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        this.f9922b.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate$ui_release = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                lookaheadDelegate$ui_release.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate$ui_release2 = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release2 != null) {
                lookaheadDelegate$ui_release2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            this.f9922b.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            if (!IntOffset.m5595equalsimpl0(j11, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            Owner requireOwner = LayoutNodeKt.requireOwner(this.f9922b.layoutNode);
            this.f9922b.setCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), this.f9922b.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1(this.f9922b, j11), 2, (Object) null);
            this.lastPosition = j11;
            this.f9922b.layoutState = LayoutNode.LayoutState.Idle;
        }

        public void forEachChildAlignmentLinesOwner(@NotNull Function1<? super AlignmentLinesOwner, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            List<LayoutNode> children$ui_release = this.f9922b.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i11 = 0; i11 < size; i11++) {
                AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = children$ui_release.get(i11).getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                function1.invoke(lookaheadAlignmentLinesOwner$ui_release);
            }
        }

        public int get(@NotNull AlignmentLine alignmentLine) {
            LayoutNode.LayoutState layoutState;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = this.f9922b.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState2 = null;
            if (parent$ui_release != null) {
                layoutState = parent$ui_release.getLayoutState$ui_release();
            } else {
                layoutState = null;
            }
            if (layoutState == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = this.f9922b.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState2 = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState2 == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            int i11 = lookaheadDelegate$ui_release.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i11;
        }

        @NotNull
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @NotNull
        public final List<Measurable> getChildMeasurables$ui_release() {
            this.f9922b.layoutNode.getChildren$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(this.f9922b.layoutNode, this._childMeasurables, LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2.INSTANCE);
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @NotNull
        public NodeCoordinator getInnerCoordinator() {
            return this.f9922b.layoutNode.getInnerCoordinator$ui_release();
        }

        @Nullable
        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m4668getLastConstraintsDWUhwKw() {
            return this.lookaheadConstraints;
        }

        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredHeight();
        }

        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredWidth();
        }

        @Nullable
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = this.f9922b.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
        }

        @Nullable
        public Object getParentData() {
            return this.parentData;
        }

        public final void invalidateIntrinsicsParent(boolean z11) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = this.f9922b.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = this.f9922b.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 != null && intrinsicsUsageByParent$ui_release != LayoutNode.UsageByParent.NotUsed) {
                while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                    parent$ui_release2 = parent$ui_release;
                }
                int i11 = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
                if (i11 == 1) {
                    parent$ui_release2.requestLookaheadRemeasure$ui_release(z11);
                } else if (i11 == 2) {
                    parent$ui_release2.requestLookaheadRelayout$ui_release(z11);
                } else {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (this.f9922b.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            LookaheadDelegate lookaheadDelegate$ui_release = getInnerCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            if (this.f9922b.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate$ui_release.isPlacingForAlignment$ui_release() && this.f9922b.getLookaheadLayoutPending$ui_release())) {
                this.f9922b.lookaheadLayoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = this.f9922b.getLayoutState$ui_release();
                this.f9922b.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.f9922b.layoutNode).getSnapshotObserver(), this.f9922b.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(this, this.f9922b, lookaheadDelegate$ui_release), 2, (Object) null);
                this.f9922b.layoutState = layoutState$ui_release;
                if (this.f9922b.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate$ui_release.isPlacingForAlignment$ui_release()) {
                    requestLayout();
                }
                this.f9922b.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        public int maxIntrinsicHeight(int i11) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicHeight(i11);
        }

        public int maxIntrinsicWidth(int i11) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicWidth(i11);
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4669measureBRTryo0(long j11) {
            trackLookaheadMeasurementByParent(this.f9922b.layoutNode);
            if (this.f9922b.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                this.f9922b.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m4670remeasureBRTryo0(j11);
            return this;
        }

        public int minIntrinsicHeight(int i11) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicHeight(i11);
        }

        public int minIntrinsicWidth(int i11) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicWidth(i11);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (this.f9922b.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List<LayoutNode> children$ui_release = this.f9922b.layoutNode.getChildren$ui_release();
                int size = children$ui_release.size();
                for (int i11 = 0; i11 < size; i11++) {
                    LayoutNode layoutNode = children$ui_release.get(i11);
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, (Object) null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutDelegate$ui_release.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                }
            }
        }

        public final void onPlaced() {
            if (!isPlaced()) {
                setPlaced(true);
                if (!this.isPreviouslyPlaced) {
                    requestSubtreeForLookahead();
                }
            }
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m4670remeasureBRTryo0(long j11) {
            boolean z11;
            boolean z12;
            boolean z13;
            LayoutNode parent$ui_release = this.f9922b.layoutNode.getParent$ui_release();
            LayoutNode access$getLayoutNode$p = this.f9922b.layoutNode;
            if (this.f9922b.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release())) {
                z11 = true;
            } else {
                z11 = false;
            }
            access$getLayoutNode$p.setCanMultiMeasure$ui_release(z11);
            if (!this.f9922b.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints = this.lookaheadConstraints;
                if (constraints == null) {
                    z13 = false;
                } else {
                    z13 = Constraints.m5415equalsimpl0(constraints.m5428unboximpl(), j11);
                }
                if (z13) {
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m5410boximpl(j11);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1.INSTANCE);
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                long IntSize = IntSizeKt.IntSize(lookaheadDelegate$ui_release.getWidth(), lookaheadDelegate$ui_release.getHeight());
                this.f9922b.m4664performLookaheadMeasureBRTryo0(j11);
                e(IntSizeKt.IntSize(lookaheadDelegate$ui_release.getWidth(), lookaheadDelegate$ui_release.getHeight()));
                if (IntSize.m5638getWidthimpl(IntSize) == lookaheadDelegate$ui_release.getWidth() && IntSize.m5637getHeightimpl(IntSize) == lookaheadDelegate$ui_release.getHeight()) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
        }

        public final void replace() {
            if (this.placedOnce) {
                d(this.lastPosition, 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(this.f9922b.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.f9922b.layoutNode, false, 1, (Object) null);
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z11) {
            this.childMeasurablesDirty = z11;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z11) {
            this.duringAlignmentLinesQuery = z11;
        }

        public void setPlaced(boolean z11) {
            this.isPlaced = z11;
        }

        public final boolean updateParentData() {
            Object parentData2 = getParentData();
            LookaheadDelegate lookaheadDelegate$ui_release = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            boolean z11 = !Intrinsics.areEqual(parentData2, lookaheadDelegate$ui_release.getParentData());
            LookaheadDelegate lookaheadDelegate$ui_release2 = this.f9922b.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release2);
            this.parentData = lookaheadDelegate$ui_release2.getParentData();
            return z11;
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bg\u0010hJ\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J@\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0002\b\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u001d\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J@\u0010\"\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0002\b\rH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0010J\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016J\u0006\u0010*\u001a\u00020\u001aJ\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 0+H\u0016J\u001c\u0010.\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\u0006\u00101\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u001aR\u0016\u00104\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00105R\"\u00107\u001a\u00020\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b7\u00105\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001f\u0010<\u001a\u00020\u00078\u0002@\u0002X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\b<\u0010=R)\u0010>\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0002\b\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR(\u0010D\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010B8\u0016@RX\u000e¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010I\u001a\u00020H8\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00010M8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bP\u00105\u001a\u0004\bQ\u00109\"\u0004\bR\u0010;R\u001c\u0010U\u001a\u0004\u0018\u00010\u00158Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\bV\u00109R\u0014\u0010Z\u001a\u00020W8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00010[8@X\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010`R\u0016\u0010f\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010e\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/LayoutNode;", "", "trackMeasurementByParent", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "placeOuterCoordinator-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeOuterCoordinator", "onIntrinsicsQueried", "onBeforeLayoutChildren", "layoutChildren", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "remeasure-BRTryo0", "(J)Z", "remeasure", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "get", "d", "replace", "height", "minIntrinsicWidth", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "updateParentData", "", "calculateAlignmentLines", "block", "forEachChildAlignmentLinesOwner", "requestLayout", "requestMeasure", "notifyChildrenUsingCoordinatesWhilePlacing", "forceRequest", "invalidateIntrinsicsParent", "measuredOnce", "Z", "placedOnce", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "()Z", "setDuringAlignmentLinesQuery$ui_release", "(Z)V", "lastPosition", "J", "lastLayerBlock", "Lkotlin/jvm/functions/Function1;", "lastZIndex", "F", "", "<set-?>", "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "childMeasurablesDirty", "getChildMeasurablesDirty$ui_release", "setChildMeasurablesDirty$ui_release", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "isPlaced", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getMeasuredWidth", "()I", "measuredWidth", "getMeasuredHeight", "measuredHeight", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        @NotNull
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        @NotNull
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        private boolean childMeasurablesDirty = true;
        private boolean duringAlignmentLinesQuery;
        @Nullable
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m5606getZeronOccac();
        private float lastZIndex;
        private boolean measuredOnce;
        @Nullable
        private Object parentData;
        private boolean placedOnce;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i11];
                    if (layoutNode.getMeasurePending$ui_release() && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m4620remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, (Object) null);
                    }
                    i11++;
                } while (i11 < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                int i11 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i11 == 1) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i11 != 2) {
                    usageByParent = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                } else {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        /* renamed from: placeOuterCoordinator-f8xVGno  reason: not valid java name */
        private final void m4671placeOuterCoordinatorf8xVGno(long j11, float f11, Function1<? super GraphicsLayerScope, Unit> function1) {
            this.lastPosition = j11;
            this.lastZIndex = f11;
            this.lastLayerBlock = function1;
            this.placedOnce = true;
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
            LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(function1, LayoutNodeLayoutDelegate.this, j11, f11));
        }

        private final void trackMeasurementByParent(LayoutNode layoutNode) {
            boolean z11;
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i11 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                    if (i11 == 1) {
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    } else if (i11 == 2) {
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    } else {
                        throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                    }
                    layoutNode.setMeasuredByParent$ui_release(usageByParent);
                    return;
                }
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + layoutNode.getMeasuredByParent$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + '.').toString());
            }
            layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }

        @NotNull
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            if (!IntOffset.m5595equalsimpl0(j11, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                Placeable.PlacementScope.place$default(companion, lookaheadPassDelegate$ui_release, IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11), 0.0f, 4, (Object) null);
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            m4671placeOuterCoordinatorf8xVGno(j11, f11, function1);
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        public void forEachChildAlignmentLinesOwner(@NotNull Function1<? super AlignmentLinesOwner, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            List<LayoutNode> children$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i11 = 0; i11 < size; i11++) {
                function1.invoke(children$ui_release.get(i11).getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
            }
        }

        public int get(@NotNull AlignmentLine alignmentLine) {
            LayoutNode.LayoutState layoutState;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState2 = null;
            if (parent$ui_release != null) {
                layoutState = parent$ui_release.getLayoutState$ui_release();
            } else {
                layoutState = null;
            }
            if (layoutState == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState2 = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState2 == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int i11 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i11;
        }

        @NotNull
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @NotNull
        public final List<Measurable> getChildMeasurables$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(LayoutNodeLayoutDelegate.this.layoutNode, this._childMeasurables, LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1.INSTANCE);
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @NotNull
        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        @Nullable
        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m4672getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m5410boximpl(c());
            }
            return null;
        }

        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        @Nullable
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
        }

        @Nullable
        public Object getParentData() {
            return this.parentData;
        }

        public final void invalidateIntrinsicsParent(boolean z11) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 != null && intrinsicsUsageByParent$ui_release != LayoutNode.UsageByParent.NotUsed) {
                while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                    parent$ui_release2 = parent$ui_release;
                }
                int i11 = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
                if (i11 == 1) {
                    parent$ui_release2.requestRemeasure$ui_release(z11);
                } else if (i11 == 2) {
                    parent$ui_release2.requestRelayout$ui_release(z11);
                } else {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public boolean isPlaced() {
            return LayoutNodeLayoutDelegate.this.layoutNode.isPlaced();
        }

        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner(access$getLayoutNode$p).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(access$getLayoutNode$p, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1(LayoutNodeLayoutDelegate.this, this, access$getLayoutNode$p));
                LayoutNodeLayoutDelegate.this.layoutState = layoutState$ui_release;
                if (getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        public int maxIntrinsicHeight(int i11) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(i11);
        }

        public int maxIntrinsicWidth(int i11) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(i11);
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4673measureBRTryo0(long j11) {
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
            if (intrinsicsUsageByParent$ui_release == usageByParent) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                this.measuredOnce = true;
                f(j11);
                LayoutNodeLayoutDelegate.this.layoutNode.setMeasuredByParentInLookahead$ui_release(usageByParent);
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.m4669measureBRTryo0(j11);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m4674remeasureBRTryo0(j11);
            return this;
        }

        public int minIntrinsicHeight(int i11) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(i11);
        }

        public int minIntrinsicWidth(int i11) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(i11);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List<LayoutNode> children$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
                int size = children$ui_release.size();
                for (int i11 = 0; i11 < size; i11++) {
                    LayoutNode layoutNode = children$ui_release.get(i11);
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, (Object) null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
            }
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m4674remeasureBRTryo0(long j11) {
            boolean z11;
            Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            boolean z12 = true;
            if (LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release())) {
                z11 = true;
            } else {
                z11 = false;
            }
            access$getLayoutNode$p.setCanMultiMeasure$ui_release(z11);
            if (LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() || !Constraints.m5415equalsimpl0(c(), j11)) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
                forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1.INSTANCE);
                this.measuredOnce = true;
                long r02 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().m4722getSizeYbymL2g();
                f(j11);
                LayoutNodeLayoutDelegate.this.m4665performMeasureBRTryo0(j11);
                if (IntSize.m5636equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().m4722getSizeYbymL2g(), r02) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                    z12 = false;
                }
                e(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
                return z12;
            }
            requireOwner.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
            return false;
        }

        public final void replace() {
            if (this.placedOnce) {
                m4671placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z11) {
            this.childMeasurablesDirty = z11;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z11) {
            this.duringAlignmentLinesQuery = z11;
        }

        public final boolean updateParentData() {
            boolean z11 = !Intrinsics.areEqual(getParentData(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData());
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return z11;
        }
    }

    public LayoutNodeLayoutDelegate(@NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    /* access modifiers changed from: private */
    public final boolean isOutMostLookaheadRoot(LayoutNode layoutNode2) {
        LookaheadScope mLookaheadScope$ui_release = layoutNode2.getMLookaheadScope$ui_release();
        return Intrinsics.areEqual((Object) mLookaheadScope$ui_release != null ? mLookaheadScope$ui_release.getRoot() : null, (Object) layoutNode2);
    }

    /* access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0  reason: not valid java name */
    public final void m4664performLookaheadMeasureBRTryo0(long j11) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new LayoutNodeLayoutDelegate$performLookaheadMeasure$1(this, j11), 2, (Object) null);
        markLookaheadLayoutPending$ui_release();
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    /* access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0  reason: not valid java name */
    public final void m4665performMeasureBRTryo0(long j11) {
        boolean z11;
        LayoutNode.LayoutState layoutState2 = this.layoutState;
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Idle;
        if (layoutState2 == layoutState3) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            LayoutNode.LayoutState layoutState4 = LayoutNode.LayoutState.Measuring;
            this.layoutState = layoutState4;
            this.measurePending = false;
            LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, new LayoutNodeLayoutDelegate$performMeasure$2(this, j11));
            if (this.layoutState == layoutState4) {
                markLayoutPending$ui_release();
                this.layoutState = layoutState3;
                return;
            }
            return;
        }
        throw new IllegalStateException("layout state is not idle before measure starts".toString());
    }

    @NotNull
    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    @Nullable
    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m4666getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m4672getLastConstraintsDWUhwKw();
    }

    @Nullable
    /* renamed from: getLastLookaheadConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m4667getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            return lookaheadPassDelegate2.m4668getLastConstraintsDWUhwKw();
        }
        return null;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    @NotNull
    public final LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    @Nullable
    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    @Nullable
    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    @NotNull
    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildMeasurablesDirty$ui_release(true);
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            lookaheadPassDelegate2.setChildMeasurablesDirty$ui_release(true);
        }
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void onLookaheadScopeChanged$ui_release(@Nullable LookaheadScope lookaheadScope) {
        LookaheadPassDelegate lookaheadPassDelegate2;
        if (lookaheadScope != null) {
            lookaheadPassDelegate2 = new LookaheadPassDelegate(this, lookaheadScope);
        } else {
            lookaheadPassDelegate2 = null;
        }
        this.lookaheadPassDelegate = lookaheadPassDelegate2;
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (alignmentLines = lookaheadPassDelegate2.getAlignmentLines()) != null) {
            alignmentLines.reset$ui_release();
        }
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int i11) {
        boolean z11;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        int i12 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = i11;
        boolean z12 = false;
        if (i12 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 == 0) {
            z12 = true;
        }
        if (z11 != z12) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                layoutNodeLayoutDelegate = parent$ui_release.getLayoutDelegate$ui_release();
            } else {
                layoutNodeLayoutDelegate = null;
            }
            if (layoutNodeLayoutDelegate == null) {
                return;
            }
            if (i11 == 0) {
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
            } else {
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z11) {
        if (this.coordinatesAccessedDuringPlacement != z11) {
            this.coordinatesAccessedDuringPlacement = z11;
            if (z11) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void updateParentData() {
        boolean z11;
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, 1, (Object) null);
        }
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 == null || !lookaheadPassDelegate2.updateParentData()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return;
        }
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release2 != null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, 1, (Object) null);
                return;
            }
            return;
        }
        LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
        if (parent$ui_release3 != null) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, 1, (Object) null);
        }
    }
}
