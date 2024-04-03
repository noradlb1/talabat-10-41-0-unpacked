package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a-\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    /* access modifiers changed from: private */
    public static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m2954getTransparent0d7_KjU();
        DefaultColor = companion.m2945getBlack0d7_KjU();
    }

    @NotNull
    public static final SpanStyle lerp(@NotNull SpanStyle spanStyle, @NotNull SpanStyle spanStyle2, float f11) {
        float f12;
        float f13;
        float f14 = f11;
        Intrinsics.checkNotNullParameter(spanStyle, "start");
        Intrinsics.checkNotNullParameter(spanStyle2, TraceLogKt.STOP_PROPERTY_NAME);
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f14);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f14);
        long r72 = m5006lerpTextUnitInheritableC3pnCVY(spanStyle.m5002getFontSizeXSAIIZE(), spanStyle2.m5002getFontSizeXSAIIZE(), f14);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f14);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m5003getFontStyle4Lr2A7w(), spanStyle2.m5003getFontStyle4Lr2A7w(), f14);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m5004getFontSynthesisZQGJjVo(), spanStyle2.m5004getFontSynthesisZQGJjVo(), f14);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f14);
        long r14 = m5006lerpTextUnitInheritableC3pnCVY(spanStyle.m5005getLetterSpacingXSAIIZE(), spanStyle2.m5005getLetterSpacingXSAIIZE(), f14);
        BaselineShift r12 = spanStyle.m5000getBaselineShift5SSeXJ0();
        if (r12 != null) {
            f12 = r12.m5280unboximpl();
        } else {
            f12 = BaselineShift.m5275constructorimpl(0.0f);
        }
        BaselineShift r52 = spanStyle2.m5000getBaselineShift5SSeXJ0();
        if (r52 != null) {
            f13 = r52.m5280unboximpl();
        } else {
            f13 = BaselineShift.m5275constructorimpl(0.0f);
        }
        float r13 = BaselineShiftKt.m5287lerpjWV1Mfo(f12, f13, f14);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f14);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f14);
        long r19 = ColorKt.m2971lerpjxsXWHM(spanStyle.m4999getBackground0d7_KjU(), spanStyle2.m4999getBackground0d7_KjU(), f14);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f14);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(lerp, r72, lerp2, fontStyle, fontSynthesis, fontFamily, str, r14, BaselineShift.m5274boximpl(r13), lerp3, localeList, r19, textDecoration, ShadowKt.lerp(shadow, shadow2, f14), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f14), (DefaultConstructorMarker) null);
    }

    public static final <T> T lerpDiscrete(T t11, T t12, float f11) {
        return ((double) f11) < 0.5d ? t11 : t12;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f11) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f11);
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m5006lerpTextUnitInheritableC3pnCVY(long j11, long j12, float f11) {
        if (TextUnitKt.m5677isUnspecifiedR2X_6o(j11) || TextUnitKt.m5677isUnspecifiedR2X_6o(j12)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m5649boximpl(j11), TextUnit.m5649boximpl(j12), f11)).m5668unboximpl();
        }
        return TextUnitKt.m5679lerpC3pnCVY(j11, j12, f11);
    }

    @NotNull
    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle spanStyle) {
        long j11;
        int i11;
        int i12;
        long j12;
        float f11;
        boolean z11;
        Intrinsics.checkNotNullParameter(spanStyle, "style");
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(SpanStyleKt$resolveSpanStyleDefaults$1.INSTANCE);
        if (TextUnitKt.m5677isUnspecifiedR2X_6o(spanStyle.m5002getFontSizeXSAIIZE())) {
            j11 = DefaultFontSize;
        } else {
            j11 = spanStyle.m5002getFontSizeXSAIIZE();
        }
        long j13 = j11;
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle r02 = spanStyle.m5003getFontStyle4Lr2A7w();
        if (r02 != null) {
            i11 = r02.m5127unboximpl();
        } else {
            i11 = FontStyle.Companion.m5129getNormal_LCdwA();
        }
        FontStyle r82 = FontStyle.m5121boximpl(i11);
        FontSynthesis r03 = spanStyle.m5004getFontSynthesisZQGJjVo();
        if (r03 != null) {
            i12 = r03.m5138unboximpl();
        } else {
            i12 = FontSynthesis.Companion.m5139getAllGVVA2EU();
        }
        FontSynthesis r92 = FontSynthesis.m5130boximpl(i12);
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m5677isUnspecifiedR2X_6o(spanStyle.m5005getLetterSpacingXSAIIZE())) {
            j12 = DefaultLetterSpacing;
        } else {
            j12 = spanStyle.m5005getLetterSpacingXSAIIZE();
        }
        long j14 = j12;
        BaselineShift r04 = spanStyle.m5000getBaselineShift5SSeXJ0();
        if (r04 != null) {
            f11 = r04.m5280unboximpl();
        } else {
            f11 = BaselineShift.Companion.m5284getNoney9eOQZs();
        }
        BaselineShift r14 = BaselineShift.m5274boximpl(f11);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long r22 = spanStyle.m4999getBackground0d7_KjU();
        if (r22 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            r22 = DefaultBackgroundColor;
        }
        long j15 = r22;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        return new SpanStyle(takeOrElse, j13, fontWeight2, r82, r92, fontFamily2, str, j14, r14, textGeometricTransform2, localeList2, j15, textDecoration2, shadow, spanStyle.getPlatformStyle(), (DefaultConstructorMarker) null);
    }
}
