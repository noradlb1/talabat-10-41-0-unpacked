package androidx.compose.material3;

import androidx.compose.material3.tokens.InputChipTokens;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u0013H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+JQ\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "Height", "getHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "inputChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class InputChipDefaults {
    public static final int $stable = 0;
    private static final float AvatarSize;
    private static final float Height;
    @NotNull
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float IconSize;

    static {
        InputChipTokens inputChipTokens = InputChipTokens.INSTANCE;
        Height = inputChipTokens.m2255getContainerHeightD9Ej5fM();
        IconSize = inputChipTokens.m2257getLeadingIconSizeD9Ej5fM();
        AvatarSize = inputChipTokens.m2253getAvatarSizeD9Ej5fM();
    }

    private InputChipDefaults() {
    }

    /* renamed from: getAvatarSize-D9Ej5fM  reason: not valid java name */
    public final float m1720getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1721getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1722getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1052444143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, i11, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1138)");
        }
        Shape shape = ShapesKt.toShape(InputChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    /* renamed from: inputChipBorder-gHcDVlo  reason: not valid java name */
    public final SelectableChipBorder m1723inputChipBordergHcDVlo(long j11, long j12, long j13, long j14, float f11, float f12, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        float f13;
        float f14;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-324924235);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j18 = j14;
        }
        if ((i12 & 16) != 0) {
            f13 = InputChipTokens.INSTANCE.m2260getUnselectedOutlineWidthD9Ej5fM();
        } else {
            f13 = f11;
        }
        if ((i12 & 32) != 0) {
            f14 = InputChipTokens.INSTANCE.m2258getSelectedOutlineWidthD9Ej5fM();
        } else {
            f14 = f12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-324924235, i11, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1120)");
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(j15, j16, j17, j18, f13, f14, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    @NotNull
    @Composable
    /* renamed from: inputChipColors-kwJvTHA  reason: not valid java name */
    public final SelectableChipColors m1724inputChipColorskwJvTHA(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, @Nullable Composer composer, int i11, int i12, int i13) {
        Composer composer2 = composer;
        int i14 = i13;
        composer2.startReplaceableGroup(1312840646);
        long r62 = (i14 & 1) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j11;
        long color = (i14 & 2) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer2, 6) : j12;
        long color2 = (i14 & 4) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLeadingIconColor(), composer2, 6) : j13;
        long color3 = (i14 & 8) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedTrailingIconColor(), composer2, 6) : j14;
        long r14 = (i14 & 16) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j15;
        long r16 = (i14 & 32) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r18 = (i14 & 64) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r202 = (i14 & 128) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long color4 = (i14 & 256) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedContainerColor(), composer2, 6) : j19;
        long r24 = (i14 & 512) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledSelectedContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        long color5 = (i14 & 1024) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLabelTextColor(), composer2, 6) : j22;
        long color6 = (i14 & 2048) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLeadingIconColor(), composer2, 6) : j23;
        long color7 = (i14 & 4096) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedTrailingIconColor(), composer2, 6) : j24;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1312840646, i11, i12, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1043)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(r62, color, color2, color3, r14, r16, r18, r202, color4, r24, color5, color6, color7, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @NotNull
    @Composable
    /* renamed from: inputChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1725inputChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(1745270109);
        if ((i12 & 1) != 0) {
            f17 = InputChipTokens.INSTANCE.m2254getContainerElevationD9Ej5fM();
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
            f22 = InputChipTokens.INSTANCE.m2256getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = f17;
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, i11, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1091)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }
}
