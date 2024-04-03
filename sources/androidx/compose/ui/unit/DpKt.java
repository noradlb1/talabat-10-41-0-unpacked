package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a%\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a%\u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00109\u001a-\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a-\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a-\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010C\u001a&\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a&\u0010J\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010I\u001a\"\u0010L\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010I\u001a\"\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010P\u001a\u00020\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010I\u001a*\u0010R\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010A\u001a+\u0010T\u001a\u00020\b*\u00020\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0VH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a+\u0010T\u001a\u00020\u0001*\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010VH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010T\u001a\u00020\u0002*\u00020\u00022\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020VH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b[\u0010Z\u001a\"\u0010\\\u001a\u00020\b*\u00020\t2\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\"\u0010\\\u001a\u00020\b*\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010I\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010.\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\"\u0010\\\u001a\u00020\b*\u00020\u00112\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010c\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\b*\u00020\t8Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\"\u0010\u0007\u001a\u00020\b*\u00020\u000e8Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u000f\u001a\u0004\b\f\u0010\u0010\"\"\u0010\u0007\u001a\u00020\b*\u00020\u00118Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\"\u0010\u0014\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\"\u0010\u001a\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u001e\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010$\"\"\u0010'\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u001e\"\"\u0010'\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010$\"\"\u0010'\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010$\"\"\u0010.\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b/\u0010\u0017\u001a\u0004\b0\u00101\"\"\u00102\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006d"}, d2 = {"center", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpSize;", "getCenter-EaSLcWc$annotations", "(J)V", "getCenter-EaSLcWc", "(J)J", "dp", "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isSpecified-jo-Fl9I$annotations", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "size", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "width", "getWidth$annotations", "getWidth", "DpOffset", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "DpSize", "DpSize-YgX7TsA", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "lerp-IDex15A", "max", "a", "b", "max-YgX7TsA", "(FF)F", "min", "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "takeOrElse-itqla9I", "times", "other", "times-3ABfNKs", "(DF)F", "times-6HolHcs", "(FJ)J", "(IF)F", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DpKt {
    @Stable
    /* renamed from: DpOffset-YgX7TsA  reason: not valid java name */
    public static final long m5499DpOffsetYgX7TsA(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return DpOffset.m5534constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    @Stable
    /* renamed from: DpSize-YgX7TsA  reason: not valid java name */
    public static final long m5500DpSizeYgX7TsA(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return DpSize.m5567constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    @Stable
    /* renamed from: coerceAtLeast-YgX7TsA  reason: not valid java name */
    public static final float m5501coerceAtLeastYgX7TsA(float f11, float f12) {
        return Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtLeast(f11, f12));
    }

    @Stable
    /* renamed from: coerceAtMost-YgX7TsA  reason: not valid java name */
    public static final float m5502coerceAtMostYgX7TsA(float f11, float f12) {
        return Dp.m5478constructorimpl(RangesKt___RangesKt.coerceAtMost(f11, f12));
    }

    @Stable
    /* renamed from: coerceIn-2z7ARbQ  reason: not valid java name */
    public static final float m5503coerceIn2z7ARbQ(float f11, float f12, float f13) {
        return Dp.m5478constructorimpl(RangesKt___RangesKt.coerceIn(f11, f12, f13));
    }

    /* renamed from: getCenter-EaSLcWc  reason: not valid java name */
    public static final long m5504getCenterEaSLcWc(long j11) {
        return m5499DpOffsetYgX7TsA(Dp.m5478constructorimpl(DpSize.m5576getWidthD9Ej5fM(j11) / 2.0f), Dp.m5478constructorimpl(DpSize.m5574getHeightD9Ej5fM(j11) / 2.0f));
    }

    @Stable
    /* renamed from: getCenter-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5505getCenterEaSLcWc$annotations(long j11) {
    }

    public static final float getDp(int i11) {
        return Dp.m5478constructorimpl((float) i11);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d11) {
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f11) {
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i11) {
    }

    public static final float getHeight(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return Dp.m5478constructorimpl(dpRect.m5560getBottomD9Ej5fM() - dpRect.m5563getTopD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return m5500DpSizeYgX7TsA(Dp.m5478constructorimpl(dpRect.m5562getRightD9Ej5fM() - dpRect.m5561getLeftD9Ej5fM()), Dp.m5478constructorimpl(dpRect.m5560getBottomD9Ej5fM() - dpRect.m5563getTopD9Ej5fM()));
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return Dp.m5478constructorimpl(dpRect.m5562getRightD9Ej5fM() - dpRect.m5561getLeftD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4  reason: not valid java name */
    public static final boolean m5506isFinite0680j_4(float f11) {
        return !(f11 == Float.POSITIVE_INFINITY);
    }

    @Stable
    /* renamed from: isFinite-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5507isFinite0680j_4$annotations(float f11) {
    }

    /* renamed from: isSpecified-0680j_4  reason: not valid java name */
    public static final boolean m5508isSpecified0680j_4(float f11) {
        return !Float.isNaN(f11);
    }

    @Stable
    /* renamed from: isSpecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5509isSpecified0680j_4$annotations(float f11) {
    }

    /* renamed from: isSpecified-EaSLcWc  reason: not valid java name */
    public static final boolean m5510isSpecifiedEaSLcWc(long j11) {
        return j11 != DpSize.Companion.m5585getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isSpecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5511isSpecifiedEaSLcWc$annotations(long j11) {
    }

    /* renamed from: isSpecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m5512isSpecifiedjoFl9I(long j11) {
        return j11 != DpOffset.Companion.m5548getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isSpecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m5513isSpecifiedjoFl9I$annotations(long j11) {
    }

    /* renamed from: isUnspecified-0680j_4  reason: not valid java name */
    public static final boolean m5514isUnspecified0680j_4(float f11) {
        return Float.isNaN(f11);
    }

    @Stable
    /* renamed from: isUnspecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5515isUnspecified0680j_4$annotations(float f11) {
    }

    /* renamed from: isUnspecified-EaSLcWc  reason: not valid java name */
    public static final boolean m5516isUnspecifiedEaSLcWc(long j11) {
        return j11 == DpSize.Companion.m5585getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isUnspecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5517isUnspecifiedEaSLcWc$annotations(long j11) {
    }

    /* renamed from: isUnspecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m5518isUnspecifiedjoFl9I(long j11) {
        return j11 == DpOffset.Companion.m5548getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isUnspecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m5519isUnspecifiedjoFl9I$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp-IDex15A  reason: not valid java name */
    public static final long m5520lerpIDex15A(long j11, long j12, float f11) {
        return m5500DpSizeYgX7TsA(m5521lerpMdfbLM(DpSize.m5576getWidthD9Ej5fM(j11), DpSize.m5576getWidthD9Ej5fM(j12), f11), m5521lerpMdfbLM(DpSize.m5574getHeightD9Ej5fM(j11), DpSize.m5574getHeightD9Ej5fM(j12), f11));
    }

    @Stable
    /* renamed from: lerp-Md-fbLM  reason: not valid java name */
    public static final float m5521lerpMdfbLM(float f11, float f12, float f13) {
        return Dp.m5478constructorimpl(MathHelpersKt.lerp(f11, f12, f13));
    }

    @Stable
    /* renamed from: lerp-xhh869w  reason: not valid java name */
    public static final long m5522lerpxhh869w(long j11, long j12, float f11) {
        return m5499DpOffsetYgX7TsA(m5521lerpMdfbLM(DpOffset.m5539getXD9Ej5fM(j11), DpOffset.m5539getXD9Ej5fM(j12), f11), m5521lerpMdfbLM(DpOffset.m5541getYD9Ej5fM(j11), DpOffset.m5541getYD9Ej5fM(j12), f11));
    }

    @Stable
    /* renamed from: max-YgX7TsA  reason: not valid java name */
    public static final float m5523maxYgX7TsA(float f11, float f12) {
        return Dp.m5478constructorimpl(Math.max(f11, f12));
    }

    @Stable
    /* renamed from: min-YgX7TsA  reason: not valid java name */
    public static final float m5524minYgX7TsA(float f11, float f12) {
        return Dp.m5478constructorimpl(Math.min(f11, f12));
    }

    /* renamed from: takeOrElse-D5KLDUw  reason: not valid java name */
    public static final float m5525takeOrElseD5KLDUw(float f11, @NotNull Function0<Dp> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!Float.isNaN(f11)) {
            return f11;
        }
        return function0.invoke().m5492unboximpl();
    }

    /* renamed from: takeOrElse-gVKV90s  reason: not valid java name */
    public static final long m5526takeOrElsegVKV90s(long j11, @NotNull Function0<DpOffset> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j11 != DpOffset.Companion.m5548getUnspecifiedRKDOV3M()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        return function0.invoke().m5547unboximpl();
    }

    /* renamed from: takeOrElse-itqla9I  reason: not valid java name */
    public static final long m5527takeOrElseitqla9I(long j11, @NotNull Function0<DpSize> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j11 != DpSize.Companion.m5585getUnspecifiedMYxV2XQ()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        return function0.invoke().m5584unboximpl();
    }

    @Stable
    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5529times3ABfNKs(float f11, float f12) {
        return Dp.m5478constructorimpl(f11 * f12);
    }

    @Stable
    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m5532times6HolHcs(int i11, long j11) {
        return DpSize.m5582timesGh9hcWk(j11, i11);
    }

    public static final float getDp(double d11) {
        return Dp.m5478constructorimpl((float) d11);
    }

    @Stable
    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5528times3ABfNKs(double d11, float f11) {
        return Dp.m5478constructorimpl(((float) d11) * f11);
    }

    @Stable
    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m5531times6HolHcs(float f11, long j11) {
        return DpSize.m5581timesGh9hcWk(j11, f11);
    }

    public static final float getDp(float f11) {
        return Dp.m5478constructorimpl(f11);
    }

    @Stable
    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5530times3ABfNKs(int i11, float f11) {
        return Dp.m5478constructorimpl(((float) i11) * f11);
    }
}
