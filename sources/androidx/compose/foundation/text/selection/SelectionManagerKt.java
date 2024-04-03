package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0000\u001a!\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0018H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getCurrentSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "merge", "lhs", "rhs", "containsInclusive", "", "Landroidx/compose/ui/geometry/Rect;", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "visibleBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SelectionManagerKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.SelectionStart.ordinal()] = 1;
            iArr[Handle.SelectionEnd.ordinal()] = 2;
            iArr[Handle.Cursor.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1021calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull SelectionManager selectionManager, long j11) {
        int i11;
        Intrinsics.checkNotNullParameter(selectionManager, "manager");
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        if (draggingHandle == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        }
        if (i11 == -1) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        if (i11 == 1) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j11, selection.getStart(), true);
        }
        if (i11 == 2) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j11, selection.getEnd(), false);
        }
        if (i11 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager selectionManager, long j11, Selection.AnchorInfo anchorInfo, boolean z11) {
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates();
        if (containerLayoutCoordinates == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        int offset = anchorInfo.getOffset();
        if (!z11) {
            offset--;
        }
        Offset r62 = selectionManager.m1007getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r62);
        float r63 = Offset.m2676getXimpl(layoutCoordinates.m4474localPositionOfR5De75A(containerLayoutCoordinates, r62.m2686unboximpl()));
        long r32 = anchorSelectable$foundation_release.m962getRangeOfLineContainingjx7JFs(offset);
        Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.m5036getMinimpl(r32));
        Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(RangesKt___RangesKt.coerceAtLeast(TextRange.m5035getMaximpl(r32) - 1, TextRange.m5036getMinimpl(r32)));
        float coerceIn = RangesKt___RangesKt.coerceIn(r63, Math.min(boundingBox.getLeft(), boundingBox2.getLeft()), Math.max(boundingBox.getRight(), boundingBox2.getRight()));
        if (Math.abs(r63 - coerceIn) > ((float) (IntSize.m5638getWidthimpl(j11) / 2))) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        return containerLayoutCoordinates.m4474localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(coerceIn, Offset.m2677getYimpl(anchorSelectable$foundation_release.getBoundingBox(offset).m2706getCenterF1C5BW0())));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m1022containsInclusiveUv8p0NA(@NotNull Rect rect, long j11) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(rect, "$this$containsInclusive");
        float left = rect.getLeft();
        float right = rect.getRight();
        float r22 = Offset.m2676getXimpl(j11);
        if (left > r22 || r22 > right) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float r62 = Offset.m2677getYimpl(j11);
            if (top > r62 || r62 > bottom) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final AnnotatedString getCurrentSelectedText(@NotNull Selectable selectable, @NotNull Selection selection) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selection, "selection");
        AnnotatedString text = selectable.getText();
        if (selectable.getSelectableId() != selection.getStart().getSelectableId() && selectable.getSelectableId() != selection.getEnd().getSelectableId()) {
            return text;
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
            }
            return text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
        } else if (selectable.getSelectableId() == selection.getStart().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return text.subSequence(0, selection.getStart().getOffset());
            }
            return text.subSequence(selection.getStart().getOffset(), text.length());
        } else if (selection.getHandlesCrossed()) {
            return text.subSequence(selection.getEnd().getOffset(), text.length());
        } else {
            return text.subSequence(0, selection.getEnd().getOffset());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.merge(r1);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.Selection merge(@org.jetbrains.annotations.Nullable androidx.compose.foundation.text.selection.Selection r0, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.selection.Selection r1) {
        /*
            if (r0 == 0) goto L_0x000a
            androidx.compose.foundation.text.selection.Selection r0 = r0.merge(r1)
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r1 = r0
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManagerKt.merge(androidx.compose.foundation.text.selection.Selection, androidx.compose.foundation.text.selection.Selection):androidx.compose.foundation.text.selection.Selection");
    }

    @NotNull
    public static final Rect visibleBounds(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m2714Rect0a9Yr6o(layoutCoordinates.m4478windowToLocalMKHz9U(boundsInWindow.m2711getTopLeftF1C5BW0()), layoutCoordinates.m4478windowToLocalMKHz9U(boundsInWindow.m2705getBottomRightF1C5BW0()));
    }
}
