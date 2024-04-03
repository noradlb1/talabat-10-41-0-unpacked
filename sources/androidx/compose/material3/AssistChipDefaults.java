package androidx.compose.material3;

import androidx.compose.material3.tokens.AssistChipTokens;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015Je\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!JQ\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+Je\u0010,\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010!JQ\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010+R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height;
    @NotNull
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float IconSize;

    static {
        AssistChipTokens assistChipTokens = AssistChipTokens.INSTANCE;
        Height = assistChipTokens.m2021getContainerHeightD9Ej5fM();
        IconSize = assistChipTokens.m2030getIconSizeD9Ej5fM();
    }

    private AssistChipDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: assistChipBorder-d_3_b6Q  reason: not valid java name */
    public final ChipBorder m1507assistChipBorderd_3_b6Q(long j11, long j12, float f11, @Nullable Composer composer, int i11, int i12) {
        long j13;
        long j14;
        float f12;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(382372847);
        if ((i12 & 1) != 0) {
            j13 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6);
        } else {
            j13 = j11;
        }
        if ((i12 & 2) != 0) {
            j14 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j14 = j12;
        }
        if ((i12 & 4) != 0) {
            f12 = AssistChipTokens.INSTANCE.m2029getFlatOutlineWidthD9Ej5fM();
        } else {
            f12 = f11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, i11, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:708)");
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
    /* renamed from: assistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1508assistChipColorsoq7We08(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i11, int i12) {
        long j19;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        Composer composer2 = composer;
        int i13 = i12;
        composer2.startReplaceableGroup(-391745725);
        if ((i13 & 1) != 0) {
            j19 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j19 = j11;
        }
        if ((i13 & 2) != 0) {
            j21 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j21 = j12;
        }
        if ((i13 & 4) != 0) {
            j22 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer2, 6);
        } else {
            j22 = j13;
        }
        if ((i13 & 8) != 0) {
            j23 = j22;
        } else {
            j23 = j14;
        }
        if ((i13 & 16) != 0) {
            j24 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j24 = j15;
        }
        if ((i13 & 32) != 0) {
            j25 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j25 = j16;
        }
        if ((i13 & 64) != 0) {
            j26 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j26 = j17;
        }
        if ((i13 & 128) != 0) {
            j27 = j26;
        } else {
            j27 = j18;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, i11, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:648)");
        }
        ChipColors chipColors = new ChipColors(j19, j21, j22, j23, j24, j25, j26, j27, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @NotNull
    @Composable
    /* renamed from: assistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1509assistChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(245366099);
        if ((i12 & 1) != 0) {
            f17 = AssistChipTokens.INSTANCE.m2028getFlatContainerElevationD9Ej5fM();
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
            f22 = AssistChipTokens.INSTANCE.m2022getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = f17;
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, i11, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:684)");
        }
        ChipElevation chipElevation = new ChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedAssistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1510elevatedAssistChipColorsoq7We08(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i11, int i12) {
        long j19;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        Composer composer2 = composer;
        int i13 = i12;
        composer2.startReplaceableGroup(-535762675);
        if ((i13 & 1) != 0) {
            j19 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedContainerColor(), composer2, 6);
        } else {
            j19 = j11;
        }
        if ((i13 & 2) != 0) {
            j21 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j21 = j12;
        }
        if ((i13 & 4) != 0) {
            j22 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer2, 6);
        } else {
            j22 = j13;
        }
        if ((i13 & 8) != 0) {
            j23 = j22;
        } else {
            j23 = j14;
        }
        if ((i13 & 16) != 0) {
            j24 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j24 = j15;
        }
        if ((i13 & 32) != 0) {
            j25 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j25 = j16;
        }
        if ((i13 & 64) != 0) {
            j26 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j26 = j17;
        }
        if ((i13 & 128) != 0) {
            j27 = j26;
        } else {
            j27 = j18;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, i11, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:733)");
        }
        ChipColors chipColors = new ChipColors(j19, j21, j22, j23, j24, j25, j26, j27, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedAssistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1511elevatedAssistChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(1457698077);
        if ((i12 & 1) != 0) {
            f17 = AssistChipTokens.INSTANCE.m2023getElevatedContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = AssistChipTokens.INSTANCE.m2027getElevatedPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = AssistChipTokens.INSTANCE.m2025getElevatedFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = AssistChipTokens.INSTANCE.m2026getElevatedHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = AssistChipTokens.INSTANCE.m2022getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = AssistChipTokens.INSTANCE.m2024getElevatedDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, i11, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:770)");
        }
        ChipElevation chipElevation = new ChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1512getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1513getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1988153916);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, i11, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:787)");
        }
        Shape shape = ShapesKt.toShape(AssistChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
