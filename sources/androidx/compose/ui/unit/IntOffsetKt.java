package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\"\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\"\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u001a\u0010\u0016\u001a\u00020\u0001*\u00020\u000eH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u0019\u001a\u00020\u000e*\u00020\u0001H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", "offset", "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i11, int i12) {
        return IntOffset.m5590constructorimpl((((long) i12) & 4294967295L) | (((long) i11) << 32));
    }

    @Stable
    /* renamed from: lerp-81ZRxRo  reason: not valid java name */
    public static final long m5607lerp81ZRxRo(long j11, long j12, float f11) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m5596getXimpl(j11), IntOffset.m5596getXimpl(j12), f11), MathHelpersKt.lerp(IntOffset.m5597getYimpl(j11), IntOffset.m5597getYimpl(j12), f11));
    }

    @Stable
    /* renamed from: minus-Nv-tHpc  reason: not valid java name */
    public static final long m5608minusNvtHpc(long j11, long j12) {
        return OffsetKt.Offset(Offset.m2676getXimpl(j11) - ((float) IntOffset.m5596getXimpl(j12)), Offset.m2677getYimpl(j11) - ((float) IntOffset.m5597getYimpl(j12)));
    }

    @Stable
    /* renamed from: minus-oCl6YwE  reason: not valid java name */
    public static final long m5609minusoCl6YwE(long j11, long j12) {
        return OffsetKt.Offset(((float) IntOffset.m5596getXimpl(j11)) - Offset.m2676getXimpl(j12), ((float) IntOffset.m5597getYimpl(j11)) - Offset.m2677getYimpl(j12));
    }

    @Stable
    /* renamed from: plus-Nv-tHpc  reason: not valid java name */
    public static final long m5610plusNvtHpc(long j11, long j12) {
        return OffsetKt.Offset(Offset.m2676getXimpl(j11) + ((float) IntOffset.m5596getXimpl(j12)), Offset.m2677getYimpl(j11) + ((float) IntOffset.m5597getYimpl(j12)));
    }

    @Stable
    /* renamed from: plus-oCl6YwE  reason: not valid java name */
    public static final long m5611plusoCl6YwE(long j11, long j12) {
        return OffsetKt.Offset(((float) IntOffset.m5596getXimpl(j11)) + Offset.m2676getXimpl(j12), ((float) IntOffset.m5597getYimpl(j11)) + Offset.m2677getYimpl(j12));
    }

    @Stable
    /* renamed from: round-k-4lQ0M  reason: not valid java name */
    public static final long m5612roundk4lQ0M(long j11) {
        return IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(j11)), MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(j11)));
    }

    @Stable
    /* renamed from: toOffset--gyyYBs  reason: not valid java name */
    public static final long m5613toOffsetgyyYBs(long j11) {
        return OffsetKt.Offset((float) IntOffset.m5596getXimpl(j11), (float) IntOffset.m5597getYimpl(j11));
    }
}
