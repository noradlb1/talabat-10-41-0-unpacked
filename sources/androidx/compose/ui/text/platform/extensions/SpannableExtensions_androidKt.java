package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001aF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010H\u0000\u001a-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002\u001a\u0016\u0010\u001b\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002\u001a1\u0010\u001d\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a1\u0010%\u001a\u00020\t*\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b(\u001a.\u0010)\u001a\u00020\t*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010-\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010$\u001aS\u0010/\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0002ø\u0001\u0001\u001a&\u00108\u001a\u00020\t*\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a9\u0010;\u001a\u00020\t*\u00020\u001e2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>\u001a&\u0010?\u001a\u00020\t*\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a9\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010H\u001a&\u0010I\u001a\u00020\t*\u00020\u001e2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010L\u001a\u00020\t*\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a$\u0010O\u001a\u00020\t*\u00020\u001e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a:\u0010R\u001a\u00020\t*\u00020\u001e2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`WH\u0002\u001a[\u0010X\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0000ø\u0001\u0001\u001a&\u0010Y\u001a\u00020\t*\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010\\\u001a\u00020\t*\u00020\u001e2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006_"}, d2 = {"createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "resolveLineHeightInPx", "", "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "lowPrioritySpans", "Ljava/util/ArrayList;", "Landroidx/compose/ui/text/platform/extensions/SpanRange;", "Lkotlin/collections/ArrayList;", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SpannableExtensions_androidKt {
    /* renamed from: createLetterSpacingSpan-eAf_CNQ  reason: not valid java name */
    private static final MetricAffectingSpan m5264createLetterSpacingSpaneAf_CNQ(long j11, Density density) {
        long r02 = TextUnit.m5658getTypeUIouoOA(j11);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5687equalsimpl0(r02, companion.m5692getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.m5446toPxR2X_6o(j11));
        }
        if (TextUnitType.m5687equalsimpl0(r02, companion.m5691getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m5659getValueimpl(j11));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(@Nullable SpanStyle spanStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(function3, "block");
        if (list.size() > 1) {
            int size = list.size();
            int i11 = size * 2;
            Integer[] numArr = new Integer[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                numArr[i12] = 0;
            }
            int size2 = list.size();
            for (int i13 = 0; i13 < size2; i13++) {
                AnnotatedString.Range range = list.get(i13);
                numArr[i13] = Integer.valueOf(range.getStart());
                numArr[i13 + size] = Integer.valueOf(range.getEnd());
            }
            ArraysKt___ArraysJvmKt.sort((T[]) (Comparable[]) numArr);
            int intValue = ((Number) ArraysKt___ArraysKt.first((T[]) numArr)).intValue();
            for (int i14 = 0; i14 < i11; i14++) {
                int intValue2 = numArr[i14].intValue();
                if (intValue2 != intValue) {
                    int size3 = list.size();
                    SpanStyle spanStyle2 = spanStyle;
                    for (int i15 = 0; i15 < size3; i15++) {
                        AnnotatedString.Range range2 = list.get(i15);
                        if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                            spanStyle2 = merge(spanStyle2, (SpanStyle) range2.getItem());
                        }
                    }
                    if (spanStyle2 != null) {
                        function3.invoke(spanStyle2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                    }
                    intValue = intValue2;
                }
            }
        } else if (!list.isEmpty()) {
            function3.invoke(merge(spanStyle, (SpanStyle) list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m5059getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI  reason: not valid java name */
    private static final float m5265resolveLineHeightInPxo2QH7mI(long j11, float f11, Density density) {
        long r02 = TextUnit.m5658getTypeUIouoOA(j11);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5687equalsimpl0(r02, companion.m5692getSpUIouoOA())) {
            return density.m5446toPxR2X_6o(j11);
        }
        if (TextUnitType.m5687equalsimpl0(r02, companion.m5691getEmUIouoOA())) {
            return TextUnit.m5659getValueimpl(j11) * f11;
        }
        return Float.NaN;
    }

    /* renamed from: setBackground-RPmYEkk  reason: not valid java name */
    public static final void m5266setBackgroundRPmYEkk(@NotNull Spannable spannable, long j11, int i11, int i12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(spannable, "$this$setBackground");
        if (j11 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m2974toArgb8_81llA(j11)), i11, i12);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM  reason: not valid java name */
    private static final void m5267setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i11, int i12) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m5280unboximpl()), i11, i12);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f11, int i11, int i12) {
        if (brush == null) {
            return;
        }
        if (brush instanceof SolidColor) {
            m5268setColorRPmYEkk(spannable, ((SolidColor) brush).m3235getValue0d7_KjU(), i11, i12);
        } else if (brush instanceof ShaderBrush) {
            setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f11), i11, i12);
        }
    }

    /* renamed from: setColor-RPmYEkk  reason: not valid java name */
    public static final void m5268setColorRPmYEkk(@NotNull Spannable spannable, long j11, int i11, int i12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(spannable, "$this$setColor");
        if (j11 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m2974toArgb8_81llA(j11)), i11, i12);
        }
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        SpanStyle spanStyle;
        boolean z11;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i11);
            AnnotatedString.Range range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range2.getItem()) || ((SpanStyle) range2.getItem()).m5004getFontSynthesisZQGJjVo() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(range);
            }
        }
        if (hasFontAttributes(textStyle)) {
            spanStyle = new SpanStyle(0, 0, textStyle.getFontWeight(), textStyle.m5058getFontStyle4Lr2A7w(), textStyle.m5059getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null);
        } else {
            spanStyle = null;
        }
        flattenFontStylesAndApply(spanStyle, arrayList, new SpannableExtensions_androidKt$setFontAttributes$1(spannable, function4));
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i11, int i12) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i11, i12);
        }
    }

    /* renamed from: setFontSize-KmRG4DE  reason: not valid java name */
    public static final void m5269setFontSizeKmRG4DE(@NotNull Spannable spannable, long j11, @NotNull Density density, int i11, int i12) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        long r02 = TextUnit.m5658getTypeUIouoOA(j11);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5687equalsimpl0(r02, companion.m5692getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt__MathJVMKt.roundToInt(density.m5446toPxR2X_6o(j11)), false), i11, i12);
        } else if (TextUnitType.m5687equalsimpl0(r02, companion.m5691getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m5659getValueimpl(j11)), i11, i12);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i11, int i12) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i11, i12);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i11, i12);
        }
    }

    /* renamed from: setLineHeight-KmRG4DE  reason: not valid java name */
    public static final void m5270setLineHeightKmRG4DE(@NotNull Spannable spannable, long j11, float f11, @NotNull Density density, @NotNull LineHeightStyle lineHeightStyle) {
        boolean z11;
        int i11;
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float r22 = m5265resolveLineHeightInPxo2QH7mI(j11, f11, density);
        if (!Float.isNaN(r22)) {
            if (spannable.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || StringsKt___StringsKt.last(spannable) == 10) {
                i11 = spannable.length() + 1;
            } else {
                i11 = spannable.length();
            }
            setSpan(spannable, new LineHeightStyleSpan(r22, 0, i11, LineHeightStyle.Trim.m5351isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m5330getTrimEVpEnUU()), LineHeightStyle.Trim.m5352isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m5330getTrimEVpEnUU()), lineHeightStyle.m5329getAlignmentPIaL0Z0()), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-r9BaKPg  reason: not valid java name */
    public static final void m5271setLineHeightr9BaKPg(@NotNull Spannable spannable, long j11, float f11, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        float r22 = m5265resolveLineHeightInPxo2QH7mI(j11, f11, density);
        if (!Float.isNaN(r22)) {
            setSpan(spannable, new LineHeightSpan(r22), 0, spannable.length());
        }
    }

    public static final void setLocaleList(@NotNull Spannable spannable, @Nullable LocaleList localeList, int i11, int i12) {
        Object obj;
        Locale locale;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                obj = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                if (localeList.isEmpty()) {
                    locale = Locale.Companion.getCurrent();
                } else {
                    locale = localeList.get(0);
                }
                obj = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(locale));
            }
            setSpan(spannable, obj, i11, i12);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i11, int i12) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m2974toArgb8_81llA(shadow.m3230getColor0d7_KjU()), Offset.m2676getXimpl(shadow.m3231getOffsetF1C5BW0()), Offset.m2677getYimpl(shadow.m3231getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i11, i12);
        }
    }

    public static final void setSpan(@NotNull Spannable spannable, @NotNull Object obj, int i11, int i12) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(obj, TtmlNode.TAG_SPAN);
        spannable.setSpan(obj, i11, i12, 33);
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m5267setBaselineShift0ocSgnM(spannable, item.m5000getBaselineShift5SSeXJ0(), start, end);
        m5268setColorRPmYEkk(spannable, item.m5001getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m5269setFontSizeKmRG4DE(spannable, item.m5002getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m5266setBackgroundRPmYEkk(spannable, item.m4999getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        MetricAffectingSpan r82 = m5264createLetterSpacingSpaneAf_CNQ(item.m5005getLetterSpacingXSAIIZE(), density);
        if (r82 != null) {
            arrayList.add(new SpanRange(r82, start, end));
        }
    }

    public static final void setSpanStyles(@NotNull Spannable spannable, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Density density, @NotNull Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(function4, "resolveTypeface");
        setFontAttributes(spannable, textStyle, list, function4);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.Range range = list.get(i11);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density, arrayList);
            }
        }
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            SpanRange spanRange = (SpanRange) arrayList.get(i12);
            setSpan(spannable, spanRange.component1(), spanRange.component2(), spanRange.component3());
        }
    }

    public static final void setTextDecoration(@NotNull Spannable spannable, @Nullable TextDecoration textDecoration, int i11, int i12) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i11, i12);
        }
    }

    public static final void setTextIndent(@NotNull Spannable spannable, @Nullable TextIndent textIndent, float f11, @NotNull Density density) {
        float f12;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        if (textIndent == null) {
            return;
        }
        if ((!TextUnit.m5656equalsimpl0(textIndent.m5390getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) || !TextUnit.m5656equalsimpl0(textIndent.m5391getRestLineXSAIIZE(), TextUnitKt.getSp(0))) && !TextUnitKt.m5677isUnspecifiedR2X_6o(textIndent.m5390getFirstLineXSAIIZE()) && !TextUnitKt.m5677isUnspecifiedR2X_6o(textIndent.m5391getRestLineXSAIIZE())) {
            long r02 = TextUnit.m5658getTypeUIouoOA(textIndent.m5390getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float f13 = 0.0f;
            if (TextUnitType.m5687equalsimpl0(r02, companion.m5692getSpUIouoOA())) {
                f12 = density.m5446toPxR2X_6o(textIndent.m5390getFirstLineXSAIIZE());
            } else if (TextUnitType.m5687equalsimpl0(r02, companion.m5691getEmUIouoOA())) {
                f12 = TextUnit.m5659getValueimpl(textIndent.m5390getFirstLineXSAIIZE()) * f11;
            } else {
                f12 = 0.0f;
            }
            long r62 = TextUnit.m5658getTypeUIouoOA(textIndent.m5391getRestLineXSAIIZE());
            if (TextUnitType.m5687equalsimpl0(r62, companion.m5692getSpUIouoOA())) {
                f13 = density.m5446toPxR2X_6o(textIndent.m5391getRestLineXSAIIZE());
            } else if (TextUnitType.m5687equalsimpl0(r62, companion.m5691getEmUIouoOA())) {
                f13 = TextUnit.m5659getValueimpl(textIndent.m5391getRestLineXSAIIZE()) * f11;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) ((float) Math.ceil((double) f12)), (int) ((float) Math.ceil((double) f13))), 0, spannable.length());
        }
    }
}
