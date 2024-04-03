package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontKt {
    @ExperimentalTextApi
    @NotNull
    /* renamed from: Font-F3nL8kk  reason: not valid java name */
    public static final Font m5102FontF3nL8kk(int i11, @NotNull FontWeight fontWeight, int i12, int i13, @NotNull FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new ResourceFont(i11, fontWeight, i12, settings, i13, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-F3nL8kk$default  reason: not valid java name */
    public static /* synthetic */ Font m5103FontF3nL8kk$default(int i11, FontWeight fontWeight, int i12, int i13, FontVariation.Settings settings, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i14 & 4) != 0) {
            i12 = FontStyle.Companion.m5129getNormal_LCdwA();
        }
        if ((i14 & 8) != 0) {
            i13 = FontLoadingStrategy.Companion.m5116getBlockingPKNRLFQ();
        }
        if ((i14 & 16) != 0) {
            settings = FontVariation.INSTANCE.m5144Settings6EWAqTQ(fontWeight, i12, new FontVariation.Setting[0]);
        }
        return m5102FontF3nL8kk(i11, fontWeight, i12, i13, settings);
    }

    /* renamed from: Font-RetOiIg$default  reason: not valid java name */
    public static /* synthetic */ Font m5105FontRetOiIg$default(int i11, FontWeight fontWeight, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i13 & 4) != 0) {
            i12 = FontStyle.Companion.m5129getNormal_LCdwA();
        }
        return Intrinsics.checkNotNullParameter(fontWeight, "weight");
    }

    @NotNull
    @Stable
    /* renamed from: Font-YpTlLL0  reason: not valid java name */
    public static final Font m5106FontYpTlLL0(int i11, @NotNull FontWeight fontWeight, int i12, int i13) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new ResourceFont(i11, fontWeight, i12, new FontVariation.Settings(new FontVariation.Setting[0]), i13, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-YpTlLL0$default  reason: not valid java name */
    public static /* synthetic */ Font m5107FontYpTlLL0$default(int i11, FontWeight fontWeight, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i14 & 4) != 0) {
            i12 = FontStyle.Companion.m5129getNormal_LCdwA();
        }
        if ((i14 & 8) != 0) {
            i13 = FontLoadingStrategy.Companion.m5116getBlockingPKNRLFQ();
        }
        return m5106FontYpTlLL0(i11, fontWeight, i12, i13);
    }

    @NotNull
    @Stable
    public static final FontFamily toFontFamily(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
