package androidx.compose.material3.tokens;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypographyTokens {
    @NotNull
    private static final TextStyle BodyLarge;
    @NotNull
    private static final TextStyle BodyMedium;
    @NotNull
    private static final TextStyle BodySmall;
    @NotNull
    private static final TextStyle DisplayLarge;
    @NotNull
    private static final TextStyle DisplayMedium;
    @NotNull
    private static final TextStyle DisplaySmall;
    @NotNull
    private static final TextStyle HeadlineLarge;
    @NotNull
    private static final TextStyle HeadlineMedium;
    @NotNull
    private static final TextStyle HeadlineSmall;
    @NotNull
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    @NotNull
    private static final TextStyle LabelLarge;
    @NotNull
    private static final TextStyle LabelMedium;
    @NotNull
    private static final TextStyle LabelSmall;
    @NotNull
    private static final TextStyle TitleLarge;
    @NotNull
    private static final TextStyle TitleMedium;
    @NotNull
    private static final TextStyle TitleSmall;

    static {
        TypeScaleTokens typeScaleTokens = TypeScaleTokens.INSTANCE;
        GenericFontFamily bodyLargeFont = typeScaleTokens.getBodyLargeFont();
        FontWeight bodyLargeWeight = typeScaleTokens.getBodyLargeWeight();
        BodyLarge = new TextStyle(0, typeScaleTokens.m2477getBodyLargeSizeXSAIIZE(), bodyLargeWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) bodyLargeFont, (String) null, typeScaleTokens.m2478getBodyLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2476getBodyLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodyMediumFont = typeScaleTokens.getBodyMediumFont();
        FontWeight bodyMediumWeight = typeScaleTokens.getBodyMediumWeight();
        BodyMedium = new TextStyle(0, typeScaleTokens.m2480getBodyMediumSizeXSAIIZE(), bodyMediumWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) bodyMediumFont, (String) null, typeScaleTokens.m2481getBodyMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2479getBodyMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily bodySmallFont = typeScaleTokens.getBodySmallFont();
        FontWeight bodySmallWeight = typeScaleTokens.getBodySmallWeight();
        BodySmall = new TextStyle(0, typeScaleTokens.m2483getBodySmallSizeXSAIIZE(), bodySmallWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) bodySmallFont, (String) null, typeScaleTokens.m2484getBodySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2482getBodySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayLargeFont = typeScaleTokens.getDisplayLargeFont();
        FontWeight displayLargeWeight = typeScaleTokens.getDisplayLargeWeight();
        DisplayLarge = new TextStyle(0, typeScaleTokens.m2486getDisplayLargeSizeXSAIIZE(), displayLargeWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) displayLargeFont, (String) null, typeScaleTokens.m2487getDisplayLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2485getDisplayLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displayMediumFont = typeScaleTokens.getDisplayMediumFont();
        FontWeight displayMediumWeight = typeScaleTokens.getDisplayMediumWeight();
        DisplayMedium = new TextStyle(0, typeScaleTokens.m2489getDisplayMediumSizeXSAIIZE(), displayMediumWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) displayMediumFont, (String) null, typeScaleTokens.m2490getDisplayMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2488getDisplayMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily displaySmallFont = typeScaleTokens.getDisplaySmallFont();
        FontWeight displaySmallWeight = typeScaleTokens.getDisplaySmallWeight();
        DisplaySmall = new TextStyle(0, typeScaleTokens.m2492getDisplaySmallSizeXSAIIZE(), displaySmallWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) displaySmallFont, (String) null, typeScaleTokens.m2493getDisplaySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2491getDisplaySmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineLargeFont = typeScaleTokens.getHeadlineLargeFont();
        FontWeight headlineLargeWeight = typeScaleTokens.getHeadlineLargeWeight();
        HeadlineLarge = new TextStyle(0, typeScaleTokens.m2495getHeadlineLargeSizeXSAIIZE(), headlineLargeWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) headlineLargeFont, (String) null, typeScaleTokens.m2496getHeadlineLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2494getHeadlineLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineMediumFont = typeScaleTokens.getHeadlineMediumFont();
        FontWeight headlineMediumWeight = typeScaleTokens.getHeadlineMediumWeight();
        HeadlineMedium = new TextStyle(0, typeScaleTokens.m2498getHeadlineMediumSizeXSAIIZE(), headlineMediumWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) headlineMediumFont, (String) null, typeScaleTokens.m2499getHeadlineMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2497getHeadlineMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily headlineSmallFont = typeScaleTokens.getHeadlineSmallFont();
        FontWeight headlineSmallWeight = typeScaleTokens.getHeadlineSmallWeight();
        HeadlineSmall = new TextStyle(0, typeScaleTokens.m2501getHeadlineSmallSizeXSAIIZE(), headlineSmallWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) headlineSmallFont, (String) null, typeScaleTokens.m2502getHeadlineSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2500getHeadlineSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelLargeFont = typeScaleTokens.getLabelLargeFont();
        FontWeight labelLargeWeight = typeScaleTokens.getLabelLargeWeight();
        LabelLarge = new TextStyle(0, typeScaleTokens.m2504getLabelLargeSizeXSAIIZE(), labelLargeWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) labelLargeFont, (String) null, typeScaleTokens.m2505getLabelLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2503getLabelLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelMediumFont = typeScaleTokens.getLabelMediumFont();
        FontWeight labelMediumWeight = typeScaleTokens.getLabelMediumWeight();
        LabelMedium = new TextStyle(0, typeScaleTokens.m2507getLabelMediumSizeXSAIIZE(), labelMediumWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) labelMediumFont, (String) null, typeScaleTokens.m2508getLabelMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2506getLabelMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily labelSmallFont = typeScaleTokens.getLabelSmallFont();
        FontWeight labelSmallWeight = typeScaleTokens.getLabelSmallWeight();
        LabelSmall = new TextStyle(0, typeScaleTokens.m2510getLabelSmallSizeXSAIIZE(), labelSmallWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) labelSmallFont, (String) null, typeScaleTokens.m2511getLabelSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2509getLabelSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleLargeFont = typeScaleTokens.getTitleLargeFont();
        FontWeight titleLargeWeight = typeScaleTokens.getTitleLargeWeight();
        TitleLarge = new TextStyle(0, typeScaleTokens.m2513getTitleLargeSizeXSAIIZE(), titleLargeWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) titleLargeFont, (String) null, typeScaleTokens.m2514getTitleLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2512getTitleLargeLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleMediumFont = typeScaleTokens.getTitleMediumFont();
        FontWeight titleMediumWeight = typeScaleTokens.getTitleMediumWeight();
        TitleMedium = new TextStyle(0, typeScaleTokens.m2516getTitleMediumSizeXSAIIZE(), titleMediumWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) titleMediumFont, (String) null, typeScaleTokens.m2517getTitleMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2515getTitleMediumLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        GenericFontFamily titleSmallFont = typeScaleTokens.getTitleSmallFont();
        FontWeight titleSmallWeight = typeScaleTokens.getTitleSmallWeight();
        TitleSmall = new TextStyle(0, typeScaleTokens.m2519getTitleSmallSizeXSAIIZE(), titleSmallWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) titleSmallFont, (String) null, typeScaleTokens.m2520getTitleSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, typeScaleTokens.m2518getTitleSmallLineHeightXSAIIZE(), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
    }

    private TypographyTokens() {
    }

    @NotNull
    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    @NotNull
    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    @NotNull
    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    @NotNull
    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    @NotNull
    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    @NotNull
    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    @NotNull
    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    @NotNull
    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    @NotNull
    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    @NotNull
    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    @NotNull
    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    @NotNull
    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    @NotNull
    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    @NotNull
    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    @NotNull
    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
