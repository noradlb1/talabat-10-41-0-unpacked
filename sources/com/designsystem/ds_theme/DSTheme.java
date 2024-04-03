package com.designsystem.ds_theme;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/designsystem/ds_theme/DSTheme;", "", "()V", "colors", "Lcom/designsystem/ds_theme/DSColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_theme/DSColors;", "dimens", "Lcom/designsystem/ds_theme/DSDimens;", "getDimens", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_theme/DSDimens;", "elevation", "Lcom/designsystem/ds_theme/DSElevation;", "getElevation", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_theme/DSElevation;", "typography", "Lcom/designsystem/ds_theme/DSTypography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_theme/DSTypography;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTheme {
    public static final int $stable = 0;
    @NotNull
    public static final DSTheme INSTANCE = new DSTheme();

    private DSTheme() {
    }

    @NotNull
    @Composable
    @JvmName(name = "getColors")
    public final DSColors getColors(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1351712758);
        DSColors dSColors = (DSColors) composer.consume(DSColorsKt.getLocalDSColors());
        composer.endReplaceableGroup();
        return dSColors;
    }

    @NotNull
    @Composable
    @JvmName(name = "getDimens")
    public final DSDimens getDimens(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-619682353);
        DSDimens dSDimens = (DSDimens) composer.consume(DSDimensKt.getLocalDSDimens());
        composer.endReplaceableGroup();
        return dSDimens;
    }

    @NotNull
    @Composable
    @JvmName(name = "getElevation")
    public final DSElevation getElevation(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1134824954);
        DSElevation dSElevation = (DSElevation) composer.consume(DSElevationKt.getLocalDSElevation());
        composer.endReplaceableGroup();
        return dSElevation;
    }

    @NotNull
    @Composable
    @JvmName(name = "getTypography")
    public final DSTypography getTypography(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(995038647);
        DSTypography dSTypography = (DSTypography) composer.consume(DSTypographyKt.getLocalDSTypography());
        composer.endReplaceableGroup();
        return dSTypography;
    }
}
