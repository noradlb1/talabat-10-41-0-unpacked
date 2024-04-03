package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u001a=\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0002\u0010\u0011\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\bH\u0002¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\bH\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"EmptyPair", "Lkotlin/Pair;", "", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "getLastLineMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "Landroidx/compose/ui/text/android/TextLayout;", "textPaint", "Landroid/text/TextPaint;", "frameworkTextDir", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Lkotlin/Pair;", "getLineHeightPaddings", "(Landroidx/compose/ui/text/android/TextLayout;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Lkotlin/Pair;", "getLineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "getVerticalPaddings", "isLineEllipsized", "", "Landroid/text/Layout;", "lineIndex", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextLayoutKt {
    @NotNull
    private static final Pair<Integer, Integer> EmptyPair = new Pair<>(0, 0);

    /* access modifiers changed from: private */
    public static final Pair<Paint.FontMetricsInt, Integer> getLastLineMetrics(TextLayout textLayout, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, LineHeightStyleSpan[] lineHeightStyleSpanArr) {
        boolean z11;
        boolean z12;
        int lineCount = textLayout.getLineCount() - 1;
        if (textLayout.getLayout().getLineStart(lineCount) == textLayout.getLayout().getLineEnd(lineCount)) {
            if (lineHeightStyleSpanArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (true ^ z11) {
                SpannableString spannableString = new SpannableString("​");
                LineHeightStyleSpan lineHeightStyleSpan = (LineHeightStyleSpan) ArraysKt___ArraysKt.first((T[]) lineHeightStyleSpanArr);
                int length = spannableString.length();
                if (lineCount == 0 || !lineHeightStyleSpan.getTrimLastLineBottom()) {
                    z12 = lineHeightStyleSpan.getTrimLastLineBottom();
                } else {
                    z12 = false;
                }
                spannableString.setSpan(lineHeightStyleSpan.copy$ui_text_release(0, length, z12), 0, spannableString.length(), 33);
                StaticLayout create$default = StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, spannableString, 0, spannableString.length(), textPaint, Integer.MAX_VALUE, textDirectionHeuristic, (Layout.Alignment) null, 0, (TextUtils.TruncateAt) null, 0, 0.0f, 0.0f, 0, textLayout.getIncludePadding(), textLayout.getFallbackLineSpacing(), 0, 0, 0, 0, (int[]) null, (int[]) null, 2072512, (Object) null);
                Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
                fontMetricsInt.ascent = create$default.getLineAscent(0);
                fontMetricsInt.descent = create$default.getLineDescent(0);
                fontMetricsInt.top = create$default.getLineTop(0);
                int lineBottom = create$default.getLineBottom(0);
                fontMetricsInt.bottom = lineBottom;
                return new Pair<>(fontMetricsInt, Integer.valueOf(lineBottom - ((int) textLayout.getLineHeight(lineCount))));
            }
        }
        return new Pair<>(null, 0);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, Integer> getLineHeightPaddings(TextLayout textLayout, LineHeightStyleSpan[] lineHeightStyleSpanArr) {
        int i11 = 0;
        int i12 = 0;
        for (LineHeightStyleSpan lineHeightStyleSpan : lineHeightStyleSpanArr) {
            if (lineHeightStyleSpan.getFirstAscentDiff() < 0) {
                i11 = Math.max(i11, Math.abs(lineHeightStyleSpan.getFirstAscentDiff()));
            }
            if (lineHeightStyleSpan.getLastDescentDiff() < 0) {
                i12 = Math.max(i11, Math.abs(lineHeightStyleSpan.getLastDescentDiff()));
            }
        }
        if (i11 == 0 && i12 == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    /* access modifiers changed from: private */
    public static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout textLayout) {
        boolean z11;
        if (!(textLayout.getText() instanceof Spanned)) {
            return new LineHeightStyleSpan[0];
        }
        CharSequence text = textLayout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        LineHeightStyleSpan[] lineHeightStyleSpanArr = (LineHeightStyleSpan[]) ((Spanned) text).getSpans(0, textLayout.getText().length(), LineHeightStyleSpan.class);
        Intrinsics.checkNotNullExpressionValue(lineHeightStyleSpanArr, "lineHeightStyleSpans");
        if (lineHeightStyleSpanArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new LineHeightStyleSpan[0];
        }
        return lineHeightStyleSpanArr;
    }

    @NotNull
    public static final TextDirectionHeuristic getTextDirectionHeuristic(int i11) {
        if (i11 == 0) {
            TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.LTR;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic, "LTR");
            return textDirectionHeuristic;
        } else if (i11 == 1) {
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.RTL;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic2, "RTL");
            return textDirectionHeuristic2;
        } else if (i11 == 2) {
            TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic3, "FIRSTSTRONG_LTR");
            return textDirectionHeuristic3;
        } else if (i11 == 3) {
            TextDirectionHeuristic textDirectionHeuristic4 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic4, "FIRSTSTRONG_RTL");
            return textDirectionHeuristic4;
        } else if (i11 == 4) {
            TextDirectionHeuristic textDirectionHeuristic5 = TextDirectionHeuristics.ANYRTL_LTR;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic5, "ANYRTL_LTR");
            return textDirectionHeuristic5;
        } else if (i11 != 5) {
            TextDirectionHeuristic textDirectionHeuristic6 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic6, "FIRSTSTRONG_LTR");
            return textDirectionHeuristic6;
        } else {
            TextDirectionHeuristic textDirectionHeuristic7 = TextDirectionHeuristics.LOCALE;
            Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic7, GlobalConstants.PrefsConstants.LOCALE);
            return textDirectionHeuristic7;
        }
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, Integer> getVerticalPaddings(TextLayout textLayout) {
        int i11;
        int i12;
        if (textLayout.getIncludePadding() || textLayout.isFallbackLinespacingApplied$ui_text_release()) {
            return new Pair<>(0, 0);
        }
        TextPaint paint = textLayout.getLayout().getPaint();
        CharSequence text = textLayout.getLayout().getText();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Rect charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(0), textLayout.getLayout().getLineEnd(0));
        int lineAscent = textLayout.getLayout().getLineAscent(0);
        int i13 = charSequenceBounds.top;
        if (i13 < lineAscent) {
            i11 = lineAscent - i13;
        } else {
            i11 = textLayout.getLayout().getTopPadding();
        }
        if (textLayout.getLineCount() != 1) {
            int lineCount = textLayout.getLineCount() - 1;
            charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(lineCount), textLayout.getLayout().getLineEnd(lineCount));
        }
        int lineDescent = textLayout.getLayout().getLineDescent(textLayout.getLineCount() - 1);
        int i14 = charSequenceBounds.bottom;
        if (i14 > lineDescent) {
            i12 = i14 - lineDescent;
        } else {
            i12 = textLayout.getLayout().getBottomPadding();
        }
        if (i11 == 0 && i12 == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public static final boolean isLineEllipsized(@NotNull Layout layout, int i11) {
        Intrinsics.checkNotNullParameter(layout, "<this>");
        if (layout.getEllipsisCount(i11) > 0) {
            return true;
        }
        return false;
    }
}
