package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/material3/NavigationRailItemDefaults;", "", "()V", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailItemDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final NavigationRailItemDefaults INSTANCE = new NavigationRailItemDefaults();

    private NavigationRailItemDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    public final NavigationRailItemColors m1774colorszjMxDiM(long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i11, int i12) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1621601574);
        if ((i12 & 1) != 0) {
            j16 = ColorSchemeKt.toColor(NavigationRailTokens.INSTANCE.getActiveIconColor(), composer2, 6);
        } else {
            j16 = j11;
        }
        if ((i12 & 2) != 0) {
            j17 = ColorSchemeKt.toColor(NavigationRailTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6);
        } else {
            j17 = j12;
        }
        if ((i12 & 4) != 0) {
            j18 = ColorSchemeKt.toColor(NavigationRailTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6);
        } else {
            j18 = j13;
        }
        if ((i12 & 8) != 0) {
            j19 = ColorSchemeKt.toColor(NavigationRailTokens.INSTANCE.getInactiveIconColor(), composer2, 6);
        } else {
            j19 = j14;
        }
        if ((i12 & 16) != 0) {
            j21 = ColorSchemeKt.toColor(NavigationRailTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6);
        } else {
            j21 = j15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1621601574, i11, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:288)");
        }
        NavigationRailItemColors navigationRailItemColors = new NavigationRailItemColors(j16, j17, j18, j19, j21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationRailItemColors;
    }
}
