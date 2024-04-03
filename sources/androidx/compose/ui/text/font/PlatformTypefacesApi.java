package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\fJ?\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceUsingTypefaceStyle", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceUsingTypefaceStyle-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VisibleForTesting
final class PlatformTypefacesApi implements PlatformTypefaces {
    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg  reason: not valid java name */
    private final Typeface m5154createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i11) {
        boolean z11;
        boolean z12 = false;
        if (FontStyle.m5124equalsimpl0(i11, FontStyle.Companion.m5129getNormal_LCdwA()) && Intrinsics.areEqual((Object) fontWeight, (Object) FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        int r52 = AndroidFontUtils_androidKt.m5077getAndroidTypefaceStyleFO1MlWM(fontWeight, i11);
        if (str == null || str.length() == 0) {
            z12 = true;
        }
        if (z12) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(r52);
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return defaultFromStyle;
        }
        Typeface create = Typeface.create(str, r52);
        Intrinsics.checkNotNullExpressionValue(create, "{\n            Typeface.c…y, targetStyle)\n        }");
        return create;
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg  reason: not valid java name */
    private final Typeface m5155loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i11) {
        boolean z11;
        boolean z12 = true;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        Typeface r62 = m5154createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i11);
        if (Intrinsics.areEqual((Object) r62, (Object) Typeface.create(Typeface.DEFAULT, AndroidFontUtils_androidKt.m5077getAndroidTypefaceStyleFO1MlWM(fontWeight, i11))) || Intrinsics.areEqual((Object) r62, (Object) m5154createAndroidTypefaceUsingTypefaceStyleRetOiIg((String) null, fontWeight, i11))) {
            z12 = false;
        }
        if (z12) {
            return r62;
        }
        return null;
    }

    @NotNull
    /* renamed from: createDefault-FO1MlWM  reason: not valid java name */
    public Typeface m5156createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i11) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return m5154createAndroidTypefaceUsingTypefaceStyleRetOiIg((String) null, fontWeight, i11);
    }

    @NotNull
    /* renamed from: createNamed-RetOiIg  reason: not valid java name */
    public Typeface m5157createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i11) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "name");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Typeface r02 = m5155loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefacesKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i11);
        if (r02 == null) {
            return m5154createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i11);
        }
        return r02;
    }

    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM  reason: not valid java name */
    public Typeface m5158optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i11, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        FontFamily.Companion companion = FontFamily.Companion;
        if (Intrinsics.areEqual((Object) str, (Object) companion.getSansSerif().getName())) {
            typeface = m5157createNamedRetOiIg(companion.getSansSerif(), fontWeight, i11);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.getSerif().getName())) {
            typeface = m5157createNamedRetOiIg(companion.getSerif(), fontWeight, i11);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.getMonospace().getName())) {
            typeface = m5157createNamedRetOiIg(companion.getMonospace(), fontWeight, i11);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.getCursive().getName())) {
            typeface = m5157createNamedRetOiIg(companion.getCursive(), fontWeight, i11);
        } else {
            typeface = m5155loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i11);
        }
        return PlatformTypefacesKt.setFontVariationSettings(typeface, settings, context);
    }
}
