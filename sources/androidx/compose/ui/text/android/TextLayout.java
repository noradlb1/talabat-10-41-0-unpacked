package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpanKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ&\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\tJ\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\tJ\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tH\u0002J\u000e\u0010^\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tJ\u000e\u0010_\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tJ\u000e\u0010`\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tJ\u000e\u0010a\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u000e\u0010d\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u000e\u0010e\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\tJ\u000e\u0010l\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\tJ\u000e\u0010n\u001a\u00020\t2\u0006\u0010c\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\tJ\u0016\u0010p\u001a\u00020\t2\u0006\u0010]\u001a\u00020\t2\u0006\u0010q\u001a\u00020\u0005J\u000e\u0010r\u001a\u00020\t2\u0006\u0010]\u001a\u00020\tJ\u0018\u0010s\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\u0010J\u0018\u0010u\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\u0010J\u001e\u0010v\u001a\u00020S2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020zJ\r\u0010{\u001a\u00020\u0010H\u0000¢\u0006\u0002\b|J\u000e\u0010}\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tJ\u000e\u0010~\u001a\u00020\u00102\u0006\u0010[\u001a\u00020\tJ\u0010\u0010\u001a\u00020S2\b\u0010\u0001\u001a\u00030\u0001R\u001c\u0010\u001e\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010'\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u000e\u0010*\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u00020/8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010 \u001a\u0004\b1\u00102R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0019\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0011\u0010D\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bH\u0010FR\u000e\u0010I\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010 \u001a\u0004\bQ\u0010\"¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "lastLineExtra", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper$delegate", "Lkotlin/Lazy;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "leftPadding", "lineCount", "getLineCount", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "getLineHeightSpans", "()[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "rightPadding", "text", "getText", "()Ljava/lang/CharSequence;", "textCanvas", "Landroidx/compose/ui/text/android/TextAndroidCanvas;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "getBoundingBox", "Landroid/graphics/RectF;", "offset", "getHorizontalPadding", "line", "getLineAscent", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "lineIndex", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class TextLayout {
    public static final int $stable = 8;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    @Nullable
    private final Paint.FontMetricsInt lastLineFontMetrics;
    @NotNull
    private final Layout layout;
    @NotNull
    private final Lazy layoutHelper$delegate;
    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    @NotNull
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final float rightPadding;
    @NotNull
    private final TextAndroidCanvas textCanvas;
    private final int topPadding;

    /* JADX INFO: finally extract failed */
    public TextLayout(@NotNull CharSequence charSequence, float f11, @NotNull TextPaint textPaint, int i11, @Nullable TextUtils.TruncateAt truncateAt, int i12, float f12, @Px float f13, boolean z11, boolean z12, int i13, int i14, int i15, int i16, int i17, int i18, @Nullable int[] iArr, @Nullable int[] iArr2, @NotNull LayoutIntrinsics layoutIntrinsics2) {
        TextDirectionHeuristic textDirectionHeuristic;
        boolean z13;
        boolean z14;
        Layout layout2;
        boolean z15;
        CharSequence charSequence2 = charSequence;
        float f14 = f11;
        int i19 = i13;
        LayoutIntrinsics layoutIntrinsics3 = layoutIntrinsics2;
        Intrinsics.checkNotNullParameter(charSequence2, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(layoutIntrinsics3, "layoutIntrinsics");
        this.includePadding = z11;
        this.fallbackLineSpacing = z12;
        this.layoutIntrinsics = layoutIntrinsics3;
        this.textCanvas = new TextAndroidCanvas();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayoutKt.getTextDirectionHeuristic(i12);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i11);
        boolean z16 = (charSequence2 instanceof Spanned) && ((Spanned) charSequence2).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics2.getBoringMetrics();
            TextDirectionHeuristic textDirectionHeuristic3 = textDirectionHeuristic2;
            double d11 = (double) f14;
            Layout.Alignment alignment2 = alignment;
            int ceil = (int) ((float) Math.ceil(d11));
            if (boringMetrics == null || layoutIntrinsics2.getMaxIntrinsicWidth() > f14 || z16) {
                int i21 = ceil;
                z14 = true;
                TextDirectionHeuristic textDirectionHeuristic4 = textDirectionHeuristic3;
                this.isBoringLayout = false;
                z13 = false;
                textDirectionHeuristic = textDirectionHeuristic4;
                layout2 = StaticLayoutFactory.INSTANCE.create(charSequence, 0, charSequence.length(), textPaint, i21, textDirectionHeuristic4, alignment2, i13, truncateAt, (int) ((float) Math.ceil(d11)), f12, f13, i18, z11, z12, i14, i15, i16, i17, iArr, iArr2);
            } else {
                this.isBoringLayout = true;
                z14 = true;
                layout2 = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, ceil, boringMetrics, alignment2, z11, z12, truncateAt, ceil);
                z13 = false;
                textDirectionHeuristic = textDirectionHeuristic3;
            }
            this.layout = layout2;
            Trace.endSection();
            int i22 = i13;
            int min = Math.min(layout2.getLineCount(), i22);
            this.lineCount = min;
            if (min >= i22 && (layout2.getEllipsisCount(min - 1) > 0 || layout2.getLineEnd(min - 1) != charSequence.length())) {
                z15 = z14;
            } else {
                z15 = z13;
            }
            this.didExceedMaxLines = z15;
            Pair access$getVerticalPaddings = TextLayoutKt.getVerticalPaddings(this);
            LineHeightStyleSpan[] access$getLineHeightSpans = TextLayoutKt.getLineHeightSpans(this);
            this.lineHeightSpans = access$getLineHeightSpans;
            Pair access$getLineHeightPaddings = TextLayoutKt.getLineHeightPaddings(this, access$getLineHeightSpans);
            this.topPadding = Math.max(((Number) access$getVerticalPaddings.getFirst()).intValue(), ((Number) access$getLineHeightPaddings.getFirst()).intValue());
            this.bottomPadding = Math.max(((Number) access$getVerticalPaddings.getSecond()).intValue(), ((Number) access$getLineHeightPaddings.getSecond()).intValue());
            Pair access$getLastLineMetrics = TextLayoutKt.getLastLineMetrics(this, textPaint, textDirectionHeuristic, access$getLineHeightSpans);
            this.lastLineFontMetrics = (Paint.FontMetricsInt) access$getLastLineMetrics.getFirst();
            this.lastLineExtra = ((Number) access$getLastLineMetrics.getSecond()).intValue();
            this.leftPadding = IndentationFixSpanKt.getEllipsizedLeftPadding$default(layout2, min - 1, (Paint) null, 2, (Object) null);
            this.rightPadding = IndentationFixSpanKt.getEllipsizedRightPadding$default(layout2, min - 1, (Paint) null, 2, (Object) null);
            this.layoutHelper$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TextLayout$layoutHelper$2(this));
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    private final float getHorizontalPadding(int i11) {
        if (i11 == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    @VisibleForTesting
    public static /* synthetic */ void getLayout$annotations() {
    }

    private final LayoutHelper getLayoutHelper() {
        return (LayoutHelper) this.layoutHelper$delegate.getValue();
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return textLayout.getPrimaryHorizontal(i11, z11);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return textLayout.getSecondaryHorizontal(i11, z11);
    }

    @VisibleForTesting
    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    public final void fillBoundingBoxes(int i11, int i12, @NotNull float[] fArr, int i13) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i14;
        float f11;
        float f12;
        int i15 = i11;
        int i16 = i12;
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr2, "array");
        int length = getText().length();
        int i17 = 1;
        if (i15 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i15 < length) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i16 > i15) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (i16 <= length) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (fArr2.length - i13 >= (i16 - i15) * 4) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (z15) {
                            int lineForOffset = getLineForOffset(i11);
                            int lineForOffset2 = getLineForOffset(i16 - 1);
                            HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
                            if (lineForOffset <= lineForOffset2) {
                                int i18 = lineForOffset;
                                int i19 = i13;
                                while (true) {
                                    int lineStart = getLineStart(i18);
                                    int lineEnd = getLineEnd(i18);
                                    int min = Math.min(i16, lineEnd);
                                    float lineTop = getLineTop(i18);
                                    float lineBottom = getLineBottom(i18);
                                    if (getParagraphDirection(i18) == i17) {
                                        i14 = i17;
                                    } else {
                                        i14 = 0;
                                    }
                                    int i21 = i14 ^ 1;
                                    for (int max = Math.max(i15, lineStart); max < min; max++) {
                                        boolean isRtlCharAt = isRtlCharAt(max);
                                        if (i14 != 0 && !isRtlCharAt) {
                                            f11 = horizontalPositionCache.getPrimaryDownstream(max);
                                            f12 = horizontalPositionCache.getPrimaryUpstream(max + 1);
                                        } else if (i14 != 0 && isRtlCharAt) {
                                            f12 = horizontalPositionCache.getSecondaryDownstream(max);
                                            f11 = horizontalPositionCache.getSecondaryUpstream(max + 1);
                                        } else if (i21 == 0 || !isRtlCharAt) {
                                            f11 = horizontalPositionCache.getSecondaryDownstream(max);
                                            f12 = horizontalPositionCache.getSecondaryUpstream(max + 1);
                                        } else {
                                            f12 = horizontalPositionCache.getPrimaryDownstream(max);
                                            f11 = horizontalPositionCache.getPrimaryUpstream(max + 1);
                                        }
                                        fArr2[i19] = f11;
                                        fArr2[i19 + 1] = lineTop;
                                        fArr2[i19 + 2] = f12;
                                        fArr2[i19 + 3] = lineBottom;
                                        i19 += 4;
                                    }
                                    if (i18 != lineForOffset2) {
                                        i18++;
                                        i17 = 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
                    }
                } else {
                    throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
                }
            } else {
                throw new IllegalArgumentException("startOffset must be less than text length".toString());
            }
        } else {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    @NotNull
    public final RectF getBoundingBox(int i11) {
        boolean z11;
        float f11;
        float f12;
        float f13;
        float f14;
        int lineForOffset = getLineForOffset(i11);
        float lineTop = getLineTop(lineForOffset);
        float lineBottom = getLineBottom(lineForOffset);
        if (getParagraphDirection(lineForOffset) == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean isRtlCharAt = this.layout.isRtlCharAt(i11);
        if (!z11 || isRtlCharAt) {
            if (z11 && isRtlCharAt) {
                f14 = getSecondaryHorizontal(i11, false);
                f13 = getSecondaryHorizontal(i11 + 1, true);
            } else if (isRtlCharAt) {
                f14 = getPrimaryHorizontal(i11, false);
                f13 = getPrimaryHorizontal(i11 + 1, true);
            } else {
                f12 = getSecondaryHorizontal(i11, false);
                f11 = getSecondaryHorizontal(i11 + 1, true);
            }
            float f15 = f14;
            f12 = f13;
            f11 = f15;
        } else {
            f12 = getPrimaryHorizontal(i11, false);
            f11 = getPrimaryHorizontal(i11 + 1, true);
        }
        return new RectF(f12, lineTop, f11, lineBottom);
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        int i11;
        if (this.didExceedMaxLines) {
            i11 = this.layout.getLineBottom(this.lineCount - 1);
        } else {
            i11 = this.layout.getHeight();
        }
        return i11 + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int i11) {
        int i12;
        Paint.FontMetricsInt fontMetricsInt;
        if (i11 != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            i12 = this.layout.getLineAscent(i11);
        } else {
            i12 = fontMetricsInt.ascent;
        }
        return (float) i12;
    }

    public final float getLineBaseline(int i11) {
        float f11;
        float f12 = (float) this.topPadding;
        if (i11 != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            f11 = (float) this.layout.getLineBaseline(i11);
        } else {
            f11 = getLineTop(i11) - ((float) this.lastLineFontMetrics.ascent);
        }
        return f12 + f11;
    }

    public final float getLineBottom(int i11) {
        int i12;
        if (i11 == this.lineCount - 1 && this.lastLineFontMetrics != null) {
            return ((float) this.layout.getLineBottom(i11 - 1)) + ((float) this.lastLineFontMetrics.bottom);
        }
        float lineBottom = ((float) this.topPadding) + ((float) this.layout.getLineBottom(i11));
        if (i11 == this.lineCount - 1) {
            i12 = this.bottomPadding;
        } else {
            i12 = 0;
        }
        return lineBottom + ((float) i12);
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int i11) {
        int i12;
        Paint.FontMetricsInt fontMetricsInt;
        if (i11 != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            i12 = this.layout.getLineDescent(i11);
        } else {
            i12 = fontMetricsInt.descent;
        }
        return (float) i12;
    }

    public final int getLineEllipsisCount(int i11) {
        return this.layout.getEllipsisCount(i11);
    }

    public final int getLineEllipsisOffset(int i11) {
        return this.layout.getEllipsisStart(i11);
    }

    public final int getLineEnd(int i11) {
        if (this.layout.getEllipsisStart(i11) == 0) {
            return this.layout.getLineEnd(i11);
        }
        return this.layout.getText().length();
    }

    public final int getLineForOffset(int i11) {
        return this.layout.getLineForOffset(i11);
    }

    public final int getLineForVertical(int i11) {
        return this.layout.getLineForVertical(this.topPadding + i11);
    }

    public final float getLineHeight(int i11) {
        return getLineBottom(i11) - getLineTop(i11);
    }

    @NotNull
    public final LineHeightStyleSpan[] getLineHeightSpans() {
        return this.lineHeightSpans;
    }

    public final float getLineLeft(int i11) {
        float f11;
        float lineLeft = this.layout.getLineLeft(i11);
        if (i11 == this.lineCount - 1) {
            f11 = this.leftPadding;
        } else {
            f11 = 0.0f;
        }
        return lineLeft + f11;
    }

    public final float getLineRight(int i11) {
        float f11;
        float lineRight = this.layout.getLineRight(i11);
        if (i11 == this.lineCount - 1) {
            f11 = this.rightPadding;
        } else {
            f11 = 0.0f;
        }
        return lineRight + f11;
    }

    public final int getLineStart(int i11) {
        return this.layout.getLineStart(i11);
    }

    public final float getLineTop(int i11) {
        int i12;
        float lineTop = (float) this.layout.getLineTop(i11);
        if (i11 == 0) {
            i12 = 0;
        } else {
            i12 = this.topPadding;
        }
        return lineTop + ((float) i12);
    }

    public final int getLineVisibleEnd(int i11) {
        if (this.layout.getEllipsisStart(i11) == 0) {
            return this.layout.getLineVisibleEnd(i11);
        }
        return this.layout.getEllipsisStart(i11) + this.layout.getLineStart(i11);
    }

    public final float getLineWidth(int i11) {
        return this.layout.getLineWidth(i11);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int i11, float f11) {
        return this.layout.getOffsetForHorizontal(i11, f11 + (((float) -1) * getHorizontalPadding(i11)));
    }

    public final int getParagraphDirection(int i11) {
        return this.layout.getParagraphDirection(i11);
    }

    public final float getPrimaryHorizontal(int i11, boolean z11) {
        return getLayoutHelper().getHorizontalPosition(i11, true, z11) + getHorizontalPadding(getLineForOffset(i11));
    }

    public final float getSecondaryHorizontal(int i11, boolean z11) {
        return getLayoutHelper().getHorizontalPosition(i11, false, z11) + getHorizontalPadding(getLineForOffset(i11));
    }

    public final void getSelectionPath(int i11, int i12, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dest");
        this.layout.getSelectionPath(i11, i12, path);
        if (this.topPadding != 0 && !path.isEmpty()) {
            path.offset(0.0f, (float) this.topPadding);
        }
    }

    @NotNull
    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "layout.text");
        return text;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout2 = this.layout;
            Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout2);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout3 = this.layout;
        Intrinsics.checkNotNull(layout3, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout3, this.fallbackLineSpacing);
    }

    public final boolean isLineEllipsized(int i11) {
        return TextLayoutKt.isLineEllipsized(this.layout, i11);
    }

    public final boolean isRtlCharAt(int i11) {
        return this.layout.isRtlCharAt(i11);
    }

    public final void paint(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i11 = this.topPadding;
        if (i11 != 0) {
            canvas.translate(0.0f, (float) i11);
        }
        this.textCanvas.setCanvas(canvas);
        this.layout.draw(this.textCanvas);
        int i12 = this.topPadding;
        if (i12 != 0) {
            canvas.translate(0.0f, ((float) -1) * ((float) i12));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextLayout(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, float r30, float r31, boolean r32, boolean r33, int r34, int r35, int r36, int r37, int r38, int r39, int[] r40, int[] r41, androidx.compose.ui.text.android.LayoutIntrinsics r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r25
        L_0x000b:
            r1 = r0 & 8
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r7 = r3
            goto L_0x0014
        L_0x0012:
            r7 = r27
        L_0x0014:
            r1 = r0 & 16
            r4 = 0
            if (r1 == 0) goto L_0x001b
            r8 = r4
            goto L_0x001d
        L_0x001b:
            r8 = r28
        L_0x001d:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r1 = 2
            r9 = r1
            goto L_0x0026
        L_0x0024:
            r9 = r29
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002e
            r1 = 1065353216(0x3f800000, float:1.0)
            r10 = r1
            goto L_0x0030
        L_0x002e:
            r10 = r30
        L_0x0030:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0036
            r11 = r2
            goto L_0x0038
        L_0x0036:
            r11 = r31
        L_0x0038:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003e
            r12 = r3
            goto L_0x0040
        L_0x003e:
            r12 = r32
        L_0x0040:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0047
            r1 = 1
            r13 = r1
            goto L_0x0049
        L_0x0047:
            r13 = r33
        L_0x0049:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r1 = 2147483647(0x7fffffff, float:NaN)
            r14 = r1
            goto L_0x0054
        L_0x0052:
            r14 = r34
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r15 = r3
            goto L_0x005c
        L_0x005a:
            r15 = r35
        L_0x005c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0063
            r16 = r3
            goto L_0x0065
        L_0x0063:
            r16 = r36
        L_0x0065:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006c
            r17 = r3
            goto L_0x006e
        L_0x006c:
            r17 = r37
        L_0x006e:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0075
            r18 = r3
            goto L_0x0077
        L_0x0075:
            r18 = r38
        L_0x0077:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0080
            r19 = r3
            goto L_0x0082
        L_0x0080:
            r19 = r39
        L_0x0082:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008a
            r20 = r4
            goto L_0x008c
        L_0x008a:
            r20 = r40
        L_0x008c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0094
            r21 = r4
            goto L_0x0096
        L_0x0094:
            r21 = r41
        L_0x0096:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00a7
            androidx.compose.ui.text.android.LayoutIntrinsics r0 = new androidx.compose.ui.text.android.LayoutIntrinsics
            r1 = r24
            r2 = r26
            r0.<init>(r1, r2, r9)
            r22 = r0
            goto L_0x00ad
        L_0x00a7:
            r1 = r24
            r2 = r26
            r22 = r42
        L_0x00ad:
            r3 = r23
            r4 = r24
            r6 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], androidx.compose.ui.text.android.LayoutIntrinsics, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
