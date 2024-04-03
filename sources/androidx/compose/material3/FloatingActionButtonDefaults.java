package androidx.compose.material3;

import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J=\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010 R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "extendedFabShape", "Landroidx/compose/ui/graphics/Shape;", "getExtendedFabShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "largeShape", "getLargeShape", "shape", "getShape", "smallShape", "getSmallShape", "bottomAppBarFabElevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "elevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();
    private static final float LargeIconSize = FabPrimaryLargeTokens.INSTANCE.m2153getIconSizeD9Ej5fM();

    private FloatingActionButtonDefaults() {
    }

    /* renamed from: bottomAppBarFabElevation-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ FloatingActionButtonElevation m1698bottomAppBarFabElevationa9UjIt4$default(FloatingActionButtonDefaults floatingActionButtonDefaults, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return floatingActionButtonDefaults.m1699bottomAppBarFabElevationa9UjIt4(f11, f12, f13, f14);
    }

    @NotNull
    /* renamed from: bottomAppBarFabElevation-a9UjIt4  reason: not valid java name */
    public final FloatingActionButtonElevation m1699bottomAppBarFabElevationa9UjIt4(float f11, float f12, float f13, float f14) {
        return new FloatingActionButtonElevation(f11, f12, f13, f14, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Composable
    /* renamed from: elevation-xZ9-QkE  reason: not valid java name */
    public final FloatingActionButtonElevation m1700elevationxZ9QkE(float f11, float f12, float f13, float f14, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-241106249);
        if ((i12 & 1) != 0) {
            f11 = FabPrimaryTokens.INSTANCE.m2170getContainerElevationD9Ej5fM();
        }
        float f15 = f11;
        if ((i12 & 2) != 0) {
            f12 = FabPrimaryTokens.INSTANCE.m2180getPressedContainerElevationD9Ej5fM();
        }
        float f16 = f12;
        if ((i12 & 4) != 0) {
            f13 = FabPrimaryTokens.INSTANCE.m2173getFocusContainerElevationD9Ej5fM();
        }
        float f17 = f13;
        if ((i12 & 8) != 0) {
            f14 = FabPrimaryTokens.INSTANCE.m2174getHoverContainerElevationD9Ej5fM();
        }
        float f18 = f14;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241106249, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:421)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f15, f16, f17, f18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return floatingActionButtonElevation;
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1855656391);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855656391, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:407)");
        }
        long color = ColorSchemeKt.toColor(FabPrimaryTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @NotNull
    @Composable
    @JvmName(name = "getExtendedFabShape")
    public final Shape getExtendedFabShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-536021915);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-536021915, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:403)");
        }
        Shape shape = ShapesKt.toShape(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getLargeIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1701getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    @NotNull
    @Composable
    @JvmName(name = "getLargeShape")
    public final Shape getLargeShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1835912187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1835912187, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:400)");
        }
        Shape shape = ShapesKt.toShape(FabPrimaryLargeTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-53247565);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53247565, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:394)");
        }
        Shape shape = ShapesKt.toShape(FabPrimaryTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getSmallShape")
    public final Shape getSmallShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(394933381);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394933381, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:397)");
        }
        Shape shape = ShapesKt.toShape(FabPrimarySmallTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    /* renamed from: loweredElevation-xZ9-QkE  reason: not valid java name */
    public final FloatingActionButtonElevation m1702loweredElevationxZ9QkE(float f11, float f12, float f13, float f14, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-285065125);
        if ((i12 & 1) != 0) {
            f11 = FabPrimaryTokens.INSTANCE.m2176getLoweredContainerElevationD9Ej5fM();
        }
        float f15 = f11;
        if ((i12 & 2) != 0) {
            f12 = FabPrimaryTokens.INSTANCE.m2179getLoweredPressedContainerElevationD9Ej5fM();
        }
        float f16 = f12;
        if ((i12 & 4) != 0) {
            f13 = FabPrimaryTokens.INSTANCE.m2177getLoweredFocusContainerElevationD9Ej5fM();
        }
        float f17 = f13;
        if ((i12 & 8) != 0) {
            f14 = FabPrimaryTokens.INSTANCE.m2178getLoweredHoverContainerElevationD9Ej5fM();
        }
        float f18 = f14;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285065125, i11, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:444)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f15, f16, f17, f18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return floatingActionButtonElevation;
    }
}
