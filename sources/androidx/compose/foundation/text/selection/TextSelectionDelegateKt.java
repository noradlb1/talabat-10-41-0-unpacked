package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(@NotNull TextLayoutResult textLayoutResult, int i11, boolean z11, boolean z12) {
        int i12;
        Intrinsics.checkNotNullParameter(textLayoutResult, "<this>");
        boolean z13 = false;
        if ((!z11 || z12) && (z11 || !z12)) {
            i12 = Math.max(i11 - 1, 0);
        } else {
            i12 = i11;
        }
        if (textLayoutResult.getBidiRunDirection(i12) == textLayoutResult.getParagraphDirection(i11)) {
            z13 = true;
        }
        return textLayoutResult.getHorizontalPosition(i11, z13);
    }

    public static final long getSelectionHandleCoordinates(@NotNull TextLayoutResult textLayoutResult, int i11, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        return OffsetKt.Offset(getHorizontalPosition(textLayoutResult, i11, z11, z12), textLayoutResult.getLineBottom(textLayoutResult.getLineForOffset(i11)));
    }
}
