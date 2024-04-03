package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-vxs03AY", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DeviceFontFamilyNameFontKt {
    @ExperimentalTextApi
    @NotNull
    /* renamed from: Font-vxs03AY  reason: not valid java name */
    public static final Font m5096Fontvxs03AY(@NotNull String str, @NotNull FontWeight fontWeight, int i11, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new DeviceFontFamilyNameFont(str, fontWeight, i11, settings, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-vxs03AY$default  reason: not valid java name */
    public static /* synthetic */ Font m5097Fontvxs03AY$default(String str, FontWeight fontWeight, int i11, FontVariation.Settings settings, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i12 & 4) != 0) {
            i11 = FontStyle.Companion.m5129getNormal_LCdwA();
        }
        if ((i12 & 8) != 0) {
            settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        }
        return m5096Fontvxs03AY(str, fontWeight, i11, settings);
    }
}
