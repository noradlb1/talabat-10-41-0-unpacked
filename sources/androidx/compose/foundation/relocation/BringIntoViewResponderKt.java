package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "completelyOverlaps", "", "Landroidx/compose/ui/geometry/Rect;", "other", "localRectOf", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BringIntoViewResponderKt {
    @NotNull
    @ExperimentalFoundationApi
    public static final Modifier bringIntoViewResponder(@NotNull Modifier modifier, @NotNull BringIntoViewResponder bringIntoViewResponder) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "responder");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BringIntoViewResponderKt$bringIntoViewResponder$$inlined$debugInspectorInfo$1(bringIntoViewResponder);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new BringIntoViewResponderKt$bringIntoViewResponder$2(bringIntoViewResponder));
    }

    /* access modifiers changed from: private */
    public static final boolean completelyOverlaps(Rect rect, Rect rect2) {
        if (rect.getLeft() > rect2.getLeft() || rect.getTop() > rect2.getTop() || rect.getRight() < rect2.getRight() || rect.getBottom() < rect2.getBottom()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Rect localRectOf(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, Rect rect) {
        return rect.m2713translatek4lQ0M(layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false).m2711getTopLeftF1C5BW0());
    }
}
