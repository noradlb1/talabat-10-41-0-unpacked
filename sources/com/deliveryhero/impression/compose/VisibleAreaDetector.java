package com.deliveryhero.impression.compose;

import androidx.annotation.IntRange;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bà\u0001\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/impression/compose/VisibleAreaDetector;", "", "calculateVisibleArea", "", "size", "Landroidx/compose/ui/unit/IntSize;", "boundsRect", "Landroidx/compose/ui/geometry/Rect;", "composeViewRect", "calculateVisibleArea-aZF9jCo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface VisibleAreaDetector {
    @IntRange(from = 0, to = 100)
    /* renamed from: calculateVisibleArea-aZF9jCo  reason: not valid java name */
    int m8232calculateVisibleAreaaZF9jCo(long j11, @NotNull Rect rect, @NotNull Rect rect2);
}
