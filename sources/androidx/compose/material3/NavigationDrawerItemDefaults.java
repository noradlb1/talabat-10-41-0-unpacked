package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "()V", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final NavigationDrawerItemDefaults INSTANCE = new NavigationDrawerItemDefaults();
    @NotNull
    private static final PaddingValues ItemPadding = PaddingKt.m481PaddingValuesYgX7TsA$default(Dp.m5478constructorimpl((float) 12), 0.0f, 2, (Object) null);

    private NavigationDrawerItemDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-oq7We08  reason: not valid java name */
    public final NavigationDrawerItemColors m1762colorsoq7We08(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i11, int i12) {
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
        composer2.startReplaceableGroup(-1574983348);
        if ((i13 & 1) != 0) {
            j19 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6);
        } else {
            j19 = j11;
        }
        if ((i13 & 2) != 0) {
            j21 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j21 = j12;
        }
        if ((i13 & 4) != 0) {
            j22 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), composer2, 6);
        } else {
            j22 = j13;
        }
        if ((i13 & 8) != 0) {
            j23 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), composer2, 6);
        } else {
            j23 = j14;
        }
        if ((i13 & 16) != 0) {
            j24 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6);
        } else {
            j24 = j15;
        }
        if ((i13 & 32) != 0) {
            j25 = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6);
        } else {
            j25 = j16;
        }
        if ((i13 & 64) != 0) {
            j26 = j24;
        } else {
            j26 = j17;
        }
        if ((i13 & 128) != 0) {
            j27 = j25;
        } else {
            j27 = j18;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1574983348, i11, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:759)");
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(j22, j23, j24, j25, j19, j21, j26, j27, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDrawerItemsColor;
    }

    @NotNull
    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }
}
