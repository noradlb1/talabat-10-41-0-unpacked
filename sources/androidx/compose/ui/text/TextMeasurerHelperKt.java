package androidx.compose.ui.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"DefaultCacheSize", "", "rememberTextMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "cacheSize", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/TextMeasurer;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextMeasurerHelperKt {
    private static final int DefaultCacheSize = 8;

    @ExperimentalTextApi
    @NotNull
    @Composable
    public static final TextMeasurer rememberTextMeasurer(int i11, @Nullable Composer composer, int i12, int i13) {
        composer.startReplaceableGroup(1538166871);
        if ((i13 & 1) != 0) {
            i11 = DefaultCacheSize;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1538166871, i12, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:41)");
        }
        FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object[] objArr = {resolver, density, layoutDirection, Integer.valueOf(i11)};
        composer.startReplaceableGroup(-568225417);
        boolean z11 = false;
        for (int i14 = 0; i14 < 4; i14++) {
            z11 |= composer.changed(objArr[i14]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextMeasurer(resolver, density, layoutDirection, i11);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextMeasurer textMeasurer = (TextMeasurer) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textMeasurer;
    }
}
