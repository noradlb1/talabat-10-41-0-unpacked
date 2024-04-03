package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/tokens/BadgeTokens;", "", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "LargeColor", "getLargeColor", "LargeLabelTextColor", "getLargeLabelTextColor", "LargeLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLargeLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LargeShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getLargeShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "LargeSize", "Landroidx/compose/ui/unit/Dp;", "getLargeSize-D9Ej5fM", "()F", "F", "Shape", "getShape", "Size", "getSize-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BadgeTokens {
    @NotNull
    private static final ColorSchemeKeyTokens Color;
    @NotNull
    public static final BadgeTokens INSTANCE = new BadgeTokens();
    @NotNull
    private static final ColorSchemeKeyTokens LargeColor;
    @NotNull
    private static final ColorSchemeKeyTokens LargeLabelTextColor = ColorSchemeKeyTokens.OnError;
    @NotNull
    private static final TypographyKeyTokens LargeLabelTextFont = TypographyKeyTokens.LabelSmall;
    @NotNull
    private static final ShapeKeyTokens LargeShape;
    private static final float LargeSize = Dp.m5478constructorimpl((float) 16.0d);
    @NotNull
    private static final ShapeKeyTokens Shape;
    private static final float Size = Dp.m5478constructorimpl((float) 6.0d);

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Error;
        Color = colorSchemeKeyTokens;
        LargeColor = colorSchemeKeyTokens;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        LargeShape = shapeKeyTokens;
        Shape = shapeKeyTokens;
    }

    private BadgeTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getColor() {
        return Color;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLargeColor() {
        return LargeColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getLargeLabelTextColor() {
        return LargeLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getLargeLabelTextFont() {
        return LargeLabelTextFont;
    }

    @NotNull
    public final ShapeKeyTokens getLargeShape() {
        return LargeShape;
    }

    /* renamed from: getLargeSize-D9Ej5fM  reason: not valid java name */
    public final float m2031getLargeSizeD9Ej5fM() {
        return LargeSize;
    }

    @NotNull
    public final ShapeKeyTokens getShape() {
        return Shape;
    }

    /* renamed from: getSize-D9Ej5fM  reason: not valid java name */
    public final float m2032getSizeD9Ej5fM() {
        return Size;
    }
}
