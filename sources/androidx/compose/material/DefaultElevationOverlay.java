package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultElevationOverlay implements ElevationOverlay {
    @NotNull
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @ReadOnlyComposable
    @Composable
    /* renamed from: apply-7g2Lkgo  reason: not valid java name */
    public long m1213apply7g2Lkgo(long j11, float f11, @Nullable Composer composer, int i11) {
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (Dp.m5477compareTo0680j_4(f11, Dp.m5478constructorimpl((float) 0)) <= 0 || colors.isLight()) {
            return j11;
        }
        return ColorKt.m2965compositeOverOWjLjI(ElevationOverlayKt.m1249calculateForegroundColorCLU3JFs(j11, f11, composer, (i11 & 112) | (i11 & 14)), j11);
    }
}
