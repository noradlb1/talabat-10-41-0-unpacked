package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a!\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "TextDrawStyleKt")
public final class TextDrawStyleKt {
    @NotNull
    public static final TextForegroundStyle lerp(@NotNull TextForegroundStyle textForegroundStyle, @NotNull TextForegroundStyle textForegroundStyle2, float f11) {
        Intrinsics.checkNotNullParameter(textForegroundStyle, "start");
        Intrinsics.checkNotNullParameter(textForegroundStyle2, TraceLogKt.STOP_PROPERTY_NAME);
        boolean z11 = textForegroundStyle instanceof BrushStyle;
        if (!z11 && !(textForegroundStyle2 instanceof BrushStyle)) {
            return TextForegroundStyle.Companion.m5386from8_81llA(ColorKt.m2971lerpjxsXWHM(textForegroundStyle.m5385getColor0d7_KjU(), textForegroundStyle2.m5385getColor0d7_KjU(), f11));
        }
        if (!z11 || !(textForegroundStyle2 instanceof BrushStyle)) {
            return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, f11);
        }
        return TextForegroundStyle.Companion.from((Brush) SpanStyleKt.lerpDiscrete(((BrushStyle) textForegroundStyle).getBrush(), ((BrushStyle) textForegroundStyle2).getBrush(), f11), MathHelpersKt.lerp(textForegroundStyle.getAlpha(), textForegroundStyle2.getAlpha(), f11));
    }

    /* renamed from: modulate-DxMtmZc  reason: not valid java name */
    public static final long m5384modulateDxMtmZc(long j11, float f11) {
        if (Float.isNaN(f11) || f11 >= 1.0f) {
            return j11;
        }
        return Color.m2918copywmQWz5c$default(j11, Color.m2921getAlphaimpl(j11) * f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final float takeOrElse(float f11, Function0<Float> function0) {
        return Float.isNaN(f11) ? function0.invoke().floatValue() : f11;
    }
}
