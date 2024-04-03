package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/tokens/TypefaceTokens;", "", "()V", "Brand", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBrand", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Plain", "getPlain", "WeightBold", "Landroidx/compose/ui/text/font/FontWeight;", "getWeightBold", "()Landroidx/compose/ui/text/font/FontWeight;", "WeightMedium", "getWeightMedium", "WeightRegular", "getWeightRegular", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypefaceTokens {
    @NotNull
    private static final GenericFontFamily Brand;
    @NotNull
    public static final TypefaceTokens INSTANCE = new TypefaceTokens();
    @NotNull
    private static final GenericFontFamily Plain;
    @NotNull
    private static final FontWeight WeightBold;
    @NotNull
    private static final FontWeight WeightMedium;
    @NotNull
    private static final FontWeight WeightRegular;

    static {
        FontFamily.Companion companion = FontFamily.Companion;
        Brand = companion.getSansSerif();
        Plain = companion.getSansSerif();
        FontWeight.Companion companion2 = FontWeight.Companion;
        WeightBold = companion2.getBold();
        WeightMedium = companion2.getMedium();
        WeightRegular = companion2.getNormal();
    }

    private TypefaceTokens() {
    }

    @NotNull
    public final GenericFontFamily getBrand() {
        return Brand;
    }

    @NotNull
    public final GenericFontFamily getPlain() {
        return Plain;
    }

    @NotNull
    public final FontWeight getWeightBold() {
        return WeightBold;
    }

    @NotNull
    public final FontWeight getWeightMedium() {
        return WeightMedium;
    }

    @NotNull
    public final FontWeight getWeightRegular() {
        return WeightRegular;
    }
}
