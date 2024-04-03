package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020 2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020\u00112\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020%2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010&\u001a\u0019\u0010'\u001a\u00020(*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\"\u0010\f\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000b\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006+"}, d2 = {"center", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", "getCenter-uvyYCjk$annotations", "(J)V", "getCenter-uvyYCjk", "(J)J", "isSpecified", "", "isSpecified-uvyYCjk$annotations", "isSpecified-uvyYCjk", "(J)Z", "isUnspecified", "isUnspecified-uvyYCjk$annotations", "isUnspecified-uvyYCjk", "Size", "width", "", "height", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-TmRCtEA", "(JLkotlin/jvm/functions/Function0;)J", "times", "", "size", "times-d16Qtg0", "(DJ)J", "(FJ)J", "", "(IJ)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SizeKt {
    @Stable
    public static final long Size(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return Size.m2736constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    /* renamed from: getCenter-uvyYCjk  reason: not valid java name */
    public static final long m2755getCenteruvyYCjk(long j11) {
        return OffsetKt.Offset(Size.m2745getWidthimpl(j11) / 2.0f, Size.m2742getHeightimpl(j11) / 2.0f);
    }

    @Stable
    /* renamed from: getCenter-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m2756getCenteruvyYCjk$annotations(long j11) {
    }

    /* renamed from: isSpecified-uvyYCjk  reason: not valid java name */
    public static final boolean m2757isSpecifieduvyYCjk(long j11) {
        return j11 != Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isSpecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m2758isSpecifieduvyYCjk$annotations(long j11) {
    }

    /* renamed from: isUnspecified-uvyYCjk  reason: not valid java name */
    public static final boolean m2759isUnspecifieduvyYCjk(long j11) {
        return j11 == Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isUnspecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m2760isUnspecifieduvyYCjk$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp-VgWVRYQ  reason: not valid java name */
    public static final long m2761lerpVgWVRYQ(long j11, long j12, float f11) {
        return Size(MathHelpersKt.lerp(Size.m2745getWidthimpl(j11), Size.m2745getWidthimpl(j12), f11), MathHelpersKt.lerp(Size.m2742getHeightimpl(j11), Size.m2742getHeightimpl(j12), f11));
    }

    /* renamed from: takeOrElse-TmRCtEA  reason: not valid java name */
    public static final long m2762takeOrElseTmRCtEA(long j11, @NotNull Function0<Size> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j11 != Size.Companion.m2753getUnspecifiedNHjbRc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        return function0.invoke().m2750unboximpl();
    }

    @Stable
    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m2765timesd16Qtg0(int i11, long j11) {
        return Size.m2748times7Ah8Wj8(j11, (float) i11);
    }

    @NotNull
    @Stable
    /* renamed from: toRect-uvyYCjk  reason: not valid java name */
    public static final Rect m2766toRectuvyYCjk(long j11) {
        return RectKt.m2716Recttz77jQw(Offset.Companion.m2692getZeroF1C5BW0(), j11);
    }

    @Stable
    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m2763timesd16Qtg0(double d11, long j11) {
        return Size.m2748times7Ah8Wj8(j11, (float) d11);
    }

    @Stable
    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m2764timesd16Qtg0(float f11, long j11) {
        return Size.m2748times7Ah8Wj8(j11, f11);
    }
}
