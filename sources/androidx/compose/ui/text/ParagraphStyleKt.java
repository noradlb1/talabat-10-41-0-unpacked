package androidx.compose.ui.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();

    @NotNull
    @Stable
    public static final ParagraphStyle lerp(@NotNull ParagraphStyle paragraphStyle, @NotNull ParagraphStyle paragraphStyle2, float f11) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "start");
        Intrinsics.checkNotNullParameter(paragraphStyle2, TraceLogKt.STOP_PROPERTY_NAME);
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(paragraphStyle.m4962getTextAlignbuA522U(), paragraphStyle2.m4962getTextAlignbuA522U(), f11);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(paragraphStyle.m4963getTextDirectionmmuk1to(), paragraphStyle2.m4963getTextDirectionmmuk1to(), f11);
        long r42 = SpanStyleKt.m5006lerpTextUnitInheritableC3pnCVY(paragraphStyle.m4961getLineHeightXSAIIZE(), paragraphStyle2.m4961getLineHeightXSAIIZE(), f11);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, r42, TextIndentKt.lerp(textIndent, textIndent2, f11), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f11), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f11), (LineBreak) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineBreak(), paragraphStyle2.getLineBreak(), f11), (Hyphens) SpanStyleKt.lerpDiscrete(paragraphStyle.getHyphens(), paragraphStyle2.getHyphens(), f11), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f11) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f11);
    }

    @NotNull
    public static final ParagraphStyle resolveParagraphStyleDefaults(@NotNull ParagraphStyle paragraphStyle, @NotNull LayoutDirection layoutDirection) {
        int i11;
        long j11;
        Intrinsics.checkNotNullParameter(paragraphStyle, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        TextAlign r12 = paragraphStyle.m4962getTextAlignbuA522U();
        if (r12 != null) {
            i11 = r12.m5365unboximpl();
        } else {
            i11 = TextAlign.Companion.m5371getStarte0LSkKk();
        }
        TextAlign r22 = TextAlign.m5359boximpl(i11);
        TextDirection r32 = TextDirection.m5372boximpl(TextStyleKt.m5064resolveTextDirectionYj3eThk(layoutDirection, paragraphStyle.m4963getTextDirectionmmuk1to()));
        if (TextUnitKt.m5677isUnspecifiedR2X_6o(paragraphStyle.m4961getLineHeightXSAIIZE())) {
            j11 = DefaultLineHeight;
        } else {
            j11 = paragraphStyle.m4961getLineHeightXSAIIZE();
        }
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        LineBreak lineBreak = paragraphStyle.getLineBreak();
        if (lineBreak == null) {
            lineBreak = LineBreak.Companion.getSimple();
        }
        LineBreak lineBreak2 = lineBreak;
        Hyphens hyphens = paragraphStyle.getHyphens();
        if (hyphens == null) {
            hyphens = Hyphens.Companion.getNone();
        }
        return new ParagraphStyle(r22, r32, j11, textIndent2, platformStyle, lineHeightStyle, lineBreak2, hyphens, (DefaultConstructorMarker) null);
    }
}
