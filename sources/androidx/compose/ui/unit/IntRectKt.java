package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "offset", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IntRectKt {
    @NotNull
    @Stable
    /* renamed from: IntRect-E1MhUcY  reason: not valid java name */
    public static final IntRect m5627IntRectE1MhUcY(long j11, long j12) {
        return new IntRect(IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11), IntOffset.m5596getXimpl(j12), IntOffset.m5597getYimpl(j12));
    }

    @NotNull
    @Stable
    /* renamed from: IntRect-VbeCjmY  reason: not valid java name */
    public static final IntRect m5628IntRectVbeCjmY(long j11, long j12) {
        return new IntRect(IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11), IntOffset.m5596getXimpl(j11) + IntSize.m5638getWidthimpl(j12), IntOffset.m5597getYimpl(j11) + IntSize.m5637getHeightimpl(j12));
    }

    @NotNull
    @Stable
    /* renamed from: IntRect-ar5cAso  reason: not valid java name */
    public static final IntRect m5629IntRectar5cAso(long j11, int i11) {
        return new IntRect(IntOffset.m5596getXimpl(j11) - i11, IntOffset.m5597getYimpl(j11) - i11, IntOffset.m5596getXimpl(j11) + i11, IntOffset.m5597getYimpl(j11) + i11);
    }

    @NotNull
    @Stable
    public static final IntRect lerp(@NotNull IntRect intRect, @NotNull IntRect intRect2, float f11) {
        Intrinsics.checkNotNullParameter(intRect, "start");
        Intrinsics.checkNotNullParameter(intRect2, TraceLogKt.STOP_PROPERTY_NAME);
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f11), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f11), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f11), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f11));
    }
}
