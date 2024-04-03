package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"ensureAtLeastOneChar", "Landroidx/compose/ui/text/TextRange;", "offset", "", "lastOffset", "isStartHandle", "", "previousHandlesCrossed", "(IIZZ)J", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(int i11, int i12, boolean z11, boolean z12) {
        if (i12 == 0) {
            return TextRangeKt.TextRange(i11, i11);
        }
        if (i11 == 0) {
            if (z11) {
                return TextRangeKt.TextRange(1, 0);
            }
            return TextRangeKt.TextRange(0, 1);
        } else if (i11 == i12) {
            if (z11) {
                return TextRangeKt.TextRange(i12 - 1, i12);
            }
            return TextRangeKt.TextRange(i12, i12 - 1);
        } else if (z11) {
            if (!z12) {
                return TextRangeKt.TextRange(i11 - 1, i11);
            }
            return TextRangeKt.TextRange(i11 + 1, i11);
        } else if (!z12) {
            return TextRangeKt.TextRange(i11, i11 + 1);
        } else {
            return TextRangeKt.TextRange(i11, i11 - 1);
        }
    }
}
