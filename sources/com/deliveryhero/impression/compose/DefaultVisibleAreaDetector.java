package com.deliveryhero.impression.compose;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Lcom/deliveryhero/impression/compose/DefaultVisibleAreaDetector;", "Lcom/deliveryhero/impression/compose/VisibleAreaDetector;", "()V", "calculateVisibleArea", "", "size", "Landroidx/compose/ui/unit/IntSize;", "boundsRect", "Landroidx/compose/ui/geometry/Rect;", "composeViewRect", "calculateVisibleArea-aZF9jCo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultVisibleAreaDetector implements VisibleAreaDetector {
    @NotNull
    public static final DefaultVisibleAreaDetector INSTANCE = new DefaultVisibleAreaDetector();

    private DefaultVisibleAreaDetector() {
    }

    /* renamed from: calculateVisibleArea-aZF9jCo  reason: not valid java name */
    public int m8231calculateVisibleAreaaZF9jCo(long j11, @NotNull Rect rect, @NotNull Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "boundsRect");
        Intrinsics.checkNotNullParameter(rect2, "composeViewRect");
        int r02 = IntSize.m5638getWidthimpl(j11) * IntSize.m5637getHeightimpl(j11);
        if (r02 == 0) {
            return 0;
        }
        float min = Math.min(rect.getBottom(), rect2.getBottom()) - Math.max(rect.getTop(), rect2.getTop());
        if (min >= 0.0f && min <= ((float) IntSize.m5637getHeightimpl(j11))) {
            float min2 = Math.min(rect.getRight(), rect2.getRight()) - Math.max(rect.getLeft(), rect2.getLeft());
            if (min2 >= 0.0f && min2 <= ((float) IntSize.m5638getWidthimpl(j11))) {
                return (int) (((min2 * min) / ((float) r02)) * ((float) 100));
            }
        }
        return 0;
    }
}
