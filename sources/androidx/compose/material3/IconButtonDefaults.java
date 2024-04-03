package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0011JQ\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J=\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0011JQ\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$J=\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0011J\u001f\u0010'\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0007¢\u0006\u0002\u0010)JQ\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "filledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: filledIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m1708filledIconButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-669858473);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, i13, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:608)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @NotNull
    @Composable
    /* renamed from: filledIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m1709filledIconToggleButtonColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(1887173701);
        if ((i12 & 1) != 0) {
            j17 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer2, 6);
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor(), composer2, 6);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer2, 6);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = ColorSchemeKt.m1609contentColorForek8zF_U(j22, composer2, (i13 >> 12) & 14);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, i13, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:635)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @NotNull
    @Composable
    /* renamed from: filledTonalIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m1710filledTonalIconButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-18532843);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, i13, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:666)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @NotNull
    @Composable
    /* renamed from: filledTonalIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m1711filledTonalIconToggleButtonColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-19426557);
        if ((i12 & 1) != 0) {
            j17 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer2, 6);
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.m1609contentColorForek8zF_U(j17, composer2, i13 & 14);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer2, 6);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor(), composer2, 6);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, i13, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:693)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @NotNull
    @Composable
    @JvmName(name = "getFilledShape")
    public final Shape getFilledShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1265841879);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, i11, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:539)");
        }
        Shape shape = ShapesKt.toShape(FilledIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedShape")
    public final Shape getOutlinedShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1327125527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, i11, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:543)");
        }
        Shape shape = ShapesKt.toShape(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    /* renamed from: iconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m1712iconButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(999008085);
        if ((i12 & 1) != 0) {
            j15 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(j16, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, i11, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:555)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @NotNull
    @Composable
    /* renamed from: iconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m1713iconToggleButtonColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2020719549);
        if ((i12 & 1) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(j18, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = ColorSchemeKt.toColor(IconButtonTokens.INSTANCE.getSelectedIconColor(), composer2, 6);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, i11, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:581)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @NotNull
    @Composable
    public final BorderStroke outlinedIconButtonBorder(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-511461558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, i11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:789)");
        }
        if (z11) {
            composer.startReplaceableGroup(1252615072);
            j11 = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1252615127);
            j11 = Color.m2918copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            composer.endReplaceableGroup();
        }
        Color r92 = Color.m2909boximpl(j11);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) r92);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m2319getUnselectedOutlineWidthD9Ej5fM(), j11);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BorderStroke borderStroke = (BorderStroke) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m1714outlinedIconButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1030517545);
        if ((i12 & 1) != 0) {
            j15 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(j16, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, i11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:723)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @Nullable
    @Composable
    public final BorderStroke outlinedIconToggleButtonBorder(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1244729690);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, i11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:776)");
        }
        if (z12) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }
        BorderStroke outlinedIconButtonBorder = outlinedIconButtonBorder(z11, composer, (i11 & 14) | ((i11 >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return outlinedIconButtonBorder;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m1715outlinedIconToggleButtonColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(2130592709);
        if ((i12 & 1) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(j18, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = ColorSchemeKt.toColor(OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer2, 6);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = ColorSchemeKt.m1609contentColorForek8zF_U(j22, composer2, (i13 >> 12) & 14);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, i13, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:749)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }
}
