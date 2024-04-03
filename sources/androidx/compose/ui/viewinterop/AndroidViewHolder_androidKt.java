package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Unmeasured", "", "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "type", "(I)I", "layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "toComposeOffset", "", "toComposeVelocity", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder_androidKt {
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* access modifiers changed from: private */
    public static final void layoutAccordingTo(View view, LayoutNode layoutNode) {
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(positionInRoot));
        int roundToInt2 = MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(positionInRoot));
        view.layout(roundToInt, roundToInt2, view.getMeasuredWidth() + roundToInt, view.getMeasuredHeight() + roundToInt2);
    }

    /* access modifiers changed from: private */
    public static final float toComposeOffset(int i11) {
        return ((float) i11) * ((float) -1);
    }

    /* access modifiers changed from: private */
    public static final float toComposeVelocity(float f11) {
        return f11 * -1.0f;
    }

    /* access modifiers changed from: private */
    public static final int toNestedScrollSource(int i11) {
        if (i11 == 0) {
            return NestedScrollSource.Companion.m4218getDragWNlRxjI();
        }
        return NestedScrollSource.Companion.m4219getFlingWNlRxjI();
    }
}
