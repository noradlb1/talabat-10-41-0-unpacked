package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J8\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J'\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b%R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "(FIIZZF)V", "ascent", "descent", "firstAscent", "<set-?>", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescent", "lastDescentDiff", "getLastDescentDiff", "getLineHeight", "()F", "getTrimLastLineBottom", "()Z", "calculateTargetMetrics", "", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "text", "", "start", "end", "spanStartVertical", "copy", "copy$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class LineHeightStyleSpan implements LineHeightSpan {
    public static final int $stable = 8;
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    public LineHeightStyleSpan(float f11, int i11, int i12, boolean z11, boolean z12, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        boolean z13;
        boolean z14;
        this.lineHeight = f11;
        this.startIndex = i11;
        this.endIndex = i12;
        this.trimFirstLineTop = z11;
        this.trimLastLineBottom = z12;
        this.topRatio = f12;
        boolean z15 = true;
        if (0.0f > f12 || f12 > 1.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z13) {
            if (f12 == -1.0f) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (!z14) {
                z15 = false;
            }
        }
        if (!z15) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        boolean z11;
        double d11;
        int lineHeight2 = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        int ceil = (int) ((float) Math.ceil((double) this.lineHeight));
        int i11 = ceil - lineHeight2;
        float f11 = this.topRatio;
        if (f11 == -1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f11 = Math.abs((float) fontMetricsInt.ascent) / ((float) LineHeightStyleSpanKt.lineHeight(fontMetricsInt));
        }
        if (i11 <= 0) {
            d11 = Math.ceil((double) (((float) i11) * f11));
        } else {
            d11 = Math.ceil((double) (((float) i11) * (1.0f - f11)));
        }
        int i12 = fontMetricsInt.descent;
        int i13 = ((int) ((float) d11)) + i12;
        this.descent = i13;
        int i14 = i13 - ceil;
        this.ascent = i14;
        if (this.trimFirstLineTop) {
            i14 = fontMetricsInt.ascent;
        }
        this.firstAscent = i14;
        if (this.trimLastLineBottom) {
            i13 = i12;
        }
        this.lastDescent = i13;
        this.firstAscentDiff = fontMetricsInt.ascent - i14;
        this.lastDescentDiff = i13 - i12;
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text_release$default(LineHeightStyleSpan lineHeightStyleSpan, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            z11 = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text_release(i11, i12, z11);
    }

    public void chooseHeight(@NotNull CharSequence charSequence, int i11, int i12, int i13, int i14, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        boolean z11;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (LineHeightStyleSpanKt.lineHeight(fontMetricsInt) > 0) {
            boolean z12 = true;
            if (i11 == this.startIndex) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i12 != this.endIndex) {
                z12 = false;
            }
            if (!z11 || !z12 || !this.trimFirstLineTop || !this.trimLastLineBottom) {
                if (z11) {
                    calculateTargetMetrics(fontMetricsInt);
                }
                if (z11) {
                    i15 = this.firstAscent;
                } else {
                    i15 = this.ascent;
                }
                fontMetricsInt.ascent = i15;
                if (z12) {
                    i16 = this.lastDescent;
                } else {
                    i16 = this.descent;
                }
                fontMetricsInt.descent = i16;
            }
        }
    }

    @NotNull
    public final LineHeightStyleSpan copy$ui_text_release(int i11, int i12, boolean z11) {
        return new LineHeightStyleSpan(this.lineHeight, i11, i12, z11, this.trimLastLineBottom, this.topRatio);
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }
}
