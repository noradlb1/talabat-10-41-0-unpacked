package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001ak\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"getAssembledSelectionInfo", "Landroidx/compose/foundation/text/selection/Selection;", "newSelectionRange", "Landroidx/compose/ui/text/TextRange;", "handlesCrossed", "", "selectableId", "", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getAssembledSelectionInfo-vJH6DeI", "(JZJLandroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/foundation/text/selection/Selection;", "getOffsetForPosition", "", "bounds", "Landroidx/compose/ui/geometry/Rect;", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-0AR0LA0", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/geometry/Rect;J)I", "getTextSelectionInfo", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "isStartHandle", "getTextSelectionInfo-yM0VcXU", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/geometry/Offset;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;Z)Lkotlin/Pair;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MultiWidgetSelectionDelegateKt {
    /* access modifiers changed from: private */
    /* renamed from: getAssembledSelectionInfo-vJH6DeI  reason: not valid java name */
    public static final Selection m957getAssembledSelectionInfovJH6DeI(long j11, boolean z11, long j12, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m5038getStartimpl(j11)), TextRange.m5038getStartimpl(j11), j12), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m5033getEndimpl(j11) - 1, 0)), TextRange.m5033getEndimpl(j11), j12), z11);
    }

    /* renamed from: getOffsetForPosition-0AR0LA0  reason: not valid java name */
    public static final int m958getOffsetForPosition0AR0LA0(@NotNull TextLayoutResult textLayoutResult, @NotNull Rect rect, long j11) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (rect.m2702containsk4lQ0M(j11)) {
            return RangesKt___RangesKt.coerceIn(textLayoutResult.m5013getOffsetForPositionk4lQ0M(j11), 0, length);
        }
        if (SelectionMode.Vertical.m1031compare3MmeM6k$foundation_release(j11, rect) < 0) {
            return 0;
        }
        return length;
    }

    @NotNull
    /* renamed from: getTextSelectionInfo-yM0VcXU  reason: not valid java name */
    public static final Pair<Selection, Boolean> m959getTextSelectionInfoyM0VcXU(@NotNull TextLayoutResult textLayoutResult, long j11, long j12, @Nullable Offset offset, long j13, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection, boolean z11) {
        int i11;
        TextRange textRange;
        boolean z12;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Selection selection2 = selection;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, (float) IntSize.m5638getWidthimpl(textLayoutResult.m5014getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(textLayoutResult.m5014getSizeYbymL2g()));
        if (!SelectionMode.Vertical.m1032isSelected2x9bVx0$foundation_release(rect, j11, j12)) {
            return new Pair<>(null, Boolean.FALSE);
        }
        int r92 = m958getOffsetForPosition0AR0LA0(textLayoutResult, rect, j11);
        int r102 = m958getOffsetForPosition0AR0LA0(textLayoutResult, rect, j12);
        if (offset != null) {
            i11 = m958getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.m2686unboximpl());
        } else {
            i11 = -1;
        }
        int i12 = i11;
        long TextRange = TextRangeKt.TextRange(r92, r102);
        if (selection2 != null) {
            textRange = TextRange.m5026boximpl(selection.m964toTextRanged9O1mEE());
        } else {
            textRange = null;
        }
        long r02 = selectionAdjustment.m965adjustZXO7KMw(textLayoutResult, TextRange, i12, z11, textRange);
        Selection r03 = m957getAssembledSelectionInfovJH6DeI(r02, TextRange.m5037getReversedimpl(r02), j13, textLayoutResult);
        boolean z13 = true;
        boolean z14 = !Intrinsics.areEqual((Object) r03, (Object) selection2);
        if (!z11 ? r102 == i12 : r92 == i12) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12 && !z14) {
            z13 = false;
        }
        return new Pair<>(r03, Boolean.valueOf(z13));
    }

    /* renamed from: getTextSelectionInfo-yM0VcXU$default  reason: not valid java name */
    public static /* synthetic */ Pair m960getTextSelectionInfoyM0VcXU$default(TextLayoutResult textLayoutResult, long j11, long j12, Offset offset, long j13, SelectionAdjustment selectionAdjustment, Selection selection, boolean z11, int i11, Object obj) {
        int i12 = i11;
        return m959getTextSelectionInfoyM0VcXU(textLayoutResult, j11, j12, offset, j13, selectionAdjustment, (i12 & 64) != 0 ? null : selection, (i12 & 128) != 0 ? true : z11);
    }
}
