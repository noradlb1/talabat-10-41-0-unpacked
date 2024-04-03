package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002\u001a\u001f\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000b\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000e\u001a!\u0010\u0012\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015\u001a!\u0010\u0019\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Constraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "size", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ConstraintsKt {
    @Stable
    public static final long Constraints(int i11, int i12, int i13, int i14) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (i12 >= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i14 >= i13) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i11 < 0 || i13 < 0) {
                    z13 = false;
                }
                if (z13) {
                    return Constraints.Companion.m5429createConstraintsZbe2FdA$ui_unit_release(i11, i12, i13, i14);
                }
                throw new IllegalArgumentException(("minWidth(" + i11 + ") and minHeight(" + i13 + ") must be >= 0").toString());
            }
            throw new IllegalArgumentException(("maxHeight(" + i14 + ") must be >= than minHeight(" + i13 + ')').toString());
        }
        throw new IllegalArgumentException(("maxWidth(" + i12 + ") must be >= than minWidth(" + i11 + ')').toString());
    }

    public static /* synthetic */ long Constraints$default(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = 0;
        }
        if ((i15 & 2) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        if ((i15 & 4) != 0) {
            i13 = 0;
        }
        if ((i15 & 8) != 0) {
            i14 = Integer.MAX_VALUE;
        }
        return Constraints(i11, i12, i13, i14);
    }

    private static final int addMaxWithMinimum(int i11, int i12) {
        return i11 == Integer.MAX_VALUE ? i11 : RangesKt___RangesKt.coerceAtLeast(i11 + i12, 0);
    }

    @Stable
    /* renamed from: constrain-4WqzIAM  reason: not valid java name */
    public static final long m5433constrain4WqzIAM(long j11, long j12) {
        return IntSizeKt.IntSize(RangesKt___RangesKt.coerceIn(IntSize.m5638getWidthimpl(j12), Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11)), RangesKt___RangesKt.coerceIn(IntSize.m5637getHeightimpl(j12), Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11)));
    }

    /* renamed from: constrain-N9IONVI  reason: not valid java name */
    public static final long m5434constrainN9IONVI(long j11, long j12) {
        return Constraints(RangesKt___RangesKt.coerceIn(Constraints.m5424getMinWidthimpl(j12), Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11)), RangesKt___RangesKt.coerceIn(Constraints.m5422getMaxWidthimpl(j12), Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11)), RangesKt___RangesKt.coerceIn(Constraints.m5423getMinHeightimpl(j12), Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11)), RangesKt___RangesKt.coerceIn(Constraints.m5421getMaxHeightimpl(j12), Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11)));
    }

    @Stable
    /* renamed from: constrainHeight-K40F9xA  reason: not valid java name */
    public static final int m5435constrainHeightK40F9xA(long j11, int i11) {
        return RangesKt___RangesKt.coerceIn(i11, Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11));
    }

    @Stable
    /* renamed from: constrainWidth-K40F9xA  reason: not valid java name */
    public static final int m5436constrainWidthK40F9xA(long j11, int i11) {
        return RangesKt___RangesKt.coerceIn(i11, Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11));
    }

    @Stable
    /* renamed from: isSatisfiedBy-4WqzIAM  reason: not valid java name */
    public static final boolean m5437isSatisfiedBy4WqzIAM(long j11, long j12) {
        int r02 = Constraints.m5424getMinWidthimpl(j11);
        int r12 = Constraints.m5422getMaxWidthimpl(j11);
        int r22 = IntSize.m5638getWidthimpl(j12);
        if (r02 <= r22 && r22 <= r12) {
            int r03 = Constraints.m5423getMinHeightimpl(j11);
            int r52 = Constraints.m5421getMaxHeightimpl(j11);
            int r62 = IntSize.m5637getHeightimpl(j12);
            if (r03 <= r62 && r62 <= r52) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: offset-NN6Ew-U  reason: not valid java name */
    public static final long m5438offsetNN6EwU(long j11, int i11, int i12) {
        return Constraints(RangesKt___RangesKt.coerceAtLeast(Constraints.m5424getMinWidthimpl(j11) + i11, 0), addMaxWithMinimum(Constraints.m5422getMaxWidthimpl(j11), i11), RangesKt___RangesKt.coerceAtLeast(Constraints.m5423getMinHeightimpl(j11) + i12, 0), addMaxWithMinimum(Constraints.m5421getMaxHeightimpl(j11), i12));
    }

    /* renamed from: offset-NN6Ew-U$default  reason: not valid java name */
    public static /* synthetic */ long m5439offsetNN6EwU$default(long j11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return m5438offsetNN6EwU(j11, i11, i12);
    }
}
