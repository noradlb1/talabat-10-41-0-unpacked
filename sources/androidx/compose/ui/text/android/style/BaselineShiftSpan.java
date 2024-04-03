package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/android/style/BaselineShiftSpan;", "Landroid/text/style/MetricAffectingSpan;", "multiplier", "", "(F)V", "getMultiplier", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public class BaselineShiftSpan extends MetricAffectingSpan {
    public static final int $stable = 0;
    private final float multiplier;

    public BaselineShiftSpan(float f11) {
        this.multiplier = f11;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.baselineShift += (int) ((float) Math.ceil((double) (textPaint.ascent() * this.multiplier)));
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.baselineShift += (int) ((float) Math.ceil((double) (textPaint.ascent() * this.multiplier)));
    }
}
