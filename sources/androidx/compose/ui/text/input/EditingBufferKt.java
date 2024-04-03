package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m5179updateRangeAfterDeletepWDy79M(long j11, long j12) {
        int i11;
        int r02 = TextRange.m5036getMinimpl(j11);
        int r12 = TextRange.m5035getMaximpl(j11);
        if (TextRange.m5040intersects5zctL8(j12, j11)) {
            if (TextRange.m5028contains5zctL8(j12, j11)) {
                r02 = TextRange.m5036getMinimpl(j12);
                r12 = r02;
            } else if (TextRange.m5028contains5zctL8(j11, j12)) {
                i11 = TextRange.m5034getLengthimpl(j12);
            } else if (TextRange.m5029containsimpl(j12, r02)) {
                r02 = TextRange.m5036getMinimpl(j12);
                i11 = TextRange.m5034getLengthimpl(j12);
            } else {
                r12 = TextRange.m5036getMinimpl(j12);
            }
            return TextRangeKt.TextRange(r02, r12);
        }
        if (r12 > TextRange.m5036getMinimpl(j12)) {
            r02 -= TextRange.m5034getLengthimpl(j12);
            i11 = TextRange.m5034getLengthimpl(j12);
        }
        return TextRangeKt.TextRange(r02, r12);
        r12 -= i11;
        return TextRangeKt.TextRange(r02, r12);
    }
}
