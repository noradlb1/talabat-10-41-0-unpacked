package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "(F)V", "getLineHeight", "()F", "chooseHeight", "", "text", "", "start", "", "end", "spanstartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 0;
    private final float lineHeight;

    public LineHeightSpan(float f11) {
        this.lineHeight = f11;
    }

    public void chooseHeight(@NotNull CharSequence charSequence, int i11, int i12, int i13, int i14, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        int lineHeight2 = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        if (lineHeight2 > 0) {
            int ceil = (int) ((float) Math.ceil((double) this.lineHeight));
            int ceil2 = (int) Math.ceil(((double) fontMetricsInt.descent) * ((double) ((((float) ceil) * 1.0f) / ((float) lineHeight2))));
            fontMetricsInt.descent = ceil2;
            fontMetricsInt.ascent = ceil2 - ceil;
        }
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }
}
