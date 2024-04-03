package u;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Pair;

public final /* synthetic */ class a {
    public static /* synthetic */ Pair a(Selectable selectable, long j11, long j12, Offset offset, boolean z11, LayoutCoordinates layoutCoordinates, SelectionAdjustment selectionAdjustment, Selection selection, int i11, Object obj) {
        if (obj == null) {
            return selectable.m963updateSelectionqCDeeow(j11, j12, offset, (i11 & 8) != 0 ? true : z11, layoutCoordinates, selectionAdjustment, (i11 & 64) != 0 ? null : selection);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSelection-qCDeeow");
    }
}
