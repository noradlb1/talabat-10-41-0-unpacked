package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "()V", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "itemColors", "Landroidx/compose/material3/MenuItemColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuDefaults {
    public static final int $stable = 0;
    @NotNull
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m480PaddingValuesYgX7TsA(MenuKt.DropdownMenuItemHorizontalPadding, Dp.m5478constructorimpl((float) 0));
    @NotNull
    public static final MenuDefaults INSTANCE = new MenuDefaults();

    private MenuDefaults() {
    }

    @NotNull
    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }

    @NotNull
    @Composable
    /* renamed from: itemColors-5tl4gsc  reason: not valid java name */
    public final MenuItemColors m1738itemColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1278543580);
        if ((i12 & 1) != 0) {
            j17 = ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemLabelTextColor(), composer2, 6);
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemLeadingIconColor(), composer2, 6);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemTrailingIconColor(), composer2, 6);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(MenuTokens.INSTANCE.getListItemDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1278543580, i11, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:234)");
        }
        MenuItemColors menuItemColors = new MenuItemColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return menuItemColors;
    }
}
