package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J8\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J@\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0014\u0010\u0019\u001a\u00020\n*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\bH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/foundation/text/selection/SelectionAdjustment$Companion$CharacterWithWordAccelerate$1", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjust", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelectionRange", "previousHandleOffset", "", "isStartHandle", "", "previousSelectionRange", "adjust-ZXO7KMw", "(Landroidx/compose/ui/text/TextLayoutResult;JIZLandroidx/compose/ui/text/TextRange;)J", "isExpanding", "newRawOffset", "previousRawOffset", "isStart", "previousReversed", "snapToWordBoundary", "currentLine", "otherBoundaryOffset", "isReversed", "updateSelectionBoundary", "previousAdjustedOffset", "isAtWordBoundary", "offset", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 implements SelectionAdjustment {
    private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i11) {
        long r02 = textLayoutResult.m5015getWordBoundaryjx7JFs(i11);
        if (i11 == TextRange.m5038getStartimpl(r02) || i11 == TextRange.m5033getEndimpl(r02)) {
            return true;
        }
        return false;
    }

    private final boolean isExpanding(int i11, int i12, boolean z11, boolean z12) {
        if (i12 == -1) {
            return true;
        }
        if (i11 == i12) {
            return false;
        }
        if (z11 ^ z12) {
            if (i11 < i12) {
                return true;
            }
        } else if (i11 > i12) {
            return true;
        }
        return false;
    }

    private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i11, int i12, int i13, boolean z11, boolean z12) {
        int i14;
        int i15;
        long r02 = textLayoutResult.m5015getWordBoundaryjx7JFs(i11);
        if (textLayoutResult.getLineForOffset(TextRange.m5038getStartimpl(r02)) == i12) {
            i14 = TextRange.m5038getStartimpl(r02);
        } else {
            i14 = textLayoutResult.getLineStart(i12);
        }
        if (textLayoutResult.getLineForOffset(TextRange.m5033getEndimpl(r02)) == i12) {
            i15 = TextRange.m5033getEndimpl(r02);
        } else {
            i15 = TextLayoutResult.getLineEnd$default(textLayoutResult, i12, false, 2, (Object) null);
        }
        if (i14 == i13) {
            return i15;
        }
        if (i15 == i13) {
            return i14;
        }
        int i16 = (i14 + i15) / 2;
        if (z11 ^ z12) {
            if (i11 <= i16) {
                return i14;
            }
        } else if (i11 < i16) {
            return i14;
        }
        return i15;
    }

    private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
        if (i11 == i12) {
            return i13;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(i11);
        if (lineForOffset != textLayoutResult.getLineForOffset(i13)) {
            return snapToWordBoundary(textLayoutResult, i11, lineForOffset, i14, z11, z12);
        }
        if (isExpanding(i11, i12, z11, z12) && isAtWordBoundary(textLayoutResult, i13)) {
            return snapToWordBoundary(textLayoutResult, i11, lineForOffset, i14, z11, z12);
        }
        return i11;
    }

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    public long m969adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j11, int i11, boolean z11, @Nullable TextRange textRange) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (textRange == null) {
            return SelectionAdjustment.Companion.f3662a.getWord().m965adjustZXO7KMw(textLayoutResult, j11, i11, z11, textRange);
        }
        if (TextRange.m5032getCollapsedimpl(j11)) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m5038getStartimpl(j11), StringsKt__StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z11, TextRange.m5037getReversedimpl(textRange.m5042unboximpl()));
        }
        if (z11) {
            i13 = updateSelectionBoundary(textLayoutResult, TextRange.m5038getStartimpl(j11), i11, TextRange.m5038getStartimpl(textRange.m5042unboximpl()), TextRange.m5033getEndimpl(j11), true, TextRange.m5037getReversedimpl(j11));
            i12 = TextRange.m5033getEndimpl(j11);
        } else {
            int r13 = TextRange.m5038getStartimpl(j11);
            i12 = updateSelectionBoundary(textLayoutResult, TextRange.m5033getEndimpl(j11), i11, TextRange.m5033getEndimpl(textRange.m5042unboximpl()), TextRange.m5038getStartimpl(j11), false, TextRange.m5037getReversedimpl(j11));
            i13 = r13;
        }
        return TextRangeKt.TextRange(i13, i12);
    }
}
