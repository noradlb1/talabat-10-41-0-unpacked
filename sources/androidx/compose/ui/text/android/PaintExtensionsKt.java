package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a,\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a$\u0010\u000b\u001a\u00020\u0002*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0000\u001a$\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¨\u0006\u0010"}, d2 = {"extendWith", "", "Landroid/graphics/Rect;", "rect", "fillStringBounds", "Landroid/graphics/Paint;", "text", "", "start", "", "end", "getCharSequenceBounds", "Landroid/text/TextPaint;", "startInclusive", "endExclusive", "getStringBounds", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaintExtensionsKt {
    private static final void extendWith(Rect rect, Rect rect2) {
        rect.right += rect2.width();
        rect.top = Math.min(rect.top, rect2.top);
        rect.bottom = Math.max(rect.bottom, rect2.bottom);
    }

    private static final void fillStringBounds(Paint paint, CharSequence charSequence, int i11, int i12, Rect rect) {
        if (Build.VERSION.SDK_INT >= 29) {
            Paint29.getTextBounds(paint, charSequence, i11, i12, rect);
        } else {
            paint.getTextBounds(charSequence.toString(), i11, i12, rect);
        }
    }

    @NotNull
    public static final Rect getCharSequenceBounds(@NotNull TextPaint textPaint, @NotNull CharSequence charSequence, int i11, int i12) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Class<MetricAffectingSpan> cls = MetricAffectingSpan.class;
            if (SpannedExtensionsKt.hasSpan(spanned, cls, i11, i12)) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i11 < i12) {
                    int nextSpanTransition = spanned.nextSpanTransition(i11, i12, cls);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i11, nextSpanTransition, cls);
                    textPaint2.set(textPaint);
                    Intrinsics.checkNotNullExpressionValue(metricAffectingSpanArr, "spans");
                    for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    fillStringBounds(textPaint2, charSequence, i11, nextSpanTransition, rect2);
                    extendWith(rect, rect2);
                    i11 = nextSpanTransition;
                }
                return rect;
            }
        }
        return getStringBounds(textPaint, charSequence, i11, i12);
    }

    @NotNull
    @VisibleForTesting
    public static final Rect getStringBounds(@NotNull Paint paint, @NotNull CharSequence charSequence, int i11, int i12) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Rect rect = new Rect();
        fillStringBounds(paint, charSequence, i11, i12, rect);
        return rect;
    }
}
