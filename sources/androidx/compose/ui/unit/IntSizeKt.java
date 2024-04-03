package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\"\u0010\f\u001a\u00020\u0002*\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0006\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i11, int i12) {
        return IntSize.m5633constructorimpl((((long) i12) & 4294967295L) | (((long) i11) << 32));
    }

    /* renamed from: getCenter-ozmzZPI  reason: not valid java name */
    public static final long m5644getCenterozmzZPI(long j11) {
        return IntOffsetKt.IntOffset(IntSize.m5638getWidthimpl(j11) / 2, IntSize.m5637getHeightimpl(j11) / 2);
    }

    @Stable
    /* renamed from: getCenter-ozmzZPI$annotations  reason: not valid java name */
    public static /* synthetic */ void m5645getCenterozmzZPI$annotations(long j11) {
    }

    @Stable
    /* renamed from: times-O0kMr_c  reason: not valid java name */
    public static final long m5646timesO0kMr_c(int i11, long j11) {
        return IntSize.m5640timesYEO4UFw(j11, i11);
    }

    @NotNull
    @Stable
    /* renamed from: toIntRect-ozmzZPI  reason: not valid java name */
    public static final IntRect m5647toIntRectozmzZPI(long j11) {
        return IntRectKt.m5628IntRectVbeCjmY(IntOffset.Companion.m5606getZeronOccac(), j11);
    }

    @Stable
    /* renamed from: toSize-ozmzZPI  reason: not valid java name */
    public static final long m5648toSizeozmzZPI(long j11) {
        return SizeKt.Size((float) IntSize.m5638getWidthimpl(j11), (float) IntSize.m5637getHeightimpl(j11));
    }
}
