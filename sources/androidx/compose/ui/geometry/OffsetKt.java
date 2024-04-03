package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"!\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OffsetKt {
    @Stable
    public static final long Offset(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return Offset.m2668constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    /* renamed from: isFinite-k-4lQ0M  reason: not valid java name */
    public static final boolean m2693isFinitek4lQ0M(long j11) {
        float r02 = Offset.m2676getXimpl(j11);
        if (!Float.isInfinite(r02) && !Float.isNaN(r02)) {
            float r42 = Offset.m2677getYimpl(j11);
            if (!Float.isInfinite(r42) && !Float.isNaN(r42)) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: isFinite-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m2694isFinitek4lQ0M$annotations(long j11) {
    }

    /* renamed from: isSpecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m2695isSpecifiedk4lQ0M(long j11) {
        return j11 != Offset.Companion.m2691getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isSpecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m2696isSpecifiedk4lQ0M$annotations(long j11) {
    }

    /* renamed from: isUnspecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m2697isUnspecifiedk4lQ0M(long j11) {
        return j11 == Offset.Companion.m2691getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isUnspecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m2698isUnspecifiedk4lQ0M$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp-Wko1d7g  reason: not valid java name */
    public static final long m2699lerpWko1d7g(long j11, long j12, float f11) {
        return Offset(MathHelpersKt.lerp(Offset.m2676getXimpl(j11), Offset.m2676getXimpl(j12), f11), MathHelpersKt.lerp(Offset.m2677getYimpl(j11), Offset.m2677getYimpl(j12), f11));
    }

    /* renamed from: takeOrElse-3MmeM6k  reason: not valid java name */
    public static final long m2700takeOrElse3MmeM6k(long j11, @NotNull Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (m2695isSpecifiedk4lQ0M(j11)) {
            return j11;
        }
        return function0.invoke().m2686unboximpl();
    }
}
