package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jo\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ListItemDefaults {
    public static final int $stable = 0;
    private static final float Elevation = ListTokens.INSTANCE.m2263getListItemContainerElevationD9Ej5fM();
    @NotNull
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();

    private ListItemDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-J08w3-E  reason: not valid java name */
    public final ListItemColors m1726colorsJ08w3E(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, @Nullable Composer composer, int i11, int i12) {
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        Composer composer2 = composer;
        int i13 = i12;
        composer2.startReplaceableGroup(-352515689);
        if ((i13 & 1) != 0) {
            j21 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemContainerColor(), composer2, 6);
        } else {
            j21 = j11;
        }
        if ((i13 & 2) != 0) {
            j22 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLabelTextColor(), composer2, 6);
        } else {
            j22 = j12;
        }
        if ((i13 & 4) != 0) {
            j23 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLeadingIconColor(), composer2, 6);
        } else {
            j23 = j13;
        }
        if ((i13 & 8) != 0) {
            j24 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemOverlineColor(), composer2, 6);
        } else {
            j24 = j14;
        }
        if ((i13 & 16) != 0) {
            j25 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemSupportingTextColor(), composer2, 6);
        } else {
            j25 = j15;
        }
        if ((i13 & 32) != 0) {
            j26 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemTrailingIconColor(), composer2, 6);
        } else {
            j26 = j16;
        }
        if ((i13 & 64) != 0) {
            j27 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledLabelTextColor(), composer2, 6), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j27 = j17;
        }
        if ((i13 & 128) != 0) {
            j28 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j28 = j18;
        }
        if ((i13 & 256) != 0) {
            j29 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j29 = j19;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-352515689, i11, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:400)");
        }
        ListItemColors listItemColors = new ListItemColors(j21, j22, j23, j24, j25, j26, j27, j28, j29, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return listItemColors;
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1253579929);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1253579929, i11, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:377)");
        }
        long color = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getContentColor")
    public final long getContentColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1076068327);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1076068327, i11, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:380)");
        }
        long color = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1727getElevationD9Ej5fM() {
        return Elevation;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-496871597);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496871597, i11, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:374)");
        }
        Shape shape = ShapesKt.toShape(ListTokens.INSTANCE.getListItemContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
