package androidx.compose.material3;

import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JQ\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J3\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\u00112\b\b\u0002\u0010'\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0018JQ\u0010,\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\"R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "elevatedSuggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "suggestionChipColors", "suggestionChipColors-5tl4gsc", "suggestionChipElevation", "suggestionChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    private static final float Height;
    @NotNull
    public static final SuggestionChipDefaults INSTANCE = new SuggestionChipDefaults();
    private static final float IconSize;

    static {
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.INSTANCE;
        Height = suggestionChipTokens.m2431getContainerHeightD9Ej5fM();
        IconSize = suggestionChipTokens.m2440getLeadingIconSizeD9Ej5fM();
    }

    private SuggestionChipDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: elevatedSuggestionChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1850elevatedSuggestionChipColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1269423125);
        if ((i12 & 1) != 0) {
            j17 = ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedContainerColor(), composer2, 6);
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1563getOnSurfaceVariant0d7_KjU();
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1562getOnSurface0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269423125, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1249)");
        }
        Color.Companion companion = Color.Companion;
        ChipColors chipColors = new ChipColors(j17, j18, j19, companion.m2955getUnspecified0d7_KjU(), j21, j22, j23, companion.m2955getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedSuggestionChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1851elevatedSuggestionChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(1118088467);
        if ((i12 & 1) != 0) {
            f17 = SuggestionChipTokens.INSTANCE.m2433getElevatedContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = SuggestionChipTokens.INSTANCE.m2437getElevatedPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = SuggestionChipTokens.INSTANCE.m2435getElevatedFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = SuggestionChipTokens.INSTANCE.m2436getElevatedHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = SuggestionChipTokens.INSTANCE.m2432getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = SuggestionChipTokens.INSTANCE.m2434getElevatedDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1118088467, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1286)");
        }
        ChipElevation chipElevation = new ChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1852getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1853getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(641188183);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(641188183, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1303)");
        }
        Shape shape = ShapesKt.toShape(SuggestionChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    /* renamed from: suggestionChipBorder-d_3_b6Q  reason: not valid java name */
    public final ChipBorder m1854suggestionChipBorderd_3_b6Q(long j11, long j12, float f11, @Nullable Composer composer, int i11, int i12) {
        long j13;
        long j14;
        float f12;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(439283919);
        if ((i12 & 1) != 0) {
            j13 = ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6);
        } else {
            j13 = j11;
        }
        if ((i12 & 2) != 0) {
            j14 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j14 = j12;
        }
        if ((i12 & 4) != 0) {
            f12 = SuggestionChipTokens.INSTANCE.m2439getFlatOutlineWidthD9Ej5fM();
        } else {
            f12 = f11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439283919, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1226)");
        }
        ChipBorder chipBorder = new ChipBorder(j13, j14, f12, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    @NotNull
    @Composable
    /* renamed from: suggestionChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1855suggestionChipColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1882647883);
        if ((i12 & 1) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLeadingIconColor(), composer2, 6);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1882647883, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1169)");
        }
        Color.Companion companion = Color.Companion;
        ChipColors chipColors = new ChipColors(j17, j18, j19, companion.m2955getUnspecified0d7_KjU(), j21, j22, j23, companion.m2955getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @NotNull
    @Composable
    /* renamed from: suggestionChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1856suggestionChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(1929994057);
        if ((i12 & 1) != 0) {
            f17 = SuggestionChipTokens.INSTANCE.m2438getFlatContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = f17;
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = f17;
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = f17;
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = SuggestionChipTokens.INSTANCE.m2432getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = f17;
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929994057, i11, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1202)");
        }
        ChipElevation chipElevation = new ChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }
}
