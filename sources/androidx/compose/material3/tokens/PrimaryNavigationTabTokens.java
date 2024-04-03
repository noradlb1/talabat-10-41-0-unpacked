package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b%\u0010\u0014R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b-\u0010\u0014R\u001c\u0010.\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b/\u0010\u0014R\u001c\u00100\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b1\u0010\u0014R\u0011\u00102\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0011\u00104\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0011\u0010@\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/material3/tokens/PrimaryNavigationTabTokens;", "", "()V", "ActiveFocusIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveFocusIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveFocusLabelTextColor", "getActiveFocusLabelTextColor", "ActiveHoverIconColor", "getActiveHoverIconColor", "ActiveHoverLabelTextColor", "getActiveHoverLabelTextColor", "ActiveIconColor", "getActiveIconColor", "ActiveIndicatorColor", "getActiveIndicatorColor", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getActiveIndicatorShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ActiveLabelTextColor", "getActiveLabelTextColor", "ActivePressedIconColor", "getActivePressedIconColor", "ActivePressedLabelTextColor", "getActivePressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DividerColor", "getDividerColor", "DividerHeight", "getDividerHeight-D9Ej5fM", "IconAndLabelTextContainerHeight", "getIconAndLabelTextContainerHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "InactiveFocusIconColor", "getInactiveFocusIconColor", "InactiveFocusLabelTextColor", "getInactiveFocusLabelTextColor", "InactiveHoverIconColor", "getInactiveHoverIconColor", "InactiveHoverLabelTextColor", "getInactiveHoverLabelTextColor", "InactiveIconColor", "getInactiveIconColor", "InactiveLabelTextColor", "getInactiveLabelTextColor", "InactivePressedIconColor", "getInactivePressedIconColor", "InactivePressedLabelTextColor", "getInactivePressedLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrimaryNavigationTabTokens {
    @NotNull
    private static final ColorSchemeKeyTokens ActiveFocusIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveFocusLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveHoverIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveHoverLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final float ActiveIndicatorHeight;
    @NotNull
    private static final RoundedCornerShape ActiveIndicatorShape;
    @NotNull
    private static final ColorSchemeKeyTokens ActiveLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActivePressedIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens ActivePressedLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float ContainerElevation = ElevationTokens.INSTANCE.m2132getLevel0D9Ej5fM();
    private static final float ContainerHeight = Dp.m5478constructorimpl((float) 48.0d);
    @NotNull
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerNone;
    @NotNull
    private static final ColorSchemeKeyTokens DividerColor = ColorSchemeKeyTokens.SurfaceVariant;
    private static final float DividerHeight = Dp.m5478constructorimpl((float) 1.0d);
    @NotNull
    public static final PrimaryNavigationTabTokens INSTANCE = new PrimaryNavigationTabTokens();
    private static final float IconAndLabelTextContainerHeight = Dp.m5478constructorimpl((float) 64.0d);
    private static final float IconSize = Dp.m5478constructorimpl((float) 24.0d);
    @NotNull
    private static final ColorSchemeKeyTokens InactiveFocusIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactiveFocusLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactiveHoverIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactiveHoverLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactiveIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactiveLabelTextColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactivePressedIconColor;
    @NotNull
    private static final ColorSchemeKeyTokens InactivePressedLabelTextColor;
    @NotNull
    private static final TypographyKeyTokens LabelTextFont = TypographyKeyTokens.TitleSmall;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        ActiveIndicatorColor = colorSchemeKeyTokens;
        float f11 = (float) 3.0d;
        ActiveIndicatorHeight = Dp.m5478constructorimpl(f11);
        ActiveIndicatorShape = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl(f11));
        ActiveFocusIconColor = colorSchemeKeyTokens;
        ActiveHoverIconColor = colorSchemeKeyTokens;
        ActiveIconColor = colorSchemeKeyTokens;
        ActivePressedIconColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        InactiveFocusIconColor = colorSchemeKeyTokens2;
        InactiveHoverIconColor = colorSchemeKeyTokens2;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurfaceVariant;
        InactiveIconColor = colorSchemeKeyTokens3;
        InactivePressedIconColor = colorSchemeKeyTokens2;
        ActiveFocusLabelTextColor = colorSchemeKeyTokens;
        ActiveHoverLabelTextColor = colorSchemeKeyTokens;
        ActiveLabelTextColor = colorSchemeKeyTokens;
        ActivePressedLabelTextColor = colorSchemeKeyTokens;
        InactiveFocusLabelTextColor = colorSchemeKeyTokens2;
        InactiveHoverLabelTextColor = colorSchemeKeyTokens2;
        InactiveLabelTextColor = colorSchemeKeyTokens3;
        InactivePressedLabelTextColor = colorSchemeKeyTokens2;
    }

    private PrimaryNavigationTabTokens() {
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveFocusIconColor() {
        return ActiveFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveFocusLabelTextColor() {
        return ActiveFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveHoverIconColor() {
        return ActiveHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveHoverLabelTextColor() {
        return ActiveHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveIconColor() {
        return ActiveIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* renamed from: getActiveIndicatorHeight-D9Ej5fM  reason: not valid java name */
    public final float m2407getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    @NotNull
    public final RoundedCornerShape getActiveIndicatorShape() {
        return ActiveIndicatorShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActiveLabelTextColor() {
        return ActiveLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActivePressedIconColor() {
        return ActivePressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getActivePressedLabelTextColor() {
        return ActivePressedLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* renamed from: getContainerElevation-D9Ej5fM  reason: not valid java name */
    public final float m2408getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* renamed from: getContainerHeight-D9Ej5fM  reason: not valid java name */
    public final float m2409getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    @NotNull
    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    @NotNull
    public final ColorSchemeKeyTokens getDividerColor() {
        return DividerColor;
    }

    /* renamed from: getDividerHeight-D9Ej5fM  reason: not valid java name */
    public final float m2410getDividerHeightD9Ej5fM() {
        return DividerHeight;
    }

    /* renamed from: getIconAndLabelTextContainerHeight-D9Ej5fM  reason: not valid java name */
    public final float m2411getIconAndLabelTextContainerHeightD9Ej5fM() {
        return IconAndLabelTextContainerHeight;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2412getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveFocusIconColor() {
        return InactiveFocusIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveFocusLabelTextColor() {
        return InactiveFocusLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveHoverIconColor() {
        return InactiveHoverIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveHoverLabelTextColor() {
        return InactiveHoverLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveIconColor() {
        return InactiveIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactiveLabelTextColor() {
        return InactiveLabelTextColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactivePressedIconColor() {
        return InactivePressedIconColor;
    }

    @NotNull
    public final ColorSchemeKeyTokens getInactivePressedLabelTextColor() {
        return InactivePressedLabelTextColor;
    }

    @NotNull
    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }
}
