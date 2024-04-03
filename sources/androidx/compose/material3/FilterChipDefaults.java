package androidx.compose.material3;

import androidx.compose.material3.tokens.FilterChipTokens;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(JQ\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0001\u00103\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u001eJQ\u00105\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010(R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height;
    @NotNull
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float IconSize;

    static {
        FilterChipTokens filterChipTokens = FilterChipTokens.INSTANCE;
        Height = filterChipTokens.m2234getContainerHeightD9Ej5fM();
        IconSize = filterChipTokens.m2250getIconSizeD9Ej5fM();
    }

    private FilterChipDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: elevatedFilterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1688elevatedFilterChipColorsXqyqHi0(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, @Nullable Composer composer, int i11, int i12, int i13) {
        Composer composer2 = composer;
        int i14 = i13;
        composer2.startReplaceableGroup(-915841711);
        long color = (i14 & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor(), composer2, 6) : j11;
        long color2 = (i14 & 2) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer2, 6) : j12;
        long color3 = (i14 & 4) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer2, 6) : j13;
        long r16 = (i14 & 8) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r18 = (i14 & 16) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long r202 = (i14 & 32) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long j24 = (i14 & 64) != 0 ? r202 : j17;
        long color4 = (i14 & 128) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor(), composer2, 6) : j18;
        long j25 = (i14 & 256) != 0 ? r16 : j19;
        long color5 = (i14 & 512) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer2, 6) : j21;
        long color6 = (i14 & 1024) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer2, 6) : j22;
        long j26 = (i14 & 2048) != 0 ? color6 : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i11, i12, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:937)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(color, color2, color3, color3, r16, r18, r202, j24, color4, j25, color5, color6, j26, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedFilterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1689elevatedFilterChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(684803697);
        if ((i12 & 1) != 0) {
            f17 = FilterChipTokens.INSTANCE.m2236getElevatedContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = FilterChipTokens.INSTANCE.m2240getElevatedPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = FilterChipTokens.INSTANCE.m2238getElevatedFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = FilterChipTokens.INSTANCE.m2239getElevatedHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = FilterChipTokens.INSTANCE.m2235getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = FilterChipTokens.INSTANCE.m2237getElevatedDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i11, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:982)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    @NotNull
    @Composable
    /* renamed from: filterChipBorder-gHcDVlo  reason: not valid java name */
    public final SelectableChipBorder m1690filterChipBordergHcDVlo(long j11, long j12, long j13, long j14, float f11, float f12, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        float f13;
        float f14;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1884534961);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j18 = j14;
        }
        if ((i12 & 16) != 0) {
            f13 = FilterChipTokens.INSTANCE.m2248getFlatUnselectedOutlineWidthD9Ej5fM();
        } else {
            f13 = f11;
        }
        if ((i12 & 32) != 0) {
            f14 = FilterChipTokens.INSTANCE.m2244getFlatSelectedOutlineWidthD9Ej5fM();
        } else {
            f14 = f12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1884534961, i11, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:901)");
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
    /* renamed from: filterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1691filterChipColorsXqyqHi0(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, @Nullable Composer composer, int i11, int i12, int i13) {
        Composer composer2 = composer;
        int i14 = i13;
        composer2.startReplaceableGroup(-1831479801);
        long r62 = (i14 & 1) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j11;
        long color = (i14 & 2) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer2, 6) : j12;
        long color2 = (i14 & 4) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer2, 6) : j13;
        long r14 = (i14 & 8) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j14;
        long r16 = (i14 & 16) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long r18 = (i14 & 32) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long j24 = (i14 & 64) != 0 ? r18 : j17;
        long color3 = (i14 & 128) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatSelectedContainerColor(), composer2, 6) : j18;
        long r24 = (i14 & 256) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        long color4 = (i14 & 512) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer2, 6) : j21;
        long color5 = (i14 & 1024) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer2, 6) : j22;
        long j25 = (i14 & 2048) != 0 ? color5 : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i11, i12, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:825)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(r62, color, color2, color2, r14, r16, r18, j24, color3, r24, color4, color5, j25, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @NotNull
    @Composable
    /* renamed from: filterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1692filterChipElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(-757972185);
        if ((i12 & 1) != 0) {
            f17 = FilterChipTokens.INSTANCE.m2241getFlatContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = FilterChipTokens.INSTANCE.m2245getFlatSelectedPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = FilterChipTokens.INSTANCE.m2242getFlatSelectedFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = FilterChipTokens.INSTANCE.m2243getFlatSelectedHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = FilterChipTokens.INSTANCE.m2235getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = f17;
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i11, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:871)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1693getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1694getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1598643637);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i11, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:999)");
        }
        Shape shape = ShapesKt.toShape(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
