package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J!\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000b*\u00020\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LookaheadAlignmentLines;", "Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "c", "Landroidx/compose/ui/geometry/Offset;", "position", "a", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "", "b", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "alignmentLinesMap", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "<init>", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class LookaheadAlignmentLines extends AlignmentLines {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadAlignmentLines(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    public long a(@NotNull NodeCoordinator nodeCoordinator, long j11) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "$this$calculatePositionInParent");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        long r02 = lookaheadDelegate$ui_release.m4689getPositionnOccac();
        return Offset.m2681plusMKHz9U(OffsetKt.Offset((float) IntOffset.m5596getXimpl(r02), (float) IntOffset.m5597getYimpl(r02)), j11);
    }

    @NotNull
    public Map<AlignmentLine, Integer> b(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getAlignmentLines();
    }

    public int c(@NotNull NodeCoordinator nodeCoordinator, @NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.get(alignmentLine);
    }
}
