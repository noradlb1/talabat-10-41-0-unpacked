package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"findParagraphEnd", "", "", "startIndex", "findParagraphStart", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class StringHelpersKt {
    public static final int findParagraphEnd(@NotNull CharSequence charSequence, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i12 = i11 + 1; i12 < length; i12++) {
            if (charSequence.charAt(i12) == 10) {
                return i12;
            }
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(@NotNull CharSequence charSequence, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i12 = i11 - 1; i12 > 0; i12--) {
            if (charSequence.charAt(i12 - 1) == 10) {
                return i12;
            }
        }
        return 0;
    }

    public static final long getParagraphBoundary(@NotNull CharSequence charSequence, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return TextRangeKt.TextRange(findParagraphStart(charSequence, i11), findParagraphEnd(charSequence, i11));
    }
}
