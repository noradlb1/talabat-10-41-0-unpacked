package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b3\u0010\nJ\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u000f\u0010\u000b\u001a\u00020\bH ¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\b*\u00020\fH\u0004R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00188&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0012R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8 X \u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "get", "calculateAlignmentLine", "", "replace$ui_release", "()V", "replace", "Landroidx/compose/ui/node/NodeCoordinator;", "g", "", "isShallowPlacing", "Z", "isShallowPlacing$ui_release", "()Z", "setShallowPlacing$ui_release", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "position", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "child", "getParent", "parent", "getHasMeasureResult", "hasMeasureResult", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "<init>", "ui_release"}, k = 1, mv = {1, 7, 1})
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode {
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;

    public abstract int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine);

    public final void g(@NotNull NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode;
        AlignmentLines alignmentLines;
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        NodeCoordinator wrapped$ui_release = nodeCoordinator.getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            layoutNode = wrapped$ui_release.getLayoutNode();
        } else {
            layoutNode = null;
        }
        if (!Intrinsics.areEqual((Object) layoutNode, (Object) nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner != null && (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) != null) {
            alignmentLines.onAlignmentsChanged();
        }
    }

    public final int get(@NotNull AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        int i11;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (!getHasMeasureResult() || (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            i11 = IntOffset.m5596getXimpl(a());
        } else {
            i11 = IntOffset.m5597getYimpl(a());
        }
        return calculateAlignmentLine + i11;
    }

    @NotNull
    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    @Nullable
    public abstract LookaheadCapablePlaceable getChild();

    @NotNull
    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @NotNull
    public abstract LayoutNode getLayoutNode();

    @NotNull
    public abstract MeasureResult getMeasureResult$ui_release();

    @Nullable
    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public abstract long m4675getPositionnOccac();

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public /* synthetic */ MeasureResult layout(int i11, int i12, Map map, Function1 function1) {
        return MeasureScope.CC.a(this, i11, i12, map, function1);
    }

    public abstract void replace$ui_release();

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m4676roundToPxR2X_6o(long j11) {
        return a.a(this, j11);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m4677roundToPx0680j_4(float f11) {
        return a.b(this, f11);
    }

    public final void setPlacingForAlignment$ui_release(boolean z11) {
        this.isPlacingForAlignment = z11;
    }

    public final void setShallowPlacing$ui_release(boolean z11) {
        this.isShallowPlacing = z11;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m4678toDpGaN1DYA(long j11) {
        return a.c(this, j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m4679toDpu2uoSUM(float f11) {
        return a.d(this, f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m4680toDpu2uoSUM(int i11) {
        return a.e(this, i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m4681toDpSizekrfVVM(long j11) {
        return a.f(this, j11);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m4682toPxR2X_6o(long j11) {
        return a.g(this, j11);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m4683toPx0680j_4(float f11) {
        return a.h(this, f11);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m4684toSizeXkaWNTQ(long j11) {
        return a.j(this, j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m4685toSp0xMU5do(float f11) {
        return a.k(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m4686toSpkPz2Gy4(float f11) {
        return a.l(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m4687toSpkPz2Gy4(int i11) {
        return a.m(this, i11);
    }
}
