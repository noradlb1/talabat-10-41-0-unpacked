package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0016J%\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010/J%\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010/R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u00020\u001a8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localLookaheadPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;J)J", "localPositionOf", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    @NotNull
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(@NotNull LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public int get(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }

    @NotNull
    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @NotNull
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Nullable
    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    @Nullable
    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m4501getSizeYbymL2g() {
        return getCoordinator().m4722getSizeYbymL2g();
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z11) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z11);
    }

    /* renamed from: localLookaheadPositionOf-R5De75A  reason: not valid java name */
    public long m4502localLookaheadPositionOfR5De75A(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates, long j11) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "sourceCoordinates");
        LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinatesImpl) lookaheadLayoutCoordinates).lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate$ui_release = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate2.getCoordinator()).getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            long r12 = lookaheadDelegate2.m4691positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(j11)), MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(j11)));
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r12) + IntOffset.m5596getXimpl(IntOffset), IntOffset.m5597getYimpl(r12) + IntOffset.m5597getYimpl(IntOffset));
            long r02 = this.lookaheadDelegate.m4691positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset2) - IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(IntOffset2) - IntOffset.m5597getYimpl(r02));
            return OffsetKt.Offset((float) IntOffset.m5596getXimpl(IntOffset3), (float) IntOffset.m5597getYimpl(IntOffset3));
        }
        LookaheadDelegate access$getRootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long r13 = lookaheadDelegate2.m4691positionInBjo55l4$ui_release(access$getRootLookaheadDelegate);
        long r32 = access$getRootLookaheadDelegate.m4689getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r13) + IntOffset.m5596getXimpl(r32), IntOffset.m5597getYimpl(r13) + IntOffset.m5597getYimpl(r32));
        long IntOffset5 = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(j11)), MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(j11)));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset4) + IntOffset.m5596getXimpl(IntOffset5), IntOffset.m5597getYimpl(IntOffset4) + IntOffset.m5597getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate3 = this.lookaheadDelegate;
        long r14 = lookaheadDelegate3.m4691positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3));
        long r33 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3).m4689getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r14) + IntOffset.m5596getXimpl(r33), IntOffset.m5597getYimpl(r14) + IntOffset.m5597getYimpl(r33));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset6) - IntOffset.m5596getXimpl(IntOffset7), IntOffset.m5597getYimpl(IntOffset6) - IntOffset.m5597getYimpl(IntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = access$getRootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.m4728localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset((float) IntOffset.m5596getXimpl(IntOffset8), (float) IntOffset.m5597getYimpl(IntOffset8)));
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m4503localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j11) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().m4728localPositionOfR5De75A(layoutCoordinates, j11);
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m4504localToRootMKHz9U(long j11) {
        return getCoordinator().m4729localToRootMKHz9U(j11);
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m4505localToWindowMKHz9U(long j11) {
        return getCoordinator().m4730localToWindowMKHz9U(j11);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m4506transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        getCoordinator().m4733transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m4507windowToLocalMKHz9U(long j11) {
        return getCoordinator().m4735windowToLocalMKHz9U(j11);
    }
}
