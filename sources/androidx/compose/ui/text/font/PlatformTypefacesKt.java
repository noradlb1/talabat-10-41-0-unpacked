package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PlatformTypefacesKt {
    @NotNull
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }
        return new PlatformTypefacesApi();
    }

    @NotNull
    @VisibleForTesting
    public static final String getWeightSuffixForFallbackFamilyName(@NotNull String str, @NotNull FontWeight fontWeight) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        int weight = fontWeight.getWeight() / 100;
        boolean z14 = true;
        if (weight < 0 || weight >= 2) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return str + "-thin";
        }
        if (2 > weight || weight >= 4) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            return str + "-light";
        } else if (weight == 4) {
            return str;
        } else {
            if (weight == 5) {
                return str + "-medium";
            }
            if (6 > weight || weight >= 8) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                return str;
            }
            if (8 > weight || weight >= 11) {
                z14 = false;
            }
            if (!z14) {
                return str;
            }
            return str + "-black";
        }
    }

    @ExperimentalTextApi
    @Nullable
    public static final Typeface setFontVariationSettings(@Nullable Typeface typeface, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, settings, context);
        }
        return typeface;
    }
}
