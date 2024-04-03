package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\fH\u0002\u001a+\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019\u001a\"\u0010 \u001a\u00020\u0016*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006$"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f11, float f12) {
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        return ScaleFactor.m4543constructorimpl((((long) Float.floatToIntBits(f12)) & 4294967295L) | (floatToIntBits << 32));
    }

    @Stable
    /* renamed from: div-UQTWf7w  reason: not valid java name */
    public static final long m4557divUQTWf7w(long j11, long j12) {
        return SizeKt.Size(Size.m2745getWidthimpl(j11) / ScaleFactor.m4549getScaleXimpl(j12), Size.m2742getHeightimpl(j11) / ScaleFactor.m4550getScaleYimpl(j12));
    }

    /* renamed from: isSpecified-FK8aYYs  reason: not valid java name */
    public static final boolean m4558isSpecifiedFK8aYYs(long j11) {
        return j11 != ScaleFactor.Companion.m4556getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isSpecified-FK8aYYs$annotations  reason: not valid java name */
    public static /* synthetic */ void m4559isSpecifiedFK8aYYs$annotations(long j11) {
    }

    /* renamed from: isUnspecified-FK8aYYs  reason: not valid java name */
    public static final boolean m4560isUnspecifiedFK8aYYs(long j11) {
        return j11 == ScaleFactor.Companion.m4556getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isUnspecified-FK8aYYs$annotations  reason: not valid java name */
    public static /* synthetic */ void m4561isUnspecifiedFK8aYYs$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp--bDIf60  reason: not valid java name */
    public static final long m4562lerpbDIf60(long j11, long j12, float f11) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m4549getScaleXimpl(j11), ScaleFactor.m4549getScaleXimpl(j12), f11), MathHelpersKt.lerp(ScaleFactor.m4550getScaleYimpl(j11), ScaleFactor.m4550getScaleYimpl(j12), f11));
    }

    /* access modifiers changed from: private */
    public static final float roundToTenths(float f11) {
        float f12 = (float) 10;
        float f13 = f11 * f12;
        int i11 = (int) f13;
        if (f13 - ((float) i11) >= 0.5f) {
            i11++;
        }
        return ((float) i11) / f12;
    }

    /* renamed from: takeOrElse-oyDd2qo  reason: not valid java name */
    public static final long m4563takeOrElseoyDd2qo(long j11, @NotNull Function0<ScaleFactor> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j11 != ScaleFactor.Companion.m4556getUnspecified_hLwfpc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        return function0.invoke().m4554unboximpl();
    }

    @Stable
    /* renamed from: times-UQTWf7w  reason: not valid java name */
    public static final long m4564timesUQTWf7w(long j11, long j12) {
        return SizeKt.Size(Size.m2745getWidthimpl(j11) * ScaleFactor.m4549getScaleXimpl(j12), Size.m2742getHeightimpl(j11) * ScaleFactor.m4550getScaleYimpl(j12));
    }

    @Stable
    /* renamed from: times-m-w2e94  reason: not valid java name */
    public static final long m4565timesmw2e94(long j11, long j12) {
        return m4564timesUQTWf7w(j12, j11);
    }
}
